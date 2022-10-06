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

import com.apiIacit.DatatechApiIacit.entity.Temperatura;
import com.apiIacit.DatatechApiIacit.service.ServiceTemperatura;

//O @ controller indica que essa classe ´fai ter rotas de endpoint
@Controller

// Nomeando a rota até a controller nesse a ro
@RequestMapping (value={"/temperatura"})
// Aqui é controller de temperatura onde será inseridas os metodosda API(GET, POST, PUT, DELETE ENTRE OUTROS)
public class TemperaturaController {
	
// fazendo a injeção de depedencia, tudo do ServiceTemperatura vira para o temperaturaService	
	@Autowired(required = true)
	private ServiceTemperatura temperaturaService;

// Metodo post onde Data é uma clase que recebe o valor do fronte e data minusculo é onde eu vou pegar os dados para fazer tratamentos.	
	@PostMapping(value = { "/filtrar" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Temperatura>> postFiltroPorData(@RequestBody FilterDataVo data) throws ParseException {
		
		System.out.println(data.getDataInicio());

		List<Temperatura> listTemperatura = temperaturaService.getByFilter(data.getDataInicio(), data.getDataFim());
		
		return listTemperatura != null && listTemperatura.size() > 0 ? new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.CREATED)
				: new ResponseEntity<List<Temperatura>>(listTemperatura, HttpStatus.BAD_REQUEST);

	}
}
