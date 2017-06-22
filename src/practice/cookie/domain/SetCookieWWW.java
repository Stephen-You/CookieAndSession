package practice.cookie.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现www,baidu.com和www.new.baidu.com共用一个Cookie,一个设置用户名和密码,另一个获取
 * @author Yorick
 */
@WebServlet("/SetCookieWWW")
public class SetCookieWWW extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型和编码
		response.setContentType("text/html;charset=utf-8");
		//获取用户名
		String username = request.getParameter("username");
		//设置Cookie
		Cookie cookie = new Cookie("uername", username);
		//设置Cookie的domain
		cookie.setPath("/");
		cookie.setDomain(".baidu.com");
		response.addCookie(cookie);
		response.getWriter().write("Cookie已经设置!");
	}

}
