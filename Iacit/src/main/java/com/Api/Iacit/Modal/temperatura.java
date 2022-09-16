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

@Entity(name="temperatura")
@Table(name="temperatura")
@Getter
@Setter
@ToString
public class temperatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tem_id")
    private Integer tem_id;
	
	@Column(name= "tem_ar_bulbo_seco")
	private BigDecimal tem_ar_bulbo_seco;
	
	@Column(name= "tem_max")
	private BigDecimal tem_max;
	
	@Column(name= "tem_min")
	private BigDecimal tem_min;
	
	@Column(name= "tem_data")
	private Timestamp tem_data;
	
	@Column(name= "tem_hora")
	private Timestamp tem_hora;
	
	@ManyToOne
    @JoinColumn(name = "estacao", referencedColumnName = "est_codigo")
    private estacao est_codigo;
}
