package com.iacit.api.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.common.collect.Range;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.RegiaoRepository;
import com.ibm.icu.text.DateTimePatternGenerator.FormatParser;
import com.univocity.parsers.conversions.DateConversion;

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
	
	public String addChar(String str, String string, int position) {
	    StringBuilder sb = new StringBuilder(str);
	    sb.insert(position, string);
	    return sb.toString();
	}
	
	public Table tableCsv() {
		
		CsvReadOptions.Builder builder = CsvReadOptions
				.builder("C:\\Users\\Jooj\\Desktop\\database.CSV")
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
	
	public ArrayList<String> listaEstacaoNome(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoNomeLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C22");
			estacaoNomeLista.add(est);  
		}	
		return estacaoNomeLista;
	}
	
	public ArrayList<String> listaEstacaoCodigo(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoCodigoLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C23");
			estacaoCodigoLista.add(est);  
		}	
		return estacaoCodigoLista;
	}
	
	public ArrayList<String> listaEstacaoLatitude(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoLatitudeLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C24");
			estacaoLatitudeLista.add(est);  
		}	
		return estacaoLatitudeLista;
	}
	
	public ArrayList<String> listaEstacaoLongitude(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoLongitudeLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C25");
			estacaoLongitudeLista.add(est);  
		}	
		return estacaoLongitudeLista;
	}
	
	public ArrayList<String> listaEstacaoAltitude(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoAltitudeLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C26");
			estacaoAltitudeLista.add(est);  
		}	
		return estacaoAltitudeLista;
	}
	
	public ArrayList<String> listaEstacaoDataFund(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> estacaoDataFundLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = tabelaCSV.getString(ii, "C27");
			estacaoDataFundLista.add(est);  
		}	
		return estacaoDataFundLista;
	}
	
	public ArrayList<String> listaTempData(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempDataLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			String hora = (tabelaCSV.getString(ii, "C2")).replace(" UTC", "");
			 TableSaw tb = new TableSaw();
			 String horat = tb.addChar(hora, ":", 2);
			est = tabelaCSV.getString(ii, "C1")+" "+ horat;
			tempDataLista.add(est);  
		}	
		return tempDataLista;
	}
	
	public ArrayList<String> listaBulboSeco(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> bulboSecoLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C8")).replace(",", ".");
			bulboSecoLista.add(est);  
		}	
		return bulboSecoLista;
	}
	
	public ArrayList<String> listaTempMax(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempMaxLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C10")).replace(",", ".");
			tempMaxLista.add(est);  
		}	
		return tempMaxLista;
	}
	
	public ArrayList<String> listaTempMin(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempMinLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C11")).replace(",", ".");
			tempMinLista.add(est);  
		}	
		return tempMinLista;
	}
}
