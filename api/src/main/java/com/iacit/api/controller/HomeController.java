package com.iacit.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceEstacao;
import com.iacit.api.service.ServiceEstado;
import com.iacit.api.service.ServiceRegiao;
import com.iacit.api.service.ServiceTemperatura;
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
	private TemperaturaRepository temperaturaRepository;

	// Método para inicialização de página
	@GetMapping(value = { "index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		TableSaw tb = new TableSaw();
		Table t = tb.tableCsv();
//
//		ArrayList<String> reg = tb.listaRegiao(t);
//		serviceRegiao.insBancoService(reg);
//
//		ArrayList<String> regEtd = tb.listaEstado(t);
//		serviceEstado.insBancoService(reg, regEtd);
//
//		ArrayList<String> regEstN = tb.listaEstacaoNome(t);
//		ArrayList<String> regEstLO = tb.listaEstacaoLongitude(t);
//		ArrayList<String> regEstLA = tb.listaEstacaoLatitude(t);
//		ArrayList<String> regEstAL = tb.listaEstacaoAltitude(t);
//		ArrayList<String> regEstD = tb.listaEstacaoDataFund(t);
		ArrayList<String> regEstC = tb.listaEstacaoCodigo(t);
//		serviceEstacao.insBancoService(regEstN, regEstC, regEstLA, regEstLO, regEstAL, regEstD, regEtd);

		ArrayList<String> estTdata = tb.listaTempData(t);
		ArrayList<String> estTbulbo = tb.listaBulboSeco(t);
		ArrayList<String> estTmax = tb.listaTempMax(t);
		ArrayList<String> estTmin = tb.listaTempMin(t);
		serviceTemperatura.insBancoService(regEstC, estTdata, estTbulbo, estTmax, estTmin);
		temperaturaRepository.delete();

		return modelAndView;
	}
}

