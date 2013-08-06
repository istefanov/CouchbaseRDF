package ch.unifr.couchbaseRDF.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import ch.unifr.couchbaseRDF.CouchbaseGraph;
import ch.unifr.couchbaseRDF.CouchbaseStageGenerator;
import ch.unifr.couchbaseRDF.QueryThread;
import ch.unifr.couchbaseRDF.results.ResultsParser;
import ch.unifr.couchbaseRDF.utils.ConnectionManager;
import ch.unifr.couchbaseRDF.utils.FileUtils;

import com.couchbase.client.CouchbaseClient;
import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.sparql.engine.main.StageBuilder;

public class MainQueryExecutor {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		List<String> queries = MainQueryExecutor5Berlin100m.queries;
		List<String> qNames = MainQueryExecutor5Berlin100m.qNames;
		
		List<String> clusterParams = readServerInfo();
		String bucketName = clusterParams.get(0);
		String clusterUrl = clusterParams.get(1);
		
		//this is for the final representation in table
		int queryCount = Integer.parseInt(clusterParams.get(2));
		int repetitions = Integer.parseInt(clusterParams.get(3));
		
		boolean print = false;
		if(clusterParams.size()>4){
			print = true;
		}
		
		CouchbaseClient client = ConnectionManager
				.getInstance(bucketName,
						clusterUrl);
		Graph g = new CouchbaseGraph(client);
		Model model = ModelFactory.createModelForGraph(g);
		
		CouchbaseStageGenerator c = new CouchbaseStageGenerator();
		StageBuilder.setGenerator(ARQ.getContext(), c) ;
		
		File file = new File("./retrieval");
		file.mkdir();
		String outputFileName = FileUtils.getPrintStreamName("./retrieval/Retrieval stats "
						+ bucketName, new Date());
		PrintStream pr = FileUtils.getPrintStream(outputFileName);
		
		try {
			for (int i = 0; i < queries.size(); i++) {
				QueryThread q = new QueryThread(queries.get(i), qNames.get(i), model,
						print, pr);
				Thread t = new Thread(q);
				t.start();
				try {
					t.join(1000000);
					System.out.println(qNames.get(i) +" finished or interrupted.");
					t.interrupt();
				} catch (Exception e) {
					// System.err.println("Interrupted");
				}
			}
			
			ResultsParser.parse(outputFileName, "TableResults ", queryCount, repetitions);
			
		} finally {
			ConnectionManager.clientShutDown();
			pr.close();
			System.exit(0);
		}
//		System.out.println("little");
//		t.interrupt();
		
	}
		

	/**
	 * 
	 * @return list of Strings the first is the bucket name, the second and further are the db urls
	 */
	public static List<String> readServerInfo(){
		List<String> result = new ArrayList<String>();
		FileInputStream is = null;
		try {
			is = new FileInputStream("./serverInfo");
		} catch (FileNotFoundException e) {
			System.err.println("Eba se 4eteneto na faila.");
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(is);
		while(sc.hasNext()){
			String line = sc.nextLine();
			if(line.charAt(0) != '#'){
				String params = line.trim();
				result.add(params);
//			for(String param:params){
//				System.out.println("|"+param+"|");
//			}
			}
		}
		return result;
	}
}
