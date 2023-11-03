package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;

import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class AlunoDAOMap implements AlunoDAO {

    private static AlunoDAOMap instancia;
    private Map<Long, Aluno> bancoDeDados = new HashMap<>();
    private static long id =1;
    
    protected static AlunoDAOMap getInstancia() {
        if (instancia == null) {
            instancia = new AlunoDAOMap();
        }

        return instancia;
    }

    private AlunoDAOMap() {}

    public void inserir(Aluno aluno) {
    	aluno.setId(id++);
        bancoDeDados.put(aluno.getId(), aluno);
    }

    public void atualizar(Aluno aluno) {
        bancoDeDados.put(aluno.getId(), aluno);
    }

    public boolean remover(long id) throws AlunoNaoEncontradoException {
        if (bancoDeDados.containsKey(id)) {
            bancoDeDados.remove(id);
            return true;
        } else {
            throw new AlunoNaoEncontradoException("Aluno com ID " + id + " não encontrado.");
        }
    }

    public Aluno get(long id) throws AlunoNaoEncontradoException {
        if (bancoDeDados.containsKey(id)) {
            return bancoDeDados.get(id);
        } else {
            throw new AlunoNaoEncontradoException("Aluno com ID " + id + " não encontrado.");
        }
    }
}
