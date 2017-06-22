package practice.cookie.image;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. ��ȡ���е�verifyCode�������û���д����֤��
 * 2. ��ȡsession�е�session_vcode��������ʵ����֤��
 * 3. �Ƚ�֮��
 * @author Yorick
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String mess = "��֤�벻��ȷ";
		//��ȡ�������֤��
		String verifyCode = request.getParameter("verifyCode");
		//��ȡSession����ʵ����֤��
		String code  = (String) request.getSession().getAttribute("code");
		//�ж�
		if(code.equalsIgnoreCase(verifyCode)){
			mess = "��½�ɹ�";
		}
		response.getWriter().write(mess);
	}

}
