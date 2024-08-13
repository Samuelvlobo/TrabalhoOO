package exceptions;

public class CampoEmBrancoException extends Exception {
    public CampoEmBrancoException(String campo) {
        super("O campo " + campo + " não pode ser deixado em branco.");
    }
}