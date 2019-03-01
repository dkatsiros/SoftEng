package test;

import static test.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import test.MyLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyLogoutSuccessHandler myLogoutSuccessHandler;
	private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	//private MyLogoutSuccessHandler myLogoutSuccessHandler;
	
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.cors().and().csrf().disable().authorizeRequests()
        //.antMatchers(HttpMethod.POST,"/logout").authenticated() //ginetai na mpoyn 2 antmatchers
		.antMatchers(HttpMethod.GET).permitAll()
		.anyRequest().authenticated() // POSIBOL
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/greeting")
		.logoutSuccessHandler(myLogoutSuccessHandler)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")); //posibol

        
		
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration configuration = new CorsConfiguration();
    //configuration.setAllowedOrigins("/logout");
    //configuration.setAllowedMethods(POST);
    //exei na kanei me to pou erxontai na aithmata toy FrontEnd
    source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
    return source;
  }
 
}