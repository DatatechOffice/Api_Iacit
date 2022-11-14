package com.iacit.api.entity;
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

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="radiacao_global")
@Table(name="radiacao_global")
@Getter
@Setter
@NoArgsConstructor
@Component
public class RadiacaoGlobal {
	
	public RadiacaoGlobal(Estacao estCodigo, Timestamp dataHora, BigDecimal ragRadiacaoGlobal) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.ragRadiacaoGlobal=ragRadiacaoGlobal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "rag_id")
    private Integer ragId;
	
	@Column(name= "rag_radiacao_global")
    private BigDecimal ragRadiacaoGlobal;
	
	@Column(name= "rag_data_hora")
    private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
