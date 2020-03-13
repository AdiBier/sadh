package com.ab.sadh.config;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecuritySettings extends WebSecurityConfigurerAdapter {

    @Bean
<<<<<<< HEAD
//    @Profile(ProfileNames.INMEMORY) //TODO możliwe by skasować 3 miejscach te rzeczy
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        UserDetails user = userBuilder
                .username("user")
                .password("user")
                .roles("CUSTOMER")
                .build();

        UserDetails admin = userBuilder
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        manager.createUser(user);
        manager.createUser(admin);
        return manager;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
=======
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers
                            ("/",
                            "/login",
<<<<<<< HEAD
                            "/api/login",
                            "/api/register",
                            "/register",
=======
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
                            "/home")
                        .permitAll()
                    .antMatchers("/auth/**", "/oauth2/**")
                        .permitAll()
                    .antMatchers
<<<<<<< HEAD
                            ("/api/**").access("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
=======
                            ("/api/**").access("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MANAGER')")
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
                    .anyRequest()
                        .authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .permitAll()
                .and()
                        .logout()
                        .permitAll();
    }
<<<<<<< HEAD
=======

>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
}
