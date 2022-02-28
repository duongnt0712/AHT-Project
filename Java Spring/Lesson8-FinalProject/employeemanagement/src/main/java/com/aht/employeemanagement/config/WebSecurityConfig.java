package com.aht.employeemanagement.config;

import com.aht.employeemanagement.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //gọi tới UserDetailService để cấu hình
    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }

    //interface PasswordEncoder đảm nhiệm việc mã hoá mật khẩu bằng thuật toán BCrypt
    //Muốn sử dụng nó, phải cấu hình nó thành 1 bean
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //cấu hình các chị tiết về bảo mật
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()

                .antMatchers("/user").hasAnyAuthority("USER")
                .antMatchers("/admin").hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()

                //Đăng nhập
                .formLogin().permitAll()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .passwordParameter("password")

                .defaultSuccessUrl("/")

                .failureUrl("/login?error")
                .and()

                .exceptionHandling()
                .accessDeniedPage("/403");
    }

}
