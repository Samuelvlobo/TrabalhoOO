package cadastros;

import app.Aluno;
import java.util.ArrayList;

public class CadastroAluno {
	private ArrayList<Aluno> alunos;

	public CadastroAluno() {
		alunos = new ArrayList<>();
	}

	public int cadastrarAluno(Aluno a) {
		alunos.add(a);
		return alunos.size();
	}

	public Aluno pesquisarAluno(String matriculaAluno) {
		for (Aluno a : alunos) {
			if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return a;
			}
		}
		return null;
	}

	public boolean removerAluno(Aluno a) {
		if (a == null) {
			return false;
		}
		return alunos.remove(a);
	}

	public boolean atualizarAluno(String matricula, Aluno a) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				alunos.set(i, a);
				return true;
			}
		}
		return false;
	}
}
