package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOAbstractFactory;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import fachada.AlunoDAOFactory;

public class ControladorAluno {
	
    private AlunoDAO fachadaDao = AlunoDAOFactory.criarAlunoDAO();

    public void inserir(Aluno aluno) throws ExcecaoAlunoInvalido {
        if (!isValido(aluno)) {
            throw new ExcecaoAlunoInvalido("Aluno inválido");
        }
        fachadaDao.inserir(aluno);
    }

    public void atualizar(Aluno aluno) throws AlunoNaoEncontradoException {
        Aluno alunoExistente = fachadaDao.get(aluno.getId());
        if (alunoExistente != null) {
        	fachadaDao.atualizar(aluno);
        } else {
            throw new AlunoNaoEncontradoException("Aluno com ID " + aluno.getId() + " não encontrado.");
        }
    }

    public boolean remover(long id) throws AlunoNaoEncontradoException {
        Aluno alunoExistente = fachadaDao.get(id);
        if (alunoExistente != null) {
            return fachadaDao.remover(id);
        } else {
            throw new AlunoNaoEncontradoException("Aluno com ID " + id + " não encontrado.");
        }
    }

    public Aluno get(long id) throws AlunoNaoEncontradoException {
        Aluno aluno = fachadaDao.get(id);
        if (aluno != null) {
            return aluno;
        } else {
            throw new AlunoNaoEncontradoException("Aluno com ID " + id + " não encontrado.");
        }
    }
	 private boolean isValido(Aluno aluno) throws ExcecaoAlunoInvalido {
		    // Validação do nome
		    String nome = aluno.getNome();
		    if (nome == null || nome.length() < 5 || nome.length() > 100) {
		        throw new ExcecaoAlunoInvalido("Nome do aluno inválido");
		    }

		    // Validação do CPF
		    String cpf = aluno.getCpf();
		    if (cpf == null || cpf.length() != 11) {
		        throw new ExcecaoAlunoInvalido("CPF do aluno inválido");
		    }
		    return true;
		}

}
