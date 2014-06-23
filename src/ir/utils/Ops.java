package ir.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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
			
			if (args[i].equals(CONS.Admin.param_Keys[0])) {
				
				if (i + 1 < len_Arg) {
					
					arg_Map.put(CONS.Admin.param_Keys[0], args[i + 1]);
					
					i ++;
					
				} else {
					
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
					
				}
				
			} else if (args[i].equals(CONS.Admin.param_Keys[1])) {
				
				if (i + 1 < len_Arg) {
					
					arg_Map.put(CONS.Admin.param_Keys[1], args[i + 1]);
					
					i ++;
					
				} else {
					
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
					
				}
				
			} else if (args[i].equals(CONS.Admin.param_Keys[2])) {
				
				if (i + 1 < len_Arg) {
					
					arg_Map.put(CONS.Admin.param_Keys[2], args[i + 1]);
					
					i ++;
					
				} else {
					
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
					
				}
				
			} else {
				
				i ++;

			}//if (args[i].equals(CONS.Admin.param_Keys[0]))
			
		}//for (int i = 0; i < len_Arg; i++)
		
		
		return null;
		
	}//get_Options(String[] args)
	
}//public class Ops
