package com.system.policefeedback.controllers;

import com.system.policefeedback.entities.User;
import com.system.policefeedback.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/debug")
public class PasswordDebugController {
    
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/check-password")
    public ResponseEntity<?> checkPassword(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("storedPasswordHash", user.getPassword());
        response.put("newPasswordHash", passwordEncoder.encode(password));
        response.put("passwordMatches", passwordEncoder.matches(password, user.getPassword()));
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/fix-password")
    public ResponseEntity<?> fixPassword(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        
        // Re-hash the password properly
        user.setPassword(passwordEncoder.encode(password));
        userService.saveUser(user);
        
        return ResponseEntity.ok("Password updated successfully");
    }
}