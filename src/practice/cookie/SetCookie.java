package practice.cookie;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ͻ��˷���Cookie
 * @author Yorick
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ���ͺͱ���
		response.setContentType("text/html;charset=utf-8");
		//��ȡһ������ַ���,��ΪCookie��ֵ
//		String id = UUID.randomUUID().toString();
		String id = "aab";
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
		response.getWriter().println("Cookie�Ѿ����㷢��ȥ��!");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/GetCookie");
	}

}
