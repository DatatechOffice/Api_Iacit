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

@Entity(name="radiacao_global")
@Table(name="radiacao_global")
@Getter
@Setter
@ToString
public class radiacaoGlobal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "rag_id")
    private Integer rag_id;
	
	@Column(name= "rag_radiacao_global")
    private BigDecimal rag_radiacao_global;
	
	@Column(name= "rag_data_hora")
    private Timestamp rag_data_hora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private estacao est_codigo;
}
