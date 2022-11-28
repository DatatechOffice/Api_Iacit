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

import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.service.ServicePressaoAtmosferica;
@Controller
public class PressaoAtmosfericaController {
	
	@Autowired(required = true)
	private ServicePressaoAtmosferica atmosfericaService;


	@PostMapping(value = { "/pressao_atmosferica" }, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<PressaoAtmosferica>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<PressaoAtmosferica> listPressaoAtm = atmosfericaService.getByFilter(data.getEstacao(), data.getDataInicio(), data.getDataFim());
		
		return listPressaoAtm != null && listPressaoAtm.size() > 0 ? new ResponseEntity<List<PressaoAtmosferica>>(listPressaoAtm, HttpStatus.CREATED)
				: new ResponseEntity<List<PressaoAtmosferica>>(listPressaoAtm, HttpStatus.BAD_REQUEST);

	}
}
