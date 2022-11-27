package com.iacit.api.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Estado;
import com.iacit.api.repository.EstacaoRepository;

@Service
public class ServiceEstacao {
	@Autowired
	ServiceEstado serviceEstado;

	@Autowired
	EstacaoRepository estacaoRepository;

	public List<Estacao> selectEstacao() {
		List<Estacao> etdLista = estacaoRepository.selectEstacao();
		return etdLista;
	}
	
	public Estacao selectEstacaoCodigo(String nomeEstacao) {
		Estacao Estacao = estacaoRepository.selectCodigoEstacao(nomeEstacao);
		Estacao idEstacao = new Estacao(Estacao.getEstCodigo());
		return idEstacao;
	}

	public void insBancoService(
		ArrayList<String> regEstN,
		ArrayList<String> regEstC,
		ArrayList<String> regEstLA,
		ArrayList<String> regEstLO,
		ArrayList<String> regEstAL,
		ArrayList<String> regEstD,
		ArrayList<String> etd
	) {
		// qual o id da regiao e com o Id em mãos inserir o estado
		int ii = regEstC.size();
		for (int i = 1; i < ii; i++) {
			String estNome = regEstN.get(i);
			String estC = regEstC.get(i);
			String latitude = regEstLA.get(i);
			String longitude = regEstLO.get(i);
			String altitude = regEstAL.get(i);
			String dataFundacao = regEstD.get(i);
			String estadoS = etd.get(i);

			if (i - 1 >= 0 && regEstC.get(i - 1) != estC) {
				String estacaoDSS = dataFundacao.replace("/", "-");
				
				Estado estado = new Estado();
				estado = serviceEstado.returnEstado(estadoS);
				Estado estadoID = new Estado(estado.getEtdId());
				System.out.println(estacaoDSS);
				Estacao estacao = new Estacao(
					estadoID, estC,
					BigDecimal.valueOf(Double.parseDouble(longitude)), estNome,
					Timestamp.valueOf(estacaoDSS+" 00:00:00"),
					BigDecimal.valueOf(Double.parseDouble(latitude)),
					BigDecimal.valueOf(Double.parseDouble(altitude))
				);
				estacaoRepository.save(estacao); 
			} else {
				continue;
			}
		}
	}
}
