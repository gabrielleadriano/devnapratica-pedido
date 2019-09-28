package br.edu.senior.devnapratica.pedidospdv.domain;

import java.time.LocalDate;

public class Cliente {

	private Long id;

	private String name;

	private String email;

	private LocalDate dataNascimento;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;

	}

	public LocalDate getdataNascimento() {
		return this.dataNascimento;
	}

	public void setdataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
