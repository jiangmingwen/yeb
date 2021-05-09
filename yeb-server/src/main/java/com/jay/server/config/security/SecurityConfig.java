package com.jay.server.config.security;

import com.jay.server.pojo.Admin;
import com.jay.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Admin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                return admin;
            }
            return null;
        };
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/api/unauth/**",
                "/ws/**",
                "/css/**",
                "/js/**",
                "/index.html",
                "favicon.ico",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用jwt不需要csrf
        http.csrf().disable()
                //基于token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //都需要认证
                .anyRequest()
                .authenticated()
                .and()
                //禁用缓存
                .headers()
                .cacheControl();

        //添加jwt,登录授权过滤器
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //添加自定义未授权，未登录的结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);

    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter() {
        return new JwtAuthencationTokenFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
