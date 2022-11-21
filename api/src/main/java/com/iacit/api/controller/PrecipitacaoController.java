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

import com.iacit.api.entity.Precipitacao;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.service.ServicePrecipitacao;
import com.iacit.api.service.ServiceTemperatura;

@Controller
public class PrecipitacaoController {

	@Autowired(required = true)
	private ServicePrecipitacao precipitacaoService;

	@PostMapping(value = { "/precipitacao" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Precipitacao>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<Precipitacao> listPrecipitacao = precipitacaoService.getByFilter(data.getEstacao(), data.getDataInicio(), data.getDataFim());
		
		return listPrecipitacao != null && listPrecipitacao.size() > 0 ? new ResponseEntity<List<Precipitacao>>(listPrecipitacao, HttpStatus.CREATED)
				: new ResponseEntity<List<Precipitacao>>(listPrecipitacao, HttpStatus.BAD_REQUEST);

	}
}
