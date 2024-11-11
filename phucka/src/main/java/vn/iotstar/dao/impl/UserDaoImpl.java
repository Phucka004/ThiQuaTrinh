package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new UserModel(
										rs.getInt("id"),
										rs.getString("email"),
										rs.getString("fullname"),
										rs.getInt("phone"),
										rs.getString("passwd"),
										rs.getTimestamp("signup_date"),
										rs.getTimestamp("last_login"),
										rs.getBoolean("is_admin")
										
						));
			}
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		
		
		
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(email, fullname, phone, passwd, signup_date, last_login, is_admin) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try
		{
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullname());
			ps.setInt(3, user.getPhone());
			ps.setString(4, user.getPasswd());
			ps.setTimestamp(5, user.getSignup_date());
			ps.setTimestamp(6, user.getLast_login());
			ps.setBoolean(7, user.getIs_admin());
			
			ps.executeUpdate();
			}
		catch(Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		UserDaoImpl userDao = new UserDaoImpl();
		//List<UserModel> list = userDao.findAll();
		
		//for(UserModel user : list)
		//{
			//System.out.println(user);
		//}
		
		//System.out.print(userDao.findByUserName("huyen@gmail.com"));
		userDao.insert(new UserModel("thanh@gmail.com","phucThanh", 030 , "123", null, null, true ));
		
	}

	@Override
	public UserModel findByUserName(String email) {
		String sql = "SELECT * from users where email = ?";
		try
		{
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getInt("phone"));
				user.setPasswd(rs.getString("passwd"));
				user.setSignup_date(rs.getTimestamp("signup_date"));
				user.setLast_login(rs.getTimestamp("last_login"));
				user.setIs_admin(rs.getBoolean("is_admin"));
				
				
				return user;
			}
		}
		catch(Exception e)
		{
			// TODO: handle exception
						e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [Users] where email = ?";
		try {
		conn = new DBConnectMySQL().getDatabaseConnection();
		ps = conn.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;

	}

	

	@Override
	public boolean checkExistPhone(String phone) {
		 boolean duplicate = false;
		    String query = "select * from [Users] where phone = ?";
		    try {
		        conn = new DBConnectMySQL().getDatabaseConnection();
		        ps = conn.prepareStatement(query);
		        ps.setString(1, phone);
		        rs = ps.executeQuery();
		        if (rs.next()) {
		            duplicate = true; // Số điện thoại đã tồn tại
		        }
		        ps.close();
		        conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace(); // In ra lỗi để dễ dàng debug
		    }
		    return duplicate;
	}
}
