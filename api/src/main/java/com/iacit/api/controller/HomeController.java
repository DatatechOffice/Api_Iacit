package com.iacit.api.controller;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceTemperatura;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RestController
@RequestMapping(value={"/"})
public class HomeController {
/*
	@Autowired(required = true)
	private ServiceTemperatura temperaturaService;

	@PostMapping(value = { "salvar" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Temperatura>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {

		List<Temperatura> listTemperatura = temperaturaService.getByFilter(data.getDataInicio(), data.getDataFim());
		
		return listTemperatura != null && listTemperatura.size() > 0 ? new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.CREATED)
				: new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.BAD_REQUEST);

	}
	*/
	// Método para inicialização de página
	@GetMapping(value = { "/index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}

