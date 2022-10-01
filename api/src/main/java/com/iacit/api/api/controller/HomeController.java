package com.iacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceTemperatura;

@Controller
@RestController
public class HomeController {
	private String A;
	private String B;
	
	@Autowired
	private TemperaturaRepository temperaturaRepository;
	
	@Autowired(required = true)
	private ServiceTemperatura temperaturaService;

	@RequestMapping(value = { "/post" }, method = RequestMethod.POST)
	public ResponseEntity<Void> posTT(ServiceTemperatura temperaturaService) {

		ServiceTemperatura Entt = new ServiceTemperatura();
		HomeController Jorge = new HomeController();

		Jorge.A = "";
		Jorge.B = "";

		Entt.serviceTEntity(A, B);

		return temperaturaService.serviceTEntity(A, B) != null ? new ResponseEntity<Void>(HttpStatus.CREATED)
				: new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/hello0/{name}")
	public String hello0(@PathVariable("name") String name) {
		return "Hello " + name;
	}

	@GetMapping("/hello1")
	public String hello1(@RequestParam(name = "name", required = false, defaultValue = "Ahmed") String name) {
		return "Hello " + name;
	}

	@GetMapping("/hello2")
	public String hello2(Parms parameters) {
		// implement the setter and getter of the Params class.
		return "Hello " + parameters.a + " " + parameters.b;
	}

	/*
	 * @RequestMapping(value = { "/post" }, method = RequestMethod.POST) public
	 * ResponseEntity<Temperatura> post(HttpStatus ok) {
	 * 
	 * ResponseEntity<Temperatura> jsonFiltro = new ResponseEntity<Temperatura>(ok);
	 * 
	 * String A="2020-10-10 00:00:00";
	 * 
	 * String B="2020-10-11 00:00:00";
	 * 
	 * jsonFiltro.ok(temperaturaService.serviceTEntity(A, B));
	 * 
	 * return jsonFiltro ; }
	 */

	// Método para inicialização de página
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// Método para inicialização de página
		@RequestMapping(value = { "/testeIndex" }, method = RequestMethod.GET)
		public ModelAndView Index2() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("index2");
			return modelAndView;
		}

	
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public ModelAndView aaaaaaa() {
		ModelAndView modelAndView = new ModelAndView();
	  
		ServiceTemperatura Entt = new ServiceTemperatura();
		HomeController Jorge = new HomeController();

		Jorge.A = "2020-10-10 00:00:00";
		Jorge.B = "2020-10-10 00:00:00";
		List<Temperatura> enviarTemperatura = temperaturaRepository.listar("A001", Timestamp.valueOf("2020-10-10 00:00:00"), Timestamp.valueOf("2020-10-10 00:00:00"));

		modelAndView.addObject(enviarTemperatura);
		
	  return modelAndView; 
	  }
}