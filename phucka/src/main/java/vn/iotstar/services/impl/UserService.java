package vn.iotstar.services.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {

	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String email, String passwd) {
		UserModel user = this.findByUserName(email);
		if(user !=null && passwd.equals(user.getPasswd()))
		{
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String email) {
		
		return userDao.findByUserName(email);
	}
	
	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
		
	}

	

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
		
	}

	@Override
	public boolean register(String email, String fullname, int phone, String passwd) {
		if (userDao.checkExistEmail(email)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(millis);
		userDao.insert(new UserModel(email, fullname, phone, passwd, timestamp, null, false));
		return true;
	}

}
