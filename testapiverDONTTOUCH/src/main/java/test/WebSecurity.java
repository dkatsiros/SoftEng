/* package test;

//sto bean ta exception se sxolia . if the token is good let him stay
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import test.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;

import static test.SecurityConstants.SIGN_UP_URL;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
    private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	//private MyLogoutSuccessHandler myLogoutSuccessHandler;
	
    public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
        		//.antMatchers(HttpMethod.POST, "/logout").authenticated()
        		.antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()//EDW AN VALW ANTI GIA POST, GET EPITREPEI OLA TA GET
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        		.and()
        		.logout()
        		.logoutSuccessUrl("/logout")
        		//.logoutSuccessHandler(myLogoutSuccessHandler)
        		.logoutUrl("/logout")
                .invalidateHttpSession(true);
    }
/*
    @Bean
    public AuthenticationSuccessHandler successHandler() {
    	SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
    	handler.setUseReferer(true);
    	handler.setDefaultTargetUrl("/greeting");
    	return handler;
}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.csrf().disable()
         .authorizeRequests()
         	//.antMatchers("/logout").authenticated()
             //.antMatchers(HttpMethod.GET).permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .successHandler(successHandler())
             //.failureUrl("/login_failure")
             .usernameParameter("username")
             .passwordParameter("password")
             .permitAll()
             .and()
             .requiresChannel()		//config request to use the mapping to a required channel
				.anyRequest().requiresSecure()
 			.and()
 			.logout()
             .permitAll()
             .logoutSuccessUrl("/greeting");
    	 }
*/
   /*
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
    source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
    return source;
  }
 */

//}
