package com.iacit.api.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;
import com.iacit.api.repository.EstacaoRepository;
import com.iacit.api.repository.EstadoRepository;
import com.iacit.api.repository.RegiaoRepository;

@Service
public class ServiceInsereEstacao {

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	EstacaoRepository estacaoRepository;

	@Autowired
	ServiceInsereRegiao serviceInsereRegiao;

	private ArrayList<String> listaEstacaoNome;
	
	private ArrayList<String> listaEstacaoCodigo;
	
	private ArrayList<String> listaEstacaoLatitude;
	
	private ArrayList<String> listaEstacaoLongitude;
	
	private ArrayList<String> listaEstacaoAltitude;
	
	private ArrayList<String> listaEstacaoData;
	
	private ArrayList<String> listaEstado;

	public ServiceInsereEstacao(ArrayList<String> listaEstacaoNome, ArrayList<String> listaEstacaoCodigo, ArrayList<String> listaEstacaoLatitude, 
			ArrayList<String> listaEstacaoLongitude, ArrayList<String> listaEstacaoAltitude, ArrayList<String> listaEstacaoData,
			ArrayList<String> listaEstado) {
		this.listaEstacaoNome = listaEstacaoNome;
		this.listaEstacaoCodigo = listaEstacaoCodigo;
		this.listaEstacaoLatitude = listaEstacaoLatitude;
		this.listaEstacaoLongitude = listaEstacaoLongitude;
		this.listaEstacaoAltitude = listaEstacaoAltitude;
		this.listaEstacaoData = listaEstacaoData;
		this.listaEstado = listaEstado;
	}

	public void insBancoService(ArrayList<String> listaEstacaoNome, ArrayList<String> listaEstacaoCodigo, ArrayList<String> listaEstacaoLatitude, 
			ArrayList<String> listaEstacaoLongitude, ArrayList<String> listaEstacaoAltitude, ArrayList<String> listaEstacaoData, ArrayList<String> listaEstado) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = listaEstacaoCodigo.size();
		for (int i = 1; i < ii; i++) {
			String estacaoNS = listaEstacaoNome.get(i);
			String estacaoCS = listaEstacaoCodigo.get(i);
			String estacaoLAS = listaEstacaoLatitude.get(i);
			String estacaoLOS = listaEstacaoLongitude.get(i);
			String estacaoAS = listaEstacaoAltitude.get(i);
			String estacaoDS = listaEstacaoData.get(i);
			if (i - 1 >= 0 && listaEstacaoNome.get(i - 1) != estacaoNS) {
				String estacaoDSS = estacaoDS.replace("/", "-");
				Estacao estacao = new Estacao(estacaoCS, BigDecimal.valueOf(Double.parseDouble(estacaoLOS)), estacaoNS, Timestamp.valueOf("20"+estacaoDSS.replace("00", "01")+" 00:00:00"),
						BigDecimal.valueOf(Double.parseDouble(estacaoLAS)), BigDecimal.valueOf(Double.parseDouble(estacaoAS)));
				
				estacaoRepository.save(estacao);
				
			} else {
				continue;
			}
		}
	}
}
