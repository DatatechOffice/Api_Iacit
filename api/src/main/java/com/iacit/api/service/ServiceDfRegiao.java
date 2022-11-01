package com.iacit.api.service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.iacit.api.entity.Regiao;
import com.iacit.api.entity.Temperatura;
import com.iacit.api.repository.RegiaoRepository;
import com.iacit.api.repository.TemperaturaRepository;

import TestSpark2.Session;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDfRegiao {
	
	

	@Autowired(required=true) 
	private RegiaoRepository regiaoRepository;

	// tipo da função deve ser TemperaturaRepository
	public List<Regiao> insereBySigla() throws ParseException {
		Session dfregiao = new Session();
		
		List<Regiao> entidades = regiaoRepository.Jorge(dfregiao.dfRegiao());
		return entidades;
	}

}
