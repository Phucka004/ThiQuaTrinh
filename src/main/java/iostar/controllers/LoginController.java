package iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import iostar.model.User;
import iostar.services.IUserService;
import iostar.services.impl.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Hiển thị trang login (form đăng nhập)
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Boolean isRememberMe = "on".equals(req.getParameter("remember"));
//			boolean isRememberMe = false;
		String alertMsg = "";
//			if("on".equals(isRememberMe)){
//				 isRememberMe = true;
//				 }
		if (email.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		IUserService userService = new UserService();
		User user;
		try {
			user = userService.login(email, password);
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				if (isRememberMe) {
					saveRemeberMe(resp, email);
				} else {
					deleteRememberMe(resp);
				}

				resp.sendRedirect(req.getContextPath() + "/waiting");
			} else {
				alertMsg = "Tài khoản hoặc mật khẩu không chính xác";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	private void saveRemeberMe(HttpServletResponse response, String email) {
		Cookie cookie = new Cookie("email", email);
		cookie.setMaxAge(30);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private void deleteRememberMe(HttpServletResponse response) {
		Cookie cookie = new Cookie("email", "");
		cookie.setMaxAge(0); // Xóa cookie ngay lập tức
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
