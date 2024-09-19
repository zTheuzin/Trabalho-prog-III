package br.edu.umfg.srp.legado;

public class Funcionario {
    private String nome;
    private Double salario;
    private TipoFuncionario tipoFuncionario;

    public Funcionario(String nome, Double salario,
                       TipoFuncionario tipoFuncionario){
        this.nome = nome;
        this.salario = salario;
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getSalario(){
        if (TipoFuncionario.Estagiario.equals(this.tipoFuncionario)){
            return this.nome + " SALARIO: " + this.salario;
        }

        return this.nome + " SALARIO: "
                + (this.salario + (this.salario * 0.10));
    }
}
