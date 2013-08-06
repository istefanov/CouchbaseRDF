package ch.unifr.couchbaseRDF.assembler;

//import nl.vu.jena.sparql.engine.main.HBaseStageGenerator;
//import nl.vu.jena.sparql.engine.optimizer.HBaseOptimize;
//import nl.vu.jena.sparql.engine.optimizer.HBaseTransformFilterPlacement;

import ch.unifr.couchbaseRDF.CouchbaseStageGenerator;

import com.hp.hpl.jena.query.ARQ;
//import com.hp.hpl.jena.sparql.ARQConstants;
import com.hp.hpl.jena.sparql.engine.main.StageBuilder;

public class CouchbaseRewriter {
static {
	CouchbaseStageGenerator couchbaseStageGenerator = new CouchbaseStageGenerator();
	StageBuilder.setGenerator(ARQ.getContext(), couchbaseStageGenerator) ;
	
//	ARQ.getContext().set(ARQConstants.sysOptimizerFactory, HBaseOptimize.hbaseOptimizationFactory);
//	ARQ.getContext().set(ARQ.optFilterPlacement, new HBaseTransformFilterPlacement());
}
}
