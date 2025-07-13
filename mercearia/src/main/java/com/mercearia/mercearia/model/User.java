package com.mercearia.mercearia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    private String id;

    private String username;
    private String password;

    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> (GrantedAuthority) role::name) // Usa o nome do enum como autoridade
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Você pode mudar isso se quiser bloquear por expiração
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Mude se for implementar bloqueio de conta
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Mude se for implementar expiração de senha
    }

    @Override
    public boolean isEnabled() {
        return true; // Mude se for ativar/desativar usuários
    }
}

