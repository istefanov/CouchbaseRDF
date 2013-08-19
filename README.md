CouchbaseRDF
============

This is an implementation of SPARQL on top of the NoSQL database Couchbase. 
It is part of the paper "NoSQL Databases for RDF: An Empirical Evaluation".

To run SPARQL queries with this application, 
first you need to generate and load data into a running [Couchbase](http://www.couchbase.com/) server 
with the help of [CouchbaseRDFLoader](https://github.com/istefanov/CouchbaseRDFLoader). 

After finishing the loading porcess, depending on which dataset you want to query, you can use the queries that are defined
