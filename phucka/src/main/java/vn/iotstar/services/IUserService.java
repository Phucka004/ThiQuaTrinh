package vn.iotstar.services;


import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String email, String password);
	 UserModel findByUserName(String email);
	 
		void insert(UserModel user);
		boolean register(String email, String fullname, int phone, String passwd);
		boolean checkExistEmail(String email);
		boolean checkExistPhone(String phone);
}
