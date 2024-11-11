package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IAuthorDao;
import vn.iotstar.models.AuthorModel;

public class AuthorDaoImpl extends DBConnectMySQL implements IAuthorDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public AuthorModel findById(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorModel> findAll() {
		List<AuthorModel> list = new ArrayList<AuthorModel>();
		String sql = "SELECT * FROM author";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				AuthorModel author = new AuthorModel();
				author.setAuthor_id(rs.getInt("authorid"));
				author.setAuthor_name(rs.getString("author_name"));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				list.add(author);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<AuthorModel> findAuthorByBookId(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AuthorModel author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AuthorModel author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int authorid) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
