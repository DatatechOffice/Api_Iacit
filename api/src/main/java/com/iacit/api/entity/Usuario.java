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
    public Usuario(
        String usuLogin,
        String usuSenha,
        String usuEmail
    ) {
        this.usuLogin = usuLogin;
        this.usuSenha = usuSenha;
        this.usuEmail = usuEmail;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "usu_id")
	private Integer usuId;

	@Column(name= "usu_login")
	private String usuLogin;

	@Column(name= "usu_senha")
	private  String usuSenha;

	@Column(name= "usu_email")
	private  String usuEmail;
}