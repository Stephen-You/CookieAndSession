package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ�ͻ��������е�Cookie
 * @author Yorick
 */
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//��ȡCookie,һ�λػ�����һ��Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("id")){
					String id = cookie.getValue();
					response.getWriter().println(id);
				}else {
					response.getWriter().println("û�����ҵ�Cookie!");
				}
				
			}
		}
	}

}
