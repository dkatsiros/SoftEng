package test;

import static test.SecurityConstants.HEADER_STRING;
import static test.SecurityConstants.SECRET;
import static test.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import test.Price;
import test.PriceRepository;
import test.Product;
import test.ProductRepository;
import test.Productout;
import test.Shop;
import test.Shopout;
import test.ShopRepository;
import test.Message;
import test.ApplicationUserRepository;
import test.ApplicationUser;
import test.AuthToken;
import test.AuthTokenRepository;

@RestController
public class DeletionController {
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private ShopRepository ShopRepository;
	@Autowired		
	private ApplicationUserRepository ApplicationUserRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private AuthTokenRepository authTokenRepository;
	

	
	@DeleteMapping("/products/{id}")
	public Message deleteProductbyId(@PathVariable int id, HttpServletRequest request,HttpServletResponse response) {
		Optional<Product> product = ProductRepository.findById(id);

		String token = request.getHeader(HEADER_STRING);
        AuthToken a = new AuthToken();
        a=authTokenRepository.findByValue(token);
        if(a==null)System.out.println("null leme");
        else if((a.getwithdrawn()).equals(1)) {
        try {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "You have to login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
            	ApplicationUser appuser = new ApplicationUser();
            	appuser=ApplicationUserRepository.findByUsername(user);
        		if((appuser.getrole()).equals("USER")) product.get().setwithdrawn(1);
        		else productService.delete(id);
            }
        }
		
		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);
		//checkarisma authorized user an einai admin / aplos user
		ProductRepository.save(product.get());
		Message messagaki = new Message();
		messagaki.setmessage("OK");
		return messagaki;
	}
	
	@DeleteMapping("/shops/{id}")
	public Message deleteShopbyId(@PathVariable int id, HttpServletRequest request) {
		Optional<Shop> shop = ShopRepository.findById(id);

		String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();

            if (user != null) {
            	ApplicationUser appuser = new ApplicationUser();
            	appuser=ApplicationUserRepository.findByUsername(user);
        		if((appuser.getrole()).equals("USER")) shop.get().setwithdrawn(1);
        		else shopService.delete(id);
            }
        }
		
		if (!shop.isPresent())
			throw new ShopNotFoundException("id-" + id);
		//checkarisma authorized user an einai admin / aplos user
		shop.get().setwithdrawn(1);
		ShopRepository.save(shop.get());
		Message messagaki = new Message();
		messagaki.setmessage("OK");
		return messagaki;
	}
}
