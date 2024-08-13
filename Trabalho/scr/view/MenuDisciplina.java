package view;

import javax.swing.JOptionPane;
import app.Disciplina;
import cadastros.CadastroDisciplina;
import exceptions.CampoEmBrancoException;

public class MenuDisciplina {

    private static Disciplina dadosNovaDisciplina() throws CampoEmBrancoException {
        String codigo = lerCodigoDisciplina();
        String nome = lerNomeDisciplina();

        return new Disciplina(codigo, nome);
    }

    private static String lerCodigoDisciplina() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private static String lerNomeDisciplina() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Remover disciplina\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            try {
                switch (opcao) {
                    case 1:
                        Disciplina novaDisciplina = dadosNovaDisciplina();
                        cadDisciplina.cadastrarDisciplina(novaDisciplina);
                        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso.");
                        break;

                    case 2:
                        String codigo = lerCodigoDisciplina();
                        Disciplina d = cadDisciplina.pesquisarDisciplina(codigo);
                        if (d != null) {
                            JOptionPane.showMessageDialog(null, d.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                        }
                        break;

                    case 3:
                        codigo = lerCodigoDisciplina();
                        Disciplina remover = cadDisciplina.pesquisarDisciplina(codigo);
                        boolean removido = cadDisciplina.removerDisciplina(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
                        }
                        break;

                    default:
                        break;
                }
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }
}
