package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IBookDao;
import vn.iotstar.models.BookDTO;
import vn.iotstar.models.BookModel;

public class BookDaoImpl extends DBConnectMySQL implements IBookDao {
  
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	

	// lỗi chỗ này
	@Override
	public List<BookDTO> findAll() {
	    String sql = "SELECT " +
	                 "b.bookid, " +  // Thêm bookid vào truy vấn SQL
	                 "b.isbn, " +
	                 "b.title, " +
	                 "b.price, " +
	                 "b.cover_image, " +
	                 "b.description" +
	                 "a.author_name, " +
	                 "b.publisher, " +
	                 "b.publish_date, " +
	                 "b.quantity, " +
	                 "COUNT(r.rating) AS slReview " +
	                 "FROM books b " +
	                 "JOIN book_author ba ON b.bookid = ba.bookid " +
	                 "JOIN author a ON ba.author_id = a.author_id " +
	                 "LEFT JOIN rating r ON b.bookid = r.bookid " +
	                 "GROUP BY b.bookid, b.cover_image, b.title, b.isbn, a.author_name, b.publisher, b.publish_date, b.quantity " +
	                 "ORDER BY b.title";

	    List<BookDTO> list = new ArrayList<>();
	    
	    try {
	        conn = super.getDatabaseConnection(); // Lấy kết nối từ DBConnectMySQL
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            // Lấy dữ liệu từ ResultSet
	            int bookid = rs.getInt("bookid");  // Lấy bookid
	            String coverImage = rs.getString("cover_image");
	            String title = rs.getString("title");
	            String isbn = rs.getString("isbn");
	            String authorName = rs.getString("author_name");
	            String publisher = rs.getString("publisher");
	            Date publishDate = rs.getDate("publish_date");
	            int quantity = rs.getInt("quantity");
	            int slReview = rs.getInt("slReview");

	            // Tạo đối tượng BookDTO và thêm vào danh sách
	            BookDTO bookDTO = new BookDTO(bookid, coverImage, title, isbn, authorName, publisher, publishDate, quantity, slReview);
	            list.add(bookDTO);  // Thêm đối tượng vào danh sách
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

		

	@Override
	public BookDTO findById(int bookId) {
	    String sql = "SELECT " +
	                 "b.bookid, " + 
	                 "b.cover_image, " +
	                 "b.title, " +
	                 "b.isbn, " +
	                 "a.author_name, " +
	                 "b.publisher, " +
	                 "b.publish_date, " +
	                 "b.quantity, " +
	                 "COUNT(r.rating) AS slReview " +
	                 "FROM books b " +
	                 "JOIN book_author ba ON b.bookid = ba.bookid " +
	                 "JOIN author a ON ba.author_id = a.author_id " +
	                 "LEFT JOIN rating r ON b.bookid = r.bookid " +
	                 "WHERE b.bookid = ? " +  // Lọc theo bookId
	                 "GROUP BY b.bookid, b.cover_image, b.title, b.isbn, a.author_name, b.publisher, b.publish_date, b.quantity";
	    
	    BookDTO book = new BookDTO();  // Khai báo đối tượng BookDTO

	    try {
	        conn = super.getDatabaseConnection();  // Lấy kết nối từ DBConnectMySQL
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, bookId);  // Thiết lập giá trị của bookId vào câu truy vấn SQL
	        rs = ps.executeQuery();  // Thực thi câu truy vấn
	        
	        if (rs.next()) {
	            // Nếu có dữ liệu sách, tạo đối tượng BookDTO và gán dữ liệu
	            book.setBookId(rs.getInt("bookid"));
	            book.setCoverImage(rs.getString("cover_image"));
	            book.setTitle(rs.getString("title"));
	            book.setIsbn(rs.getString("isbn"));
	            book.setAuthorName(rs.getString("author_name"));
	            book.setPublisher(rs.getString("publisher"));
	            book.setPublishDate(rs.getDate("publish_date"));
	            book.setQuantity(rs.getInt("quantity"));
	            book.setSlReview(rs.getInt("slReview"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Đảm bảo đóng tài nguyên kết nối
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    return book;  // Trả về đối tượng BookDTO hoặc null nếu không tìm thấy sách
	}

	@Override
	public void insert(BookModel book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BookModel book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
