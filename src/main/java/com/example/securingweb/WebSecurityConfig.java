package com.example.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/r/r1").hasAuthority("p1")
				.antMatchers("/r/r2").hasAuthority("p2")
				.anyRequest().authenticated()
				.and()


			.formLogin()
				.loginPage("/login")//设置没有登录的情况下跳转到哪个controller的url
				.loginProcessingUrl("/loginProcessUrlXRQ")//设置哪个url处理登录表单请求，即登录表单应该配置的请求地址
				.permitAll()
				.and()
			    .logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.authorities("p1")
				.build();

		UserDetails user2 =
				User.withDefaultPasswordEncoder()
						.username("user2")
						.password("password2")
						.authorities("p2")
						.build();


		return new InMemoryUserDetailsManager(user,user2);
	}
}
