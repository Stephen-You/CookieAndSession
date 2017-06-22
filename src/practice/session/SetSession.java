package practice.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��Session�д洢����,�ض�����һ��Servlet,��ȡSession������
 * @author Yorick
 */
@WebServlet("/SetSession")
public class SetSession extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", "��");
		response.sendRedirect("/CookieAndSession/GetSession");
	}

}
