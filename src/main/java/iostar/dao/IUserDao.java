package iostar.dao;

import java.sql.SQLException;
import java.util.List;

import iostar.model.User;

public interface IUserDao {
	
	User findUserByEmail(String email) throws ClassNotFoundException;

	User getUserById(int userId) throws ClassNotFoundException;
}
