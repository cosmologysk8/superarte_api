package app.api.superarte;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService()throws Exception{

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("adrian")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build());

        manager.createUser(User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN","USER")
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        Aquí, usamos antMatchers() en lugar de requestMatchers() para poder especificar patrones de URL más complejos.
//        Con .antMatchers("/gabinetes/delete/**").hasRole("ADMIN"), estamos permitiendo el acceso solo a los usuarios
//        con el rol "ADMIN" a todos los endpoints que comienzan con "/gabinetes/delete/".

        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/gabinetes/listar", "/gabinetes/id/**", "/gabinetes/direccion/**").hasAnyRole("USER")
                .requestMatchers("/gabinetes/delete/**", "/gabinetes/crear", "/gabinetes/editar/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint((request, response, authException) -> {
                    System.out.println("Autenticación fallida: " + authException.getMessage());
                });

        return http.build();
    }

}
