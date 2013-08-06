package ch.unifr.couchbaseRDF.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	public static void main(String[] args) {
		String folderName = null;
//				"eba-li-go-vyv-foldera";
//		PrintStream pr = null;
//		if(folderName == null){
//			pr = FileUtils.getPrintStream("ebali si Entities", new Date());
//		} else {
//
//			File f = new File("./" + folderName);
//			f.mkdir();
//
//			pr = FileUtils.getPrintStream("./" + folderName
//					+ "/Retrieved Entities", new Date());
//		}
//		pr.println("6to li ne si eba maikata az");
		System.out.println(normalizeFileName("C:/iliya/uni/MSC Thesis/n3 dataset/UniDataSingleOrderedSmall.nt"));
	}

	public static String formatedDate(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd-kk.mm.ss");
		return dateFormat.format(date);
	}

	public static String getPrintStreamName(String name, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yy.MM.dd-kk.mm.ss-SSSS");

		String outputFilePath = name + "" + dateFormat.format(date) + ".txt";
		return outputFilePath;
	}
	
	public static PrintStream getPrintStream(String name){
		File f = new File(name);
		
		PrintStream pr = null;
		try {
			pr = new PrintStream(f);
		} catch (FileNotFoundException e1) {
			System.err.println("Neshto se eba sys printstreama!");
			e1.printStackTrace();
		}
		return pr;
	}
	
	public static PrintStream getPrintStream(String name, Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd-kk.mm.ss-SSSS");
		
		String outputFilePath = name + ""+dateFormat.format(date)+ ".nt";
		
		File f = new File(outputFilePath);
		
		PrintStream pr = null;
		try {
			pr = new PrintStream(f);
		} catch (FileNotFoundException e1) {
			System.err.println("Neshto se eba sys printstreama!");
			e1.printStackTrace();
		}
		return pr;
	}
	public static PrintStream getIndexedPrintStream(String name, Date date, String index){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy.MM.dd-kk.mm.ss");
		
		String outputFilePath = name + " "+dateFormat.format(date)+ " Pt-"+index+".nt";
		
		File f = new File(outputFilePath);
		
		PrintStream pr = null;
		try {
			pr = new PrintStream(f);
		} catch (FileNotFoundException e1) {
			System.err.println("Neshto se eba sys printstreama!");
			e1.printStackTrace();
		}
		return pr;
	}
	
	public static String normalizeFileName(String wholePath){
		int begIndex = wholePath.lastIndexOf("/");
		int endIndex = wholePath.lastIndexOf(".");
		if(endIndex!=-1){
			wholePath = wholePath.substring(begIndex+1,endIndex);
		} else {
			wholePath = wholePath.substring(begIndex+1);
		}
		return wholePath;
	}
}
