package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.common.collect.Range;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;

import org.apache.commons.math3.analysis.function.Add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.filtering.predicates.*;
import tech.tablesaw.io.csv.CsvReadOptions;

@Service
public class TableSaw {
	
	public ArrayList<String> insereRegiaoBanco() {
		
		ArrayList<String> regis = new ArrayList();
		
		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\admin\\Desktop\\Api_Iacit-PersistenciaSpark\\Api_Iacit\\database.CSV")
				.separator(';') // table is tab-delimited
				.header(false) // no header
				.dateFormat("yyyy.MM.dd"); // the date format to use.

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
		//System.out.println(t1);

		Table t2 = t1.selectColumns("C20");
		//System.out.println(t2);
		
		
		Regiao regiaoCO = new Regiao();
		
		regiaoCO.setRegSigla(t2.getString(1, "C20"));
		
		
		int i = 0;
		i = t2.rowCount();
		//System.out.println(i);
		for (int ii = 0; ii < i; ii++) {
			String x;
			
			x = t2.getString(ii, "C20");
			regis.add(x);
		}
		
		
		
		

		
		
		

		//		ColumnType[] types = {};
//		Table t = Table.read().usingOptions(CsvReadOptions
//		    .builder("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database - Copia.csv")
//		    .columnTypes(types));
		return regis;
	}
}
