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


@Entity(name="temperatura_orvalho_maxima")
@Table(name="temperatura_orvalho_maxima")
@Getter
@Setter
@ToString
public class TemperaturaOrvalhoMaxima {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "temp_orv_max_id")
		private Integer tempOrvMaxId;
	    
	    @Column(name= "temp_orv_max_valor")
	    private BigDecimal tempOrvMaxValor;
	    
	    @Column(name= "temp_orv_max_data")
	    private Timestamp tempOrvMaxData; 
}
