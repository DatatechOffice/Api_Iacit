package com.iacit.api.service;

import org.apache.spark.sql.SparkSession;

public class Spark {

	SparkSession spark = SparkSession
	  .builder()
	  .appName("Java Spark SQL basic example")
	  .config("spark.some.config.option", "some-value")
	  .getOrCreate();
}
