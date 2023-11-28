package br.edu.ifpe.apoo.entidades;

import java.io.Serializable;

import br.edu.ifpe.apoo.excecoes.TamanhoCPFInvalidoException;
import br.edu.ifpe.apoo.excecoes.TamanhoNomeInvalidoException;

public class Aluno implements Serializable {

	private static final int numberMin = 5;
	private static final int numberMax = 100;

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
    public Aluno() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws TamanhoNomeInvalidoException {
		if (nome != null && nome.length() >= numberMin && nome.length() <= numberMax) {
			this.nome = nome;
		} else {
			throw new TamanhoNomeInvalidoException("O nome do aluno deve ter entre 5 e 100 caracteres.");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws TamanhoCPFInvalidoException {
		String cpfSemPontosETraços = cpf.replaceAll("[.-]", "");

		if (cpfSemPontosETraços.length() == 11) {
			this.cpf = cpfSemPontosETraços;
		} else {
			throw new TamanhoCPFInvalidoException("O CPF deve ter 11 caracteres.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}
	   @Override
	    public Aluno clone() {
	        return new Aluno(this);
	    }

}
