import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;
import view.MenuProfessor;
import view.MenuTurma;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessor cadProfessor;
    static CadastroDisciplina cadDisciplina;
    static CadastroTurma cadTurma;

    public static void main(String[] args) {
        // Inicializando os objetos de cadastro
        cadAluno = new CadastroAluno();
        cadProfessor = new CadastroProfessor();
        cadDisciplina = new CadastroDisciplina();
        cadTurma = new CadastroTurma();

        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    MenuAluno.menuAluno(cadAluno);
                    break;
                case 2:
                    MenuProfessor.menuProfessor(cadProfessor);
                    break;
                case 3:
                    MenuDisciplina.menuDisciplina(cadDisciplina);
                    break;
                case 4:
                    MenuTurma.menuTurma(cadTurma, cadDisciplina, cadProfessor);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }
}
