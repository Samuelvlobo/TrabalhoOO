package view;

import javax.swing.JOptionPane;
import app.Turma;
import app.Professor;
import app.Disciplina;
import cadastros.CadastroTurma;
import cadastros.CadastroProfessor;
import cadastros.CadastroDisciplina;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

public class MenuTurma {

    public static void menuTurma(CadastroTurma cadTurma, CadastroDisciplina cadDisciplina,
            CadastroProfessor cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Remover turma\n"
                + "4 - Imprimir lista de presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadDisciplina, cadProfessor);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
                    break;

                case 2:
                    String codigoTurma = lerCodigoTurma();
                    Turma turma = cadTurma.pesquisarTurma(codigoTurma);
                    if (turma != null) {
                        JOptionPane.showMessageDialog(null, turma.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 3:
                    codigoTurma = lerCodigoTurma();
                    Turma turmaRemover = cadTurma.pesquisarTurma(codigoTurma);
                    if (turmaRemover != null) {
                        boolean removido = cadTurma.removerTurma(turmaRemover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                case 4:
                    codigoTurma = lerCodigoTurma();
                    turma = cadTurma.pesquisarTurma(codigoTurma);
                    if (turma != null) {
                        JOptionPane.showMessageDialog(null, turma.imprimirListaPresenca());
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    private static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
        String codigo = lerCodigoTurma();
        String codigoDisciplina = lerCodigoDisciplina();
        String matriculaProfessor = lerMatriculaProfessor();

        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
        Professor professor = cadProfessor.pesquisarProfessor(matriculaProfessor);

        try {
            if (disciplina == null) {
                throw new DisciplinaNaoAtribuidaException();
            }
            if (professor == null) {
                throw new ProfessorNaoAtribuidoException();
            }
            return new Turma(codigo, disciplina, professor);
        } catch (CampoEmBrancoException | DisciplinaNaoAtribuidaException | ProfessorNaoAtribuidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    private static String lerCodigoTurma() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private static String lerMatriculaProfessor() {
        return JOptionPane.showInputDialog("Informe a matrícula do professor: ");
    }
}
