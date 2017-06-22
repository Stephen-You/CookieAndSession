package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户端请求中的Cookie
 * @author Yorick
 */
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取Cookie,一次回话共用一个Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("id")){
					String id = cookie.getValue();
					response.getWriter().println(id);
				}else {
					response.getWriter().println("没有所找的Cookie!");
				}
				
			}
		}
	}

}
