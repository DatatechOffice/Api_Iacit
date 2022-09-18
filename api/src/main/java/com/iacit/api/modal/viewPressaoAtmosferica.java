package com.iacit.api.modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_pressao_atmosferica")
@Immutable
@Getter
@Setter
public class viewPressaoAtmosferica {

	@Id
	@Column(name= "est_codigo", length = 4)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "pra_id")
    private String pra_id;
	
	@Column(name= "pra_nivel_estacao")
	private String pra_nivel_estacao;
	
	@Column(name= "pra_max")
	private String pra_max;
	
	@Column(name= "pra_min")
	private String pra_min;
	
	@Column(name= "pra_data_hora")
	private Timestamp pra_data_hora;
}
