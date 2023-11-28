package fachada;

import br.edu.ifpe.apoo.dao.AlunoDAO;
import br.edu.ifpe.apoo.dao.AlunoDAOMap;

public class AlunoDAOFactory {

    public static AlunoDAO criarAlunoDAO() {
        // Neste exemplo, estamos usando AlunoDAOMap, mas você pode modificar para outras implementações.
        return AlunoDAOMap.getInstancia();
    }
}
