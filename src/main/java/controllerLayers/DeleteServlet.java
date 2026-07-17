package controllerLayers;

import java.io.IOException;

import daoLayers.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void dpass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("status", true);
		req.setAttribute("key", "Employee Deleted Successfully!");
		req.setAttribute("message", "The employee record has been deleted successfully from the database.");
		req.setAttribute("page", "delete.html");
		req.setAttribute("button", "Delete Employee");
		RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
		rd.forward(req, resp);
	}

	protected void dfail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("status", false);
		req.setAttribute("key", "Employee Deletion Failed!");
		req.setAttribute("message", "Unable to delete the employee record. Please check the details and try again.");
		req.setAttribute("page", "delete.html");
		req.setAttribute("button", "Try Again");
		RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
		rd.forward(req, resp);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("deleteType");
		String value = req.getParameter("value");
		EmployeeDao dao = new EmployeeDao();
		if (type.equals("id")) {
			if (dao.deleteDetailsById(Integer.parseInt(value))) {
				dpass(req, resp);
			} else {
				dfail(req, resp);
			}
		} else if (type.equals("email")) {
			if (dao.deleteDetailsByEmail(value)) {
				dpass(req, resp);

			} else {
				dfail(req, resp);
			}
		} else {
			if (dao.deleteDetailsByPhno(value)) {
				dpass(req, resp);

			} else {
				dfail(req, resp);
			}
		}

	}

}
