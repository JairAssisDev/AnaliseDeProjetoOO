package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;

public class FachadaDeNegocio implements IFachadaDeNegocio{

	ControladorAluno controladorAluno = new ControladorAluno();

	
	@Override
	public void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido  {
		// TODO Auto-generated method stub
		
			controladorAluno.inserir(aluno);
		
	}

	@Override
	public void atualizarALUNO(Aluno aluno) throws AlunoNaoEncontradoException {
		// TODO Auto-generated method stub
		
			controladorAluno.atualizar(aluno);
	
	}

	@Override
	public boolean removerAluno(long id) throws AlunoNaoEncontradoException {
		// TODO Auto-generated method stub
			return controladorAluno.remover(id);
		
	}

	@Override
	public Aluno getAluno(long id) throws AlunoNaoEncontradoException {
			return controladorAluno.get(id);

	}

}
