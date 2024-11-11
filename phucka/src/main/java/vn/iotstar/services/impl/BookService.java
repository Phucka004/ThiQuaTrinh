package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IBookDao;
import vn.iotstar.dao.impl.BookDaoImpl;
import vn.iotstar.models.BookDTO;
import vn.iotstar.models.BookModel;
import vn.iotstar.services.IBookService;

public class BookService implements IBookService {

	public IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<BookDTO> findAll() {
		return bookDao.findAll();
	}

	@Override
	public BookDTO findById(int id) {
		return bookDao.findById(id);
	}

	@Override
	public void insert(BookModel book) {
		bookDao.insert(book);
		
	}

	@Override
	public void update(BookModel book) {
		/*BookModel books = new BookModel();
		books = bookDao.findById(book.getBookid());
		if(books != null)
		{
		bookDao.update(book);
		}*/
	
	}

	@Override
	public void delete(int id) {
		/*BookModel books = new BookModel();
		books = bookDao.findById(id);
		if(books != null)
		{
		bookDao.delete(id);
		}*/
	}

}
