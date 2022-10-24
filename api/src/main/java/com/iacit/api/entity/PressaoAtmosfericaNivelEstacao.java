package com.iacit.api.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name="pressao_atmosferica_nivel_estacao")
@Table(name="pressao_atmosferica_nivel_estacao")
@Getter
@Setter
@ToString
public class PressaoAtmosfericaNivelEstacao {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "pre_atm_lvl_est_id")
		private Integer preAtmLvlEstId;
	    
	    @Column(name= "pre_atm_lvl_est_valor")
	    private BigDecimal preAtmLvlEstValor;
	    
	    @Column(name= "pre_atm_lvl_est_data")
	    private Timestamp preAtmLvlEstData; 
}
