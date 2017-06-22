package practice.cookie.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**��ȡCookie,��Cookie�л�ȡ����,���Ƿ�ΪͬһCookie
 * @author Yorick
 */
@WebServlet("/GetCookieNew")
public class GetCookieNew extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String mess = "�Բ����ȡ���Ĳ���ͬһCookie!";
		//��ȡCookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")){
					mess = "��ȡ������ͬ��Cookie"+cookie.getValue();
					break;
				}
			}
		}
		response.getWriter().write(mess);
	}

}
