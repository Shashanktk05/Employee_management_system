package controllerLayers;

import java.io.IOException;

import daoLayers.EmployeeDao;
import entityLayer.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		if (req.getParameter("id") == null || req.getParameter("name") == null || req.getParameter("age") == null
				|| req.getParameter("email") == null || req.getParameter("phno") == null
				|| req.getParameter("address") == null || req.getParameter("salary") == null) {
			req.setAttribute("status", false);
			req.setAttribute("key", " All Input not filled");
			req.setAttribute("message",
					"Unable to save the employee details into the database. Please\r\n" + "try again.");
			req.setAttribute("page", "form.html");
			req.setAttribute("button", "Try Again");
			RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
			rd.forward(req, resp);
		}

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String address = req.getParameter("address");
		double sal = Double.parseDouble(req.getParameter("salary"));
		boolean isActive = Boolean.parseBoolean(req.getParameter("isActive"));
		Employee e = new Employee(id, name, age, email, phno, address, sal, isActive);

		if (dao.insertDetails(e)) {
			req.setAttribute("status", true);
			req.setAttribute("key", name + " Employee Inserted Successfully!");
			req.setAttribute("message", "Your employee details have been saved into the database.");
			req.setAttribute("page", "form.html");
			req.setAttribute("button", "Insert Another");
			RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("status", false);
			req.setAttribute("key", name + " Employee Insertion Failed!");
			req.setAttribute("message",
					"Unable to save the employee details into the database. Please\r\n" + "try again.");
			req.setAttribute("page", "form.html");
			req.setAttribute("button", "Try Again");
			RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
			rd.forward(req, resp);

		}

	}

}
