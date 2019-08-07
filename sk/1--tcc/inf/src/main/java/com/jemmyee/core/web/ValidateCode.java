package com.jemmyee.core.web;

/**
 * @Description:生成随机验证码类
 * @author:jemmyee@gmail.com
 * @version:v1.0
 */
public class ValidateCode {

	/**
	* @Description: 图片宽度
	* @author:jemmyee@gmail.com
	*/
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	* @Description: 图片高度
	* @author:jemmyee@gmail.com
	*/
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	/**
	* @Description:字符数量
	* @author:jemmyee@gmail.com
	*/
	public int getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getFontHeight() {
		return fontHeight;
	}

	public void setFontHeight(int fontHeight) {
		this.fontHeight = fontHeight;
	}

	public int getCodeY() {
		return codeY;
	}

	public void setCodeY(int codeY) {
		this.codeY = codeY;
	}

	public char[] getCodeSequence() {
		return codeSequence;
	}

	public void setCodeSequence(char[] codeSequence) {
		this.codeSequence = codeSequence;
	}

	private static final long serialVersionUID = 1L;

	// 验证码图片的宽度。
	private int width = 50;
	// 验证码图片的高度。
	private int height = 20;
	// 验证码字符个数
	private int codeCount = 4;

	private int x = 2;
	// 字体高度
	private int fontHeight;
	private int codeY;

	public static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 初始化验证图片属性
	 */
	public ValidateCode() {
		// 从web.xml中获取初始信息
		// 宽度
		String strWidth = "60";
		// 高度
		String strHeight = "15";
		// 字符个数
		String strCodeCount = "4";

		// 将配置的信息转换成数值
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		x = width / (codeCount + 1);
		fontHeight = height - 2;
		codeY = height - 4;

	}
	/**
	 * protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	 * throws ServletException, java.io.IOException { //禁止图像缓存
	 * resp.setHeader("Pragma", "no-cache"); resp.setHeader("Cache-Control",
	 * "no-cache"); resp.setDateHeader("Expires", 0);
	 * resp.setContentType("image/jpeg"); HttpSession session =
	 * req.getSession();
	 * 
	 * //定义图像buffer BufferedImage buffImg = new BufferedImage(width,
	 * height,BufferedImage.TYPE_INT_RGB); Graphics2D g =
	 * buffImg.createGraphics();
	 * 
	 * //创建一个随机数生成器类 Random random = new Random();
	 * 
	 * //将图像填充为白色 g.setColor(Color.WHITE); g.fillRect(0, 0, width, height+50);
	 * 
	 * //创建字体，字体的大小应该根据图片的高度来定。 Font font = new Font("Fixedsys", Font.PLAIN,
	 * fontHeight); //设置字体 g.setFont(font);
	 * 
	 * //画边框。 g.setColor(Color.BLACK); g.drawRect(0, 0, 0, 0);
	 * 
	 * //随机产生20条干扰线，使图象中的认证码不易被其它程序探测到。 g.setColor(Color.BLACK); for(int i = 0;
	 * i < 20; i++) { int x = random.nextInt(width); int y =
	 * random.nextInt(height); int xl = random.nextInt(1); int yl =
	 * random.nextInt(1); g.drawLine(x, y, x + xl, y + yl); }
	 * 
	 * //randomCode用于保存随机产生的验证码，以便用户登录后进行验证。 StringBuffer randomCode = new
	 * StringBuffer(); int red = 0, green = 0, blue = 0;
	 * 
	 * //随机产生codeCount数字的验证码。 for (int i = 0; i < codeCount; i++) {
	 * //得到随机产生的验证码数字。 String strRand =
	 * String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
	 * //产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。 red = random.nextInt(200); green =
	 * random.nextInt(200); blue = random.nextInt(200);
	 * 
	 * //用随机产生的颜色将验证码绘制到图像中。 g.setColor(new Color(red, green, blue)); int
	 * point=0; if(i==0) point=2; else if(i==1) point=18; else if(i==2)
	 * point=34; else point=50; g.drawString(strRand, point, codeY);
	 * 
	 * //将产生的四个随机数组合在一起。 randomCode.append(strRand); } // 将四位数字的验证码保存到Session中。
	 * session.setAttribute("code", randomCode.toString());
	 * 
	 * //将图像输出到Servlet输出流中。 g.dispose(); ServletOutputStream sos =
	 * resp.getOutputStream(); ImageIO.write(buffImg, "jpeg", sos); sos.close();
	 * 
	 * }
	 **/
}
