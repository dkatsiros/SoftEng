package test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import test.Price;
import test.PriceRepository;
import test.Product;
import test.ProductRepository;
import test.Productout;
import test.Shop;
import test.Shopout;
import test.ShopRepository;
import test.Message;
 
@RestController
public class DeletionController {
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private ShopRepository ShopRepository;
	
	@DeleteMapping("/products/{id}")
	public Message deleteProductbyId(@PathVariable int id) {
		Optional<Product> product = ProductRepository.findById(id);

		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);
		//checkarisma authorized user an einai admin / aplos user
		product.get().setwithdrawn(1);
		ProductRepository.save(product.get());
		Message messagaki = new Message();
		messagaki.setmessage("OK");
		return messagaki;
	}
	
	@DeleteMapping("/shops/{id}")
	public Message deleteShopbyId(@PathVariable int id) {
		Optional<Shop> shop = ShopRepository.findById(id);

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
