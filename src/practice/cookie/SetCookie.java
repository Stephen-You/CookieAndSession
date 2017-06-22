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
 * 给客户端发送Cookie
 * @author Yorick
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型和编码
		response.setContentType("text/html;charset=utf-8");
		//获取一个随机字符串,作为Cookie的值
//		String id = UUID.randomUUID().toString();
		String id = "aab";
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
		response.getWriter().println("Cookie已经给你发过去了!");
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath+"/GetCookie");
	}

}
