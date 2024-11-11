package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.AuthorModel;



public interface IAuthorDao {
	AuthorModel findById(int bookid);
	List<AuthorModel> findAll();
	List<AuthorModel> findAuthorByBookId(int bookid);
	void insert(AuthorModel author);
	void update(AuthorModel author);
	void delete(int authorid) throws Exception;
}
