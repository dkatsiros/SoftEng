package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.aspectj.weaver.reflect.IReflectionWorld;
import org.assertj.core.util.DateUtil;
import org.hibernate.id.ResultSetIdentifierConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.Price;
import test.PriceRepository;
import test.Product;
import test.ProductRepository;
import test.Productout;
import test.Shop;
import test.Shopout;
import test.ShopRepository;
import test.Priceout;
import test.PagingProduct;
import test.PagingShop;
 
@RestController
public class GreetingController {
//implements ErrorController {
	
	private static final String PATH="/error";
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private ShopRepository ShopRepository;
	@Autowired
	private PriceRepository PriceRepository;
	
	@GetMapping (path = "/products")
	public PagingProduct getAllProducts(@RequestParam Optional<String> status, @RequestParam Optional<String> sort,
			@RequestParam Optional<Integer> start, @RequestParam Optional<Integer> count) {
		int size = 0, i, total;
		List<Productout> productsout = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		if (!status.isPresent()) {
			ProductRepository.findBywithdrawn(0).forEach(products::add);
			size = products.size();
		}
		else {
			if (status.get().equals("ACTIVE")) {
				ProductRepository.findBywithdrawn(0).forEach(products::add);
				size = products.size();
			}
			if (status.get().equals("ALL")) {
				ProductRepository.findAll().forEach(products::add);
				size = products.size();
			}
			if (status.get().equals("WITHDRAWN")) {
				ProductRepository.findBywithdrawn(1).forEach(products::add);
				size = products.size();
			}
		}
		if (!sort.isPresent()) {
			products.sort(Comparator.comparing(Product::getid).reversed());
		}
		else {
			if (sort.get().equals("id/DESC")) products.sort(Comparator.comparing(Product::getid).reversed());
			if (sort.get().equals("id/ASC")) products.sort(Comparator.comparing(Product::getid));
			if (sort.get().equals("name/ASC")) products.sort(Comparator.comparing(Product::getname));
			if (sort.get().equals("name/DESC")) products.sort(Comparator.comparing(Product::getname).reversed());
		}
		for (i=0; i<size; i++) {
			Productout productout = new Productout(products.get(i));
			productsout.add(productout);
		}
		
		total = size;
		PagingProduct out = new PagingProduct(start.get(), count.get(), total);
		if (count.get() < total) size = count.get();
		else size = total;
		for (i=0; i<size; i++) {
			out.products.add(productsout.get(i));
		}
		return out;
	}
	
	@GetMapping("/products/{id}")
	public Productout retrieveProduct(@PathVariable int id) {
		Optional<Product> product = ProductRepository.findById(id);

		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);

		Productout productout = new Productout(product.get());
		return productout;
	}
	
	@PutMapping("/products/{id}")
	public Productout updateProduct(@PathVariable int id, @RequestParam String name, @RequestParam String description, @RequestParam String category,
			@RequestParam String tags) {
		Optional<Product> product = ProductRepository.findById(id);
		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);
		product.get().setname(name);
		product.get().setdescription(description);
		product.get().setcategory(category);
		product.get().settags(tags);
		ProductRepository.save(product.get());
		Productout productout = new Productout(product.get());
		return productout;
		
	}
	
	@PatchMapping("/products/{id}")
	public Productout semiupdateProduct(@PathVariable int id, @RequestParam Optional<String> name, @RequestParam Optional<String> description, @RequestParam Optional<String> category,
			@RequestParam Optional<String> tags) {
		Optional<Product> product = ProductRepository.findById(id);
		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);
		if (name.isPresent()) {
			product.get().setname(name.get());
		}
		if (description.isPresent()) {
			product.get().setdescription(description.get());
		}
		if (category.isPresent()) {
			product.get().setcategory(category.get());
		}
		if (tags.isPresent()) {
			product.get().settags(tags.get());
		}
		ProductRepository.save(product.get());
		Productout productout = new Productout(product.get());
		return productout;
	}
	 
	@PostMapping (path = "/products")
	public @ResponseBody Productout addProduct(@RequestParam String name, @RequestParam String description, @RequestParam String category,
			@RequestParam String tags) {
		Product p = new Product();
		p.setname(name);
		p.setcategory(category);
		p.setdescription(description);
		p.settags(tags);
		p.setwithdrawn(0);
		ProductRepository.save(p);
		Productout productout = new Productout(p);
		return productout;
	}
	
	@GetMapping(path = "/shops")
	public @ResponseBody PagingShop getAllShops(@RequestParam Optional<String> status, @RequestParam Optional<String> sort,
			@RequestParam Optional<Integer> start, @RequestParam Optional<Integer> count) {
		int size=0, i, total;
		List<Shopout> shopssout = new ArrayList<>();
		List<Shop> shops = new ArrayList<>();
		if (!status.isPresent()) {
			ShopRepository.findBywithdrawn(0).forEach(shops::add);
			size = shops.size();
		}
		else {
			if (status.get().equals("ACTIVE")) {
				ShopRepository.findBywithdrawn(0).forEach(shops::add);
				size = shops.size();
			}
			if (status.get().equals("ALL")) {
				ShopRepository.findAll().forEach(shops::add);
				size = shops.size();
			}
			if (status.get().equals("WITHDRAWN")) {
				ShopRepository.findBywithdrawn(1).forEach(shops::add);
				size = shops.size();
			}
		}
		if (!sort.isPresent()) {
			shops.sort(Comparator.comparing(Shop::getid).reversed());
		}
		else {
			if (sort.get().equals("id/DESC")) shops.sort(Comparator.comparing(Shop::getid).reversed());
			if (sort.get().equals("id/ASC")) shops.sort(Comparator.comparing(Shop::getid));
			if (sort.get().equals("name/ASC")) shops.sort(Comparator.comparing(Shop::getname));
			if (sort.get().equals("name/DESC")) shops.sort(Comparator.comparing(Shop::getname).reversed());
		}
		for (i=0; i<size; i++) {
			Shopout shopout = new Shopout(shops.get(i));
			shopssout.add(shopout);
		}
		total = size;
		PagingShop out = new PagingShop(start.get(), count.get(), total);
		if (count.get() < total) size = count.get();
		else size = total;
		for (i=0; i<size; i++) {
			out.shops.add(shopssout.get(i));
		}
		return out;
	}
	
	
	@GetMapping("/shops/{id}")
	public Shopout retrieveShop(@PathVariable int id) {
		Optional<Shop> shop = ShopRepository.findById(id);

		if (!shop.isPresent())
			throw new ShopNotFoundException("id-" + id);

		Shopout shopout = new Shopout(shop.get());
		return shopout;
	}
	
	@PutMapping("/shops/{id}")
	public Shopout updateShop(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam Double lng, 
			@RequestParam Double lat, @RequestParam String tags) {
		Optional<Shop> shop = ShopRepository.findById(id);
		if (!shop.isPresent())
			throw new ShopNotFoundException("id-" + id);
		shop.get().setname(name);
		shop.get().setaddress(address);
		shop.get().setlng(lng);
		shop.get().setlat(lat);
		shop.get().settags(tags);
		ShopRepository.save(shop.get());
		Shopout shopout = new Shopout(shop.get());
		return shopout;
	}
	
	@PatchMapping("/shops/{id}")
	public Shopout semiupdateShop(@PathVariable int id, @RequestParam Optional<String> name, @RequestParam Optional<String> address, 
			@RequestParam Optional<Double> lng, @RequestParam Optional<Double> lat, @RequestParam Optional<String> tags) {
		Optional<Shop> shop = ShopRepository.findById(id);
		if (!shop.isPresent())
			throw new ShopNotFoundException("id-" + id);
		if(name.isPresent()) {
			shop.get().setname(name.get());
		}
		if(address.isPresent()) {
			shop.get().setaddress(address.get());
		}
		if(lng.isPresent()) {
			shop.get().setlng(lng.get());
		}
		if(lat.isPresent()) {
			shop.get().setlat(lat.get());
		}
		if(tags.isPresent()) {
			shop.get().settags(tags.get());
		}
		Shopout shopout = new Shopout(shop.get());
		return shopout;
	}
	
	@PostMapping(path = "/shops") 
	public @ResponseBody Shopout addShop(@RequestParam String name, @RequestParam String address, @RequestParam Double lng, 
			@RequestParam Double lat, @RequestParam String tags) {
		Shop s = new Shop();
		s.setname(name);
		s.setaddress(address);
		s.setlng(lng);
		s.setlat(lat);
		s.settags(tags);
		s.setwithdrawn(0);
		ShopRepository.save(s);
		Shopout shopout = new Shopout(s);
		return shopout;
	}
	
	
	@GetMapping("/prices")
	public @ResponseBody PagingPrice getallPrices(@RequestParam Optional<List<Integer>> Productsid, @RequestParam Optional<List<Integer>> Shopsid,
			@RequestParam Optional<Integer> geoDst, @RequestParam Optional<Double> geoLng, @RequestParam Optional<Double> geoLat,
			@RequestParam Optional<Date> dateFrom, @RequestParam Optional<Date> dateTo, @RequestParam Optional<List<String>> tags,
			@RequestParam Optional<String> sort, @RequestParam Optional<Integer> start, @RequestParam Optional<Integer> count) {
		int size=0, i, total;
		List<Priceout> result = new ArrayList<>();
		List<Price> prices = new ArrayList<>();
		List<Price> priceout = new ArrayList<>();
		List<Price> priceout2 = new ArrayList<>();
		List<Price> priceout3 = new ArrayList<>(); 
		if (!Productsid.isPresent() && Shopsid.isPresent()) {
			PriceRepository.findByShopIdIn(Shopsid.get()).forEach(prices::add);
		}
		if (Productsid.isPresent() && !Shopsid.isPresent()) {
			PriceRepository.findByProductIdIn(Productsid.get()).forEach(prices::add);
		}
		if (Productsid.isPresent() && Shopsid.isPresent()) {
			PriceRepository.findByProductIdAndShopIdIn(Productsid.get(), Shopsid.get()).forEach(prices::add);
		}
		if (!Productsid.isPresent() && !Shopsid.isPresent()) {
			PriceRepository.findAll().forEach(prices::add);
		}
		if (dateFrom.isPresent()) {
			size = prices.size();
			for (i=0; i<size; i++) {
				Date dateFromPrice = prices.get(i).getdateFrom();
				Date dateToPrice = prices.get(i).getdateTo();
				
				if(dateFromPrice.before(dateFrom.get()) && dateToPrice.after(dateTo.get())) {
					priceout.add(prices.get(i));
				}
			}
		}
		else {
			java.util.Date dateFrom1 = new java.util.Date();
			Date dateFrom2 = new java.sql.Date(dateFrom1.getTime());
			java.util.Date dateTo1 = new java.util.Date();
			Date dateTo2 = new java.sql.Date(dateTo1.getTime());
			size = prices.size();
			for (i=0; i<size; i++) {
				Date dateFromPrice = prices.get(i).getdateFrom();
				Date dateToPrice = prices.get(i).getdateTo();
				
				if(dateFromPrice.before(dateFrom2) && dateToPrice.after(dateTo2)) {
					priceout.add(prices.get(i));
				}
			}
		}
		if (tags.isPresent()) {
			size = priceout.size();
			for (i=0; i<size; i++) {
				List<String> producttags = Arrays.asList(priceout.get(i).getproduct().gettags().split("\\s*,\\s*"));
				List<String> shopttags = Arrays.asList(priceout.get(i).getshop().gettags().split("\\s*,\\s*"));
				boolean flag = false;
				for (int j=0; j<producttags.size(); j++) {
					if (flag) break;
					for (int k=0; k<tags.get().size(); k++) {
						if (tags.get().get(k).equals(producttags.get(j))) {
							priceout2.add(priceout.get(i));
							flag = true;
							break;
						}
					}
				}
				for (int j=0; j<shopttags.size(); j++) {
					if (flag) break;
					for (int k=0; k<tags.get().size(); k++) {
						if (tags.get().get(k).equals(shopttags.get(j))) {
							priceout2.add(priceout.get(i));
							flag = true;
							break;
						}
					}
				}
			}
		}
		else {
			size = priceout.size();
			for (i=0; i<size; i++) {
				priceout2.add(priceout.get(i));
			}
		}
		List<Double> distances = new ArrayList<>();
		if (geoDst.isPresent()) {
			size = priceout2.size();
			for (i=0; i<size; i++) {
				Shop newshop = priceout2.get(i).getshop();
				double lng = newshop.getlng();
				double lat = newshop.getlat();
				double theta = geoLng.get() - lng;
				double dist = Math.sin(Math.toRadians(geoLat.get())) * Math.sin(Math.toRadians(lat)) + Math.cos(Math.toRadians(geoLat.get()))* Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.515;
				dist = dist * 1.609344;
				if (dist <= geoDst.get()) {
					priceout3.add(priceout2.get(i));
					distances.add(dist);
				}
			}
		}
		else {
			size = priceout2.size();
			for (i=0; i<size; i++) {
				priceout3.add(priceout2.get(i));
				distances.add(0.0);
			}
		}
		Date date;
		if (!dateFrom.isPresent()) {
			java.util.Date dateFrom1 = new java.util.Date();
			Date dateFrom2 = new java.sql.Date(dateFrom1.getTime());
			date = dateFrom2;
		}
		else {
			date = dateFrom.get();
		}
		size = priceout3.size();
		for (i=0; i<size; i++) {
			Priceout newresult = new Priceout(priceout3.get(i), distances.get(i), date);
			result.add(newresult);
		}
		if(!sort.isPresent()) {
			result.sort(Comparator.comparing(Priceout::getprice));
		}
		else {
			if (sort.get().equals("price/ASC")) {
				result.sort(Comparator.comparing(Priceout::getprice));
			}
			if (sort.get().equals("price/DESC")) {
				result.sort(Comparator.comparing(Priceout::getprice).reversed());
			}
			if (sort.get().equals("geoDist/ASC")) {
				result.sort(Comparator.comparing(Priceout::getdist));
			}
			if (sort.get().equals("geoDist/DESC")) {
				result.sort(Comparator.comparing(Priceout::getdist).reversed());
			}
		}
		total = size;
		PagingPrice out = new PagingPrice(start.get(), count.get(), total);
		if (count.get() < total) size = count.get();
		else size = total;
		for (i=0; i<size; i++) {
			out.products.add(result.get(i));
		}
		return out;
		
		//return result;
		//return priceout3;
	}
	
	@PostMapping("/prices")
	public @ResponseBody String addPrice(@RequestParam Double price, @RequestParam Integer productid, @RequestParam Integer shopid,
			@RequestParam Date dateFrom, @RequestParam Date dateTo) {
		Price p = new Price();
		p.setprice(price);
		Optional<Product> product = ProductRepository.findById(productid);
		Optional<Shop> shop = ShopRepository.findById(shopid);
		p.setproduct(product.get());
		p.setshop(shop.get());
		p.setdateFrom(dateFrom);
		p.setdateTp(dateTo);
		p.setthumbsdown(0);
		p.setthumbsup(0);
		PriceRepository.save(p);
		return "done";
	}
	
	/*
	@RequestMapping(value=PATH,method=RequestMethod.GET)
	public String defaultErrorMessage(){
		return "Requested Resource is not found!4!0!4!";
	}

	@Override
	public String getErrorPath() {
		return PATH;	
	}	*/
	
	
	
}