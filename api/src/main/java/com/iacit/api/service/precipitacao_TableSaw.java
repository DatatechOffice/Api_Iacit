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
	TableSaw tb = new TableSaw();
	Table t = tb.tableCsv();
	
//	ArrayList<String> dat = tb.listaTempData(t);
	ArrayList<String> cod = tb.listaEstacaoCodigo(t);
	ArrayList<String> pre = tb.listaPrecipitacao(t);
		
	public String[] criaLista(){
	String[] manuel = new String[pre.size()];{

	// array tem o tamanho da lista, ele é modificado dentro do método
	pre.toArray(manuel);
	return manuel;
	}
	}

	public List <String[]> criaLista2(String[] listPrecipitacao){
		
		String[] input = new String[cod.size()];{
		// array tem o tamanho da lista, ele é modificado dentro do método
		pre.toArray(input);
		List <String[]> fabio = new ArrayList();
	for(String c : input) {
		for (String p : listPrecipitacao){
		String[] ex = {c, p};
		fabio.add(ex);
		}
	}
	return fabio;
	}
	}
	
	
	
	public static void main(String[] args) throws IOException{	
	
		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\precipitacao2.csv"));{
		CSVWriter csvWriter = new CSVWriter(writer);
		
		precipitacao_TableSaw precipitacao_Tablesaw = new precipitacao_TableSaw();
		csvWriter.writeAll(precipitacao_Tablesaw.criaLista2(precipitacao_Tablesaw.criaLista()));
		
		csvWriter.flush();
		writer.close();
	}
	}
	
}
	