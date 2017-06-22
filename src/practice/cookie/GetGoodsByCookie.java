package practice.cookie;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取商品,在index页面打印
 * @author Yorick
 *
 */
@WebServlet("/GetGoodsByCookie")
public class GetGoodsByCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String goodName = request.getParameter("name");
		//获取Cookie的value
		String goods = CookieUtils.getCookieValue(request, "goods");
		if(goods!=null){
			//按,分割这是Cookie的value的形式[A, p, p, l, e],所以分割和后边的substring是这样的形式
			String[] arr = goods.split(", ");
			//将字符串元素放入集合中
			Set<String> s = new LinkedHashSet<>(Arrays.asList(arr));
			//把新获取的商品放入集合
			s.add(goodName);
			//集合转变成字符串
			goods = s.toString();
			goods = goods.substring(1, goods.length() - 1);
		} else {
			goods = goodName;
		}
		Cookie cookie = new Cookie("goods", goods);
		cookie.setMaxAge(2*2);
		response.addCookie(cookie);
		
		response.sendRedirect("/CookieAndSession/index.jsp");
	}
}
