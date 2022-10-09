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
import com.iacit.api.entity.Vento;
import com.iacit.api.service.ServiceTemperatura;
import com.iacit.api.service.ServiceVento;

@Controller
public class VentoDirecaoHorariaController {

	@Autowired(required = true)
	private ServiceVento ventoService;

	@PostMapping(value = { "/ventoDirecaoHoraria" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vento>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<Vento> listVento = ventoService.getByFilter(data.getDataInicio(), data.getDataFim());
		
		return listVento != null && listVento.size() > 0 ? new ResponseEntity<List<Vento>>(listVento, HttpStatus.CREATED)
				: new ResponseEntity<List<Vento>>(listVento, HttpStatus.BAD_REQUEST);

	}
}
