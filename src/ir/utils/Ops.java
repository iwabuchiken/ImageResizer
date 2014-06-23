package ir.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;


public class Ops {

	public static void open_ImageWindow() {
		// TODO Auto-generated method stub
		String message = "open_ImageWindow()";
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
	}

	public static HashMap<String, String> 
	get_ArgMap(String[] args) {

		/******************************
			validate
		 ******************************/
		if (args == null || args.length < 1) {
			
			// Log
			String message = "args == null || args.length < 1";
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());

			message = null;
			
			return null;
			
		}
		
		////////////////////////////////

		// build: hashed map

		////////////////////////////////
		HashMap<String, String> arg_Map = new HashMap<String, String>();
		
//		"-size",	0
//		"-src",		1
//		"-dst"		2
		
		int len_Arg = args.length;
		
		for (int i = 0; i < len_Arg; i++) {
			
//			"-size",	0
			if (args[i].equals(CONS.Admin.param_Keys[0])) {
				
//				String message = "!args[i + 1].toLowerCase().startsWith(\"c:\") => " 
//								+ !args[i + 1].toLowerCase().startsWith("c:");
//				String label = "["
//						+ Thread.currentThread().getStackTrace()[1]
//								.getFileName()
//						+ " : "
//						+ Thread.currentThread().getStackTrace()[1]
//								.getMethodName()
//						+ " : "
//						+ Thread.currentThread().getStackTrace()[1]
//								.getLineNumber() + "]";
//				System.out.println(label + " " + message);
				
				//REF regex http://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
				String regex = "\\d+,\\d";
				
				Pattern p = Pattern.compile(regex);
				
//				Matcher m = p.matcher(s);
				
				if (i + 1 < len_Arg 
						&& !args[i + 1].startsWith("-")
						&& p.matcher(args[i + 1]).find()
						) {
					
					arg_Map.put(CONS.Admin.param_Keys[0], args[i + 1]);
					
					i ++;
					
				} else if (i + 1 < len_Arg 
						&& !args[i + 1].startsWith("-")
						&& !p.matcher(args[i + 1]).find()
						) {
					/*
					 * the format of the value string => doesn't match
					 */
					String message = "The size string format doesn't match for: "
							+ CONS.Admin.param_Keys[0];
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					String command_Line = StringUtils.join(args, " ");
					
					System.out.println(command_Line);
					
					System.exit(-1);
					
					
					
				} else {
					
//					String message = "Value not given for: "
					String message = "Value not given for: "
									+ CONS.Admin.param_Keys[0];
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					String command_Line = StringUtils.join(args, " ");
					
					System.out.println(command_Line);
					
					System.exit(-1);
//					return null;
					
				}
			
//				"-src",		1
			} else if (args[i].equals(CONS.Admin.param_Keys[1])) {
				
//				if (i + 1 < len_Arg) {
				if (i + 1 < len_Arg 
						&& !args[i + 1].startsWith("-")
						//REF lower case http://stackoverflow.com/questions/19154117/startswith-method-of-string-ignoring-case answered Oct 3 '13 at 8:19
						&& args[i + 1].toLowerCase().startsWith("c:")) {
					
					arg_Map.put(CONS.Admin.param_Keys[1], args[i + 1]);
					
					i ++;
					
					String message = "'-src' option => given";
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					
				} else if (i + 1 < len_Arg 
						&& !args[i + 1].startsWith("-")
						&& !args[i + 1].toLowerCase().startsWith("c:")) {
					/*
					 * args => "-src images\..."
					 * 	=> needs to be "-src C:\WORKS\..."
					 */
					String message = "source file needs to be of a full path: "
//							String message = "source file needs to be of a full path: "
							+ CONS.Admin.param_Keys[1];
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					String command_Line = StringUtils.join(args, " ");
					
					System.out.println(command_Line);
					
					System.exit(-1);
					
				} else {
					
					String message = "Value not given for: "
									+ CONS.Admin.param_Keys[1];
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					String command_Line = StringUtils.join(args, " ");
					
					System.out.println(command_Line);
					
					System.exit(-1);
					
//					return null;
					
				}
				
//				"-dst"		2
			} else if (args[i].equals(CONS.Admin.param_Keys[2])) {
				
//				if (i + 1 < len_Arg) {
				if (i + 1 < len_Arg && !args[i + 1].startsWith("-")) {
					
					arg_Map.put(CONS.Admin.param_Keys[2], args[i + 1]);
					
					i ++;
					
				} else {
					
					String message = "Value not given for: "
									+ CONS.Admin.param_Keys[2];
					String label = "["
							+ Thread.currentThread().getStackTrace()[1]
									.getFileName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName()
							+ " : "
							+ Thread.currentThread().getStackTrace()[1]
									.getLineNumber() + "]";
					System.out.println(label + " " + message);
					
					String command_Line = StringUtils.join(args, " ");
					
					System.out.println(command_Line);
					
					System.exit(-1);
					
//					return null;
					
				}
				
			} else {
				
				i ++;

			}//if (args[i].equals(CONS.Admin.param_Keys[0]))
			
		}//for (int i = 0; i < len_Arg; i++)
		
		
		return arg_Map;
		
	}//get_Options(String[] args)

	public static void 
	set_OptVals_Dflt() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// set: size

		////////////////////////////////
		set_OptVals_Dflt__Size();
//		CONS.Main.resizePercent[0] = 20;
//		CONS.Main.resizePercent[1] = 20;
		
		////////////////////////////////

		// set: src

		////////////////////////////////
		set_OptVals_Dflt__Src();
		
		////////////////////////////////

		// set: dst

		////////////////////////////////
		set_OptVals_Dflt__Dst();
//		String ext = FilenameUtils.getExtension(CONS.Main.fpath_Src);
////		String ext = FilenameUtils.getExtension(fname_Src);
//		
//		String marker = ".";
//		
//		String fname_Dst_Trunk = Methods.get_Trunk(CONS.Main.fpath_Src, marker);
////		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, marker);
////		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, ".");
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(fname_Dst_Trunk);
//		sb.append("_");
//		sb.append(Methods.get_TimeLabel(
//				Methods.getMillSeconds_now(), 
//				CONS.Admin.TimeLabelTypes.SERIAL));
//		sb.append(String.format(
//							"_size-%dx%d", 
//							CONS.Main.resizePercent[0], 
//							CONS.Main.resizePercent[1]));
//		sb.append(marker);
//		sb.append(ext);
//		
//		String fname_Dst = sb.toString();
//		
//		CONS.Main.fpath_Dst = StringUtils.join(
//				new String[]{
//						CONS.Paths.dpath_Images,
//						fname_Dst
//				}, 
//				File.separator);

	}//set_OptVals_Dflt()

	private static void 
	set_OptVals_Dflt__Dst() {
		// TODO Auto-generated method stub
		String ext = FilenameUtils.getExtension(CONS.Main.fpath_Src);
//		String ext = FilenameUtils.getExtension(fname_Src);
		
		String marker = ".";
		
		String fname_Dst_Trunk = Methods.get_Trunk(CONS.Main.fpath_Src, marker);
//		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, marker);
//		String fname_Dst_Trunk = Methods.get_Trunk(fname_Src, ".");
		
		StringBuilder sb = new StringBuilder();
		sb.append(fname_Dst_Trunk);
		sb.append("_");
		sb.append(Methods.get_TimeLabel(
				Methods.getMillSeconds_now(), 
				CONS.Admin.TimeLabelTypes.SERIAL));
		sb.append(String.format(
							"_size-%dx%d", 
							CONS.Main.resizePercent[0], 
							CONS.Main.resizePercent[1]));
		sb.append(marker);
		sb.append(ext);
		
		String fname_Dst = sb.toString();
		
		CONS.Main.fpath_Dst = StringUtils.join(
				new String[]{
						CONS.Paths.dpath_Images,
						fname_Dst
				}, 
				File.separator);
		
	}//set_OptVals_Dflt__Dst()

	private static void set_OptVals_Dflt__Size() {
		// TODO Auto-generated method stub
		CONS.Main.resizePercent[0] = 20;
		CONS.Main.resizePercent[1] = 20;
				
	}

	private static void set_OptVals_Dflt__Src() {
		// TODO Auto-generated method stub
		String fname_Src = "200px-Lactose.svg.png";
		
//		CONS.fpath_Src = new File(CONS.Paths.dpath_Images, fname_Src);
		
		CONS.Main.fpath_Src = StringUtils.join(
							new String[]{
									CONS.Paths.dpath_Images,
									fname_Src
							}, 
							CONS.Admin.pathSeparator);
//		File.separator);
		
//		String message = "CONS.Main.fpath_Src: set to => " + CONS.Main.fpath_Src;
//		String label = "["
//				+ Thread.currentThread().getStackTrace()[1].getFileName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getMethodName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//				+ "]";
//		System.out.println(label + " " + message);
		

	}

	public static void 
	set_OptVals
	(HashMap<String, String> arg_Map) {
		// TODO Auto-generated method stub
//		"-size",	0
//		"-src",		1
//		"-dst"		2
		
		////////////////////////////////

		// -src

		////////////////////////////////
		set_OptVals__Src(arg_Map);
		
		////////////////////////////////
		
		// -size
		
		////////////////////////////////
		set_OptVals__Size(arg_Map);
		
		
		
	}//set_OptVals

	private static void
	set_OptVals__Src
	(HashMap<String, String> arg_Map) {
		// TODO Auto-generated method stub

		String val = arg_Map.get(CONS.Admin.param_Keys[1]);
		
		String message = "val => " + val;
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
				
		////////////////////////////////
		
		// set
		
		////////////////////////////////
		if (val == null) {
			
			Ops.set_OptVals_Dflt__Src();
			
		} else {
			
			CONS.Main.fpath_Src = val;
			
		}
		
		return;
		
	}//set_OptVals__Src
	
	private static void
	set_OptVals__Size
	(HashMap<String, String> arg_Map) {
		// TODO Auto-generated method stub
		
		String val = arg_Map.get(CONS.Admin.param_Keys[0]);
		
		String message = "val => " + val;
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		////////////////////////////////
		
		// set
		
		////////////////////////////////
		if (val == null) {
			
			Ops.set_OptVals_Dflt__Size();
			
		} else {
			
			String[] tokens = val.split(",");
			
			CONS.Main.resizePercent[0] = Integer.parseInt(tokens[0]);
			CONS.Main.resizePercent[1] = Integer.parseInt(tokens[1]);
			
//			CONS.Main.fpath_Src = val;
			
		}
		
		return;
		
	}//set_OptVals__Src
	
}//public class Ops
