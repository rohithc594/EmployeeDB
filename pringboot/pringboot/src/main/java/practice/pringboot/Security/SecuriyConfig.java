package practice.pringboot.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
public class SecuriyConfig {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/test").permitAll()
                        .requestMatchers("/addUser").permitAll()
                        .requestMatchers("/user/register").permitAll()
                        .requestMatchers("/AllEmployees").permitAll()
                        .requestMatchers("/get").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()); //username and password , login page cerate
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws  Exception{
        return configuration.getAuthenticationManager();
    }
}
