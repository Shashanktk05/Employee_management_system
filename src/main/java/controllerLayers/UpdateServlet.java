package controllerLayers;

import java.io.IOException;

import daoLayers.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void succussResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("status", true);
		req.setAttribute("key", " Employee Updated Successfully!");
		req.setAttribute("message", "Your employee details have been updated successfully.");
		req.setAttribute("page", "update.html");
		req.setAttribute("button", "Update Another Employee");

		RequestDispatcher rd = req.getRequestDispatcher("status.jsp");

		rd.forward(req, resp);

	}

	public void failResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("status", false);
		req.setAttribute("key", "Employee Update Failed!");
		req.setAttribute("message",
				"Unable to update the employee details. Please verify the information and try again.");
		req.setAttribute("page", "update.html");
		req.setAttribute("button", "Try Again");

		RequestDispatcher rd = req.getRequestDispatcher("status.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeDao dao = new EmployeeDao();
		int id = Integer.parseInt(req.getParameter("id"));
		String updateType = req.getParameter("updateType");
		String value = req.getParameter("value");
		switch (updateType) {

		case "address":
			if (dao.updateAdress(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		case "name":
			if (dao.updateName(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		case "age":
			if (dao.updateAge(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}

			break;

		case "email":
			if (dao.updateEmail(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		case "phone":
			if (dao.updatePhno(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		case "salary":
			if (dao.updateSalary(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		case "isActive":
			if (dao.updateState(id, value)) {
				succussResponse(req, resp);
			} else {
				failResponse(req, resp);
			}
			break;

		default:
			System.out.println("Invalid Update Type");
			failResponse(req, resp);
			break;
		}

	}

}
