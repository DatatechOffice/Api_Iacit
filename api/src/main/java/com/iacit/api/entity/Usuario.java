package com.iacit.api.entity;

import javax.annotation.Nonnull;
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
        String usuNome,
        String usuEmail,
        String usuSenha
    ) {
        this.usuNome = usuNome;
        this.usuEmail = usuEmail;
        this.usuSenha = usuSenha;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "usu_id")
	private Integer usuId;

	@Column(name= "usu_nome")
	private String usuNome;

	@Column(name= "usu_email")
	private  String usuEmail;

	@Column(name= "usu_senha")
	private  String usuSenha;

	public void getUsuarioAcesso() {
	}
}