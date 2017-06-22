package practice.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Session中数据
 * @author Yorick
 *
 */
@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (String) request.getSession().getAttribute("username");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(value);
	}

}
