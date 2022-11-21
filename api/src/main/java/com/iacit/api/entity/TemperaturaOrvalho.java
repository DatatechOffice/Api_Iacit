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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="temperatura_orvalho")
@Table(name="temperatura_orvalho")
@Getter
@Setter
@ToString
public class TemperaturaOrvalho {
<<<<<<< Updated upstream
	
=======
	public TemperaturaOrvalho(
		Estacao estCodigo, 
		Timestamp dataHora, 
<<<<<<< Updated upstream
		BigDecimal tdoPonto, 
=======
		BigDecimal temperatura_orvalho, 
>>>>>>> Stashed changes
		BigDecimal tdoMax,
		BigDecimal tdoMin
	) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
<<<<<<< Updated upstream
		this.tdoPonto=tdoPonto;
=======
		this.temperatura_orvalho=temperatura_orvalho;
>>>>>>> Stashed changes
		this.tdoMax=tdoMax;
		this.tdoMin=tdoMin;
	}

>>>>>>> Stashed changes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "tdo_id")
	private Integer tdoId;
	
	@Column(name= "tdo_ponto")
<<<<<<< Updated upstream
	private BigDecimal tdoPonto;
<<<<<<< Updated upstream
    
=======
=======
	private BigDecimal temperatura_orvalho;
>>>>>>> Stashed changes

>>>>>>> Stashed changes
	@Column(name= "tdo_max")
	private BigDecimal tdoMax;
    
	@Column(name= "tdo_min")
	private BigDecimal tdoMin;
    
	@Column(name= "tdo_data_hora")
	private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
