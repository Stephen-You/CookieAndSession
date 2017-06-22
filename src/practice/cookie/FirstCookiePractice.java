package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie的第一个练习:
 * 客户端访问AServlet，AServlet在响应中添加Cookie，浏览器会自动保存Cookie。
 * 然后客户端访问BServlet，这时浏览器会自动在请求中带上Cookie，BServlet获取请求中
 * 的Cookie打印出来。
 * @author Yorick
 *
 */
public class FirstCookiePractice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//获取Cookie得到访问次数
//		String cookie = request.getHeader("Cookie");
//		//判断Cookie不是null,并且去除无用空格后不是空字符串
//		if(cookie!=null && !cookie.trim().isEmpty()){
//			//获取=字符的脚标,截取后面的数字
//			int index = cookie.indexOf("=");
//			//注意字符串截取包头不包尾
//			int count = Integer.parseInt(cookie.substring(index+1));
//			//访问次数加1
//			count++;
//			//把访问次数放到Cookie中,用于记录访问次数
//			response.setHeader("Set-Cookie", "count="+count);
//			response.getWriter().print(count);;
//		}else {
//			//说明是第一次访问
//			response.setHeader("Set-Cookie", "count=1");
//			response.getWriter().print(1);;
//		}
		//通过上面我们简单实现了访问次数,那么有没有什么简单的实现方法呢,还有每次浏览器返还给我们的Cookie也不止一个,怎么解决呢
		//声明一个变量作为访问次数
		int count = 1;
		//首先获取所有浏览器返还给我们的Cookie
		Cookie[] cookie = request.getCookies();
		if(cookie!=null){
			//遍历Cookie,获取指定名称的Cookie
			for (Cookie cookie2 : cookie) {//注意如果没有Cookie,那么会在这句报错ava.lang.NullPointerException,所以添加一句判断语句
				if(cookie2.getName().equals("count")){
					//声明变量作为访问次数
					count = Integer.parseInt(cookie2.getValue());
					//访问次数加1
					count++;
					//跳出循环
					break;
				}
			}
		}
		
		// count有两种可能，如果请求中存在count这个Cookie，我们的int类型的count变量值为cookie的值
		// 如果请求中不存在名为count的Cookie，int类型变量count的值为1
		/*
		 * 2. 保存cnt到Cookie中，添加到响应中
		 */
//		response.setHeader("Set-Cookie", "count="+count);
		response.getWriter().println(count);
		Cookie cookieNew = new Cookie("count", count+"");
		//设计以秒计的存活时间
		cookieNew.setMaxAge(2*2);
		response.addCookie(cookieNew);
	}


}
