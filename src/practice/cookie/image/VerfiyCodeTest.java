package practice.cookie.image;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.junit.Test;

import cn.itcast.vcode.utils.VerifyCode;

/**
 * ��ʾVerfiyCode��
 * @author Yorick
 */
public class VerfiyCodeTest {
	
	@Test
	public void test(){
		//��ȡһ��ͼ����֤�����
		VerifyCode vc = new VerifyCode();
		//����һ��ͼƬ
		BufferedImage image = vc.getImage();
		//��ȡ4������ַ�
		String code = vc.getText();
		System.out.println(code);
		//���������,����ͼƬ
		try {
			FileOutputStream os = new FileOutputStream("F://image.jpg");
			// ʹ��ImageIO�������
			// bi --> Ҫ�����ͼƬ
			// "JPEG" --> ��ʽ�����ƣ���ʲô���͵�ͼƬ
			// out --> ���浽ָ�����������
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
