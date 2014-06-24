package ir.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

public class Resize {

	public static boolean 
	resize() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// setup: vars

		////////////////////////////////
		File f_Src = new File(
//						CONS.Paths.dpath_Images, 
						CONS.Main.fpath_Src);
		
		File f_Dst = new File(
//						CONS.Paths.dpath_Images, 
						CONS.Main.fpath_Dst);
		
		String ext = FilenameUtils.getExtension(CONS.Main.fpath_Src);
		
		String message = "f_Src.getAbsolutePath() = " + f_Src.getAbsolutePath();
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		
		////////////////////////////////
		
		// validate: file type
		
		////////////////////////////////
//		boolean res = Ops.validate_FileType(fname);
		
		try {
			
			BufferedImage originalImage = ImageIO.read(f_Src);
//			BufferedImage originalImage = ImageIO.read(new File(fname));
			
			int type = originalImage.getType() == 0? 
					BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			
			BufferedImage resizedImage = new BufferedImage(100, 100, type);
			
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, 100, 100, null);
			g.dispose();
			
			ImageIO.write(
					resizedImage, ext, f_Dst);
//			resizedImage, "png", fpath_Dst);
//			resizedImage, "png", new File(fname_new));
			
//			message = "resized/saved";
//			label = "["
//					+ Thread.currentThread().getStackTrace()[1].getFileName()
//					+ " : "
//					+ Thread.currentThread().getStackTrace()[1].getMethodName()
//					+ " : "
//					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//					+ "]";
//			System.out.println(label + " " + message);
			
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
			
		}//try
		
	}//resize()

}
