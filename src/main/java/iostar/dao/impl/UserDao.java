package iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import iostar.configs.DBConnectMySQL;
import iostar.dao.IUserDao;
import iostar.model.User;

public class UserDao implements IUserDao {

	@Override
	public User findUserByEmail(String email) throws ClassNotFoundException{
		String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return mapToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	private User mapToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setFullname(rs.getString("fullname"));
        user.setPhone(rs.getString("phone"));
        user.setPasswd(rs.getString("passwd"));
        user.setSignup_date(rs.getDate("signup_date"));
        user.setLast_login(rs.getDate("last_login"));
        user.setIs_admin(rs.getBoolean("is_admin"));
        return user;
    }
	@Override
	public User getUserById(int userId) throws ClassNotFoundException {
		String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, userId);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return mapToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	

}
