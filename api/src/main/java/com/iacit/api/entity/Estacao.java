package com.iacit.api.entity;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="estacao")
@Table(name="estacao")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Estacao {
	
	public Estacao(String estCodigo, BigDecimal estLongitude, String estNomeEstacao, Timestamp estDataFundacao, 
			BigDecimal estLatitude, BigDecimal estAltitude) {
		this.estCodigo=estCodigo;
		this.estLongitude=estLongitude;
		this.estNomeEstacao=estNomeEstacao;
		this.estDataFundacao=estDataFundacao;
		this.estLatitude=estLatitude;
		this.estAltitude=estAltitude;
	}
	 
	@Id
	@Column(name= "est_codigo", length = 4)
	private String estCodigo;
	
	@Column(name= "est_longitude", length = 10)
	private BigDecimal estLongitude;
	
	@Column(name= "est_nome_estacao", length = 50)
	private String estNomeEstacao;
	
	@Column(name= "est_data_fundacao")
	private Timestamp estDataFundacao;
	
	@Column(name= "est_latitude", length = 10)
	private BigDecimal estLatitude;
	
	@Column(name= "est_altitude", length = 10)
	private BigDecimal estAltitude;
	
	@ManyToOne
    @JoinColumn(name = "etd_id", referencedColumnName = "etd_id")
	private Estado etdId;
	
}
