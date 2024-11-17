package iostar.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iostar.model.Author;
import iostar.model.Book;
import iostar.services.IAuthorService;
import iostar.services.IBookService;
import iostar.services.impl.AuthorService;
import iostar.services.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookController extends HttpServlet {
    private IAuthorService authorService = new AuthorService();
    private IBookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 List<Author> authors = authorService.getAllAuthors();
        Map<Author, List<Book>> authorBooks = new HashMap<>();
        
        for (Author author : authors) {
            List<Book> books = bookService.getBooksByAuthorId(author.getAuthorId());
            authorBooks.put(author, books);
        }
        

        req.setAttribute("authorBooks", authorBooks);
        req.getRequestDispatcher("/views/book-list.jsp").forward(req, resp);
    }
}
