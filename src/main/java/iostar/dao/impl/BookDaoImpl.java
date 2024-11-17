package iostar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import iostar.configs.DBConnectMySQL;
import iostar.dao.IBookDao;
import iostar.model.Author;
import iostar.model.Book;
import iostar.model.Rating;
import iostar.model.User;

public class BookDaoImpl implements IBookDao {
	
	@Override
	public List<Book> getBooksByAuthorId(int authorId) throws ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		String query = "SELECT b.* FROM books b " + "JOIN book_author ba ON b.bookid = ba.bookid "
				+ "WHERE ba.author_id = ?";
		try (Connection conn = DBConnectMySQL.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, authorId);
			ResultSet rs = stmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy"); // Đối tượng định dạng ngày

            while (rs.next()) {
                Book book = new Book();
                book.setBookid(rs.getInt("bookid"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));
                book.setPublisher(rs.getString("publisher"));

                // Chuyển đổi publish_date sang chuỗi với định dạng mong muốn
                Date publishDate = rs.getDate("publish_date");
                if (publishDate != null) {
                    book.setPublish_date(publishDate); // Gán chuỗi định dạng
                } else {
                    book.setPublish_date(publishDate);
                }
                
                book.setQuantity(rs.getInt("quantity"));
                book.setCover_image(rs.getString("cover_image"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}
	@Override
	public Book findById(int bookid) throws ClassNotFoundException {
	    Book book = null;
	    String query = "SELECT * FROM books WHERE bookid = ?";
	    
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, bookid);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            book = new Book();
	            book.setBookid(rs.getInt("bookid"));
	            book.setTitle(rs.getString("title"));
	            book.setIsbn(rs.getString("isbn"));
	            book.setPublisher(rs.getString("publisher"));
	            book.setPublish_date(rs.getDate("publish_date"));
	            book.setQuantity(rs.getInt("quantity"));
	            book.setCover_image(rs.getString("cover_image"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return book;
	}

	@Override
	public Book findBookDetails(int id) throws ClassNotFoundException {
		Book book = null;
        List<Author> authors = new ArrayList<>();

        String sql = "SELECT b.bookid, b.isbn, b.title, b.publisher, b.price, b.description, b.publish_date, " +
                     "b.cover_image, b.quantity, a.author_id, a.author_name, a.date_of_birth " +
                     "FROM books b " +
                     "JOIN book_author ba ON b.bookid = ba.bookid " +
                     "JOIN author a ON ba.author_id = a.author_id " +
                     "WHERE b.bookid = ?";

        try (Connection conn = DBConnectMySQL.getDatabaseConnection(); // Giả sử bạn có lớp DatabaseConnection để lấy connection
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (book == null) { // Khởi tạo đối tượng Book một lần khi lần đầu vào kết quả
                    	 book = new Book(
                    		resultSet.getInt("bookid"),
                             resultSet.getString("isbn"),
                             resultSet.getString("title"),
                             resultSet.getString("publisher"),
                             resultSet.getDouble("price"),
                             resultSet.getString("description"),
                             resultSet.getDate("publish_date"),
                             resultSet.getString("cover_image"),
                             resultSet.getInt("quantity")
                         );
                    }

                    // Thêm tác giả vào danh sách authors
                    Author author = new Author(
                        resultSet.getInt("author_id"),
                        resultSet.getString("author_name"),
                        resultSet.getDate("date_of_birth")
                    );
                    authors.add(author);
                }
                
                // Gán danh sách tác giả cho sách
                if (book != null) {
                    book.setAuthors(authors);
                }
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            return book;
        
    }

	@Override
	public Book findBookRatings(int bookid) throws ClassNotFoundException {
		Book book = null;
        List<Rating> ratings = new ArrayList<>();

        String sql = "SELECT b.bookid, b.isbn, b.title, b.publisher, b.price, b.description, b.publish_date, " +
                     "b.cover_image, b.quantity, " +
                     "r.rating, r.review_text, " +
                     "u.id AS user_id, u.email, u.fullname, u.phone,u.passwd, u.signup_date, u.last_login, u.is_admin " +
                     "FROM books b " +
                     "JOIN rating r ON b.bookid = r.bookid " +
                     "JOIN users u ON r.userid = u.id " +
                     "WHERE b.bookid = ?";

        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, bookid);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (book == null) { // Khởi tạo đối tượng Book nếu chưa có
                        book = new Book(
                            resultSet.getInt("bookid"),
                            resultSet.getString("isbn"),
                            resultSet.getString("title"),
                            resultSet.getString("publisher"),
                            resultSet.getDouble("price"),
                            resultSet.getString("description"),
                            resultSet.getDate("publish_date"),
                            resultSet.getString("cover_image"),
                            resultSet.getInt("quantity")
                        );
                    }

                    // Tạo đối tượng User
                    User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("email"),
                        resultSet.getString("fullname"),
                        resultSet.getString("phone"),
                        resultSet.getString("passwd"),
                        resultSet.getDate("signup_date"),
                        resultSet.getDate("last_login"),
                        resultSet.getBoolean("is_admin")
                    );

                    // Tạo đối tượng Rating và gán User cho nó
                    Rating rating = new Rating(
                    	resultSet.getInt("bookid"),
                    	resultSet.getInt("user_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("review_text"),
                        user
                    );

                    // Thêm Rating vào danh sách
                    ratings.add(rating);
                }

                // Gán danh sách rating cho sách
                if (book != null) {
                    book.setRatings(ratings);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }
}



