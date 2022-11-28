package com.iacit.api.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iacit.api.repository.PrecipitacaoRepository;
import com.iacit.api.service.ServicePrecipitacao;
import com.iacit.api.service.ServicePressaoAtmosferica;
import com.iacit.api.service.ServiceRadiacaoGlobal;
import com.iacit.api.service.ServiceTemperatura;
import com.iacit.api.service.ServiceTemperaturaOrvalho;
import com.iacit.api.service.ServiceUmidade;
import com.iacit.api.service.ServiceVento;
import com.iacit.api.service.TableSaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tech.tablesaw.api.Table;

@Controller
public class PersistenciaVariavelController {
	@Autowired
	ServicePressaoAtmosferica atmosfericaService;
	
	@Autowired
	ServiceTemperatura temperaturaService;
	
	@Autowired
	ServicePrecipitacao precipitacaoService;
	
	@Autowired
	ServiceVento ventoService;
	
	@Autowired
	ServiceTemperaturaOrvalho orvalhoService;
	
	@Autowired
	ServiceUmidade umidadeService;
	
	@Autowired
	ServiceRadiacaoGlobal radiacaoService;
	
	TableSaw tb = new TableSaw();
	Table t = tb.tableCsv();
	ArrayList<String> datas = tb.listaData(t);
	ArrayList<String> estacaoCodigo = tb.listaEstacaoCodigo(t);
	
	@GetMapping(value = { "/persistirPrecipitacao" })
	public void persistirPrecipitacao() throws ParseException, IOException { 

		ArrayList<String> valorPrecipitacao = tb.listaPrecipitacao(t);
		precipitacaoService.precipitacaoCopy(datas, estacaoCodigo, valorPrecipitacao);
	}
	
	@GetMapping(value = { "/persistirPressao" })
	public void persistirPressaoAtmosferica() throws ParseException, IOException {

		ArrayList<String> valorMaximoPressao = tb.listaPressaoAtMax(t);
		ArrayList<String> valorMinimoPressao = tb.listaPressaoAtMin(t);
		ArrayList<String> valorPressao = tb.listaPressaoAtNivelEst(t);
		atmosfericaService.pressaoAtmosfericaCopy(datas, estacaoCodigo, valorMaximoPressao, valorMinimoPressao, valorPressao);
	}
	
	@GetMapping(value = { "/persistirRadiacao" })
	public void persistirRadiacao() throws ParseException, IOException {

		ArrayList<String> valorRadiacao = tb.listaRadiacaoGlobal(t);
		radiacaoService.radiacaoCopy(datas, estacaoCodigo, valorRadiacao);
	}
	
	@GetMapping(value = { "/persistirTemperatura" })
	public void persistirTemperatura() throws ParseException, IOException {

		ArrayList<String> valorMaximoTemperatura = tb.listaTempMax(t);
		ArrayList<String> valorMinimoTemperatura = tb.listaTempMin(t);
		ArrayList<String> valorTemperatura = tb.listaBulboSeco(t);
		temperaturaService.temperaturaCopy(datas, estacaoCodigo, valorMaximoTemperatura, valorMinimoTemperatura, valorTemperatura);
	}
	
	@GetMapping(value = { "/persistirOrvalho" })
	public void persistirOrvalho() throws ParseException, IOException {

		ArrayList<String> valorMaximoOrvalho = tb.listaTempOrvalhoMax(t);
		ArrayList<String> valorMinimoOrvalho = tb.listaTempOrvalhoMin(t);
		ArrayList<String> valorOrvalho = tb.listaTempPontoOrvalho(t);
		orvalhoService.temperaturaOrvalhoCopy(datas, estacaoCodigo, valorMaximoOrvalho, valorMinimoOrvalho, valorOrvalho);
	}
	
	@GetMapping(value = { "/persistirUmidade" })
	public void persistirUmidade() throws ParseException, IOException {

		ArrayList<String> valorMaximoUmidade = tb.listaUmiRelativaMax(t);
		ArrayList<String> valorMinimoUmidade = tb.listaUmiRelativaMin(t);
		ArrayList<String> valorUmidade = tb.listaUmiRelativaAr(t);
		umidadeService.umidadeCopy(datas, estacaoCodigo, valorMaximoUmidade, valorMinimoUmidade, valorUmidade);
	}
	
	@GetMapping(value = { "/persistirVento" })
	public void persistirVento() throws ParseException, IOException {

		ArrayList<String> valorMaximoVento = tb.listaVentoRajadaMax(t);
		ArrayList<String> valorMinimoVento = tb.listaVentoVelocidadeHor(t);
		ArrayList<String> valorVento = tb.listaVentoDirecaoHor(t);
		ventoService.ventoCopy(datas, estacaoCodigo, valorMaximoVento, valorMinimoVento, valorVento);
	}
}
