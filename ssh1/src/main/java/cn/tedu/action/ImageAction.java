package cn.tedu.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageAction {
	private InputStream image;
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
		
	public String execute(){
		//生成图片...
		try {
			byte[] data = createPngImage();
			image = new ByteArrayInputStream(data);
			return "img";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public byte[] createPngImage() throws IOException{
		//创建 BufferedImage对象
		BufferedImage img = new BufferedImage(
			200, 100, BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(0, 0, 0xff0000); 
		img.setRGB(100, 50, 0xffff00); 
		//利用API将图片对象编码为 png
		//酱油瓶子out(变长byte数组)
		ByteArrayOutputStream out=
				new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		//再获取PNG数据数组
		out.close();
		//从酱油瓶子中倒出数据(byte[])
		byte[] data = out.toByteArray();
		return data;
	}
}







