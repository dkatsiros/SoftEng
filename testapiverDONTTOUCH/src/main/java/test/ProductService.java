package test;

import test.Product;

public interface ProductService {

	public Iterable<Product> findAll();

	public void delete(int id);

}