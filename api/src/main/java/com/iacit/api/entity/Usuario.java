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

@Entity(name="usuario")
@Table(name="usuario")
@Getter
@Setter
@NoArgsConstructor
@Component

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "usu_Id")
    private Integer usuarioId;

	
	@Column(name= "usu_Login", length = 50)
	private String usuarioLogin;

	@Column(name= "usu_Senha")
	private String usuarioSenha;

	@Column(name= "usu_Acesso")
	private Boolean usuarioAcesso;
	
	

	

	

}
