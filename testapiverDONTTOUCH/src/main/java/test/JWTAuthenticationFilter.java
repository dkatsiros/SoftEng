package test;

//gia na dimioyrgh8ei to token OUSIASTIKA PARAEGEI TO TOKEN
import com.auth0.jwt.JWT;
import test.ApplicationUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static test.SecurityConstants.EXPIRATION_TIME;
import static test.SecurityConstants.HEADER_STRING;
import static test.SecurityConstants.SECRET;
import static test.SecurityConstants.TOKEN_PREFIX;
import test.AuthToken;
import test.AuthTokenRepository;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    @Autowired
	private AuthTokenRepository AuthTokenRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager; //constructor
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException { //prospa8ei na koitaxei an tairiazei username password
        try {
            ApplicationUser creds = new ObjectMapper()
                    .readValue(req.getInputStream(), ApplicationUser.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);    //dimiourgei to token poy 8eloyme    
        
        /*
        AuthToken a = new AuthToken();
		a.setvalue(token);
		//String usernamegiatotoken= ((User) auth.getPrincipal()).getUsername();
		//Optional<ApplicationUser> appuser =ApplicationUserRepository.findByUsername(usernamegiatoken);
		//a.setuser_role(appuser.getrole()); 
		a.setuser_role("ADMIN"); //GIA TESTING
		a.setwithdrawn(0);
		AuthTokenRepository.save(a);
		*/
    }
}