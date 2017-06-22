package practice.cookie.image;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 获取表单中的verifyCode，它是用户填写的验证码
 * 2. 获取session中的session_vcode，它是真实的验证码
 * 3. 比较之！
 * @author Yorick
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String mess = "验证码不正确";
		//获取输入的验证码
		String verifyCode = request.getParameter("verifyCode");
		//获取Session中真实的验证码
		String code  = (String) request.getSession().getAttribute("code");
		//判断
		if(code.equalsIgnoreCase(verifyCode)){
			mess = "登陆成功";
		}
		response.getWriter().write(mess);
	}

}
