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
import org.springframework.web.bind.annotation.RequestMapping;
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.entity.RadiacaoGlobal;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.service.ServicePressaoAt;
import com.iacit.api.service.ServiceRadiacaoGlobal;
import com.iacit.api.service.ServiceTemperatura;

@Controller
public class RadiacaoGlobalController {
	
	@Autowired(required = true)
	private ServiceRadiacaoGlobal serviceRadicaoGlobal;

	@PostMapping(value = { "/radiacaoGlobal" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RadiacaoGlobal>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<RadiacaoGlobal> listRadiacao = serviceRadicaoGlobal.getByFilter(data.getDataInicio(), data.getDataFim());
		
		return listRadiacao != null && listRadiacao.size() > 0 ? new ResponseEntity<List<RadiacaoGlobal>>(listRadiacao, HttpStatus.CREATED)
				: new ResponseEntity<List<RadiacaoGlobal>>(listRadiacao, HttpStatus.BAD_REQUEST);

	}
}
