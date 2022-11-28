package com.iacit.api.entity;

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

@Entity(name = "estado")
@Table(name = "estado")
@Getter
@Setter
@NoArgsConstructor
@Component
public class Estado {
	public Estado(String etdUnidadeFederativa) {
		this.etdUnidadeFederativa = etdUnidadeFederativa;
	}

	public Estado(Regiao regId, String etdUnidadeFederativa) {
		this.regId = regId;
		this.etdUnidadeFederativa = etdUnidadeFederativa;
	}

	public Estado(Integer etdId) {
		this.etdId = etdId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "etd_id")
	private Integer etdId;

	@Column(name = "etd_unidade_federativa", length = 2)
	private String etdUnidadeFederativa;

	@ManyToOne
	@JoinColumn(name = "reg_id", referencedColumnName = "reg_id")
	private Regiao regId;
}
