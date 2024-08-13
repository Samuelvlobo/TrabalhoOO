package exceptions;

public class DisciplinaNaoAtribuidaException extends Exception {
    public DisciplinaNaoAtribuidaException() {
        super("Disciplina não atribuída.");
    }
}
