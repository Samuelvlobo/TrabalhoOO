package app;

import java.util.ArrayList;
import java.util.List;
import exceptions.CampoEmBrancoException;
import exceptions.ProfessorNaoAtribuidoException;
import exceptions.DisciplinaNaoAtribuidaException;

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
        if (aluno != null && !alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
        }
    }

    public String imprimirLista() {
        String resposta = "Disciplina: " + disciplina.getNome() + "\n";
        resposta += "Professor: " + professor.getNome() + "\n";
        resposta += "Código da Turma: " + codigo + "\n";
        resposta += "Lista de Alunos:\n";

        for (Aluno aluno : alunosMatriculados) {
            resposta += aluno.getMatricula() + " - " + aluno.getNome() + "\n";
        }

        return resposta;
    }

    public Object getCodigo() {
        return codigo;
    }
}
