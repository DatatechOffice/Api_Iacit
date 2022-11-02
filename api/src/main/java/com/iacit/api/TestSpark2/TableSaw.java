package com.iacit.api.TestSpark2;

import java.util.ArrayList;

import com.iacit.api.entity.Regiao;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;
import tech.tablesaw.filtering.predicates.*;
import tech.tablesaw.io.csv.CsvReadOptions;

public class TableSaw {
	public static void main(String args[]) {

		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\Jooj\\Desktop\\MainIacit\\Api_Iacit\\ApiIacit\\database.CSV")
				.separator(';') // table is tab-delimited
				.header(false) // no header
				.dateFormat("yyyy.MM.dd"); // the date format to use.

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
		System.out.println(t1);

		Table t2 = t1.selectColumns("C20");
		//System.out.println(t2);
		
		Regiao regiaoCO = new Regiao();
		Regiao regiaoNRD = new Regiao();
		Regiao regiaoNRT = new Regiao();
		Regiao regiaoSUL = new Regiao();
		Regiao regiaoSUD = new Regiao();
		
		regiaoCO.setRegSigla(t2.getString(1, "C20"));
		regiaoSUL.setRegSigla(t2.getString(5000000, "C20"));
		ArrayList<Regiao> regioes = new ArrayList<Regiao>();
		
		System.out.println(regiaoCO.getRegSigla()+"\n"+regiaoSUL.getRegSigla());
//		ColumnType[] types = {};
//		Table t = Table.read().usingOptions(CsvReadOptions
//		    .builder("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database - Copia.csv")
//		    .columnTypes(types));
	}
}
