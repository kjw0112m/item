package spring.repository;

import java.util.List;

import spring.entity.ItemDto;

public interface ItemDao {
	void insert(ItemDto dto);
	
	List<ItemDto> list();
	
	List<ItemDto> get(int no);
}


