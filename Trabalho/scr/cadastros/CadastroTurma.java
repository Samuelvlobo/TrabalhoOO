package cadastros;

import app.Turma;

import java.util.ArrayList;
import java.util.List;

public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        this.turmas = new ArrayList<>();
    }

    public void cadastrarTurma(Turma turma) {
        turmas.add(turma);
    }

    public Turma pesquisarTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public String pesquisar(String codigo) {
        String aux;
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {

                aux = "Turma: " + codigo;
                return aux;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma turma) {
        return turmas.remove(turma);
    }
}
