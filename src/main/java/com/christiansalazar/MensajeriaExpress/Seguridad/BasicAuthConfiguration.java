package com.christiansalazar.MensajeriaExpress.Seguridad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthConfiguration {

    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        return new InMemoryUserDetailsManager
                (User.withUsername(username)
                        .password(passwordEncoder().encode(password))
                        .authorities("read","write")
                        .build()
                );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic()
                .and().authorizeHttpRequests()
                .antMatchers(HttpMethod.GET).hasAuthority("read")
                .antMatchers(HttpMethod.POST).hasAuthority("write")
                .antMatchers(HttpMethod.PUT).hasAuthority("write")
                .antMatchers(HttpMethod.DELETE).hasAuthority("write")
                .antMatchers("/swagger-ui/**").hasAuthority("write")
                .antMatchers("/h2-console/**").hasAuthority("write")
                .and().csrf().disable().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }
}
