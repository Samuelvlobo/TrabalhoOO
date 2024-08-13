package app;

import exceptions.CampoEmBrancoException;

public class Disciplina {
    private String codigo;
    private String nome;

    public Disciplina(String codigo, String nome) throws CampoEmBrancoException {
        if (codigo.isBlank()) {
            throw new CampoEmBrancoException("Código da Disciplina"); // verifica se ta em branco
        }
        if (nome.isBlank()) {
            throw new CampoEmBrancoException("Nome da Disciplina"); // verifica se ta em branco
        }
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return "Disciplina: " + nome + " (Código: " + codigo + ")";
    }
}
