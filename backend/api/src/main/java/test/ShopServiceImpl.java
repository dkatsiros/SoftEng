package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.Shop;
import test.ShopRepository;

@Transactional
@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Iterable<Shop> findAll() {
		return shopRepository.findAll();
	}

	@Override
	public void delete(int id) {
		shopRepository.deleteById(id);
	}

}
