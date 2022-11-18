package br.saoroque.controller.payloads;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.saoroque.jwt.Role;
import br.saoroque.jwt.UserPrincipal;

import java.util.Arrays;
import java.util.Collection;

public class UsuarioPayload implements Authentication {

    private Long id;
    private String name;
    private String username;
    private String email;
    private boolean isAuthenticated;

    public UsuarioPayload(Long id, String name, String username, String email, boolean isAuthenticated) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(Role.values());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return new UserPrincipal(id, name, username, email, null, getAuthorities());
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.isAuthenticated = b;
    }

    @Override
    public String getName() {
        return name;
    }
}
