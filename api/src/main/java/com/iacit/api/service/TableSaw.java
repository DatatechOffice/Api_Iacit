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
	
	public Table tableCsv() {
		
		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\admin\\Desktop\\Api_Iacit-PersistenciaSpark\\Api_Iacit\\database.CSV")
				.separator(';') // table is tab-delimited
				.header(false) // no header
				.dateFormat("yyyy.MM.dd"); // the date format to use.

		CsvReadOptions options = builder.build();

		//tabela csv é a tabela que contém todos os dados 
		Table tabelaCSV = Table.read().usingOptions(options);
		
		return tabelaCSV;
	}
	
	public ArrayList<String> listaRegiao(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> regiaoLista = new ArrayList();
		//System.out.println(i);
		for (int ii = 0; ii < i; ii++) {
			String reg;
			reg = tabelaCSV.getString(ii, "C20");//C20 é a coluna para Região no arquivo csv
			regiaoLista.add(reg); 
		}
		return regiaoLista;
	}
	
	public ArrayList<String> listaEstado(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estadoLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String etd;
			etd = tabelaCSV.getString(ii, "C21");
			estadoLista.add(etd);  
		}	
		return estadoLista;
	}
}
