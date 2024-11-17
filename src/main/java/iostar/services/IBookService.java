package iostar.services;

import java.util.List;

import iostar.model.Book;

public interface IBookService {

	List<Book> getBooksByAuthorId(int authorId);
	Book findBookDetails(int id);
	Book findBookRatings(int id);
	Book findById(int bookid);
}
