package ch.unifr.couchbaseRDF.execution;

import java.util.ArrayList;
import java.util.List;

public class MainQueryExecutor5Berlin1000m {

		
		
		static final List<String> queries = new ArrayList<String>();
		static final List<String> qNames = new ArrayList<String>();
		
		{
		qNames.add("Q1");
		queries.add("PREFIX bsbm-inst: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n\nSELECT DISTINCT ?product ?label\nWHERE { \n    ?product rdfs:label ?label .\n    ?product a <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductType2241> .\n    ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature5964> . \n    ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature53211> . \n    ?product bsbm:productPropertyNumeric1 ?value1 . \n\tFILTER (?value1 > 126) \n\t}\nORDER BY ?label\nLIMIT 10");
		
		qNames.add("Q2");
		queries.add("PREFIX bsbm-inst: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\n\nSELECT ?label ?comment ?producer ?productFeature ?propertyTextual1 ?propertyTextual2 ?propertyTextual3\n ?propertyNumeric1 ?propertyNumeric2 ?propertyTextual4 ?propertyTextual5 ?propertyNumeric4 \nWHERE {\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> rdfs:label ?label .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> rdfs:comment ?comment .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:producer ?p .\n    ?p rdfs:label ?producer .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> dc:publisher ?p . \n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productFeature ?f .\n    ?f rdfs:label ?productFeature .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyTextual1 ?propertyTextual1 .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyTextual2 ?propertyTextual2 .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyTextual3 ?propertyTextual3 .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyNumeric1 ?propertyNumeric1 .\n    <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyNumeric2 ?propertyNumeric2 .\n    OPTIONAL { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyTextual4 ?propertyTextual4 }\n    OPTIONAL { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyTextual5 ?propertyTextual5 }\n    OPTIONAL { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer50363/Product2550522> bsbm:productPropertyNumeric4 ?propertyNumeric4 }\n}");
		
		qNames.add("Q3");
		queries.add("PREFIX bsbm-inst: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n\nSELECT ?product ?label\nWHERE {\n    ?product rdfs:label ?label .\n    ?product a <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductType6066> .\n\t?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature1579> .\n\t?product bsbm:productPropertyNumeric1 ?p1 .\n\tFILTER ( ?p1 > 114 ) \n\t?product bsbm:productPropertyNumeric3 ?p3 .\n\tFILTER (?p3 < 481 )\n    OPTIONAL { \n        ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature1573> .\n        ?product rdfs:label ?testVar }\n    FILTER (!bound(?testVar)) \n}\nORDER BY ?label\nLIMIT 10");
		
		qNames.add("Q4");
		queries.add("PREFIX bsbm-inst: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n\nSELECT DISTINCT ?product ?label ?propertyTextual\nWHERE {\n    { \n       ?product rdfs:label ?label .\n       ?product rdf:type <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductType5627> .\n       ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature16166> .\n\t   ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature1461> .\n       ?product bsbm:productPropertyTextual1 ?propertyTextual .\n\t   ?product bsbm:productPropertyNumeric1 ?p1 .\n\t   FILTER ( ?p1 > 94 )\n    } UNION {\n       ?product rdfs:label ?label .\n       ?product rdf:type <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductType5627> .\n       ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature16166> .\n\t   ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature16162> .\n       ?product bsbm:productPropertyTextual1 ?propertyTextual .\n\t   ?product bsbm:productPropertyNumeric2 ?p2 .\n\t   FILTER ( ?p2> 320 ) \n    } \n}\nORDER BY ?label\nOFFSET 5\nLIMIT 10");
				
		qNames.add("Q5");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\n\nSELECT DISTINCT ?product ?productLabel\nWHERE { \n\t<http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer37808/Product1913343> bsbm:productFeature ?prodFeature .\n\t?product bsbm:productFeature ?prodFeature .\n\t<http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer37808/Product1913343> bsbm:productPropertyNumeric1 ?origProperty1 .\n\t?product bsbm:productPropertyNumeric1 ?simProperty1 .\n\tFILTER (?simProperty1 < (?origProperty1 + 120) && ?simProperty1 > (?origProperty1 - 120))\n\t<http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer37808/Product1913343> bsbm:productPropertyNumeric2 ?origProperty2 .\n\t?product bsbm:productPropertyNumeric2 ?simProperty2 .\n\tFILTER (?simProperty2 < (?origProperty2 + 170) && ?simProperty2 > (?origProperty2 - 170))\n\t?product rdfs:label ?productLabel .\n    FILTER (<http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer37808/Product1913343> != ?product)\n}\nORDER BY ?productLabel\nLIMIT 5");
				
//		qNames.add("Q5edit");
//		queries.add("");
				
		qNames.add("Q7");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rev: <http://purl.org/stuff/rev#>\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\n\nSELECT ?productLabel ?offer ?price ?vendor ?vendorTitle ?review ?revTitle \n       ?reviewer ?revName ?rating1 ?rating2\nWHERE { \n\t<http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer29369/Product1488891> rdfs:label ?productLabel .\n    OPTIONAL {\n        ?offer bsbm:product <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer29369/Product1488891> .\n\t\t?offer bsbm:price ?price .\n\t\t?offer bsbm:vendor ?vendor .\n\t\t?vendor rdfs:label ?vendorTitle .\n        ?vendor bsbm:country <http://downlode.org/rdf/iso-3166/countries#DE> .\n        ?offer dc:publisher ?vendor . \n        ?offer bsbm:validTo ?date .\n        FILTER (?date > \"2008-06-20T00:00:00\"^^<http://www.w3.org/2001/XMLSchema#dateTime> )\n    }\n    OPTIONAL {\n\t?review bsbm:reviewFor <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer29369/Product1488891> .\n\t?review rev:reviewer ?reviewer .\n\t?reviewer foaf:name ?revName .\n\t?review dc:title ?revTitle .\n    OPTIONAL { ?review bsbm:rating1 ?rating1 . }\n    OPTIONAL { ?review bsbm:rating2 ?rating2 . } \n    }\n}");
				
		qNames.add("Q8");
		queries.add("PREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\nPREFIX rev: <http://purl.org/stuff/rev#>\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\n\nSELECT ?title ?text ?reviewDate ?reviewer ?reviewerName ?rating1 ?rating2 ?rating3 ?rating4 \nWHERE { \n\t?review bsbm:reviewFor <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer22261/Product1124404> .\n\t?review dc:title ?title .\n\t?review rev:text ?text .\n\tFILTER langMatches( lang(?text), \"EN\" ) \n\t?review bsbm:reviewDate ?reviewDate .\n\t?review rev:reviewer ?reviewer .\n\t?reviewer foaf:name ?reviewerName .\n\tOPTIONAL { ?review bsbm:rating1 ?rating1 . }\n\tOPTIONAL { ?review bsbm:rating2 ?rating2 . }\n\tOPTIONAL { ?review bsbm:rating3 ?rating3 . }\n\tOPTIONAL { ?review bsbm:rating4 ?rating4 . }\n}\nORDER BY DESC(?reviewDate)\nLIMIT 20");
				
		qNames.add("Q9");
		queries.add("PREFIX rev: <http://purl.org/stuff/rev#>\n\nDESCRIBE ?x\nWHERE { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromRatingSite309/Review3020018> rev:reviewer ?x }\n");
				
		qNames.add("Q10");
		queries.add("PREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \nPREFIX dc: <http://purl.org/dc/elements/1.1/>\n\nSELECT DISTINCT ?offer ?price\nWHERE {\n\t?offer bsbm:product <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromProducer17234/Product871221> .\n\t?offer bsbm:vendor ?vendor .\n    ?offer dc:publisher ?vendor .\n\t?vendor bsbm:country <http://downlode.org/rdf/iso-3166/countries#US> .\n\t?offer bsbm:deliveryDays ?deliveryDays .\n\tFILTER (?deliveryDays <= 3)\n\t?offer bsbm:price ?price .\n    ?offer bsbm:validTo ?date .\n    FILTER (?date > \"2008-06-20T00:00:00\"^^<http://www.w3.org/2001/XMLSchema#dateTime> )\n}\nORDER BY xsd:double(str(?price))\nLIMIT 10");
				
		qNames.add("Q11");
		queries.add("SELECT ?property ?hasValue ?isValueOf\nWHERE {\n  { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor20554/Offer41149204> ?property ?hasValue }\n  UNION\n  { ?isValueOf ?property <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor20554/Offer41149204> }\n}");
				
		qNames.add("Q12");
		queries.add("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rev: <http://purl.org/stuff/rev#>\nPREFIX foaf: <http://xmlns.com/foaf/0.1/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX bsbm-export: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/export/>\nPREFIX dc: <http://purl.org/dc/elements/1.1/>\n\nCONSTRUCT {  <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:product ?productURI .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:productlabel ?productlabel .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:vendor ?vendorname .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:vendorhomepage ?vendorhomepage . \n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:offerURL ?offerURL .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:price ?price .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:deliveryDays ?deliveryDays .\n             <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm-export:validuntil ?validTo } \nWHERE { <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:product ?productURI .\n        ?productURI rdfs:label ?productlabel .\n        <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:vendor ?vendorURI .\n        ?vendorURI rdfs:label ?vendorname .\n        ?vendorURI foaf:homepage ?vendorhomepage .\n        <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:offerWebpage ?offerURL .\n        <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:price ?price .\n        <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:deliveryDays ?deliveryDays .\n        <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromVendor8757/Offer17368343> bsbm:validTo ?validTo }");
		
//		-------------
		
		qNames.add("Q1b");
		queries.add("PREFIX bsbm-inst: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/>\nPREFIX bsbm: <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/>\nPREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\nPREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n\nSELECT DISTINCT ?product ?label\nWHERE { \n    ?product rdfs:label ?label .\n    ?product a <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductType2939> .\n    ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature70191> . \n    ?product bsbm:productFeature <http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/ProductFeature57> . \n    ?product bsbm:productPropertyNumeric1 ?value1 . \n\tFILTER (?value1 > 275) \n\t}\nORDER BY ?label\nLIMIT 10");
		
		qNames.add("Q2b");
		queries.add("");
		
		qNames.add("Q3b");
		queries.add("");
		
		qNames.add("Q4b");
		queries.add("");
				
		qNames.add("Q5b");
		queries.add("");
				
		qNames.add("Q5bedit");
		queries.add("");
				
		qNames.add("Q7b");
		queries.add("");
				
		qNames.add("Q8b");
		queries.add("");
				
		qNames.add("Q9b");
		queries.add("");
				
		qNames.add("Q10b");
		queries.add("");
				
		qNames.add("Q11b");
		queries.add("");
				
		qNames.add("Q12b");
		queries.add("");
		
//		--------------
		
		qNames.add("Q1c");
		queries.add("");
		
		qNames.add("Q2c");
		queries.add("");
		
		qNames.add("Q3c");
		queries.add("");
		
		qNames.add("Q4c");
		queries.add("");
				
		qNames.add("Q5c");
		queries.add("");
				
		qNames.add("Q5cedit");
		queries.add("");
				
		qNames.add("Q7c");
		queries.add("");
				
		qNames.add("Q8c");
		queries.add("");
				
		qNames.add("Q9c");
		queries.add("");
				
		qNames.add("Q10c");
		queries.add("");
				
		qNames.add("Q11c");
		queries.add("");
				
		qNames.add("Q12c");
		queries.add("");
		
//		------------
		
		qNames.add("Q1d");
		queries.add("");
		
		qNames.add("Q2d");
		queries.add("");
		
		qNames.add("Q3d");
		queries.add("");
		
		qNames.add("Q4d");
		queries.add("");
				
		qNames.add("Q5d");
		queries.add("");
				
		qNames.add("Q5dedit");
		queries.add("");
				
		qNames.add("Q7d");
		queries.add("");
				
		qNames.add("Q8d");
		queries.add("");
				
		qNames.add("Q9d");
		queries.add("");
				
		qNames.add("Q10d");
		queries.add("");
				
		qNames.add("Q11d");
		queries.add("");
				
		qNames.add("Q12d");
		queries.add("");
		
//		--------------
		
		
		qNames.add("Q1e");
		queries.add("");
		
		qNames.add("Q2e");
		queries.add("");
		
		qNames.add("Q3e");
		queries.add("");
		
		qNames.add("Q4e");
		queries.add("");
				
		qNames.add("Q5e");
		queries.add("");
				
		qNames.add("Q5eedit");
		queries.add("");
				
		qNames.add("Q7e");
		queries.add("");
				
		qNames.add("Q8e");
		queries.add("");
				
		qNames.add("Q9e");
		queries.add("");
				
		qNames.add("Q10e");
		queries.add("");
				
		qNames.add("Q11e");
		queries.add("");
				
		qNames.add("Q12e");
		queries.add("");
		
	}
		
}
