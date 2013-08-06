package ch.unifr.couchbaseRDF.utils;


import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.View;

public class ConnectionManager {

	private static CouchbaseClient client;
	public static final String DB_URL = "http://192.168.214.153:8091/pools"; //192.168.214.153  diufpc301 diuflx01
	public static final String DB_BUCKET_NAME = "dataset_5mCorrect"; // dataset_05m
																// "bucket01"
	public static List<URI> URIS;

	static {
		URIS = new LinkedList<URI>();
		URIS.add(URI.create(DB_URL));
	}

	private ConnectionManager() {

	}

	public static CouchbaseClient getInstance() {

		if (client == null) {
			try {
				// Use the "default" bucket with no password
				client = new CouchbaseClient(URIS, DB_BUCKET_NAME, "");
				// client = new CouchbaseClient(uris, "default", "");
			} catch (IOException e) {
				System.err.println("IOException connecting to Couchbase: "
						+ e.getMessage());
				System.exit(1);
			}
		}
		return client;
	}

	public static CouchbaseClient getInstance(String bucketName, String ... uris) {
		List<URI> connections = new LinkedList<URI>();
		for(String uri:uris){
			connections.add(URI.create(uri));
		}
		
		
		if (client == null) {
			try {
				// Use the "default" bucket with no password
				client = new CouchbaseClient(connections, bucketName, "");
				// client = new CouchbaseClient(uris, "default", "");
			} catch (IOException e) {
				System.err.println("IOException connecting to Couchbase: "
						+ e.getMessage());
				System.exit(1);
			}
		}
		return client;
	}
	
	public static CouchbaseClient getInstance(String bucketName) {

		if (client == null) {
			try {
				// Use the "default" bucket with no password
				client = new CouchbaseClient(URIS, bucketName, "");
				// client = new CouchbaseClient(uris, "default", "");
			} catch (IOException e) {
				System.err.println("IOException connecting to Couchbase: "
						+ e.getMessage());
				System.exit(1);
			}
		}
		return client;
	}
	
	public static void clientShutDown() {
		if(client!=null){
			client.shutdown(2, TimeUnit.SECONDS);
		}
	}
	static View viewPredObj;
	static View viewSubjPred;
	static View viewSubjPredObj;
	static View viewPred;
	static View viewSubj;
	static View viewObj;
	static String dev = "";
	
	public static View getPredObjView(){
		if(viewPredObj == null){
			viewPredObj = getInstance().getView(dev+"PredObj", "PredObj");
		}
		
		return viewPredObj;
	}
	
	public static View getSubjPredView(){
		if(viewSubjPred == null){
			viewSubjPred = getInstance().getView(dev+"SubjPred", "SubjPred");
		}
		
		return viewSubjPred;
	}
	
	public static View getSubjPredObjView(){
		if(viewSubjPredObj == null){
			viewSubjPredObj = getInstance().getView(dev+"SubjPredObj", "SubjPredObj");
		}
		
		return viewSubjPredObj;
	}
	public static View getPredView(){
		if(viewPred == null){
			viewPred = getInstance().getView(dev+"Pred", "Pred");
		}
		
		return viewPred;
	}
	
	public static View getSubjView(){
		if(viewSubj == null){
			viewSubj = getInstance().getView(dev+"Subj", "Subj");
		}
		
		return viewSubj;
	}
	
	public static View getObjView(){
		if(viewObj == null){
			viewObj = getInstance().getView(dev+"Obj", "Obj");
		}
		
		return viewObj;
	}
}
