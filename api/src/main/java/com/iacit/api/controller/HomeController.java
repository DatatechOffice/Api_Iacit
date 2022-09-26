package com.iacit.api.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceTemperatura;

@Controller
@RestController
public class HomeController {
	private Post inputs;
	
	@Autowired(required=true)
	private TemperaturaRepository temperatura;
	private ServiceTemperatura serviceTemperatura;
	
	
	@RequestMapping(value = { "/post" }, method = RequestMethod.POST)
    public ServiceTemperatura post() {
		
		inputs.setDatainicio(null);
		inputs.setDatafim(null);
		inputs.setRegiao(null);
		inputs.setEstacao(null);
		inputs.setDado(null);
		
        return serviceTemperatura;
        }

	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
    public ModelAndView aaaaaaa() {
        ModelAndView modelAndView = new ModelAndView();
        
    	// listaTemperatura
    	ArrayList<Temperatura> enviarTemperatura = temperatura.listar("A001", Timestamp.valueOf("2020-01-01 00:00:00"));
   
    	modelAndView.addObject("teste_Temperatura", enviarTemperatura);
        modelAndView.setViewName("index");
        return modelAndView;
	}
}
