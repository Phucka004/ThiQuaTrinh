package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.BookDTO;
import vn.iotstar.models.BookModel;
import vn.iotstar.services.impl.BookService;

@WebServlet(urlPatterns = {"/admin/books"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
maxFileSize = 1024 * 1024 * 50,       // 50MB
maxRequestSize = 1024 * 1024 * 250)   // 250MB
//@WebServlet(name = "BookController", value = {"/admin/books", "/admin/book/detail"})
public class BookController extends HttpServlet {
public static final long serialVersionUID = 1L;
public BookService bookService = new BookService();

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("UTF-8");
resp.setCharacterEncoding("UTF-8");
String url = req.getRequestURI();

if (url.contains("/admin/books")) {
    // Lấy danh sách tất cả các sách
    List<BookDTO> list = bookService.findAll();
    req.setAttribute("listBooks", list);
    req.getRequestDispatcher("/views/admin/book_list.jsp").forward(req, resp);
} else if (url.contains("/admin/book/detail")) {
    // Hiển thị chi tiết của sách
    int id = Integer.parseInt(req.getParameter("id"));
    BookDTO book = bookService.findById(id);
    req.setAttribute("book", book);
    req.getRequestDispatcher("/views/admin/book_detail.jsp").forward(req, resp);
} 
}


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("UTF-8");
resp.setCharacterEncoding("UTF-8");
String url = req.getRequestURI();

if (url.contains("/admin/book/update")) {
    BookModel book = new BookModel();
    book.setBookid(Integer.parseInt(req.getParameter("bookId")));
    book.setIsbn(Integer.parseInt(req.getParameter("isbn")));
    book.setTitle(req.getParameter("title"));
    book.setPublisher(req.getParameter("publisher"));
    book.setPrice(new BigDecimal(req.getParameter("price")));
    book.setDescription(req.getParameter("description"));
    book.setPublish_date(Date.valueOf(req.getParameter("publish_date")));
    book.setQuantity(Integer.parseInt(req.getParameter("quantity")));

    // Save old image
 // Khai báo biến bookOld bên ngoài try-catch
    BookDTO bookOld = null;

    try {
        // Gán giá trị cho bookOld
        bookOld = bookService.findById(book.getBookid());
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Kiểm tra bookOld có giá trị hợp lệ trước khi truy cập
    String oldImage = (bookOld != null) ? bookOld.getCoverImage() : "default.png";
    
    // Process image upload
    String uploadPath = url;
    File uploadDir = new File(uploadPath);
    if (!uploadDir.exists())
        uploadDir.mkdir();
    try {
        Part part = req.getPart("cover_image");
        if (part.getSize() > 0) {
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            int index = filename.lastIndexOf(".");
            String ext = filename.substring(index+1);
            String fname = System.currentTimeMillis() + "." + ext;
            part.write(uploadPath + "/" + fname);
            book.setCover_image(fname);
        } else {
            book.setCover_image(oldImage);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    bookService.update(book);
    resp.sendRedirect(req.getContextPath() + "/admin/books");
} else if (url.contains("/admin/book/add")) {
    BookModel book = new BookModel();
    book.setIsbn(Integer.parseInt(req.getParameter("isbn")));
    book.setTitle(req.getParameter("title"));
    book.setPublisher(req.getParameter("publisher"));
    book.setPrice(new BigDecimal(req.getParameter("price")));
    book.setDescription(req.getParameter("description"));
    book.setPublish_date(Date.valueOf(req.getParameter("publish_date")));
    book.setQuantity(Integer.parseInt(req.getParameter("quantity")));

    // Process image upload
    String uploadPath = url;
    File uploadDir = new File(uploadPath);
    if (!uploadDir.exists())
        uploadDir.mkdir();
    try {
        Part part = req.getPart("cover_image");
        if (part.getSize() > 0) {
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            int index = filename.lastIndexOf(".");
            String ext = filename.substring(index+1);
            String fname = System.currentTimeMillis() + "." + ext;
            part.write(uploadPath + "/" + fname);
            book.setCover_image(fname);
        } else {
            book.setCover_image("default.png");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    bookService.insert(book);
    resp.sendRedirect(req.getContextPath() + "/admin/books");
}
}
}
