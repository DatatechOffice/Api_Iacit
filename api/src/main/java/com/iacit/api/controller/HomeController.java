package com.iacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
//import com.iacit.api.service.ServiceTemperatura;

@Controller
@RestController
public class HomeController {

	private Post inputs;
	
	private String t1;
	
	@Autowired(required=true)
	private TemperaturaRepository temperatura;
	
	/*
	 * @Autowired(required=true) private ServiceTemperatura temperaturaService;
	 */
	@RequestMapping(value = { "/post" }, method = RequestMethod.POST) 
    public ResponseEntity<Temperatura> post(HttpStatus accepted) {
		
		String tem_data_hora = "2020-10-10 00:00:00";
		List<Temperatura> enviarTemperatura = temperatura.listar("A001", Timestamp.valueOf(tem_data_hora));
		/*
		 * inputs.setDatainicio(null); inputs.setDatafim(null); inputs.setRegiao(null);
		 * inputs.setEstacao(null); inputs.setDado(null);
		 */	
		ResponseEntity<Temperatura> printnn = new ResponseEntity<Temperatura>(accepted);
		
		
		
        return printnn ;
        }


	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
    public ModelAndView aaaaaaa() {
        ModelAndView modelAndView = new ModelAndView();
        
    	// listaTemperatura
    	List<Temperatura> enviarTemperatura = temperatura.listar("A001", Timestamp.valueOf("2020-01-01 00:00:00"));
   
    	modelAndView.addObject("teste_Temperatura", enviarTemperatura);
        modelAndView.setViewName("index");
        return modelAndView;
	}
}