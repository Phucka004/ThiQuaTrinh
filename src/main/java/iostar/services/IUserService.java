package iostar.services;

import iostar.model.User;

public interface IUserService {
	  User login(String email, String password) throws ClassNotFoundException;

	User getUserById(int userId) throws ClassNotFoundException;
}
