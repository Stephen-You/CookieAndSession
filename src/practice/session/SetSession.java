package practice.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 向Session中存储数据,重定向到另一个Servlet,获取Session中数据
 * @author Yorick
 */
@WebServlet("/SetSession")
public class SetSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", "静");
		response.sendRedirect("/CookieAndSession/GetSession");
	}

}
