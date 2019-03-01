package test;

import test.Shop;

public interface ShopService {

	public Iterable<Shop> findAll();

	public void delete(int id);

}