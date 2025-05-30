package com.ekzonpractice.cepassport.security;

import com.ekzonpractice.cepassport.security.AuthRequest;
import com.ekzonpractice.cepassport.security.AuthResponse;
import com.ekzonpractice.cepassport.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest request) {
        AuthResponse response = userService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@Valid @RequestBody AuthRequest request) {
        AuthResponse response = userService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/upgrade-to-editor")
    public ResponseEntity<Void> upgradeToEditor(@RequestParam String username) {
        userService.upgradeToEditor(username);
        return ResponseEntity.ok().build();
    }
}