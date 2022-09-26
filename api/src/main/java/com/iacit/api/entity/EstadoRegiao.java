package com.iacit.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="estado_regiao")
@Table(name="estado_regiao")
@Getter
@Setter
@ToString
public class EstadoRegiao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "eer_id")
	private Integer eer_id;
	
	@Column(name= "eer_nome_regiao",length = 2)
    private String eer_nome_regiao;
	
	@Column(name= "eer_unidade_federativa",length = 2)
    private String eer_unidade_federativa;
}
