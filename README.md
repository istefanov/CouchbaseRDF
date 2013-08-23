CouchbaseRDF
============

This is an implementation of SPARQL on top of the NoSQL database Couchbase, using the [Jena ARQ library](http://jena.apache.org/documentation/query/). 
It is part of the paper ["NoSQL Databases for RDF: An Empirical Evaluation"](http://ribs.csres.utexas.edu/nosqlrdf/).

To run SPARQL queries with this application, 
first you need to generate and load data into a running [Couchbase](http://www.couchbase.com/) server 
with the help of [CouchbaseRDFLoader](https://github.com/istefanov/CouchbaseRDFLoader). 

After finishing the loading porcess, depending on which dataset you want to query, 
you can use the queries that are defined in the package ch.unifr.couchbaseRDF.execution for each dataset.
The main class for executing the queries is ch.unifr.couchbaseRDF.execution.MainQueryExecutor which uses ch.unifr.couchbaseRDF.QueryThread 
to limit each query's execution time. 

When creating a runable jar from the project, the jar looks for parameters that should be provided in a file called serverInfo.

The result execution times are provided in a directory retrieval 
and a table with the results is provided in a directory called TableResults.

If you have questions you can write to iliya.enchev[at]exascale.info
