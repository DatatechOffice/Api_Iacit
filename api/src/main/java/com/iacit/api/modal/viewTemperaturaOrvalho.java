package com.iacit.api.modal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_temperatura_orvalho")
@Immutable
@Getter
@Setter
public class viewTemperaturaOrvalho {
	
	@Id
	@Column(name= "est_codigo", length = 10)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "tdo_id")
    private String tdo_id;
	
	@Column(name= "tdo_ponto")
	private String tdo_ponto;
	
	@Column(name= "tdo_max")
	private String tdo_max;
	
	@Column(name= "tdo_min")
	private String tdo_min;
	
	@Column(name= "tdo_data_hora")
	private Timestamp tdo_data_hora;
}
