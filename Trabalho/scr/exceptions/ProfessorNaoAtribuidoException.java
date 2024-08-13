package exceptions;

public class ProfessorNaoAtribuidoException extends Exception {
    public ProfessorNaoAtribuidoException() {
        super("Professor não atribuído.");
    }
}
