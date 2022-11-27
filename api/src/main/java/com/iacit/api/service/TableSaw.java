package com.iacit.api.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import tech.tablesaw.api.Table;
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
		.builder("C:\\bd\\database.CSV")
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

	public ArrayList<String> listaEstacaoDataFund(Table tabelaCSV) throws ParseException {
		int i = 0;
		i = tabelaCSV.rowCount();
		DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> estacaoDataFundLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			TableSaw tb = new TableSaw();
			String est;
			est = tabelaCSV.getString(ii, "C27");
			if(est.contains("/")) {
				
				String estdata = (est.replace("/", "-"));
				String data2 = tb.addChar(estdata, "20", 6);
				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(data2);  	
				String dataConvertida = formatUS.format(date1);
				estacaoDataFundLista.add(dataConvertida);
				
			}else {
				estacaoDataFundLista.add(est);
			}
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
			String estdata = est.replace("/", "-");
			tempDataLista.add(estdata);  
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

	public ArrayList<String> listaPrecipitacao(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> precipitacaoLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C3")).replace(",", ".");
			precipitacaoLista.add(est);  
		}	
		return precipitacaoLista;
	}

	public ArrayList<String> listaPressaoAtNivelEst(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> pressaoAtNivelEstLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C4")).replace(",", ".");
			pressaoAtNivelEstLista.add(est);  
		}	
		return pressaoAtNivelEstLista;
	}

	public ArrayList<String> listaPressaoAtMax(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> pressaoAtMaxLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C5")).replace(",", ".");
			pressaoAtMaxLista.add(est);  
		}	
		return pressaoAtMaxLista;
	}

	public ArrayList<String> listaPressaoAtMin(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> pressaoAtMinLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C6")).replace(",", ".");
			pressaoAtMinLista.add(est);  
		}	
		return pressaoAtMinLista;
	}

	public ArrayList<String> listaRadiacaoGlobal(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> radiacaoGlobalLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C7")).replace(",", ".");
			radiacaoGlobalLista.add(est);  
		}	
		return radiacaoGlobalLista;
	}

	public ArrayList<String> listaTempPontoOrvalho(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempPontoOrvalhoLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C9")).replace(",", ".");
			tempPontoOrvalhoLista.add(est);  
		}	
		return tempPontoOrvalhoLista;
	}

	public ArrayList<String> listaTempOrvalhoMax(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempOrvalhoMaxLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C12")).replace(",", ".");
			tempOrvalhoMaxLista.add(est);  
		}	
		return tempOrvalhoMaxLista;
	}

	public ArrayList<String> listaTempOrvalhoMin(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> tempOrvalhoMinLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C13")).replace(",", ".");
			tempOrvalhoMinLista.add(est);  
		}	
		return tempOrvalhoMinLista;
	}

	public ArrayList<String> listaUmiRelativaMax(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> umiRelativaMaxLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C14")).replace(",", ".");
			umiRelativaMaxLista.add(est);  
		}	
		return umiRelativaMaxLista;
	}

	public ArrayList<String> listaUmiRelativaMin(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> umiRelativaMinLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C15")).replace(",", ".");
			umiRelativaMinLista.add(est);  
		}	
		return umiRelativaMinLista;
	}

	public ArrayList<String> listaUmiRelativaAr(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> umiRelativaArLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C16")).replace(",", ".");
			umiRelativaArLista.add(est);  
		}	
		return umiRelativaArLista;
	}

	public ArrayList<String> listaVentoDirecaoHor(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> ventoDirecaoHorLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C17")).replace(",", ".");
			ventoDirecaoHorLista.add(est);  
		}	
		return ventoDirecaoHorLista;
	}
	
	public ArrayList<String> listaVentoRajadaMax(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> ventoRajadaMaxLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C18")).replace(",", ".");
			ventoRajadaMaxLista.add(est);  
		}	
		return ventoRajadaMaxLista;
	}

	public ArrayList<String> listaVentoVelocidadeHor(Table tabelaCSV) {
		int i = 0;
		i = tabelaCSV.rowCount();
		ArrayList<String> ventoVelocidadeHorLista = new ArrayList();
		for (int ii = 0; ii < i; ii++) {
			String est;
			est = (tabelaCSV.getString(ii, "C19")).replace(",", ".");
			ventoVelocidadeHorLista.add(est);  
		}	
		return ventoVelocidadeHorLista;
	}
}
