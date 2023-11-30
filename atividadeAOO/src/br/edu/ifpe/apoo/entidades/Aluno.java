package br.edu.ifpe.apoo.entidades;

import java.io.Serializable;

import br.edu.ifpe.apoo.excecoes.TamanhoCPFInvalidoException;
import br.edu.ifpe.apoo.excecoes.TamanhoNomeInvalidoException;

public class Aluno implements Serializable {

	

	private long id;
	private String nome;
	private String cpf;
	private String email;

	public Aluno(Aluno original) {
		this.id = original.id;
		this.nome = original.nome;
		this.cpf = original.cpf;
		this.email = original.email;
	}

	public Aluno() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	@Override
	public Aluno clone() {
		
			return new Builder()
					.nome(this.nome)
					.cpf(this.cpf)
					.email(this.email)
					.build();
		
	}

	public static class Builder {

		private String nome;
		private String cpf;
		private String email;

		public Builder() {

		}

		public Builder nome(String nome)  {
			this.nome = nome;
			return this;
		}

		public Builder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Aluno build(){
			Aluno aluno = new Aluno();
			aluno.setNome(this.nome);
			aluno.setCpf(this.cpf);
			aluno.setEmail(this.email);
			return aluno;
		}
	}
}