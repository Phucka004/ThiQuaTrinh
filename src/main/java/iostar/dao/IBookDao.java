package iostar.dao;

import java.util.List;

import iostar.model.Book;

public interface IBookDao {

	List<Book> getBooksByAuthorId(int authorId) throws ClassNotFoundException;
	Book findById(int bookid) throws ClassNotFoundException;
	Book findBookDetails(int id) throws ClassNotFoundException;
	Book findBookRatings(int id) throws ClassNotFoundException;

}
