package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.excecoes.TamanhoCPFInvalidoException;
import br.edu.ifpe.apoo.excecoes.TamanhoNomeInvalidoException;

public class Main{

    public static void main(String[] args) throws TamanhoCPFInvalidoException, TamanhoNomeInvalidoException {
        // Criação de um aluno original
        Aluno original = new AlunoBuilder()
                .setId(1)
                .setNome("Joãod")
                .setCpf("123.456.789-09")
                .setEmail("joao@example.com")
                .build();

        // Clonagem do aluno original para criar uma nova instância
        Aluno clone = original.clone();

        // Ambos os objetos têm os mesmos atributos
        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);
    }
}