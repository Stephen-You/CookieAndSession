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
	private int w = 70;//图片的宽度
	private int h = 35;//图片的调试
	// 随机对象！
 	private Random r = new Random();
 	// {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
	private String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
	// 随机生成的字符可选集
	private String codes  = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	
	// 它是图片背景色（白色）
	private Color bgColor  = new Color(255, 255, 255);
	private String text ;
	
	private Color randomColor () {
		/*
		 * 生成随机三元色！
		 */
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		
		// 创建颜色对象返回
		return new Color(red, green, blue);
	}
	
	/**
	 * 生成随机字体
	 * @return
	 */
	private Font randomFont () {
		// 生成随机下标
		int index = r.nextInt(fontNames.length);
		// 使用随机下标，得到字体名称
		String fontName = fontNames[index];
		// 生成一个随机样式
		/*
		 * 0 --> 表示不粗不斜
		 * 1 --> 粗
		 * 2 --> 斜
		 * 3 --> 表示又粗又斜
		 */
		int style = r.nextInt(4);
		/*
		 * 生成随机字号
		 * 生成0、1、2、3、4，再加上24，最终得到的是24、25、26、27、28
		 */
		int size = r.nextInt(5) + 24; 
		// 创建字体对象返回
		return new Font(fontName, style, size);
	}
	
	/**
	 * 添加干扰线
	 * @param image
	 */
	private void drawLine (BufferedImage image) {
		int num  = 3;//表示3条
		// 获取笔
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		// 循环画，每次画一条！
		for(int i = 0; i < num; i++) {
			/*
			 * 随机获取四个坐标点
			 */
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h); 
			/*
			 * 设置笔粗
			 */
			g2.setStroke(new BasicStroke(1.5F)); 
			/*
			 * 设置线的颜色
			 */
			g2.setColor(Color.BLUE); 
			
			/*
			 * 画线！ 
			 */
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * 生成一个随机字符
	 * @return
	 */
	private char randomChar () {
		// r.nextInt(10)，生成0~9之间的一个整数
		// 获取字符串的长度为限制！生成的随机数一定是有效下标
		int index = r.nextInt(codes.length());
		// 获取该下标的字符，然后返回
		return codes.charAt(index);
	}
	
	/**
	 * 创建空图片
	 * @return
	 */
	private BufferedImage createImage () {
		// 创建BufferedImage对象
		// w、h表示图片的宽和高
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		// 获取图片的画笔！
		Graphics2D g2 = (Graphics2D)image.getGraphics(); 
		
		// 设置笔的颜色
		g2.setColor(this.bgColor);
		
		// 在图片上填充一个矩形, 矩形的左上角在0,0位置上！矩形的宽和高与图片相同！
		// 设置图片的背景色为白色！
		g2.fillRect(0, 0, w, h);
 		return image;
	}
	
	
	/**
	 * 生成图片
	 * @return
	 */
	public BufferedImage getImage () {
		// 创建图片，但图片上是空的！
		BufferedImage image = createImage(); 
		
		// 获取图片的画笔
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		
		// 创建一个Stringbuilder，用来保存随机生成的字符！
		StringBuilder sb = new StringBuilder();
		// 向图片中画4个字符
		for(int i = 0; i < 4; i++)  {//循环每次都会向图片上写一个字符！！！
			// 生成一个随机字符，转换成字符串
			String s = randomChar() + "";
			// 把随机生成的字符保存到sb中！
			sb.append(s); 
			// 设置当前字符的x坐标点！
			float x = i * 1.0F * w / 4; 
			
			// 设置画笔的字体！
			g2.setFont(randomFont()); 
			
			// 设置画笔的颜色
			g2.setColor(randomColor()); 
			
			// 向图片上画字符
			/*
			 * s --> 要画的字符串
			 * x --> 字符的x轴坐标
			 * h-5 --> 字符的y轴坐标
			 */
			g2.drawString(s, x, h-5); 
		}
		// 获取图片上的文本，设置给text！
		this.text = sb.toString(); 
		// 给图片添加三条干扰线！
		drawLine(image); 
		return image;		
	}
	
	/**
	 * 返回图片上的文本！
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




