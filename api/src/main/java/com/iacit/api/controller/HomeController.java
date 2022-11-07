package com.iacit.api.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.entity.Regiao;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.RegiaoRepository;
import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceInsereEstacao;
import com.iacit.api.service.ServiceInsereEstado;
import com.iacit.api.service.ServiceInsereRegiao;
import com.iacit.api.service.ServiceTemperatura;
import com.iacit.api.service.TableSaw;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import tech.tablesaw.api.Table;

@Controller
@RestController
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired(required = true)
	private ServiceInsereRegiao serviceInsereRegiao;

	@Autowired(required = true)
	private ServiceInsereEstado serviceInsereEstado;

	@Autowired(required = true)
	private ServiceInsereEstacao serviceInsereEstacao;

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

		ArrayList<String> reg = tb.listaRegiao(t);
		serviceInsereRegiao.insBancoService(reg);

		ArrayList<String> regEtd = tb.listaEstado(t);
		serviceInsereEstado.insBancoService(reg, regEtd);

		ArrayList<String> regEstN = tb.listaEstacaoNome(t);
		ArrayList<String> regEstLO = tb.listaEstacaoLongitude(t);
		ArrayList<String> regEstLA = tb.listaEstacaoLatitude(t);
		ArrayList<String> regEstAL = tb.listaEstacaoAltitude(t);
		ArrayList<String> regEstD = tb.listaEstacaoDataFund(t);
		ArrayList<String> regEstC = tb.listaEstacaoCodigo(t);
		serviceInsereEstacao.insBancoService(regEstN, regEstC, regEstLA, regEstLO, regEstAL, regEstD, regEtd);

		ArrayList<String> estTdata = tb.listaTempData(t);
		ArrayList<String> estTbulbo = tb.listaBulboSeco(t);
		ArrayList<String> estTmax = tb.listaTempMax(t);
		ArrayList<String> estTmin = tb.listaTempMin(t);
		serviceTemperatura.insBancoService(estTdata, estTbulbo, estTmax, estTmin);
		temperaturaRepository.delete();

		return modelAndView;
	}
}