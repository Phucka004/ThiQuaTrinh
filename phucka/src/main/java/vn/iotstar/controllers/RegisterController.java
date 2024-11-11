package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;
import vn.iotstar.utils.Constant;


@WebServlet(urlPatterns = "/register")

public class RegisterController extends HttpServlet 
{

	
	private static final long serialVersionUID = 1L;
	IUserService service = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("email") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
	}

	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setCharacterEncoding("UTF-8");
	        req.setCharacterEncoding("UTF-8");

	        String email = req.getParameter("email");
	        String fullname = req.getParameter("fullname");
	        int phone = Integer.parseInt(req.getParameter("phone"));
	        String passwd = req.getParameter("passwd");

	        // Initialize alert message
	        String alertMsg = "";

	        // Check if the email already exists
	        if (service.checkExistEmail(email)) {
	            alertMsg = "Email đã tồn tại!";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
	            return;
	        }

	        // Register the user
	        boolean isSuccess = service.register(email, fullname, phone, passwd);
	        if (isSuccess) {
	            req.setAttribute("alert", alertMsg);
	            resp.sendRedirect(req.getContextPath() + "/login");
	        } else {
	            alertMsg = "System error!";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
	        }
	    }
	
				
	

}
