package com.iacit.api.controller;

import java.util.ArrayList;

import com.iacit.api.service.ServiceEstacao;
import com.iacit.api.service.ServiceEstado;
import com.iacit.api.service.ServiceRegiao;
import com.iacit.api.service.TableSaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tech.tablesaw.api.Table;

@Controller
public class PersistenciaController {
	
	@Autowired(required = true)
	private ServiceRegiao serviceRegiao;

	@Autowired(required = true)
	private ServiceEstado serviceEstado;

	@Autowired(required = true)
	private ServiceEstacao serviceEstacao;

	@GetMapping(value = { "/persistir" })
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
}
