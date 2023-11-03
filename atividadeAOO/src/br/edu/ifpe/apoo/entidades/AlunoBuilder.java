package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.excecoes.TamanhoCPFInvalidoException;
import br.edu.ifpe.apoo.excecoes.TamanhoNomeInvalidoException;

public class AlunoBuilder {
    private Aluno aluno;

    public AlunoBuilder() {
        this.aluno = new Aluno();
    }

    public AlunoBuilder setId(long id) {
        this.aluno.setId(id);
        return this;
    }

    public AlunoBuilder setNome(String nome) throws TamanhoNomeInvalidoException {
        this.aluno.setNome(nome);
        return this;
    }

    public AlunoBuilder setCpf(String cpf) throws TamanhoCPFInvalidoException {
        this.aluno.setCpf(cpf);
        return this;
    }

    public AlunoBuilder setEmail(String email) {
        this.aluno.setEmail(email);
        return this;
    }

    public Aluno build() {
        return this.aluno;
    }
}
