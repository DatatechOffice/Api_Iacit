package com.iacit.api;

import com.iacit.api.entity.Regiao;
import com.iacit.api.service.ServiceInsereRegiao;
import com.iacit.api.service.TableSaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		Regiao reg = new Regiao();
		TableSaw tb = new TableSaw();
		reg = tb.insereRegiaoBanco();
		ServiceInsereRegiao serv = new ServiceInsereRegiao(reg);
		serv.insBancoService();
		
	}

}
