package cadastros;

import app.Professor;
import java.util.ArrayList;

public class CadastroProfessor {
    private ArrayList<Professor> professores;

    public CadastroProfessor() {
        professores = new ArrayList<>();
    }

    public int cadastrarProfessor(Professor p) {
        professores.add(p);
        return professores.size();
    }

    public Professor pesquisarProfessor(String matriculaFUB) {
        for (Professor p : professores) {
            if (p.getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerProfessor(Professor p) {
        if (p == null) {
            return false;
        }
        return professores.remove(p);
    }

    public boolean atualizarProfessor(String matriculaFUB, Professor p) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
                professores.set(i, p);
                return true;
            }
        }
        return false;
    }
}
