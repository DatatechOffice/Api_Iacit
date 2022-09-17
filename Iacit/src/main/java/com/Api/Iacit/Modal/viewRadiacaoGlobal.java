package com.Api.Iacit.Modal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "view_radiacao_global")
@Immutable
@Getter
@Setter
public class viewRadiacaoGlobal {
	
	@Id
	@Column(name= "est_codigo", length = 4)
	private String est_codigo;
	
	@Column(name= "est_nome_estacao", length = 30)
	private String est_nome_estacao;
	
	@Column(name= "rag_id")
    private String rag_id;
	
	@Column(name= "rag_radiacao_global")
	private String rag_radiacao_global;
	
	@Column(name= "rag_data_hora")
	private Timestamp rag_data_hora;
}
