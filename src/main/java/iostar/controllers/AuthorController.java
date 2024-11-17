package iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import iostar.model.Author;
import iostar.services.*;
import iostar.services.impl.*;

@WebServlet(name = "AuthorController", urlPatterns = { "/admin/author", "/admin/author/save", "/admin/author/add",
        "/admin/author/edit", "/admin/author/update", "/admin/author/delete" })
public class AuthorController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private final IAuthorService authorService = new AuthorService();
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
        case "/admin/author/add":
            req.getRequestDispatcher("/views/admin/author-add.jsp").forward(req, resp);
            break;
        case "/admin/author/edit":
            try {
				loadAuthorForEdit(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Load author data for edit
            break;
        default:
            req.getRequestDispatcher("/views/admin/author-list.jsp").forward(req, resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
        case "/admin/author":
            try {
				getAuthorsWithPagination(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
        case "/admin/author/save":
            try {
				addAuthor(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
        case "/admin/author/update":
            try {
				updateAuthor(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
        case "/admin/author/delete":
            deleteAuthor(req, resp);
            break;
        default:
        	resp.setContentType("application/json");

            int start = Integer.parseInt(req.getParameter("start"));
            int length = Integer.parseInt(req.getParameter("length"));
            String searchValue = req	.getParameter("search[value]");

            int totalRecords = 0;
            int totalFilteredRecords = 0;
            List<Map<String, Object>> authors = null;

            try {
                // Gọi các phương thức trong BookDao
                totalRecords = authorService.countTotalAuthors();
                totalFilteredRecords = authorService.countFilteredAuthors(searchValue);
                authors = authorService.getAuthors(searchValue, start, length);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Chuẩn bị JSON phản hồi
            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("draw", req.getParameter("draw"));
            jsonResponse.put("recordsTotal", totalRecords);
            jsonResponse.put("recordsFiltered", totalFilteredRecords);
            jsonResponse.put("data", authors);

            // Trả về JSON cho DataTable
            PrintWriter out = resp.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            out.print(mapper.writeValueAsString(jsonResponse));
            out.flush();
            break;
        }
    }

    private void loadAuthorForEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String authorIdParam = request.getParameter("authorid");
        int authorId = Integer.parseInt(authorIdParam);
        Author author = authorService.getAuthorById(authorId);

        if (author != null) {
            request.setAttribute("author", author);
            request.getRequestDispatcher("/views/admin/author-edit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/author");
        }
    }

    private void getAuthorsWithPagination(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");

        Long totalRecords = authorService.count();
        List<Author> authors = authorService.searchAuthors(searchValue, start, length);
        Long filteredRecords = authorService.countAuthors(searchValue);

        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("draw", request.getParameter("draw"));
        jsonResponse.put("recordsTotal", totalRecords);
        jsonResponse.put("recordsFiltered", filteredRecords);
        jsonResponse.put("data", authors);

        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(jsonResponse));
    }

    private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        Author author = new Author();
        author.setAuthorName(request.getParameter("author_name"));
        String dateStr = request.getParameter("date_of_birth");
        Date dateOfBirth = Date.valueOf(dateStr);
        author.setDateOfBirth(dateOfBirth);
        
        authorService.addAuthor(author);
        response.sendRedirect(request.getContextPath() + "/admin/author");
    }
    private void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        String authorIdParam = request.getParameter("authorId");
        int authorId = Integer.parseInt(authorIdParam);
        Author author = authorService.getAuthorById(authorId);

        if (author != null) {
            author.setAuthorName(request.getParameter("author_name"));
            String dateStr = request.getParameter("date_of_birth");
            Date dateOfBirth = Date.valueOf(dateStr);
            author.setDateOfBirth(dateOfBirth);

            authorService.updateAuthor(author);
        }
        response.sendRedirect(request.getContextPath() + "/admin/author");
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorIdParam = request.getParameter("authorid");
        int authorId = Integer.parseInt(authorIdParam);
        try {
            authorService.deleteAuthor(authorId);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\": \"success\"}");
            response.sendRedirect(request.getContextPath() + "/admin/author");

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Có lỗi xảy ra khi xóa tác giả.\"}");
            e.printStackTrace();
        }
    }
}
