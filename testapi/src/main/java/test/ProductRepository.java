package test;

import org.springframework.data.repository.CrudRepository;

import test.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
