package test;

import org.springframework.data.repository.CrudRepository;
import test.Price;

public interface PriceRepository extends CrudRepository<Price, Integer> {

}
