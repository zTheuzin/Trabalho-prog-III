package br.edu.umfg.srp.refatorado;

public abstract class AbstractFuncionario {
    protected String nome;
    protected Double salario;

    public AbstractFuncionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public abstract String getSalario();
}
