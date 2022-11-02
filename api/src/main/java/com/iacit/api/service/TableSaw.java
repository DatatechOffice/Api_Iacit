package com.iacit.api.service;

import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;
import tech.tablesaw.filtering.predicates.*;
import tech.tablesaw.io.csv.CsvReadOptions;

@Service
public class TableSaw {
	
	public Regiao insereRegiaoBanco() {

		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\Jooj\\Desktop\\MainIacit\\Api_Iacit\\ApiIacit\\database.CSV")
				.separator(';') // table is tab-delimited
				.header(false) // no header
				.dateFormat("yyyy.MM.dd"); // the date format to use.

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
		//System.out.println(t1);

		Table t2 = t1.selectColumns("C20");
		//System.out.println(t2);
		
		Regiao regiaoCO = new Regiao();
		Regiao regiaoNRD = new Regiao();
		Regiao regiaoNRT = new Regiao();
		Regiao regiaoSUL = new Regiao();
		Regiao regiaoSUD = new Regiao();
		
		regiaoCO.setRegSigla(t2.getString(1, "C20"));
		regiaoSUL.setRegSigla(t2.getString(5000000, "C20"));
		

		
		
		
//		ColumnType[] types = {};
//		Table t = Table.read().usingOptions(CsvReadOptions
//		    .builder("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database - Copia.csv")
//		    .columnTypes(types));
		return regiaoCO;
	}
}
