package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		LocalDate localBirthDate = LocalDate.parse(request.getParameter("birthDate"));
		Date birthDate = Date.valueOf(localBirthDate);

		if (username.isEmpty() || password.isEmpty() || gender.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("register.html");
			req.include(request, response);
		} else {
			boolean insertSuccess = false;
			User user = new User(username, password, gender, birthDate);

			UserDao userDao = new UserDaoImpl();
			insertSuccess = userDao.save(user);

			if (insertSuccess) {
				response.sendRedirect("index.jsp");
			} else {
				RequestDispatcher req = request.getRequestDispatcher("register.html");
				req.include(request, response);
			}
		}
	}
}
