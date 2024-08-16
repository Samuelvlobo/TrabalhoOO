package view;

import javax.swing.JOptionPane;
import app.Disciplina;
import cadastros.CadastroDisciplina;
import exceptions.CampoEmBrancoException;

public class MenuDisciplina {

    public static Disciplina dadosNovaDisciplina() throws CampoEmBrancoException {
        String codigo = lerCodigo();
        String nome = lerNome();
        return new Disciplina(codigo, nome);
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    private static String lerNome() {
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
                        break;

                    case 2:
                        String codigo = lerCodigo();
                        Disciplina d = cadDisciplina.pesquisarDisciplina(codigo);
                        if (d != null)
                            JOptionPane.showMessageDialog(null, d.toString());
                        break;

                    case 3:
                        codigo = lerCodigo();
                        Disciplina remover = cadDisciplina.pesquisarDisciplina(codigo);
                        boolean removido = cadDisciplina.removerDisciplina(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
                            System.gc();
                        }
                        break;

                    default:
                        break;
                }
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } while (opcao != 0);
    }
}
