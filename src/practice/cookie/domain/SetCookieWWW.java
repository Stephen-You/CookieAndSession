package practice.cookie.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʵ��www,baidu.com��www.new.baidu.com����һ��Cookie,һ�������û���������,��һ����ȡ
 * @author Yorick
 */
@WebServlet("/SetCookieWWW")
public class SetCookieWWW extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ���ͺͱ���
		response.setContentType("text/html;charset=utf-8");
		//��ȡ�û���
		String username = request.getParameter("username");
		//����Cookie
		Cookie cookie = new Cookie("uername", username);
		//����Cookie��domain
		cookie.setPath("/");
		cookie.setDomain(".baidu.com");
		response.addCookie(cookie);
		response.getWriter().write("Cookie�Ѿ�����!");
	}

}
