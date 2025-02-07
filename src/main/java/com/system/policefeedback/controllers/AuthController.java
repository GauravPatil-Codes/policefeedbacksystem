package com.system.policefeedback.controllers;

import com.system.policefeedback.entities.User;
import com.system.policefeedback.services.UserServiceImpl;
import com.system.policefeedback.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        try {
            // Fetch the user from the database by username
            User user = userService.findByUsername(loginRequest.getUsername());
            
            if (user == null) {
                return ResponseEntity.status(401).body("Invalid username or password");
            }

            // Verify password
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(401).body("Invalid username or password");
            }

            // Generate JWT token directly from username
            String token = jwtTokenUtil.generateToken(user.getUsername());

            // Build response
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("role", user.getRole());
            response.put("departmentName", user.getDepartmentName());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

    // Register API
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userRequest) {
        try {
            // Check if the username already exists
            if (userService.findByUsername(userRequest.getUsername()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            // Hash the password before saving
            userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            // Save the user
            User savedUser = userService.saveUser(userRequest);

            return ResponseEntity.ok("User registered successfully with username: " + savedUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("User registration failed: " + e.getMessage());
        }
    }
}
