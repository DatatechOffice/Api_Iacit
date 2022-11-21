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

@Entity(name="pressao_atmosferica")
@Table(name="pressao_atmosferica")
@Getter
@Setter
@NoArgsConstructor
@Component
public class PressaoAtmosferica {
	public PressaoAtmosferica(
		Estacao estCodigo, 
		Timestamp dataHora, 
		BigDecimal praMax, 
		BigDecimal praMin,
<<<<<<< Updated upstream
		BigDecimal praNivelEstacao
=======
		BigDecimal pressao_atmosferica
>>>>>>> Stashed changes
	) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.praMax=praMax;
		this.praMin=praMin;
<<<<<<< Updated upstream
		this.praNivelEstacao=praNivelEstacao;
=======
		this.pressao_atmosferica=pressao_atmosferica;
>>>>>>> Stashed changes
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "pra_id")
	private Integer praId;

	@Column(name= "pra_nivel_estacao")
<<<<<<< Updated upstream
    private BigDecimal praNivelEstacao;
=======
    private BigDecimal pressao_atmosferica;
>>>>>>> Stashed changes

	@Column(name= "pra_max")
    private BigDecimal praMax;

	@Column(name= "pra_min")
    private BigDecimal praMin;

	@Column(name= "pra_data_hora")
    private Timestamp dataHora;

	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
