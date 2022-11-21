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

@Entity(name="radiacao_global")
@Table(name="radiacao_global")
@Getter
@Setter
@ToString
public class RadiacaoGlobal {
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
	public RadiacaoGlobal(Estacao estCodigo, Timestamp dataHora, BigDecimal ragRadiacaoGlobal) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.ragRadiacaoGlobal=ragRadiacaoGlobal;
=======
	public RadiacaoGlobal(Estacao estCodigo, Timestamp dataHora, BigDecimal radiacao_global) {
		this.estCodigo=estCodigo;
		this.dataHora=dataHora;
		this.radiacao_global=radiacao_global;
>>>>>>> Stashed changes
	}
>>>>>>> Stashed changes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "rag_id")
    private Integer ragId;
	
	@Column(name= "rag_radiacao_global")
<<<<<<< Updated upstream
    private BigDecimal ragRadiacaoGlobal;
<<<<<<< Updated upstream
	
=======
=======
    private BigDecimal radiacao_global;
>>>>>>> Stashed changes

>>>>>>> Stashed changes
	@Column(name= "rag_data_hora")
    private Timestamp dataHora;
	
	@ManyToOne
    @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo")
    private Estacao estCodigo;
}
