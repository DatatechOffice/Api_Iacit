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

@Entity(name="umidade")
@Table(name="umidade")
@Getter
@Setter
@ToString
public class Umidade {
<<<<<<< Updated upstream
	
=======
	public Umidade(
		Estacao estCodigo, 
		Timestamp dataHora, 
<<<<<<< Updated upstream
		BigDecimal umiRelativaAr, 
=======
		BigDecimal umidade, 
>>>>>>> Stashed changes
		BigDecimal umiRelativaMax, 
		BigDecimal umiRelativaMin
	) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
<<<<<<< Updated upstream
		this.umiRelativaAr=umiRelativaAr;
=======
		this.umidade=umidade;
>>>>>>> Stashed changes
		this.umiRelativaMax=umiRelativaMax;
		this.umiRelativaMin=umiRelativaMin;
	}

>>>>>>> Stashed changes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "umi_id")
	private Integer umiId;
	
	@Column(name= "umi_relativa_min")
	private BigDecimal umiRelativaMin;
    
	@Column(name= "umi_relativa_ar")
<<<<<<< Updated upstream
	private BigDecimal umiRelativaAr;
<<<<<<< Updated upstream
    
=======
=======
	private BigDecimal umidade;
>>>>>>> Stashed changes

>>>>>>> Stashed changes
	@Column(name= "umi_data_hora")
	private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
