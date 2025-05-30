package com.ekzonpractice.cepassport.security;

import com.ekzonpractice.cepassport.security.AuthRequest;
import com.ekzonpractice.cepassport.security.AuthResponse;
import com.ekzonpractice.cepassport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.authenticate(request));
    }

    @PostMapping("/upgrade-to-editor")
    public ResponseEntity<Void> upgradeToEditor(@RequestParam String username) {
        userService.upgradeToEditor(username);
        return ResponseEntity.ok().build();
    }
}