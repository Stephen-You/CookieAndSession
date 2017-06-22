package practice.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	public static String getCookieValue(HttpServletRequest request,String name){
		String value = "";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(name)){
					value = cookie.getValue();
					return value;
				}
			}
		}
		return null;
	} 
}
