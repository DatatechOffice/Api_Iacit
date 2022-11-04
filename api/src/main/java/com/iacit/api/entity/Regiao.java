package com.iacit.api.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name="regiao")
@Table(name="regiao")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Regiao{

    public Regiao(String regSigla) {
		this.regSigla=regSigla;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "reg_id")
	private Integer regId;
	
	@Column(name= "reg_sigla", length = 2)
	private String regSigla;
	
}