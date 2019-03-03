package test;

import static test.SecurityConstants.HEADER_STRING;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//edw exoyme to sign up
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import test.AuthToken;
import test.AuthTokenRepository;

@RestController
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
	private AuthTokenRepository authTokenRepository;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        /*
        user.setEmail(user.getEmail());
        user.setFname(user.getEmail());
        user.setLname(user.getEmail());
        user.setPoints(0);
        */
        applicationUserRepository.save(user);
		return "Done signing up";

    }
    
    @PostMapping("/api/logout")
    public Message onLogoutSuccessShowMessage(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
    	response.setStatus(HttpServletResponse.SC_OK);
    	AuthToken a=new AuthToken();
    	String tokenValue=request.getHeader(HEADER_STRING);
    	if (tokenValue != null) a=authTokenRepository.findByValue(tokenValue);
    	a.setwithdrawn(1);
    	authTokenRepository.save(a);
        Message messagaki = new Message();
		messagaki.setmessage("OK");
		return messagaki;
    }
/*
    @PostMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "giiiiiixaaaaaa";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    */
}