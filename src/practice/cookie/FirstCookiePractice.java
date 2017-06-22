package practice.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie�ĵ�һ����ϰ:
 * �ͻ��˷���AServlet��AServlet����Ӧ�����Cookie����������Զ�����Cookie��
 * Ȼ��ͻ��˷���BServlet����ʱ��������Զ��������д���Cookie��BServlet��ȡ������
 * ��Cookie��ӡ������
 * @author Yorick
 *
 */
public class FirstCookiePractice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//��ȡCookie�õ����ʴ���
//		String cookie = request.getHeader("Cookie");
//		//�ж�Cookie����null,����ȥ�����ÿո���ǿ��ַ���
//		if(cookie!=null && !cookie.trim().isEmpty()){
//			//��ȡ=�ַ��Ľű�,��ȡ���������
//			int index = cookie.indexOf("=");
//			//ע���ַ�����ȡ��ͷ����β
//			int count = Integer.parseInt(cookie.substring(index+1));
//			//���ʴ�����1
//			count++;
//			//�ѷ��ʴ����ŵ�Cookie��,���ڼ�¼���ʴ���
//			response.setHeader("Set-Cookie", "count="+count);
//			response.getWriter().print(count);;
//		}else {
//			//˵���ǵ�һ�η���
//			response.setHeader("Set-Cookie", "count=1");
//			response.getWriter().print(1);;
//		}
		//ͨ���������Ǽ�ʵ���˷��ʴ���,��ô��û��ʲô�򵥵�ʵ�ַ�����,����ÿ����������������ǵ�CookieҲ��ֹһ��,��ô�����
		//����һ��������Ϊ���ʴ���
		int count = 1;
		//���Ȼ�ȡ������������������ǵ�Cookie
		Cookie[] cookie = request.getCookies();
		if(cookie!=null){
			//����Cookie,��ȡָ�����Ƶ�Cookie
			for (Cookie cookie2 : cookie) {//ע�����û��Cookie,��ô������䱨��ava.lang.NullPointerException,�������һ���ж����
				if(cookie2.getName().equals("count")){
					//����������Ϊ���ʴ���
					count = Integer.parseInt(cookie2.getValue());
					//���ʴ�����1
					count++;
					//����ѭ��
					break;
				}
			}
		}
		
		// count�����ֿ��ܣ���������д���count���Cookie�����ǵ�int���͵�count����ֵΪcookie��ֵ
		// ��������в�������Ϊcount��Cookie��int���ͱ���count��ֵΪ1
		/*
		 * 2. ����cnt��Cookie�У���ӵ���Ӧ��
		 */
//		response.setHeader("Set-Cookie", "count="+count);
		response.getWriter().println(count);
		Cookie cookieNew = new Cookie("count", count+"");
		//�������ƵĴ��ʱ��
		cookieNew.setMaxAge(2*2);
		response.addCookie(cookieNew);
	}


}
