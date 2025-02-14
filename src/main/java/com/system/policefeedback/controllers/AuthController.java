package com.system.policefeedback.controllers;

import com.system.policefeedback.entities.User;
import com.system.policefeedback.services.UserServiceImpl;
import com.system.policefeedback.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        try {
            logger.debug("Login attempt for username: {}", loginRequest.getUsername());

            // Fetch user from database
            User user = userService.findByUsername(loginRequest.getUsername());

            if (user == null) {
                return ResponseEntity.status(401).body("Invalid username");
            }

            // Check if the password matches
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(401).body("Invalid password");
            }

            // Generate JWT token
            String token = jwtTokenUtil.generateToken(user.getUsername());

            // Build response
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("role", user.getRole());
            response.put("departmentName", user.getDepartmentName());
            response.put("id", user.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Login error", e);
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userRequest) {
        try {
            logger.info("Registration attempt for username: {}", userRequest.getUsername());

            if (userService.findByUsername(userRequest.getUsername()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            // Hash the password only here
            userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            logger.debug("Password after hashing: {}", userRequest.getPassword());

            // Save the user
            userService.saveUser(userRequest);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            logger.error("Registration error", e);
            return ResponseEntity.status(500).body("User registration failed");
        }
    }


    // Test endpoint to verify stored password manually
    @PostMapping("/verify-password")
    public ResponseEntity<?> verifyPassword(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String rawPassword = request.get("password");

            User user = userService.findByUsername(username);
            if (user == null) {
                return ResponseEntity.badRequest().body("User not found");
            }

            boolean matches = passwordEncoder.matches(rawPassword, user.getPassword());
            logger.debug("Password verification for {}: {}", username, matches);

            Map<String, Object> response = new HashMap<>();
            response.put("passwordMatches", matches);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Password verification failed", e);
            return ResponseEntity.status(500).body("Verification failed");
        }
    }
}
