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


@Entity(name="temperatura_orvalho_minima")
@Table(name="temperatura_orvalho_minima")
@Getter
@Setter
@ToString
public class TemperaturaOrvalhoMinima {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "temp_orv_min_id")
		private Integer tempOrvMinId;
	    
	    @Column(name= "temp_orv_min_valor")
	    private BigDecimal tempOrvMinValor;
	    
	    @Column(name= "temp_orv_min_data")
	    private Timestamp tempOrvMinData; 
}
