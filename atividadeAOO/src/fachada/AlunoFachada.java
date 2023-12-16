package fachada;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;

public class AlunoFachada {

    private AlunoDAO alunoDAO;

    public AlunoFachada() {
        
        this.alunoDAO = AlunoDAOFactory.criarAlunoDAO();
    }

    public void inserirAluno(Aluno aluno) {
        alunoDAO.inserir(aluno);
    }

    public void atualizarAluno(Aluno aluno) {
        try {
			alunoDAO.atualizar(aluno);
		} catch (AlunoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void removerAluno(long id) throws AlunoNaoEncontradoException {
        alunoDAO.remover(id);
    }

    public Aluno buscarAluno(long id) throws AlunoNaoEncontradoException {
        return alunoDAO.get(id);
    }
}
