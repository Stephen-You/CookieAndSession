package practice.cookie.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {
	private int w = 70;//ͼƬ�Ŀ��
	private int h = 35;//ͼƬ�ĵ���
	// �������
 	private Random r = new Random();
 	// {"����", "���Ŀ���", "����", "������κ", "��������", "΢���ź�", "����_GB2312"}
	private String[] fontNames  = {"����", "���Ŀ���", "����", "΢���ź�", "����_GB2312"};
	// ������ɵ��ַ���ѡ��
	private String codes  = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	
	// ����ͼƬ����ɫ����ɫ��
	private Color bgColor  = new Color(255, 255, 255);
	private String text ;
	
	private Color randomColor () {
		/*
		 * ���������Ԫɫ��
		 */
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		
		// ������ɫ���󷵻�
		return new Color(red, green, blue);
	}
	
	/**
	 * �����������
	 * @return
	 */
	private Font randomFont () {
		// ��������±�
		int index = r.nextInt(fontNames.length);
		// ʹ������±꣬�õ���������
		String fontName = fontNames[index];
		// ����һ�������ʽ
		/*
		 * 0 --> ��ʾ���ֲ�б
		 * 1 --> ��
		 * 2 --> б
		 * 3 --> ��ʾ�ִ���б
		 */
		int style = r.nextInt(4);
		/*
		 * ��������ֺ�
		 * ����0��1��2��3��4���ټ���24�����յõ�����24��25��26��27��28
		 */
		int size = r.nextInt(5) + 24; 
		// ����������󷵻�
		return new Font(fontName, style, size);
	}
	
	/**
	 * ��Ӹ�����
	 * @param image
	 */
	private void drawLine (BufferedImage image) {
		int num  = 3;//��ʾ3��
		// ��ȡ��
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		// ѭ������ÿ�λ�һ����
		for(int i = 0; i < num; i++) {
			/*
			 * �����ȡ�ĸ������
			 */
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h); 
			/*
			 * ���ñʴ�
			 */
			g2.setStroke(new BasicStroke(1.5F)); 
			/*
			 * �����ߵ���ɫ
			 */
			g2.setColor(Color.BLUE); 
			
			/*
			 * ���ߣ� 
			 */
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * ����һ������ַ�
	 * @return
	 */
	private char randomChar () {
		// r.nextInt(10)������0~9֮���һ������
		// ��ȡ�ַ����ĳ���Ϊ���ƣ����ɵ������һ������Ч�±�
		int index = r.nextInt(codes.length());
		// ��ȡ���±���ַ���Ȼ�󷵻�
		return codes.charAt(index);
	}
	
	/**
	 * ������ͼƬ
	 * @return
	 */
	private BufferedImage createImage () {
		// ����BufferedImage����
		// w��h��ʾͼƬ�Ŀ�͸�
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		// ��ȡͼƬ�Ļ��ʣ�
		Graphics2D g2 = (Graphics2D)image.getGraphics(); 
		
		// ���ñʵ���ɫ
		g2.setColor(this.bgColor);
		
		// ��ͼƬ�����һ������, ���ε����Ͻ���0,0λ���ϣ����εĿ�͸���ͼƬ��ͬ��
		// ����ͼƬ�ı���ɫΪ��ɫ��
		g2.fillRect(0, 0, w, h);
 		return image;
	}
	
	
	/**
	 * ����ͼƬ
	 * @return
	 */
	public BufferedImage getImage () {
		// ����ͼƬ����ͼƬ���ǿյģ�
		BufferedImage image = createImage(); 
		
		// ��ȡͼƬ�Ļ���
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		
		// ����һ��Stringbuilder����������������ɵ��ַ���
		StringBuilder sb = new StringBuilder();
		// ��ͼƬ�л�4���ַ�
		for(int i = 0; i < 4; i++)  {//ѭ��ÿ�ζ�����ͼƬ��дһ���ַ�������
			// ����һ������ַ���ת�����ַ���
			String s = randomChar() + "";
			// ��������ɵ��ַ����浽sb�У�
			sb.append(s); 
			// ���õ�ǰ�ַ���x����㣡
			float x = i * 1.0F * w / 4; 
			
			// ���û��ʵ����壡
			g2.setFont(randomFont()); 
			
			// ���û��ʵ���ɫ
			g2.setColor(randomColor()); 
			
			// ��ͼƬ�ϻ��ַ�
			/*
			 * s --> Ҫ�����ַ���
			 * x --> �ַ���x������
			 * h-5 --> �ַ���y������
			 */
			g2.drawString(s, x, h-5); 
		}
		// ��ȡͼƬ�ϵ��ı������ø�text��
		this.text = sb.toString(); 
		// ��ͼƬ������������ߣ�
		drawLine(image); 
		return image;		
	}
	
	/**
	 * ����ͼƬ�ϵ��ı���
	 * @return
	 */
	public String getText () {
		return text;
	}
	
	public static void output (BufferedImage image, OutputStream out) 
				throws IOException {
		ImageIO.write(image, "JPEG", out);
	}
}




