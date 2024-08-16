package view;

import javax.swing.JOptionPane;
import app.Professor;
import cadastros.CadastroProfessor;

public class MenuProfessor {

    public static Professor dadosNovoProfessor() { // instancia um objeto para cadastrar
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String areaFormacao = lerAreaFormacao();
        String matriculaFUB = lerMatriculaFUB();

        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB);
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }

    private static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe a área de formação do professor: ");
    }

    private static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matrícula FUB do professor: ");
    }

    public static void menuProfessor(CadastroProfessor cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Remover professor\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor();
                    cadProfessor.cadastrarProfessor(novoProfessor);
                    JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso.");
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    Professor p = cadProfessor.pesquisarProfessor(matriculaFUB);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                    }
                    break;

                case 3:
                    matriculaFUB = lerMatriculaFUB();
                    Professor remover = cadProfessor.pesquisarProfessor(matriculaFUB);
                    boolean removido = cadProfessor.removerProfessor(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido do cadastro.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                    }
                    break;

                default:
                    break;
            }

        } while (opcao != 0);
    }
}
