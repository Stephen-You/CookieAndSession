package practice.cookie.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;

/**
 * ����һ��ͼƬ����ͼƬ��Ӧ���ͻ���
 * @author Yorick
 */
@WebServlet("/VCServlet")
public class VCServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡһ��VerifyCode����
		VerifyCode vc = new VerifyCode();
		//��ȡͼƬ
		BufferedImage image = vc.getImage();
		//��ȡͼƬ�ϵ��ı�
		String code = vc.getText();
		//���ı�����Session
		request.getSession().setAttribute("code", code);
		//��ͼƬ������ͻ���
		response.setContentType("image/jpeg");
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
