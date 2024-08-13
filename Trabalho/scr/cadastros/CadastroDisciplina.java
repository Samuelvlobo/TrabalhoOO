package cadastros;

import java.util.HashMap;
import java.util.Map;
import app.Disciplina;
import exceptions.CampoEmBrancoException;

public class CadastroDisciplina {

    private Map<String, Disciplina> disciplinas;

    public CadastroDisciplina() {
        this.disciplinas = new HashMap<>();
    }

    public void cadastrarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        if (disciplina == null || disciplina.getCodigo().isEmpty() || disciplina.getNome().isEmpty()) {
            throw new CampoEmBrancoException("Campos de cadastro da disciplina");
        }
        disciplinas.put(disciplina.getCodigo(), disciplina);
    }

    public Disciplina pesquisarDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    public boolean atualizarDisciplina(String codigo, Disciplina novaDisciplina) throws CampoEmBrancoException {
        if (disciplinas.containsKey(codigo)) {
            cadastrarDisciplina(novaDisciplina); // Utiliza o mesmo método de cadastro para verificar os campos
            disciplinas.put(codigo, novaDisciplina);
            return true;
        }
        return false;
    }

    public boolean removerDisciplina(Disciplina disciplina) {
        if (disciplina != null && disciplinas.containsKey(disciplina.getCodigo())) {
            disciplinas.remove(disciplina.getCodigo());
            return true;
        }
        return false;
    }
}
