package com.iacit.api.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.modal.temperatura;

import com.iacit.api.repository.temperaturaRepository;

@Controller
@RestController
public class homeController {

	@Autowired(required=true)
	private temperaturaRepository temperatura;
	
	@RequestMapping(value = { "/temp" }, method = RequestMethod.POST)
	public ModelAndView bbbbbb() {
        ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
    public ModelAndView aaaaaaa() {
        ModelAndView modelAndView = new ModelAndView();
        
    	// listaTemperatura
    	List<temperatura> enviarTemperatura = temperatura.listar("BRASILIA", "A001", Timestamp.valueOf("2020-01-01 00:00:00"));
   
    	modelAndView.addObject("teste_Temperatura", enviarTemperatura);
        modelAndView.setViewName("index");
        return modelAndView;
	}
}
