package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	UserModel findByUserName(String email);
	
	void insert(UserModel user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);


}
