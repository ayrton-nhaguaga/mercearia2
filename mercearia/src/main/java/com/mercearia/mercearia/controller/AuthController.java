package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.*;
import com.mercearia.mercearia.model.*;
import com.mercearia.mercearia.repository.UserRepository;
import com.mercearia.mercearia.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        if (userRepo.findByUsername(request.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(encoder.encode(request.password()));
        user.setRoles(Set.of(Role.ROLE_USER));

        userRepo.save(user);
        return ResponseEntity.ok("Usuário registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        UserDetails user = (UserDetails) auth.getPrincipal();
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
