package ir.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Methods {

	/****************************************
	 *	getMillSeconds_now()
	 * 
	 * <Caller> 
	 * 1. ButtonOnClickListener # case main_bt_start
	 * 
	 * <Desc> 1. <Params> 1.
	 * 
	 * <Return> 1.
	 * 
	 * <Steps> 1.
	 ****************************************/
	public static long getMillSeconds_now() {
		
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime().getTime();
		
	}//private long getMillSeconds_now(int year, int month, int date)

	public static String get_TimeLabel(long millSec) {
		
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		 
		return sdf1.format(new Date(millSec));
		
	}//public static String get_TimeLabel(long millSec)
	
	public static String get_TimeLabel(long millSec, CONS.Admin.TimeLabelTypes type) {
		
		SimpleDateFormat sdf1 = null;
		
		switch(type) {
		
		case SERIAL:
			
			sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
			
			break;
			
		case STANDARD:
			
			sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			break;
			
		default:
			
			sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
			
			break;
		
		}
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		return sdf1.format(new Date(millSec));
		
	}//public static String get_TimeLabel(long millSec)

	public static boolean
	write_Log(String string, String fileName, int line) {
		
		String message_ = "string => " + string;
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message_);
		
		
//		String fpath_Log = "log";
//		String fname_Log = "log.txt";
		
		////////////////////////////////

		// validate: log dir => exists?

		////////////////////////////////
		File dir_Log = new File(CONS.Paths.dpath_Log);
//		File dir_Log = new File(fpath_Log);
		
		if (!dir_Log.exists()) {
			
			String message2 = "Log dir => doesn't exist";
			message(message2,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			boolean res = dir_Log.mkdir();
			
			if (res == false) {
				
				String message = "Cant create dir: " + dir_Log.getAbsolutePath();
				Methods.message(
						message,
						Thread.currentThread().getStackTrace()[1].getFileName(),
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());

				message = null;
				
				return false;
				
			} else {
				
				String message = "dir created: " + dir_Log.getAbsolutePath();
				Methods.message(
						message,
						Thread.currentThread().getStackTrace()[1].getFileName(),
						Thread.currentThread().getStackTrace()[1]
								.getLineNumber());

				message = null;
				
				
			}
			
		}//if (!dir_Log.exists())
		
		////////////////////////////////

		// write log

		////////////////////////////////
		File f = new File(CONS.Paths.dpath_Log, CONS.Paths.fname_Log);
//		File f = new File(CONS.Paths.dpath_Log, fname_Log);
		
		try {
			
			FileWriter fw = new FileWriter(f, true);
			
//			String text = String.format("[%s : %d] %s", fileName, line, message);
			String text = String.format(
						"[%s][%s : %d] %s\n", 
						Methods.get_TimeLabel(
										Methods.getMillSeconds_now(),
										CONS.Admin.TimeLabelTypes.STANDARD),
						fileName, line, string);
//			fileName, line, message);
			
			fw.write(text);
			
			fw.close();
			
			String message2 = "log file => closed";
			message(message2,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String message2 = "message";
			message(message2,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			return false;
			
		}
		
	}//message(String message, String fileName, int line)

	public static void
	message(String message, String fileName, int line) {
		
		String label = "["
				+ fileName
				+ " : "
				+ line
				+ "]";
		
		System.out.println(label + " " + message);
		
	}
	
	public static void
	message
	(String message, String fileName, String methodName, int line) {
		
		String label = "["
				+ fileName
				+ " : "
				+ methodName
				+ " : "
				+ line
				+ "]";
		
		System.out.println(label + " " + message);
		
	}

	public static String 
	get_Trunk(String string, String marker) {
		
		String[] tokens = string.split(Pattern.quote(marker));
//		String[] tokens = string.split(Pattern.quote(string));
//		String[] tokens = string.split(string);
		
//		String message = "string = " + string
//						+ " / "
//						+ "tokens.length = " + tokens.length;
//		String label = "["
//				+ Thread.currentThread().getStackTrace()[1].getFileName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getMethodName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//				+ "]";
//		System.out.println(label + " " + message);
		
		
		// tokens => 1?
		if (tokens == null || tokens.length < 1) {
			
			return string;
			
		}
		
		// 2?
		if (tokens.length == 2) {
			
			return tokens[0];
			
		}
		
//		for (String s : tokens) {
//			
//			String message = "token = " + s;
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
		
		// 3<
		return StringUtils.join(
//					Arrays.copyOfRange(tokens, 0, tokens.length - 2), 
					Arrays.copyOfRange(tokens, 0, tokens.length - 1), 
					marker);
		
		
	}
}
