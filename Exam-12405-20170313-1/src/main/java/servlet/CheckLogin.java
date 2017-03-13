package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

public class CheckLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		req.getSession().setAttribute("name",name);
		LoginService loginService = new LoginService();
		if(loginService.checkLogin(name)){
			getServletContext().getRequestDispatcher("/index.jsp")
			.forward(req, resp);
		}else {
			getServletContext().getRequestDispatcher("/")
			.forward(req, resp);
		}
	}
}
