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
        @Nonnull String usuNome,
        @Nonnull String usuEmail,
        @Nonnull String usuSenha
    ) {
        this.usuNome = usuNome;
        this.usuEmail = usuEmail;
        this.usuSenha = usuSenha;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "usu_id")
	private Integer usuId;

    @Nonnull
	@Column(name= "usu_nome")
	private String usuNome;

    @Nonnull
	@Column(name= "usu_email")
	private  String usuEmail;

    @Nonnull
	@Column(name= "usu_senha")
	private  String usuSenha;
}