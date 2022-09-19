package com.iacit.api.modal;

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

@Entity(name="umidade")
@Table(name="umidade")
@Getter
@Setter
@ToString
public class umidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "umi_id")
	private Integer umi_id;
	
	@Column(name= "umi_relativa_min")
	private BigDecimal umi_relativa_min;
    
	@Column(name= "umi_relativa_ar")
	private BigDecimal umi_relativa_ar;
    
	@Column(name= "umi_data_hora")
	private Timestamp umi_data_hora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private estacao est_codigo;
}