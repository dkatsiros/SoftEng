package test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import test.Price;

public interface PriceRepository extends CrudRepository<Price, Integer> {
	
	public List<Price> findByProductIdIn(List<Integer> productid);
	public List<Price> findByShopIdIn(List<Integer> shopid); 
	public List<Price> findByProductIdAndShopIdIn(List<Integer> productid, List<Integer> shopid);

}
