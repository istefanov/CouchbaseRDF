package ch.unifr.couchbaseRDF.execution;

import java.util.ArrayList;
import java.util.List;

public class MainQueryExecutor6DBPedia100m {

		
		
		
		static final List<String> queries = new ArrayList<String>();
		static final List<String> qNames = new ArrayList<String>();
		{
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
		
//		----------- Round2 -------------
		
		
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
//		round 3
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		//round 4
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
//		round 5
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

//		round 6
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
//		round 7
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
		//round 8
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
//		round 9
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

		
//		round 10
		
		qNames.add("Q1");
		queries.add("select distinct ?var1 where { <http://dbpedia.org/resource/Akatsi> <http://www.w3.org/2004/02/skos/core#subject> ?var1 .}");
		
		qNames.add("Q2");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/> SELECT DISTINCT ?var WHERE { ?var dbpp:redirect ?var1 . } LIMIT 1000");
		
		qNames.add("Q3");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 ?var8 ?var10 WHERE { ?var5 dbpedia-owl:thumbnail ?var4 .\r\n\r\n                                ?var5 rdf:type dbpedia-owl:Person .\r\n\r\n                                ?var5 rdfs:label \"Maria Carolina van Savoye\"@NL .\r\n\r\n                                ?var5 foaf:page ?var8 .\r\n\r\n                                OPTIONAL { ?var5 foaf:homepage ?var10 .}\r\n.\r\n}");
		
		qNames.add("Q4");
		queries.add("SELECT ?var3 ?var2 WHERE { { <http://dbpedia.org/resource/Craig_Emerson> <http://www.w3.org/2004/02/skos/core#subject> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Paul_Walker> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var3 <http://www.w3.org/2004/02/skos/core#broader> ?var2 .\r\n}\r\n\r\nUNION { <http://dbpedia.org/resource/Maiacetus> <http://www.w3.org/2004/02/skos/core#subject> ?var3 .\r\n?var2 <http://www.w3.org/2004/02/skos/core#broader> ?var3 .\r\n}\r\n}\r\n");
		
		qNames.add("Q5 without filtering");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\n# FILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q5");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nPREFIX dbo: <http://dbpedia.org/ontology/>\r\nSELECT ?var8 ?var6 ?var10 ?var4 WHERE { ?var4 dbpedia2:birthPlace \"Newburgh, New York\"@EN .\r\n?var4 dbo:birthDate ?var6 .\r\n?var4 foaf:name ?var8 .\r\n?var4 dbo:deathDate ?var10 \r\n\r\n# 4store cannot do this filtering, do it if you can\r\nFILTER (?var6 < '1900-01-01'^^xsd:date) .\r\n\r\n}\r\n");
		
		qNames.add("Q6");
		queries.add("PREFIX dbpp: <http://dbpedia.org/property/>\r\nSELECT DISTINCT ?var1 WHERE { { <http://dbpedia.org/resource/Cleaning_Time> dbpp:writer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:creator ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:starring ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:executiveProducer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:guest ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:director ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:producer ?var1 .\r\n}\r\nUNION { <http://dbpedia.org/resource/Cleaning_Time> dbpp:series ?var1 .\r\n}\r\n}\r\n");
		
		qNames.add("Q7");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Bazaar-e-Husn> <http://dbpedia.org/ontology/abstract> ?var1.\r\nFILTER langMatches(lang(?var1), 'en') }");
		
		qNames.add("Q9");
		queries.add("PREFIX dbpo: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nSELECT * WHERE { ?var1 a <http://dbpedia.org/class/yago/PakistaniQawwaliSingers> .\r\n?var1 foaf:givenName ?var2 FILTER regex(?var2, '^A').\r\n}");
		
		qNames.add("Q10");
		queries.add("SELECT ?var1 WHERE { <http://dbpedia.org/resource/Marcelo_Estigarribia> a ?var1 .\r\nOPTIONAL { ?var2 <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?var1 }\r\n.\r\nFILTER (!bound(?var2)) .\r\nFILTER (?var1 != <http://dbpedia.org/ontology/Resource>) .\r\n}");
		
		qNames.add("Q11");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var6 ?var8 ?var10 ?var4 WHERE { ?var4 skos:subject <http://dbpedia.org/resource/Category:McFly> .\r\n?var4 foaf:name ?var6 .\r\nOPTIONAL { ?var4 rdfs:comment ?var8 .\r\nFILTER (LANG(?var8) = 'en') .\r\n}\r\nOPTIONAL { ?var4 rdfs:comment ?var10 .\r\nFILTER (LANG(?var10) = 'de') .\r\n}\r\n}");
		
		qNames.add("Q12");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE { <http://dbpedia.org/resource/Dodgy> ?var0 ?var1.\r\nfilter(?var0 = dbpedia2:redirect) }");
		
		qNames.add("Q13");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbowl: <http://dbpedia.org/ontology/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nSELECT distinct ?var4 ?var6 WHERE { ?var3 dbowl:influenced <http://dbpedia.org/resource/John_Wesley> .\r\n?var3 foaf:page ?var4 .\r\n?var3 rdfs:label ?var6 filter(lang(?var6)='EN') }");
				
		qNames.add("Q14");
		queries.add("PREFIX dbpedia-owl-artist: <http://dbpedia.org/ontology/Artist/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT DISTINCT ?var1 WHERE { <http://dbpedia.org/resource/Randy_Brecker> dbpedia2:instrument ?var1 FILTER ( langMatches(lang(?var1), 'EN') ) }");
		
		qNames.add("Q15");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT * WHERE {{ <http://dbpedia.org/resource/Cabezamesada> rdfs:comment ?var0.\r\nFILTER (lang(?var0) = 'en')}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:depiction ?var1}\r\nUNION {<http://dbpedia.org/resource/Cabezamesada> foaf:homepage ?var2}}");
		
		qNames.add("Q16");
		queries.add("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX dc: <http://purl.org/dc/terms/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX stitch: <http://www4.wiwiss.fu-berlin.de/stitch/resource/stitch/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nSELECT DISTINCT ?var2 ?var4 WHERE { ?var2 rdf:type <http://dbpedia.org/class/yago/EnglishTranslators>  OPTIONAL { ?var2 rdfs:label ?var4 .\r\nFILTER(lang(?var4) = 'en') .\r\n}\r\n}");
		
		qNames.add("Q17");
		queries.add("PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var3 ?var4 ?var5 WHERE { { <http://dbpedia.org/resource/Australia> ?var3 ?var4.\r\nFILTER ( (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#label' && lang(?var4) = 'en') || (STR(?var3) = 'http://dbpedia.org/ontology/abstract' && lang(?var4) = 'en') || (STR(?var3) = 'http://www.w3.org/2000/01/rdf-schema#comment' && lang(?var4) = 'en') || (STR(?var3\r\n) != 'http://dbpedia.org/ontology/abstract' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#comment' && STR(?var3) != 'http://www.w3.org/2000/01/rdf-schema#label') ) }\r\nUNION { ?var5 ?var3 <http://dbpedia.org/resource/Australia> FILTER ( STR(?var3) = 'http://dbpedia.org/ontology/owner' || STR(?var3) = 'http://dbpedia.org/property/redirect' ) }\r\n}");
		
		qNames.add("Q18");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX : <http://dbpedia.org/resource/>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nPREFIX dbpedia2: <http://dbpedia.org/property/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX owl: <http://www.w3.org/2002/07/owl#>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX dbpedia: <http://dbpedia.org/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX skos: <http://www.w3.org/2004/02/skos/core#>\r\nSELECT ?var1 WHERE { <http://dbpedia.org/resource/Ryfylke> rdfs:label ?var1 .}");
		
		qNames.add("Q19");
		queries.add("SELECT * WHERE { ?var0 <http://www.w3.org/2000/01/rdf-schema#label> \"Guillermo Coria\"@DE ;\r\n<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?var1 .\r\n}");
		
		qNames.add("Q20");
		queries.add("PREFIX dc: <http://purl.org/dc/elements/1.1/>\r\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\r\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\nPREFIX space: <http://purl.org/net/schemas/space/>\r\nPREFIX dbpedia-owl: <http://dbpedia.org/ontology/>\r\nPREFIX dbpedia-prop: <http://dbpedia.org/property/>\r\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\nSELECT ?var4 WHERE { ?var2 rdf:type dbpedia-owl:Person .\r\n?var2 rdfs:label \"Ruri Hoshino\"@EN .\r\n?var2 foaf:page ?var4 .\r\n}");

	}
}
