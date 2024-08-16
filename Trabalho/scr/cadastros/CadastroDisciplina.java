package cadastros;

import java.util.ArrayList;
import app.Disciplina;
import exceptions.CampoEmBrancoException;

public class CadastroDisciplina {

    private ArrayList<Disciplina> disciplinas;

    public CadastroDisciplina() {
        this.disciplinas = new ArrayList<>();
    }

    public void cadastrarDisciplina(Disciplina disciplina) throws CampoEmBrancoException {
        if (disciplina == null || disciplina.getCodigo().isEmpty() || disciplina.getNome().isEmpty()) {
            throw new CampoEmBrancoException("Campos de cadastro da disciplina");
        }
        disciplinas.add(disciplina);
    }

    public Disciplina pesquisarDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    public boolean removerDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            return false;
        }
        return disciplinas.remove(disciplina);
    }
}
