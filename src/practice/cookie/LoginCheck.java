package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��¼У��,ͬʱ������Cookie�д洢����
 * @author Yorick
 *
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������������Ӧ���ͼ�����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ�û���
		String username = request.getParameter("username");
		//�����û�����ȷ,��ת��succ.jsp,������ת��login.jsp
		if(username.equals("jing")){
			request.setAttribute("message", "��������û�������������!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//�����¼�ɹ���Ϣ
			request.setAttribute("msg", "��ӭ" + username + "��¼��վ��");
			//���û������浽Cookie,��jspҳ���ȡCookie�е�����
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			request.getRequestDispatcher("/succ.jsp").include(request, response);
		}
	}

}
