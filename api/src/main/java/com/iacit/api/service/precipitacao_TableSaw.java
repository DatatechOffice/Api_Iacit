package com.iacit.api.service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.PositionToBeanField;

import tech.tablesaw.api.Table;

public class precipitacao_TableSaw {
	TableSaw tb = new TableSaw();
	Table t = tb.tableCsv();
	
//	ArrayList<String> dat = tb.listaTempData(t);
	ArrayList<String> cod = tb.listaEstacaoCodigo(t);
	ArrayList<String> pre = tb.listaPrecipitacao(t);
		
	public List <String[]> criaLista(){
	String[] input = new String[pre.size()];{

	// array tem o tamanho da lista, ele é modificado dentro do método
	pre.toArray(input);

	List <String[]> listPrecipitacao = new ArrayList<String[]>();
	for (String p : input) {
		String[] manuel = {p};
		listPrecipitacao.add(manuel);
		}
	return listPrecipitacao;
	}
	}
	
	public List <String[]> criaLista2(){
		String[] input = new String[cod.size()];{
		// array tem o tamanho da lista, ele é modificado dentro do método
		pre.toArray(input);
	List<String[]> listCodigo = new ArrayList<String[]>();
	for(String c : input) {
		String[] ex = {c};
		listCodigo.add(ex);
	}
	return listCodigo;
	}
	}
	
	
	
	public static void main(String[] args) throws IOException{	
	
		Writer writer = Files.newBufferedWriter(Paths.get("C:\\DataFrame\\precipitacao2.csv"));{
		CSVWriter csvWriter = new CSVWriter(writer);
		
		precipitacao_TableSaw precipitacao_Tablesaw = new precipitacao_TableSaw();
		csvWriter.writeAll(precipitacao_Tablesaw.criaLista());
		
		csvWriter.writeAll(precipitacao_Tablesaw.criaLista2());	
		
		csvWriter.flush();
		writer.close();
	}
	}
}
	