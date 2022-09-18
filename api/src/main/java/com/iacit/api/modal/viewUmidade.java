package com.iacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_umidade")
@Immutable
@Getter
@Setter
public class viewUmidade {
	
	@Id
	@Column(name= "est_codigo", length = 10)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "umi_id")
    private String umi_id;
	
	@Column(name= "umi_relativa_min")
	private String umi_relativa_min;
	
	@Column(name= "umi_relativa_ar")
	private String umi_relativa_ar;
	
	@Column(name= "umi_data_hora")
	private Timestamp umi_data_hora;
}
