package ch.unifr.couchbaseRDF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

import ch.unifr.couchbaseRDF.utils.ConnectionManager;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.hp.hpl.jena.datatypes.RDFDatatype;
import com.hp.hpl.jena.datatypes.TypeMapper;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.TripleMatch;
import com.hp.hpl.jena.graph.impl.GraphBase;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.WrappedIterator;

public class CouchbaseGraph extends GraphBase{
	
	public static int predObj = 0;
	public static int obj = 0;
	public static int subj = 0;
	public static int subjPred = 0;
	public static int subjPredObj = 0;
	public static int pred = 0;
	
	private CouchbaseClient client;
	private org.json.simple.parser.JSONParser parser;
	public CouchbaseGraph(CouchbaseClient client){
		this.client = client;
		this.parser = new org.json.simple.parser.JSONParser();
	}
	@Override
	protected ExtendedIterator<Triple> graphBaseFind(TripleMatch m) {
//		CouchbaseClient client = ConnectionManager.getInstance();
		Query query = new Query();
//		Gson gson = new Gson();
		Node subject = m.getMatchSubject();
		Node predicate = m.getMatchPredicate();
		Node object = m.getMatchObject();
		ValueFactory valFactory = new ValueFactoryImpl();
		List<Triple> triples = new ArrayList<Triple>();
		//By predicate object
		if(subject == null && predicate !=null && object !=null){
			predObj++;
			JSONArray jar = new JSONArray();
			String k1 = predicate.toString();
			jar.add(k1);
			String k2 = object.toString();
			jar.add(k2);
			query.setKey(jar.toString());
			
			ViewResponse result = client.query(ConnectionManager.getPredObjView(), query);
			// Iterate over the results and print out some info
			Iterator<ViewRow> itr = result.iterator();
			while (itr.hasNext()) {
				ViewRow row = itr.next();
				String val = row.getId();
				Node s = Node
						.createURI(val);
//						(val.substring(1, val.length()-1));
				Node p = predicate;
				Node o = object;
				Triple tr = new Triple(s, p, o);
				triples.add(tr);
			}
//			By subject predicate
		} else if(subject != null && predicate !=null && object ==null){
			subjPred++;
			Object result = client.get(subject.toString());
			JSONArray molecule = null;
			try {
				molecule = (JSONArray) parser.parse(result.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONArray pAr = (JSONArray) molecule.get(0);
			JSONArray oAr = (JSONArray) molecule.get(1);
			for(int i = 0;i<pAr.size();i++){
				String pred = pAr.get(i).toString();
				if(predicate.toString().equals(pred)){
					Node s = subject;
					Node p = predicate;
					Node o = generateObject(oAr.get(i).toString());
					Triple tr = new Triple(s, p, o);
					triples.add(tr);
				}
			}
//			By subject
		} else if(subject != null && predicate ==null && object ==null){
			subj++;
			Object result = client.get(subject.toString());
			JSONArray molecule = null;
			try {
				molecule = (JSONArray) parser.parse(result.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONArray pAr = (JSONArray) molecule.get(0);
			JSONArray oAr = (JSONArray) molecule.get(1);
			for(int i = 0;i<pAr.size();i++){
				Node s = subject;
				Node p = Node
						.createURI(pAr.get(i).toString());
				Node o = generateObject(oAr.get(i).toString());
				Triple tr = new Triple(s, p, o);
				triples.add(tr);
			}
			
//		By object	
		}  else if(subject == null && predicate ==null && object !=null){
			obj++;
			View view = ConnectionManager.getObjView();
			String key = object.toString();
			
			//this is done because of problems with encoding
			JSONArray jar = new JSONArray();
			jar.add(key);
			query.setKey(jar.toString());
			
			ViewResponse result = client.query(view, query);
			Iterator<ViewRow> itr = result.iterator();
			while (itr.hasNext()) {
				ViewRow row = itr.next();
				String val = row.getValue();
				String subj = row.getId();
				Node s = Node
						.createURI(subj);
				Node p = Node
						.createURI(val);
				
				Node o = object;
				Triple tr = new Triple(s, p, o);
				triples.add(tr);
			}
//			by Predicate
		} else if(subject == null && predicate !=null && object ==null){
			pred++;
			View view = ConnectionManager.getPredView();
			query.setKey(predicate.toString());
			
			ViewResponse result = client.query(view, query);
			Iterator<ViewRow> itr = result.iterator();
			while (itr.hasNext()) {
				ViewRow row = itr.next();
				String val = row.getValue();
				String subj = row.getId();
				Node s = Node
						.createURI(subj);
				Node p = predicate;
				Node o = generateObject(val);
				Triple tr = new Triple(s, p, o);
				triples.add(tr);
			}
//			int i = 9;
//			System.out.println();
//			subject predicate object
		} else if (subject != null && predicate != null && object != null) {
			subjPredObj++;
			Object result = client.get(subject.toString());
			JSONArray molecule = null;
			try {
				molecule = (JSONArray) parser.parse(result.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONArray pAr = (JSONArray) molecule.get(0);
			JSONArray oAr = (JSONArray) molecule.get(1);
			for(int i = 0;i<pAr.size();i++){
				String pred = pAr.get(i).toString();
				String obj = oAr.get(i).toString();
				if(predicate.toString().equals(pred) && object.toString().equals(obj)){
					Triple tr = new Triple(subject, predicate, object);
					triples.add(tr);
				}
			}

		}
		
		return WrappedIterator.createNoRemove(triples.iterator()) ;
	}
	public static Node generateObject(String val){
		Node o = null;
		int length = val.length();
		if(val.charAt(0)=='"'){
			char lastLetter = val.charAt(length-1);
			if(lastLetter=='"'){
				o = Node.createLiteral(val.substring(1, length - 1));
			} else {
				int index = val.indexOf("^^");
				if(index > -1){
					String valuePart = val.substring(1, index - 1);
					String type = val.substring(index + 2, length);
					RDFDatatype rd = TypeMapper.getInstance().getTypeByName(type);
					o = Node.createLiteral(valuePart, rd);
				} else {
					int indLang = val.indexOf('@', length -5);
					String valuePart = val.substring(1, indLang - 1);
					String lang = val.substring(indLang + 1);
					o = Node.createLiteral(valuePart, lang, false);
				}
			}
		} else {
				o = Node.createURI(val);
		}
		return o;
	}
	public static String convertObjectToCouch(String obj){
		int quoteInd = obj.indexOf('"');
		String result = null;
		if(quoteInd>-1){
			int roofInd = obj.indexOf("^^");
			if(roofInd>-1){
				String pt1 = obj.substring(0,roofInd+2);
				String pt2 = obj.substring(roofInd+2);
				result = pt1+"<"+pt2+">";
			} else {
				result = obj;
			}
		} else {
			result = "<"+obj+">";
		}
		return result;
	}
}
