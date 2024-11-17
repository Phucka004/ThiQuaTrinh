package iostar.services;

import java.util.List;
import java.util.Map;

import iostar.model.Author;

public interface IAuthorService {

	int countFilteredAuthors(String searchValue) throws Exception;
	List<Map<String, Object>> getAuthors(String searchValue, int start, int length) throws Exception;
	int countTotalAuthors() throws Exception;
	List<Author> findAll();
	List<Author> getAllAuthors();

    Author getAuthorById(int authorId) throws ClassNotFoundException;
    void addAuthor(Author author) throws ClassNotFoundException ;
    void updateAuthor(Author author) throws ClassNotFoundException;
    void deleteAuthor(int authorId) throws ClassNotFoundException;
    List<Author> searchAuthors(String searchValue, int start, int length) throws ClassNotFoundException;
    Long count() throws ClassNotFoundException;
    Long countAuthors(String searchValue) throws ClassNotFoundException;

}
