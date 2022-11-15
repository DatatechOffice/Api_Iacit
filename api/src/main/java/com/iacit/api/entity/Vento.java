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

@Entity(name="vento")
@Table(name="vento")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Vento {
	public Vento(
		Estacao estCodigo, 
		Timestamp dataHora, 
		BigDecimal venDirecaoHoraria, 
		BigDecimal venRajadaMax, BigDecimal
		venVelocidadeHoraria
	) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.venDirecaoHoraria=venDirecaoHoraria;
		this.venRajadaMax=venRajadaMax;
		this.venVelocidadeHoraria=venVelocidadeHoraria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ven_id")
	private Integer venId;

	@Column(name= "ven_direcao_horaria")
	private BigDecimal venDirecaoHoraria;

	@Column(name= "ven_rajada_max")
	private BigDecimal venRajadaMax;

	@Column(name= "ven_velocidade_horaria")
	private BigDecimal venVelocidadeHoraria;

	@Column(name= "ven_data_hora")
	private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
