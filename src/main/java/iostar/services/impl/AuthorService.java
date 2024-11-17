package iostar.services.impl;

import java.util.List;
import java.util.Map;

import iostar.model.Author;
import iostar.dao.*;
import iostar.dao.impl.*;
import iostar.services.*;

public class AuthorService implements IAuthorService{
	IAuthorDao authorDao = new AuthorDao();
	@Override
	public List<Author> findAll(){
		return authorDao.findAll();
	}
	@Override
	public int countTotalAuthors() throws Exception{
		return authorDao.countTotalAuthors();
	}
	
	@Override
	public List<Map<String, Object>> getAuthors(String searchValue, int start, int length) throws Exception{
		return authorDao.getAuthors(searchValue, start, length);
	}
	
	@Override
	public int countFilteredAuthors(String searchValue) throws Exception{
		return authorDao.countFilteredAuthors(searchValue);
	}
	@Override
	public List<Author> getAllAuthors(){
		try {
			return authorDao.getAllAuthors();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	@Override
	public Author getAuthorById(int authorId) throws ClassNotFoundException {
		return authorDao.getAuthorById(authorId);
	}
	@Override
	public void addAuthor(Author author) throws ClassNotFoundException {
		authorDao.addAuthor(author);
	}
	@Override
	public void updateAuthor(Author author) throws ClassNotFoundException {
		authorDao.updateAuthor(author);
	}
	@Override
	public void deleteAuthor(int authorId) throws ClassNotFoundException {
		authorDao.deleteAuthor(authorId);
		
	}
	@Override
	public List<Author> searchAuthors(String searchValue, int start, int length) throws ClassNotFoundException {
		return authorDao.searchAuthors(searchValue, start, length);
	}
	@Override
	public Long count() throws ClassNotFoundException {
		return authorDao.count();
	}
	@Override
	public Long countAuthors(String searchValue) throws ClassNotFoundException {
		return authorDao.countAuthors(searchValue);
	}
	
}
