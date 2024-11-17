package iostar.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import iostar.configs.DBConnectMySQL;
import iostar.dao.IRatingDao;
import iostar.model.Rating;

public class RatingDao implements IRatingDao {
	@Override
	public void insert(Rating rating) throws ClassNotFoundException {
		String query = "INSERT INTO rating (userid, bookid, review_text, rating) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	      ;
	        // Thiết lập các giá trị cho câu truy vấn
	        stmt.setLong(1, rating.getUserId());
	        stmt.setLong(2, rating.getBookid());
	        stmt.setString(3, rating.getReview_text());
	        stmt.setLong(4, rating.getRating());

	        // Thực thi câu truy vấn
	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Có thể ném ngoại lệ hoặc xử lý thêm nếu cần thiết
	        throw new RuntimeException("Error inserting rating", e);
	    }
	}
}
