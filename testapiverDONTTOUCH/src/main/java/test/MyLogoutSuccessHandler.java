package test;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.Message;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler{
	/*
    public Message onLogoutSuccessShowMessage (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        Message messagaki = new Message();
        if (authentication != null && authentication.getDetails() != null) {
            try {
                //httpServletRequest.getSession().invalidate();
                //System.out.println("User Successfully Logout");
        		messagaki.setmessage("OK");
        		authentication.setAuthenticated(false);
                //you can add more codes here when the user successfully logs out,
                //such as updating the database for last active.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        //httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		return messagaki;

    }

	/*
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Override
		public void onLogoutSuccess(HttpServletRequest request,
				HttpServletResponse response, Authentication authentication)
				throws IOException, ServletException {
			// Code For Business Here
			logger.info("Logout Sucessfull with Principal: ");
			
			response.setStatus(HttpServletResponse.SC_OK);
	        //redirect to login
			//response.sendRedirect("/logoutsuccessful");
		}
		
	*/

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		 if (authentication != null && authentication.getDetails() != null) {
	            try {
	                //httpServletRequest.getSession().invalidate();
	                //System.out.println("User Successfully Logout");
	        		//messagaki.setmessage("OK");
	        		//authentication.setAuthenticated(false);
	                //you can add more codes here when the user successfully logs out,
	                //such as updating the database for last active.
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
		 }
		 response.setStatus(HttpServletResponse.SC_OK);
	}




}