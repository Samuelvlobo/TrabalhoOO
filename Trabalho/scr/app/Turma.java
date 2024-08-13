package app;

import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;
import exceptions.CampoEmBrancoException;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosMatriculados;

    public Turma(String codigo, Disciplina disciplina, Professor professor)
            throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        if (codigo.isBlank()) {
            throw new CampoEmBrancoException("Código da Turma");
        }
        if (disciplina == null) {
            throw new DisciplinaNaoAtribuidaException();
        }
        if (professor == null) {
            throw new ProfessorNaoAtribuidoException();
        }
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public String imprimirListaPresenca() {
        StringBuilder lista = new StringBuilder();
        lista.append("Disciplina: ").append(disciplina.getNome()).append("\n");
        lista.append("Professor: ").append(professor.getNome()).append("\n");
        lista.append("Código da Turma: ").append(codigo).append("\n");
        lista.append("Lista de Alunos:\n");

        for (Aluno aluno : alunosMatriculados) {
            lista.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
        }

        return lista.toString();
    }

    public Object getCodigo() {
        return codigo;
    }
}
