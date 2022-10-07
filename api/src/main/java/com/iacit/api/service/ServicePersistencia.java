
package com.iacit.api.service;

import org.apache.spark.SparkFiles;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.iacit.api.entity.Temperatura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ServicePersistencia{
	private Temperatura t1;
	
	/*
	// A CSV dataset is pointed to by path.
	// The path can be either a single CSV file or a directory of CSV files
	String path = "C:/Users/Jooj/Desktop/IacitSprint2/Api_Iacit-ClasseServiceEndpointPost/ApiDtTchIacit/BRASILIA2020.csv";
	
	// Read a csv with delimiter, the default delimiter is ","
	Dataset<Row> df = Spark.read().csv(path);
	df.show();
	
	// Read a csv with delimiter and a header
	Dataset<Row> df2 = spark.read().option("delimiter", ";").csv(path);
	df2.show();
	
	// You can also use options() to use multiple options
	Dataset<Row> df3 = spark.read().option("delimiter", ";").option("header", "true").csv(path);
	df3.show();
	
	// "output" is a folder which contains multiple csv files and a _SUCCESS file.
	java.util.Map<String, String> optionsMap = new java.util.HashMap<String, String>();
	optionsMap.put("delimiter",";");
	optionsMap.put("header","true");
	Dataset<Row> df4 = spark.read().options(optionsMap).csv(path);
	
	// Read all files in a folder, please make sure only CSV files should present in the folder.
	df3.write().csv("output");
	
	
	// Wrong schema because non-CSV files are read
	String folderPath = "examples/src/main/resources";
	Dataset<Row> df5 = spark.read().csv(folderPath);
	df5.show();
	 */
}
