package springsecurity.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	//create filter chain
}
