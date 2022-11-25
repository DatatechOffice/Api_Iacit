package com.iacit.api.service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import tech.tablesaw.api.Table;

public class precipitacao_TableSaw {
	public List <String[]> criaLista(){TableSaw tb = new TableSaw();
	Table t = tb.tableCsv();

	ArrayList<String> reg = tb.listaPrecipitacao(t);
	
	
	String[] input = new String[reg.size()];

	// array tem o tamanho da lista, ele é modificado dentro do método
	reg.toArray(input);
	List <String[]> jorge = new ArrayList<String[]>();
	for (String s : input) {
		String[] manuel = {s};
		jorge.add(manuel);
		}
	return jorge;
	}
	public static void main(String[] args) throws IOException{
		
//		    System.out.println(s); // imprime os 3 nomes
		
	
		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\precipitacao2.csv"));
		CSVWriter csvWriter = new CSVWriter(writer);
		
		precipitacao_TableSaw precipitacao_Tablesaw = new precipitacao_TableSaw();
		csvWriter.writeAll(precipitacao_Tablesaw.criaLista());
		
		csvWriter.flush();
		writer.close();
		
	}
}
	