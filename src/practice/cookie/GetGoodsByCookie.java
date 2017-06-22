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
 * ��ȡ��Ʒ,��indexҳ���ӡ
 * @author Yorick
 *
 */
@WebServlet("/GetGoodsByCookie")
public class GetGoodsByCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�������
		String goodName = request.getParameter("name");
		//��ȡCookie��value
		String goods = CookieUtils.getCookieValue(request, "goods");
		if(goods!=null){
			//��,�ָ�����Cookie��value����ʽ[A, p, p, l, e],���Էָ�ͺ�ߵ�substring����������ʽ
			String[] arr = goods.split(", ");
			//���ַ���Ԫ�ط��뼯����
			Set<String> s = new LinkedHashSet<>(Arrays.asList(arr));
			//���»�ȡ����Ʒ���뼯��
			s.add(goodName);
			//����ת����ַ���
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
