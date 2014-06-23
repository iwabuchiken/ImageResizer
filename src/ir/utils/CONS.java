package ir.utils;

public class CONS {

	public static class Admin {
		
//		public static final int		INITIAL_NUM		= 10;
		public static final int		INITIAL_GENE_NUM		= 4;
		
		public static final int		STANDARD_GENE_NUM		= 8;
		
		public static final int		NUM_OF_BITS		= 6; // number of gene bits
		
		public static final int		NUM_OF_PAIRS	= 4 ; // Number of pairs for mating
		
		public static enum TimeLabelTypes {
				SERIAL,			// xxxxxxxx_xxxxxx
				STANDARD,		// xx/xx/xx xx:xx:xx
		}
		
		public static final String[] param_Keys = {
			
					"-size",
					"-src",
					"-dst"
			
		};
		
		public static final String pathSeparator = "/";
		
	}//public static class Admin

	public static class Paths {
		
		public static final String dpath_Images = 
				"C:/WORKS/WS/Eclipse_Kepler/ImageResizer/images";
		
		public static final String dpath_Log =
							"C:/WORKS/WS/Eclipse_Kepler/ImageResizer/log";
		
		public static final String fname_Log = "log.txt";
		
	}

	public static class Main {
		
		public static String fpath_Src;		
		
		public static String fpath_Dst;
		
		public static int[] resizePercent = new int[2];
		
	}

}
