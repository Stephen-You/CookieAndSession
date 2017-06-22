package practice.cookie.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**获取Cookie,从Cookie中获取名字,看是否为同一Cookie
 * @author Yorick
 */
@WebServlet("/GetCookieNew")
public class GetCookieNew extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String mess = "对不起获取到的不是同一Cookie!";
		//获取Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")){
					mess = "获取到了相同的Cookie"+cookie.getValue();
					break;
				}
			}
		}
		response.getWriter().write(mess);
	}

}
