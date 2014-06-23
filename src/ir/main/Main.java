package ir.main;

import ir.utils.CONS;
import ir.utils.Methods;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_test();
		
//		_test_2_Conv_Regex_to_String();
		
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

	private static void _test_2_Conv_Regex_to_String() {
		// TODO Auto-generated method stub
		String string = "200px-Lactose.svg.png";
		
		String s1 = ".";
//		String s2 = "\\.";
		
		String message = "s1 = " + s1
						+ " / "
						+ "Pattern.quote(s1) = " + Pattern.quote(s1);
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		////////////////////////////////

		// 2

		////////////////////////////////
		String[] tokens = string.split(Pattern.quote(s1));
//		String[] tokens = string.split(Pattern.quote(string));
//		String[] tokens_2 = string.split(Pattern.quote(string));
		
		message = "tokens.length = " + tokens.length;
		label = "["
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
//		String fname = "../images/200px-Lactose.svg.png";
//		String fname_new = "../images/200px-Lactose.svg.resized.png";
//		String fname = "images/200px-Lactose.svg.png";
//		String fname_new = "images/200px-Lactose.svg.resized.png";
		
		String fname_Src = "200px-Lactose.svg.png";
		
		//REF http://stackoverflow.com/questions/3571223/how-do-i-get-the-file-extension-of-a-file-in-java answered Apr 24 '13 at 21:12
		String ext = FilenameUtils.getExtension(fname_Src);

		String marker = ".";
		
		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, marker);
//		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, ".");
		
		StringBuilder sb = new StringBuilder();
		sb.append(fname_Dst_Trunk);
		sb.append("_");
		sb.append(Methods.get_TimeLabel(Methods.getMillSeconds_now()));
		sb.append(marker);
		sb.append(ext);
		
		String fname_Dst = sb.toString();
		
//		String fname_Dst = Methods.get_Trunk(fname_Src, "\\.");
		
		String message = "fname_Src = " + fname_Src
						+ " / "
						+ "fname_Dst = " + fname_Dst;
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		
		
		
//		String[] tokens = fname_Src.split("\\.", 2);
//		
//		for (String string : tokens) {
//			
//			String message = "token = " + string;
//			String label = "["
//					+ Thread.currentThread().getStackTrace()[1].getFileName()
//					+ " : "
//					+ Thread.currentThread().getStackTrace()[1].getMethodName()
//					+ " : "
//					+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//					+ "]";
//			System.out.println(label + " " + message);
//			
//		}
		
		File fpath_Src = new File(CONS.Admin.dpath_Images, fname_Src);
		File fpath_Dst = new File(
							CONS.Admin.dpath_Images, 
							fname_Dst);
//	"200px-Lactose.svg.resized.png");
		
		////////////////////////////////

		// validate: file type

		////////////////////////////////
//		boolean res = Ops.validate_FileType(fname);
		
		try {
			
			BufferedImage originalImage = ImageIO.read(fpath_Src);
//			BufferedImage originalImage = ImageIO.read(new File(fname));
			
			int type = originalImage.getType() == 0? 
							BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			
			BufferedImage resizedImage = new BufferedImage(100, 100, type);
			
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, 100, 100, null);
			g.dispose();
			
			ImageIO.write(
						resizedImage, ext, fpath_Dst);
//			resizedImage, "png", fpath_Dst);
//			resizedImage, "png", new File(fname_new));
			
			message = "resized/saved";
			label = "["
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
