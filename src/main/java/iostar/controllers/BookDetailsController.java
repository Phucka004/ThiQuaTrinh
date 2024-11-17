package iostar.controllers;

import java.io.IOException;
import java.util.List;

import iostar.model.Author;
import iostar.model.Book;
import iostar.model.Rating;
import iostar.model.User;
import iostar.services.IBookService;
import iostar.services.IRatingService;
import iostar.services.IUserService;
import iostar.services.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book-details")
public class BookDetailsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IBookService bookService = new BookServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");
       Book book = bookService.findBookDetails(Integer.parseInt(bookId));
       Book bookD = bookService.findBookRatings(Integer.parseInt(bookId));
       List<Author> authors = book.getAuthors();
        // Fetch book details based on bookId and set it in request attributes
        // Forward to a JSP page to display book details
        request.setAttribute("book", book);
        request.setAttribute("authors", authors);
        request.setAttribute("bookD", bookD);
        request.getRequestDispatcher("/views/book-details.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Lấy dữ liệu từ form
	        String userid = request.getParameter("userid");
	        String bookid = request.getParameter("id");
	        String reviewText = request.getParameter("reviewText");

	        IUserService uService = new UserService();
	        User user = uService.getUserById(Integer.parseInt(userid)); // Có thể ném ClassNotFoundException

	        // Kiểm tra dữ liệu không null
	        if (reviewText != null && bookid != null) {
	            // Tạo đối tượng Rating
	            Rating rating = new Rating();
	            rating.setBookid(Integer.parseInt(bookid));
	            rating.setUserId(Integer.parseInt(userid));
	            rating.setRating(5);
	            rating.setReview_text(reviewText);
	            rating.setUser(user);

	            // Gửi dữ liệu đến dịch vụ để lưu vào cơ sở dữ liệu
	            IRatingService ratingService = new RatingServiceImpl();
	            try {
	            	ratingService.insert(rating);
	            }catch(Exception	e)
	            {
	            	e.printStackTrace(); // In ra console để dễ dàng debug

	                // Thêm thông báo lỗi vào request
	                request.setAttribute("errorMessage", "Khong the them 2 danh gia cung 1 quyen sach.");

	                // Forward về trang chi tiết sách cùng với thông báo lỗi
	                response.sendRedirect("book-details?id=" + bookid);
	               return;
	            }
	            

	            // Redirect về trang chi tiết sách sau khi thêm review
	            
	            response.sendRedirect("book-details?id=" + bookid);
	        } else {
	            // Nếu thiếu thông tin, gửi lại lỗi hoặc hiển thị thông báo
	            response.getWriter().write("Error: Missing required fields.");
	        }
	    } catch (ClassNotFoundException e) {
	        // Xử lý ngoại lệ nếu xảy ra
	        e.printStackTrace();
	        response.getWriter().write("Error: Unable to process request due to a server error.");
	    }
	}

}