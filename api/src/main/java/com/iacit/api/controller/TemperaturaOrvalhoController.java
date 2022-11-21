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
import com.iacit.api.entity.TemperaturaOrvalho;
import com.iacit.api.service.ServiceTemperatura;
import com.iacit.api.service.ServiceTemperaturaOrvalho;

@Controller
public class TemperaturaOrvalhoController {

	@Autowired(required = true)
	private ServiceTemperaturaOrvalho orvalhoService;

<<<<<<< Updated upstream
	@PostMapping(value = { "/temperaturaOrvalho" }, consumes = MediaType.APPLICATION_JSON_VALUE)
=======
	@PostMapping(value = { "/temperatura_orvalho" }, consumes = MediaType.APPLICATION_JSON_VALUE)
>>>>>>> Stashed changes
	public ResponseEntity<List<TemperaturaOrvalho>> postFiltroPorDataTemp(@RequestBody FilterDataVo data) throws ParseException {

		List<TemperaturaOrvalho> listTempOrvalho = orvalhoService.getByFilter(data.getEstacao(), data.getDataInicio(), data.getDataFim());
		
		return listTempOrvalho != null && listTempOrvalho.size() > 0 ? new ResponseEntity<List<TemperaturaOrvalho>>(listTempOrvalho, HttpStatus.CREATED)
				: new ResponseEntity<List<TemperaturaOrvalho>>(listTempOrvalho, HttpStatus.BAD_REQUEST);

	}
}
