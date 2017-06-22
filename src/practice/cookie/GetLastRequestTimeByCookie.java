package practice.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取上一次访问的时间
 * @author Yorick
 *创建Cookie，名为lasttime，值为当前时间，添加到response中；
在AServlet中获取请求中名为lasttime的Cookie；
如果不存在输出“您是第一次访问本站”，如果存在输出“您上一次访问本站的时间是xxx”；
 */
@WebServlet("/GetLastRequestTimeByCookie")
public class GetLastRequestTimeByCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型和编码
		response.setContentType("text/html;charset=utf-8");
		//创建Cookie
		Cookie cookie = new Cookie("lasttime", new Date().toString());
		//设置Cookie的声明周期
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		//获取Cookie,判断是否为空,获取指定名称的Cookie,获取值
		Cookie[] cookies = request.getCookies();
		String value = "对不起您是第一次访问!";
		if(cookie!=null){
			for (Cookie cookie2 : cookies) {
				if(cookie2.getName().equals("lasttime")){
					value= cookie2.getValue();
					value = "您上次访问的时间为:"+value;
					//跳出循环
					break;
				}
			}
		}
		response.getWriter().println(value);
	}

}
