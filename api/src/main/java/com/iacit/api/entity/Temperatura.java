package com.iacit.api.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="temperatura")
@Table(name="temperatura")
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Temperatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tem_id")
    private Integer temId;
	
	@Column(name= "tem_ar_bulbo_seco")
	private BigDecimal tem_ar_bulbo_seco;
	
	@Column(name= "tem_max")
	private BigDecimal temMax;
	
	@Column(name= "tem_min")
	private BigDecimal temMin;
	
	@Column(name= "tem_data_hora")
	private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;	
}
