package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public interface IFachadaDeNegocio {

	public void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido;
	
	public void atualizarALUNO(Aluno aluno) throws AlunoNaoEncontradoException;
	
	public boolean removerAluno(long id) throws AlunoNaoEncontradoException;
	
	public Aluno getAluno(long id) throws AlunoNaoEncontradoException;
	
}
