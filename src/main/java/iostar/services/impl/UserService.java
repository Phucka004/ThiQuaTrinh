package iostar.services.impl;

import iostar.model.User;
import iostar.services.IUserService;
import iostar.dao.IUserDao;
import iostar.dao.impl.UserDao;

public class UserService implements IUserService{
	IUserDao userDao = new UserDao();
	@Override
	public User login(String email, String password) throws ClassNotFoundException {
		User user = this.findUserByEmail(email);
		if (user != null && password.equals(user.getPasswd())) {
			return user;
		}
		return null;
	}
	public User findUserByEmail(String email) throws ClassNotFoundException {
		return userDao.findUserByEmail(email);
	}
	@Override
	public User getUserById(int userId) throws ClassNotFoundException{
		return userDao.getUserById(userId);
	}
	
}
