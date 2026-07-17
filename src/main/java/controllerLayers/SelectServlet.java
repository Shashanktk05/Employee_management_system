package controllerLayers;

import java.io.IOException;
import java.util.List;

import daoLayers.EmployeeDao;
import entityLayer.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {

	/**
	 * 
	 */

	public void disp(HttpServletRequest req, HttpServletResponse resp, List<Employee> list)
			throws ServletException, IOException {

		req.setAttribute("list", list);
		req.setAttribute("type", "multiple");
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, resp);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sortType = req.getParameter("sortType");
		EmployeeDao dao = new EmployeeDao();
		String id = req.getParameter("id");
		if (id != null && !id.isBlank()) {
			Employee e = dao.selectDetailsById(Integer.parseInt(id));
			req.setAttribute("employee", e);
			req.setAttribute("type", "single");
			RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
			rd.forward(req, resp);
			return;
		}
		

		List<Employee> list = null;
		

		switch (sortType) {

		case "idAsc":
			list = dao.selectDetailsByIdAsc();
			disp(req, resp, list);
			break;

		case "idDesc":
			list = dao.selectDetailsByIdDesc();
			disp(req, resp, list);
			break;

		case "nameAsc":
			list = dao.selectDetailsByNameAsc();
			disp(req, resp, list);
			break;

		case "nameDesc":
			list = dao.selectDetailsByNameDesc();
			disp(req, resp, list);
			break;

		case "salaryAsc":
			list = dao.selectDetailsBySalAsc();
			disp(req, resp, list);

			break;

		case "salaryDesc":
			list = dao.selectDetailsBySalDesc();
			disp(req, resp, list);
			break;

		case "active":
			list = dao.selectDetailsByActive();
			disp(req, resp, list);

			break;

		case "inactive":
			list = dao.selectDetailsByNotActive();
			disp(req, resp, list);
			break;
		default:
		    list = dao.selectAllDetails();
		    disp(req, resp, list);
		    break;
		}
	}

}
