package ptf.rs.eventApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ptf.rs.eventApp.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private CustomUserDetailService _CustomUserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf()
        .disable()
        .authorizeHttpRequests()
        .antMatchers("/registration", "/").permitAll()
        .antMatchers("/registration/**").permitAll()
        .antMatchers("/addlocation").hasAuthority("ADMIN")
        .antMatchers("/addcategory").hasAuthority("ADMIN")
        .antMatchers("/addevent").hasAuthority("ADMIN")
        .antMatchers("/getlocations").hasAuthority("ADMIN")
        .antMatchers("/getcategories").hasAuthority("ADMIN")
        .antMatchers("/home").hasAuthority("USER")
        .antMatchers("/home").hasAuthority("ADMIN")
        .antMatchers("/registration-static-files/**").permitAll()
        .antMatchers("/login-static-files/**").permitAll()
        .antMatchers("/homepage-static-files/**").permitAll()
        .antMatchers("/bootstrap/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .failureUrl("/login?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/", true)
            .permitAll())
        .logout(
            logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .permitAll())
        .rememberMe()
        .key("security-remember-secret")
        .tokenValiditySeconds(86400)
        .and()
        .userDetailsService(_CustomUserDetailService)
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

