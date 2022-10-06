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

import com.apiIacit.DatatechApiIacit.entity.Temperatura;
import com.apiIacit.DatatechApiIacit.repository.TemperaturaRepository;
import com.apiIacit.DatatechApiIacit.service.ServiceTemperatura;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RestController
@RequestMapping(value={"/"})
public class HomeController {

	// Método para inicialização de página
	@GetMapping(value = { "/index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	// Método para inicialização de página
		@GetMapping(value = { "/testeIndex" })
		public ModelAndView Index2() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("index2");
			return modelAndView;
		}
