package com.iacit.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.service.ServiceEstacao;
import com.iacit.api.service.ServiceEstado;
import com.iacit.api.service.ServicePrecipitacao;
import com.iacit.api.service.ServicePressaoAtmosferica;
import com.iacit.api.service.ServiceRadiacaoGlobal;
import com.iacit.api.service.ServiceRegiao;
import com.iacit.api.service.ServiceTemperatura;
import com.iacit.api.service.ServiceTemperaturaOrvalho;
import com.iacit.api.service.ServiceUmidade;
import com.iacit.api.service.ServiceVento;
import com.iacit.api.service.TableSaw;

import tech.tablesaw.api.Table;

@Controller
@RestController
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired(required = true)
	private ServiceRegiao serviceRegiao;

	@Autowired(required = true)
	private ServiceEstado serviceEstado;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	@Autowired(required = true)
	private ServiceTemperatura serviceTemperatura;
	
	@Autowired(required = true)
	private ServicePrecipitacao servicePrecipitacao;
	
	@Autowired(required = true)
	private ServicePressaoAtmosferica servicePressaoAtmosferica;
	
	@Autowired(required = true)
	private ServiceRadiacaoGlobal serviceRadicaoGlobal;
	
	@Autowired(required = true)
	private ServiceTemperaturaOrvalho serviceTemperaturaOrvalho;
	
	@Autowired(required = true)
	private ServiceUmidade serviceUmidade;
	
	@Autowired(required = true)
	private ServiceVento serviceVento;

	// Método para inicialização de página
	@GetMapping(value = { "index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		return modelAndView;
	}
	
	@GetMapping(value = { "persistir" })
	public void persistir() {

		TableSaw tb = new TableSaw();
		Table t = tb.tableCsv();
		
		ArrayList<String> reg = tb.listaRegiao(t);
		serviceRegiao.insBancoService(reg);
		 
		ArrayList<String> etd = tb.listaEstado(t);
		serviceEstado.insBancoService(reg, etd);

		ArrayList<String> regEstN = tb.listaEstacaoNome(t);
		ArrayList<String> regEstLO = tb.listaEstacaoLongitude(t);
		ArrayList<String> regEstLA = tb.listaEstacaoLatitude(t);
		ArrayList<String> regEstAL = tb.listaEstacaoAltitude(t);
		ArrayList<String> regEstD = tb.listaEstacaoDataFund(t);
		ArrayList<String> regEstC = tb.listaEstacaoCodigo(t);
		
		serviceEstacao.insBancoService(regEstN, regEstC, regEstLA, regEstLO, regEstAL, regEstD, etd);

		
	}
	
	@GetMapping(value = { "persistirVariavel" })
	public void persistirVariavel() {
		TableSaw tb = new TableSaw();
		Table t = tb.tableCsv();
		
		ArrayList<String> regEstC = tb.listaEstacaoCodigo(t);
		
		ArrayList<String> estTdata = tb.listaTempData(t);
		
		ArrayList<String> estTbulbo = tb.listaBulboSeco(t);
		ArrayList<String> estTmax = tb.listaTempMax(t);
		ArrayList<String> estTmin = tb.listaTempMin(t);
		serviceTemperatura.insBancoService(regEstC, estTdata, estTbulbo, estTmax, estTmin);
		
		ArrayList<String> estPrecipitacao = tb.listaPrecipitacao(t);
		servicePrecipitacao.insBancoService(regEstC, estTdata, estPrecipitacao);
		
		ArrayList<String> estPrAtMax = tb.listaPressaoAtMax(t);
		ArrayList<String> estPrAtMin = tb.listaPressaoAtMin(t);
		ArrayList<String> estPrAtNivelEst = tb.listaPressaoAtNivelEst(t);
		servicePressaoAtmosferica.insBancoService(regEstC, estTdata, estPrAtMax, estPrAtMin, estPrAtNivelEst);
		
		ArrayList<String> estRadiacaoGlobal = tb.listaRadiacaoGlobal(t);
		serviceRadicaoGlobal.insBancoService(regEstC, estTdata, estRadiacaoGlobal);
		
		ArrayList<String> estToPontoOrvalho = tb.listaTempPontoOrvalho(t);
		ArrayList<String> estToOrvalhoMax = tb.listaTempOrvalhoMax(t);
		ArrayList<String> estToOrvalhoMin = tb.listaTempOrvalhoMin(t);
		serviceTemperaturaOrvalho.insBancoService(regEstC, estTdata, estToPontoOrvalho, estToOrvalhoMax, estToOrvalhoMin);
		
		ArrayList<String> estUmiRelAr = tb.listaUmiRelativaAr(t);
		ArrayList<String> estUmiRelMax = tb.listaUmiRelativaMax(t);
		ArrayList<String> estUmiRelMin = tb.listaUmiRelativaMin(t);
		serviceUmidade.insBancoService(regEstC, estTdata, estUmiRelAr, estUmiRelMax, estUmiRelMin);
		
		ArrayList<String> estVentoDirHor = tb.listaVentoDirecaoHor(t);
		ArrayList<String> estVentoRajMax = tb.listaVentoRajadaMax(t);
		ArrayList<String> estVentoVelHor = tb.listaVentoVelocidadeHor(t);
		serviceVento.insBancoService(regEstC, estTdata, estVentoDirHor, estVentoRajMax, estVentoVelHor);
	}
			
}
