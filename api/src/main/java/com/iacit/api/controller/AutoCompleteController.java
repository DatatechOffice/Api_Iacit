package com.iacit.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
import com.iacit.api.service.ServiceEstacao;
import com.iacit.api.service.ServiceEstado;
import com.iacit.api.service.ServiceRegiao;

@Controller
public class AutoCompleteController {
	@Autowired(required = true)
	private ServiceRegiao regiaoService;

	@Autowired(required = true)
	private ServiceEstado estadoService;

	@Autowired(required = true)
	private ServiceEstacao estacaoService;

	@GetMapping(value = { "/regiao" })
	public ResponseEntity<List<Regiao>> listaRegiao() {
		List<Regiao> listRegiao = regiaoService.selectRegiao();
		return listRegiao != null && listRegiao.size() > 0 ? new ResponseEntity<List<Regiao>>(
			listRegiao, HttpStatus.ACCEPTED
		)
		: new ResponseEntity<List<Regiao>>(listRegiao, HttpStatus.BAD_REQUEST);
	}
	@GetMapping(value = { "/estado" })
	public ResponseEntity<List<Estado>> listaEstado() {
		List<Estado> listEstado = estadoService.selectEstado();
		return listEstado != null && listEstado.size() > 0 ? new ResponseEntity<List<Estado>>(
			listEstado, HttpStatus.CREATED
		)
		: new ResponseEntity<List<Estado>>(listEstado, HttpStatus.BAD_REQUEST);
	}
	@GetMapping(value = { "/estacao" })
	public ResponseEntity<List<Estacao>> listaEstacao() {
		List<Estacao> listEstacao = estacaoService.selectEstacao();
		return listEstacao != null && listEstacao.size() > 0 ? new ResponseEntity<List<Estacao>>(
			listEstacao, HttpStatus.ACCEPTED
		)
		: new ResponseEntity<List<Estacao>>(listEstacao, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = { "/variavel" })
	public ResponseEntity<List<String>> listaVariavel() {
		List<String> listVariavel = List.of("temperatura", "temperatura_orvalho"
		, "precipitacao", "umidade", "pressao_atmosferica", "radiacao_global"
		,"vento");
		
		return listVariavel != null && listVariavel.size() > 0 ? new ResponseEntity<List<String>>(
			listVariavel, HttpStatus.ACCEPTED
		)
		: new ResponseEntity<List<String>>(listVariavel, HttpStatus.BAD_REQUEST);
	}

}
