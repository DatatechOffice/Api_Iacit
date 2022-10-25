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

	@PostMapping(value = "salvar") /*mapeia a url*/
	@ResponseBody /*Descricao da respsota*/
	public ResponseEntity<FilterDataVo> salvar(@RequestBody FilterDataVo filtro){ /* Recebe os dados para salvar */
		 
		System.out.println(filtro);
		
		return null;
	}
	
	// Método para inicialização de página
	@GetMapping(value = { "/index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}

