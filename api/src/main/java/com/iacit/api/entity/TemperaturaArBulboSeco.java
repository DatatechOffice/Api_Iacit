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


@Entity(name="temperatura_ar_bulbo_seco")
@Table(name="temperatura_ar_bulbo_seco")
@Getter
@Setter
@ToString
public class TemperaturaArBulboSeco {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "temp_bul_sec_id")
		private Integer tempBulSecId;
	    
	    @Column(name= "temp_bul_sec_valor")
	    private BigDecimal tempBulSecValor;
	    
	    @Column(name= "temp_bul_sec_data")
	    private Timestamp tempBulSecData; 
}
