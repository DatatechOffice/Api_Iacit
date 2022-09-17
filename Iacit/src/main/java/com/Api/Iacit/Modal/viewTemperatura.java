package com.Api.Iacit.Modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_temperatura")
@Immutable
@Getter
@Setter
public class viewTemperatura {
	
	@Id
	@Column(name= "est_codigo", length = 10)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "tem_id")
    private String tem_id;
	
	@Column(name= "tem_ar_bulbo_seco")
	private String tem_ar_bulbo_seco;
	
	@Column(name= "tem_max")
	private String tem_max;
	
	@Column(name= "tem_min")
	private String tem_min;
	
	@Column(name= "tem_data_hora")
	private Timestamp tem_data_hora;
}
