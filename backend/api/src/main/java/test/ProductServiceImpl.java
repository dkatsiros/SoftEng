package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.Product;
import test.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

}
