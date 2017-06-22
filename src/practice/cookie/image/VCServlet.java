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
 * 生成一张图片，把图片响应给客户端
 * @author Yorick
 */
@WebServlet("/VCServlet")
public class VCServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取一个VerifyCode对象
		VerifyCode vc = new VerifyCode();
		//获取图片
		BufferedImage image = vc.getImage();
		//获取图片上的文本
		String code = vc.getText();
		//把文本放入Session
		request.getSession().setAttribute("code", code);
		//把图片输出给客户端
		response.setContentType("image/jpeg");
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

}
