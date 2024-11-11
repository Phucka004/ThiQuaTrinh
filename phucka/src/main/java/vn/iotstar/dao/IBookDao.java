package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.BookDTO;
import vn.iotstar.models.BookModel;

public interface IBookDao {
	List<BookDTO> findAll();
	
	BookDTO findById(int id);
	void insert(BookModel book);
	void update(BookModel book);
	void delete(int id);
	
}
