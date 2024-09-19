package br.edu.umfg.srp;

import br.edu.umfg.srp.legado.Funcionario;
import br.edu.umfg.srp.legado.TipoFuncionario;
import br.edu.umfg.srp.refatorado.Estagiario;
import br.edu.umfg.srp.refatorado.Vendedor;

public class PrincipioDeResponsabilidadeUnica {
    public static void executarLegado(){
        Funcionario estagiario =
                new Funcionario("JOÃO",
                        600.00,
                        TipoFuncionario.Estagiario);

        Funcionario vendedor =
                new Funcionario("JOSÉ",
                        2500.00,
                        TipoFuncionario.Vendedor);

        System.out.println(estagiario.getSalario());
        System.out.println(vendedor.getSalario());
    }

    public static void executarRefatorado(){
        Estagiario estagiario
                = new Estagiario("MONIQUE", 600.00);
        Vendedor vendedor
                = new Vendedor("ELIZABETE", 2500.00);

        System.out.println(estagiario.getSalario());
        System.out.println(vendedor.getSalario());
    }
}
