package com.iacit.api.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_vento")
@Immutable
@Getter
@Setter
public class ViewVento {

	@Id
	@Column(name= "est_codigo", length = 10)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "ven_id")
    private String ven_id;
	
	@Column(name= "ven_direcao_horaria")
	private String ven_direcao_horaria;
	
	@Column(name= "ven_data_hora")
	private Timestamp ven_data_hora;
}
