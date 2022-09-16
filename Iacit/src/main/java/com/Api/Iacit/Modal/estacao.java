package com.Api.Iacit.Modal;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="estacao")
@Table(name="estacao")
@Getter
@Setter
@ToString
public class estacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "est_codigo")
	private String est_codigo;
	
	@Column(name= "est_longitude")
	private BigDecimal est_longitude;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "est_data_fundacao")
	private Timestamp est_data_fundacao;
	
	@Column(name= "est_latitud")
	private BigDecimal est_latitude;
	
	@Column(name= "est_altitude")
	private BigDecimal est_altitude;
	
	@ManyToOne
    @JoinColumn(name = "estado_regiao", referencedColumnName = "eer_id")
	private estadoRegiao eer_id;
}
