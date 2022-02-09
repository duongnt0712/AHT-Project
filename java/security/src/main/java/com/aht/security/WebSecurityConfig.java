package com.aht.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //kích hoạt việc tích hợp Spring Security với Spring MVC
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //gọi tới UserDetailService để cấu hình
    @Autowired
    private UserDetailsService userDetailsService;

    //interface PasswordEncoder đảm nhiệm việc mã hoá mật khẩu bằng thuật toán BCrypt
    //Muốn sử dụng nó, phải cấu hình nó thành 1 bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService);
    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    //cấu hình các chị tiết về bảo mật
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                //Phân quyền request
                .authorizeRequests()
                //antMatchers() khai báo đường dẫn của request (ở đây là register)
                //permitAll() cho phép tất cả các user truy cập
                .antMatchers("/register").permitAll()

                //hasRole(role) chỉ cho các user có GrantedAuthority là ROLE_role truy cập
                .antMatchers("/").hasRole("MEMBER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()

                //Đăng nhập
                .formLogin()

                //đường dẫn tới trang chứa form đăng nhập
                .loginPage("/login")

                //giá trị của thuộc tính name của 2 input nhập username và password
                .usernameParameter("email")
                .passwordParameter("password")

                //đường dẫn tới trang đăng nhập thành công
                .defaultSuccessUrl("/")

                //đường dẫn tới trang đăng nhập thất bại
                .failureUrl("/login?error")

                .and()

                //Trang đăng xuất có mặc định là /logout, sau khi đăng xuất sẽ
                //redirect về trang /login?logout
                //ta giữ nguyên cấu hình mặc định của phần này nên không viết code

                //Từ chối truy cập => redirect về trang 403
                .exceptionHandling()
                .accessDeniedPage("/403");

    }
}
