package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验,同时尝试向Cookie中存储中文
 * @author Yorick
 *
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码和响应类型及编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取用户名
		String username = request.getParameter("username");
		//假如用户名正确,跳转到succ.jsp,否则跳转到login.jsp
		if(username.equals("jing")){
			request.setAttribute("message", "您输入的用户名或密码有误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//保存登录成功信息
			request.setAttribute("msg", "欢迎" + username + "登录本站！");
			//把用户名保存到Cookie,让jsp页面获取Cookie中的名字
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			request.getRequestDispatcher("/succ.jsp").include(request, response);
		}
	}

}
