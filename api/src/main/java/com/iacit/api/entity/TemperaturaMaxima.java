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


@Entity(name="temperatura_maxima")
@Table(name="temperatura_maxima")
@Getter
@Setter
@ToString
public class TemperaturaMaxima {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "temp_max_id")
		private Integer tempMaxId;
	    
	    @Column(name= "temp_min_valor")
	    private BigDecimal tempMaxValor;
	    
	    @Column(name= "temp_bul_sec_data")
	    private Timestamp tempMaxData; 
}
