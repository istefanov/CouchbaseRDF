package ch.unifr.couchbaseRDF.results;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

import ch.unifr.couchbaseRDF.utils.FileUtils;


public class ResultsParser {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		String inputFile = "D:/work/uni-assistent/couchbase/Retrieval stats dbpedia13.06.07-21.10.01-0123.nt";
//		parse(inputFile, "TableResults ", 19, 10);
//	}
	
	public static void parse(String inputFile, String outputFile, int queryCount, int repetitions){
//		int queryCount = 11;
//		int queryCount = 19;
//		int repetitions = 10;
		long[][] results = new long[queryCount][repetitions];
		
		FileInputStream is = null;
		try {
			is = new FileInputStream(inputFile);
		} catch (FileNotFoundException e) {
			System.err.println("Eba se 4eteneto na faila.");
			e.printStackTrace();
		}

		Scanner sc = new Scanner(is);
		int qCounter = 0;
		int repeatTimer = 0;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.contains("Executed")) {
				String time = line.substring(13);
				long t = Long.parseLong(time);
				results[qCounter][repeatTimer] = t;
				qCounter++;
				if(qCounter == queryCount){
					repeatTimer++;
					qCounter=0;
				}
			}
		}
		
		File file = new File("tableRetrieval");
		file.mkdir();
		PrintStream pr = FileUtils.getPrintStream("./tableRetrieval/"+outputFile, new Date());
		for(int i = 0;i<queryCount;i++){
			StringBuilder line = new StringBuilder();
			for(int j = 0;j<repetitions;j++){
				line.append(results[i][j]+"\t");
			}
			pr.println(line.toString());
		}
	}

}
