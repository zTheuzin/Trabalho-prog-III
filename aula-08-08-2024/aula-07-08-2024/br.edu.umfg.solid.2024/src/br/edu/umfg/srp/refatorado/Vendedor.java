package br.edu.umfg.srp.refatorado;

public class Vendedor extends AbstractFuncionario{
    public Vendedor(String nome, Double salario){
        super(nome, salario);
    }

    @Override
    public String getSalario() {
        return this.nome + " SALÁRIO: "+ (this.salario * 1.1);
    }
}
