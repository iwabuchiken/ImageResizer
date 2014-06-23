package ir.main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_test();
		
		String message = "done";
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		
	}

	private static void _test() {
		// TODO Auto-generated method stub
		String fname = "images/200px-Lactose.svg.png";
		String fname_new = "images/200px-Lactose.svg.resized.png";
		
		////////////////////////////////

		// validate: file type

		////////////////////////////////
//		boolean res = Ops.validate_FileType(fname);
		
		try {
			
			BufferedImage originalImage = ImageIO.read(new File(fname));
			
			int type = originalImage.getType() == 0? 
							BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			
			BufferedImage resizedImage = new BufferedImage(100, 100, type);
			
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, 100, 100, null);
			g.dispose();
			
			ImageIO.write(
						resizedImage, "png", new File(fname_new));
			
			String message = "resized/saved";
			String label = "["
					+ Thread.currentThread().getStackTrace()[1].getFileName()
					+ " : "
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " : "
					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
					+ "]";
			System.out.println(label + " " + message);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
