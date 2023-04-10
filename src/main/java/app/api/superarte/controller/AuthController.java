package app.api.superarte.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AuthController {

    private boolean hasRole(String role){

        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) { return false; }

        Authentication authentication = context.getAuthentication();
        if (authentication == null){ return false; }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority: authorities){
            if (role.equals(authority.getAuthority())){
                return true;
            }
        }
        return false;

    }

}
