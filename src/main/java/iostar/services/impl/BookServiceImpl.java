package iostar.services.impl;

import java.util.List;

import iostar.dao.IBookDao;
import iostar.dao.impl.BookDaoImpl;
import iostar.model.Book;
import iostar.services.IBookService;

public class BookServiceImpl implements IBookService{
	 private IBookDao bookDAO = new BookDaoImpl();

	    @Override
		public List<Book> getBooksByAuthorId(int authorId) {
	        try {
				return bookDAO.getBooksByAuthorId(authorId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }

		@Override
		public Book findBookDetails(int id) {
			try {
				return bookDAO.findBookDetails(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Book findBookRatings(int id) {
			try {
				return bookDAO.findBookRatings(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Book findById(int bookid) {
			try {
				return bookDAO.findById(bookid);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}
