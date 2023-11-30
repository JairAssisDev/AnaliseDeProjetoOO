package br.edu.ifpe.apoo.dao;

public class AlunoDAOFactory {

    public static AlunoDAO criarAlunoDAO() {
        // Neste exemplo, estamos usando AlunoDAOMap, mas você pode modificar para outras implementações.
        return AlunoDAOMap.getInstancia();
    }
}
