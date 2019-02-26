package test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import test.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	public List<Product> findBywithdrawn(Integer withdrawn);
	//public List<Product> findBywithdrawnOrderByidDesc(Integer withdrawn);
	//public List<Product> findBywithdrawnOrderBynameAsc(Integer withdrawn);
	//public List<Product> findBywithdrawnOrderBynameDesc(Integer withdrawn);
	//public List<Product> findAllByOrderBynameAsc();
	//public List<Product> findAllByOrderBynameDesc();
	//public List<Product> findAllByOrderByidAsc();
	//public List<Product> findAllByOrderByidDesc();
}
