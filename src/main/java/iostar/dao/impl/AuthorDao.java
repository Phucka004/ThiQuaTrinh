package iostar.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import iostar.configs.DBConnectMySQL;
import iostar.dao.IAuthorDao;
import iostar.model.Author;
public class AuthorDao extends DBConnectMySQL implements IAuthorDao{
	public Connection conn = null;
	 public PreparedStatement ps = null;
	 public ResultSet rs = null;
	@Override
	public List<Author> findAll() {
		String sql = "select * from [Author]";
        List<Author> list = new ArrayList<>();

        try {
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                list.add(
                        new Author(
                        		Integer.parseInt(rs.getString("author_id")), 
                                rs.getString("author_name"), 
                                rs.getDate("date_of_birth")
                                )
                        );
            }
            return list;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	 @Override
	public int countTotalAuthors() throws Exception {
	        int totalRecords = 0;
	        String countQuery = "SELECT COUNT(*) FROM author";

	        try (Connection conn = super.getDatabaseConnection();
	             PreparedStatement countStmt = conn.prepareStatement(countQuery)) {

	            ResultSet countRs = countStmt.executeQuery();
	            if (countRs.next()) {
	                totalRecords = countRs.getInt(1);
	            }
	        }
	        return totalRecords;
	    }
	 
	// Đếm tổng số bản ghi sau khi lọc
	    @Override
		public int countFilteredAuthors(String searchValue) throws Exception {
	        int totalFilteredRecords = 0;
	        String filteredCountQuery = "SELECT COUNT(*) FROM author WHERE author_name LIKE ?";

	        try (Connection conn = super.getDatabaseConnection();
	             PreparedStatement filteredCountStmt = conn.prepareStatement(filteredCountQuery)) {

	            filteredCountStmt.setString(1, "%" + searchValue + "%");
	            ResultSet filteredCountRs = filteredCountStmt.executeQuery();
	            if (filteredCountRs.next()) {
	                totalFilteredRecords = filteredCountRs.getInt(1);
	            }
	        }
	        return totalFilteredRecords;
	    }
	    
	 // Lấy dữ liệu sách với phân trang và tìm kiếm
	    @Override
		public List<Map<String, Object>> getAuthors(String searchValue, int start, int length) throws Exception {
	        List<Map<String, Object>> authors = new ArrayList<>();
	        String dataQuery = "SELECT * FROM author WHERE author_name LIKE ? LIMIT ?, ?";

	        try (Connection conn = super.getDatabaseConnection();
	             PreparedStatement dataStmt = conn.prepareStatement(dataQuery)) {

	            dataStmt.setString(1, "%" + searchValue + "%");
	            dataStmt.setInt(2, start);
	            dataStmt.setInt(3, length);
	            ResultSet dataRs = dataStmt.executeQuery();

	            while (dataRs.next()) {
	                Map<String, Object> author = new HashMap<>();
	                author.put("author_id", dataRs.getInt("author_id"));
	                author.put("author_name", dataRs.getString("author_name"));
	                author.put("date_of_birth", dataRs.getDate("date_of_birth"));
	                authors.add(author);
	            }
	        }
	        return authors;
	    }
	    
	    @Override
		public List<Author> getAllAuthors() throws ClassNotFoundException {
		        List<Author> authors = new ArrayList<>();
		        String query = "SELECT * FROM author";
		        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
		             Statement stmt = conn.createStatement();
		             ResultSet rs = stmt.executeQuery(query)) {
		            while (rs.next()) {
		                Author author = new Author();
		                author.setAuthorId(rs.getInt("author_id"));
		                author.setAuthorName(rs.getString("author_name"));
		                authors.add(author);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return authors;
		    }

		@Override
		public Author getAuthorById(int  authorId) throws ClassNotFoundException {
			String sql = "SELECT author_id, author_name, date_of_birth FROM author WHERE author_id = ?";
	        Author author = null;

	        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setInt(1, authorId);
	            ResultSet rs = statement.executeQuery();

	            if (rs.next()) {
	                author = new Author();
	                author.setAuthorId(rs.getInt("author_id"));
	                author.setAuthorName(rs.getString("author_name"));
	                author.setDateOfBirth(rs.getDate("date_of_birth"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return author;
		}

		@Override
		public void addAuthor(Author author) throws ClassNotFoundException {
			String sql = "INSERT INTO author (author_name, date_of_birth) VALUES (?, ?)";

	        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setString(1, author.getAuthorName());
	            statement.setDate(2, (Date)author.getDateOfBirth());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

		@Override
		public void updateAuthor(Author author) throws ClassNotFoundException {
			String sql = "UPDATE author SET author_name = ?, date_of_birth = ? WHERE author_id = ?";

	        try (Connection connection =  DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	        	 statement.setString(1, author.getAuthorName());
		          statement.setDate(2, (Date)author.getDateOfBirth());
	            statement.setInt(3, author.getAuthorId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

		@Override
		public void deleteAuthor(int authorId) throws ClassNotFoundException {
			String sql = "DELETE FROM author WHERE author_id = ?";

	        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setInt(1, authorId);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
			

		@Override
		public List<Author> searchAuthors(String searchValue, int start, int length) throws ClassNotFoundException {
			List<Author> authors = new ArrayList<>();
	        String sql = "SELECT author_id, author_name, date_of_birth FROM author WHERE author_name LIKE ? LIMIT ? OFFSET ?";

	        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setString(1, "%" + searchValue + "%");
	            statement.setInt(2, length);
	            statement.setInt(3, start);
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	                Author author = new Author();
	                author.setAuthorId(rs.getInt("author_id"));
	                author.setAuthorName(rs.getString("author_name"));
	                author.setDateOfBirth(rs.getDate("date_of_birth"));
	                authors.add(author);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return authors;
		}

		@Override
		public Long count() throws ClassNotFoundException {
			String sql = "SELECT COUNT(*) FROM author";
	        try (Connection connection =  DBConnectMySQL.getDatabaseConnection();
		             PreparedStatement statement = connection.prepareStatement(sql);
		             ResultSet rs = statement.executeQuery()) {

		            if (rs.next()) {
		                return rs.getLong(1);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return 0L;
		}

		@Override
		public Long countAuthors(String searchValue) throws ClassNotFoundException {
			String sql = "SELECT COUNT(*) FROM author WHERE author_name LIKE ?";
	        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setString(1, "%" + searchValue + "%");
	            ResultSet rs = statement.executeQuery();

	            if (rs.next()) {
	                return rs.getLong(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0L;
		}
	    
	    
}
