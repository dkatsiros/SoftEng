package test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import test.Shop;

public interface ShopRepository extends CrudRepository<Shop, Integer> {
	
	public List<Shop> findBywithdrawn(Integer withdrawn);


}
