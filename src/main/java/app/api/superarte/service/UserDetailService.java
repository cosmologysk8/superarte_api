package app.api.superarte.service;

import app.api.superarte.model.Role;
import app.api.superarte.model.Users;
import app.api.superarte.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);

        if (user == null){
            logger.error("Error login: No existe el email " + email);
            throw  new UsernameNotFoundException("Email " + email + " no existe");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()){
            logger.info("Role: ".concat(role.getRole()));
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        if (authorities.isEmpty()){
            logger.error("Error login: no tienes role asignado");
            throw  new UsernameNotFoundException("No existe role asignado");
        }

        return new User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
    }

}
