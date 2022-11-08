package com.iacit.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iacit.api.repository.TemperaturaRepository;
import com.iacit.api.service.ServiceEstacao;
import com.iacit.api.service.ServiceEstado;
import com.iacit.api.service.ServiceRegiao;
import com.iacit.api.service.ServiceTemperatura;

@Controller
@RestController
@RequestMapping(value={"/"})
public class HomeController {


	//Metodo para receber as informaçõs dos filtros vindo do front
	@PostMapping(value = "salvar") /*mapeia a url*/
	@ResponseBody /*Descricao da respsota*/
	public ResponseEntity<FilterDataVo> salvar(@RequestBody FilterDataVo filtro){ /* Recebe os dados para salvar */
		 
		System.out.println(filtro);
		
		return salvar(filtro);
	}
	@Autowired(required = true)
	private ServiceRegiao serviceInsereRegiao;

	@Autowired(required = true)
	private ServiceEstado serviceInsereEstado;

	@Autowired(required = true)
	private ServiceEstacao serviceInsereEstacao;

	@Autowired(required = true)
	private ServiceTemperatura serviceTemperatura;

	@Autowired(required = true)
	private TemperaturaRepository temperaturaRepository;

	// Método para inicialização de página
	@GetMapping(value = { "/index" })
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}

