package practice.cookie.image;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.junit.Test;

import cn.itcast.vcode.utils.VerifyCode;

/**
 * 演示VerfiyCode类
 * @author Yorick
 */
public class VerfiyCodeTest {
	
	@Test
	public void test(){
		//获取一个图像验证码对象
		VerifyCode vc = new VerifyCode();
		//创建一张图片
		BufferedImage image = vc.getImage();
		//获取4个随机字符
		String code = vc.getText();
		System.out.println(code);
		//创建输出流,保存图片
		try {
			FileOutputStream os = new FileOutputStream("F://image.jpg");
			// 使用ImageIO类来完成
			// bi --> 要保存的图片
			// "JPEG" --> 格式化名称，即什么类型的图片
			// out --> 保存到指定的输出流中
			ImageIO.write(image, "JPEG", os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
