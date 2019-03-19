package pl.borowik.akademia.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.borowik.akademia.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource securityDataSource;

    @Autowired
    private UserService userService;

 //   @Autowired
 //   private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource)
        .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/home",
                        "/loginForm", "/logaut", "register/**",
                        "/resources/**").permitAll()
                .antMatchers("/students/list").hasAnyRole("ROLE_USER")
                .antMatchers("/**").access("hasRole('ROLE_TRAINER')")
                .and()

                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/authenticateTheUser").permitAll()
                .defaultSuccessUrl("/students/list")
            //    .successHandler(customAuthenticationSuccessHandler)
                .usernameParameter("username")//
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout();
            //    .and()
            //    .exceptionHandling().accessDeniedPage("/access-denied");

    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


}
