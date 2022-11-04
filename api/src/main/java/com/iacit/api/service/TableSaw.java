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
	
	public Table insereRegiaoBanco() {
		
		ArrayList<String> tabela = new ArrayList();
		
		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\admin\\Desktop\\Api_Iacit-PersistenciaSpark\\Api_Iacit\\database.CSV")
				.separator(';') // table is tab-delimited
				.header(false) // no header
				.dateFormat("yyyy.MM.dd"); // the date format to use.

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
		
		return t1;
	}
	
	public ArrayList<String> listaRegiao(Table t1) {
		int i = 0;
		i = t1.rowCount();
		ArrayList<String> tabela = new ArrayList();
		//System.out.println(i);
		for (int ii = 0; ii < i; ii++) {
			String reg;
			reg = t1.getString(ii, "C20");
			tabela.add(reg); 
		}
		return tabela;
	}
	
	public ArrayList<String> listaEstadoRegiao(Table t1) {
		int i = 0;
		i = t1.rowCount();
		ArrayList<String> tabela = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			
			String reg;
			reg = t1.getString(ii, "C20");
			tabela.add(reg);
			
			String etd;
			etd = t1.getString(ii, "C21");
			tabela.add(etd);  
		}	
		return tabela;
	}
}
