package vn.iotstar.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.dao.IBookDao;
import vn.iotstar.dao.impl.BookDaoImpl;
import vn.iotstar.models.BookDTO;
import vn.iotstar.models.BookModel;
import vn.iotstar.services.IBookService;
import vn.iotstar.services.impl.BookService;

@WebServlet(urlPatterns = {"/books", "/bookDetail"})
public class BookController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public IBookService bookService = new BookService();

 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        
        // Kiểm tra nếu URL là "/books", hiển thị danh sách sách
        if ("/books".equals(path)) {
            List<BookDTO> list = bookService.findAll();  // Lấy tất cả sách từ service
            req.setAttribute("listbook", list);
            req.getRequestDispatcher("/views/book_list.jsp").forward(req, resp);
        
        // Nếu URL là "/bookDetail", hiển thị chi tiết sách
        } else if ("/bookDetail".equals(path)) {
            String bookId = req.getParameter("id");
            if (bookId != null) {
                IBookDao bookDao = new BookDaoImpl();
                BookDTO book = bookDao.findById(Integer.parseInt(bookId));  // Lấy sách theo id
                req.setAttribute("book", book);
                req.getRequestDispatcher("/views/bookdetail.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/books");  // Nếu không có id, quay lại danh sách sách
            }
        }
    }
}