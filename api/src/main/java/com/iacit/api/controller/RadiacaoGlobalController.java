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
import com.iacit.api.entity.RadiacaoGlobal;
import com.iacit.api.service.ServiceRadiacaoGlobal;

@Controller
public class RadiacaoGlobalController {
	
	@Autowired(required = true)
	private ServiceRadiacaoGlobal serviceRadicaoGlobal;

<<<<<<< Updated upstream
	@PostMapping(value = { "/radiacaoGlobal" }, consumes = MediaType.APPLICATION_JSON_VALUE)
=======
	@PostMapping(value = { "/radiacao_global" }, consumes = MediaType.APPLICATION_JSON_VALUE)
>>>>>>> Stashed changes
	public ResponseEntity<List<RadiacaoGlobal>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<RadiacaoGlobal> listRadiacao = serviceRadicaoGlobal.getByFilter(data.getEstacao(), data.getDataInicio(), data.getDataFim());
		
		return listRadiacao != null && listRadiacao.size() > 0 ? new ResponseEntity<List<RadiacaoGlobal>>(listRadiacao, HttpStatus.CREATED)
				: new ResponseEntity<List<RadiacaoGlobal>>(listRadiacao, HttpStatus.BAD_REQUEST);

	}
}
