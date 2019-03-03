package test;

import java.util.ArrayList;
import java.util.List;

public class PagingShop {
	
	private Integer start;
	private Integer count;
	private Integer total;
	public List<Shopout> shops = new ArrayList<>();
	
	public Integer getstart() {
		return start;
	}
	
	public Integer getcount() {
		return count;
	}
	
	public Integer gettotal() {
		return total;
	}
	
	public List<Shopout> getshops() {
		return shops;
	}
	
	public PagingShop(Integer start, Integer count, Integer total) {
		this.start = start;
		this.count = count;
		this.total = total;
	}

}
