package com.iacit.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iacit.api.entity.Umidade;
import com.iacit.api.service.ServiceUmidade;

@Controller
public class UmidadeController {

	@Autowired(required = true)
	private ServiceUmidade umidadeService;

	@PostMapping(value = { "/umidade" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Umidade>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<Umidade> listUmidade = umidadeService.getByFilter(data.getEstacao(), data.getDataInicio(),
				data.getDataFim());

		return listUmidade != null && listUmidade.size() > 0
				? new ResponseEntity<List<Umidade>>(listUmidade, HttpStatus.CREATED)
				: new ResponseEntity<List<Umidade>>(listUmidade, HttpStatus.BAD_REQUEST);

	}
}
