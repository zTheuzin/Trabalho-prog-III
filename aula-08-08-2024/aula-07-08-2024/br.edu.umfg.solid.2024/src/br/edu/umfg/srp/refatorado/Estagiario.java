package br.edu.umfg.srp.refatorado;

public class Estagiario extends AbstractFuncionario{
    public Estagiario(String nome, Double salario)
    {
        super(nome, salario);
    }

    @Override
    public String getSalario() {
        return this.nome + " SALÁRIO: " + this.salario;
    }
}
