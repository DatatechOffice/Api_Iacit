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

import com.iacit.api.entity.Temperatura;
import com.iacit.api.service.ServiceTemperatura;

@Controller
public class TemperaturaController {

	@Autowired(required = true)
	private ServiceTemperatura temperaturaService;

	@PostMapping(value = { "/temperatura" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Temperatura>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {
		
		List<Temperatura> listTemperatura = temperaturaService.getByFilter(data.getEstacao(), data.getDataInicio(), data.getDataFim());
		
		return listTemperatura != null && listTemperatura.size() > 0 ? new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.CREATED)
				: new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.BAD_REQUEST);

	}
}
