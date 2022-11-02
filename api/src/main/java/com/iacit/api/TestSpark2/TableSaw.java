package com.iacit.api.TestSpark2;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;
import tech.tablesaw.filtering.predicates.*;
import tech.tablesaw.io.csv.CsvReadOptions;

public class TableSaw {
	public static void main(String[] args) {
		
	
	CsvReadOptions.Builder builder = 
			CsvReadOptions.builder("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database - Copia.csv")
				.separator(';')										// table is tab-delimited
				.header(false)											// no header
				.dateFormat("yyyy.MM.dd");  				// the date format to use. 

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
//		System.out.println(t1);
		
		Table t2 = t1.selectColumns("C20");
		System.out.println(t2);
		
		
		
//		ColumnType[] types = {};
//		Table t = Table.read().usingOptions(CsvReadOptions
//		    .builder("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database - Copia.csv")
//		    .columnTypes(types));
	}
}
