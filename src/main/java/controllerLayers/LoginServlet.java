package controllerLayers;

import java.io.IOException;
import java.util.List;

import daoLayers.EmployeeDao;
import daoLayers.UsersDao;
import entityLayer.Employee;
import entityLayer.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
//			PrintWriter out = resp.getWriter();

		List<String> emails = UsersDao.fetchAllEmails();
//			for(String e:emails) {
//				out.println(e);
//			}
		if (emails.contains(email)) {
			Users u = UsersDao.getDetails(email);
			if (password.equals(u.getPassword())) {
				HttpSession sss = req.getSession();
				sss.setAttribute("user", u);
				if (u.getRole().equalsIgnoreCase("admin")) {
					RequestDispatcher rd = req.getRequestDispatcher("index.html");
					rd.forward(req, resp);
				} else {
					EmployeeDao empDao = new EmployeeDao();
					Employee emp = empDao.selectDetailsById(u.getEmpId());
					req.setAttribute("employee", emp);
					RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
					rd.forward(req, resp);

				}
			} else {
				req.setAttribute("error", "Invalid Credentials");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);

			}

		}

	}

}
