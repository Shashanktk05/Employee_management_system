package filter;

import java.io.IOException;

import entityLayer.Users;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({ "/delete.html", "/form.html", "/update.html", "/select.html", "/index.html", "/delete", "/insert",
		"/select", "/update" })
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		HttpSession session = request.getSession(false);

		Users u = (Users) session.getAttribute("user");

		if (session == null || !"ADMIN".equals(u.getRole())) {
			response.sendRedirect("unauthorized.jsp");
			return;
		}

		chain.doFilter(req, res);
	}
}
