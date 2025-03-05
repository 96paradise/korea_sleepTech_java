package chapter10.practice01; // 인터페이스 -1

import java.util.List;

// 재고 관리 시스탬에서 관리할 수 있는 동작 정의 
public interface Manageable {
	void add(Item item);
	void remove(String id);
	List<Item> search(String keyword);
	List<Item> searchByCategory(String category);
	List<Item> searchByPriceRange(int minPrice, int maxPrice);
	void updateStock(String id, int quantity);
	void listAll();

}
