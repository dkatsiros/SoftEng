package test;

import javax.servlet.http.HttpServletRequest;

//edw exoyme to sign up
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request,
           @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (logout != null) {
            model.addObject("message", "logout successfully");
        }

        model.setViewName("login-new"); 
        return model;
    }
}