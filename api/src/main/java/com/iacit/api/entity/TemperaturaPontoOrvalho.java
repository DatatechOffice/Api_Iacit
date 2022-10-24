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


@Entity(name="temperatura_ponto_orvalho")
@Table(name="temperatura_ponto_orvalho")
@Getter
@Setter
@ToString
public class TemperaturaPontoOrvalho {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "temp_pnt_orv_id")
		private Integer tempPntOrvId;
	    
	    @Column(name= "temp_pnt_orv_valor")
	    private BigDecimal tempPntOrvValor;
	    
	    @Column(name= "temp_pnt_orv_data")
	    private Timestamp tempPntOrvData; 
}
