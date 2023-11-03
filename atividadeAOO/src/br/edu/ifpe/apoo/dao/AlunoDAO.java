package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;

public interface AlunoDAO {
	
	public void inserir(Aluno aluno);
	public void atualizar(Aluno aluno) throws AlunoNaoEncontradoException;
	public boolean remover(long id) throws AlunoNaoEncontradoException;
	public Aluno get(long id) throws AlunoNaoEncontradoException;
}
