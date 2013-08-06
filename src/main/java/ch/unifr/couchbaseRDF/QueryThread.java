package ch.unifr.couchbaseRDF;

import java.io.PrintStream;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class QueryThread implements Runnable {
	
	
	private String query;
	private Model model;
	private boolean print;
	private PrintStream pr;
	private String qName;
	public QueryThread(String query, String qName, Model model, boolean print, PrintStream pr) {
		super();
		this.query = query;
		this.model = model;
		this.print = print;
		this.pr = pr;
		this.qName = qName;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		long t1 = System.currentTimeMillis();
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		ResultSet results = null;
		Model result = null;
		String qLow = query.toLowerCase();
		boolean construct = qLow.contains("construct");
		boolean describe = qLow.contains("describe");
		long t2 = System.currentTimeMillis();
		try {
			if(construct){
				result = qexec.execConstruct();
				pr.println("\n"+qName);
				StmtIterator stmts = result.listStatements();
				while (stmts.hasNext()) {
					if (print) {
						pr.println(stmts.next().toString());
					}
				}
			} else if (describe){
				result = qexec.execDescribe();
				pr.println("\n"+qName);
				StmtIterator stmts = result.listStatements();
				while (stmts.hasNext()) {
					if (print) {
						pr.println(stmts.next().toString());
					}
				}
			} else {
			results = qexec.execSelect();
//			System.out.println("Query executed");
			pr.println("\n"+qName);
			
//			System.out.println("Want to print");
			while (results.hasNext()) {
				QuerySolution solution = results.next();
				if (print) {
					pr.println(solution.toString());
				}
			}
			}
			long t3 = System.currentTimeMillis();
//			System.out.println("Printed ready");
			pr.println("Qexec prepared in: "+(t2-t1));
			pr.println("Executed in: "+(t3-t1));
			
		} finally {
			qexec.close();
		}
	}

}
