package br.edu.umfg.ocp;

import br.edu.umfg.ocp.legado.Produto;
import br.edu.umfg.ocp.legado.TipoVenda;
import br.edu.umfg.ocp.legado.Venda;
import br.edu.umfg.ocp.refatorado.*;

import java.util.ArrayList;

public class PrincipioAbertoFechado {
    public static void executarLegado(){
        Produto cocaCola
                = new Produto("COCA-COLA 350ML", 7.50);
        Produto batataFrita
                = new Produto("BATATA FRITA 400GR", 25.90);

        Venda vendaUm = new Venda(TipoVenda.Parana);
        vendaUm.addProduto(cocaCola);
        vendaUm.addProduto(batataFrita);

        System.out.println(vendaUm.toString());
    }

    public static void executarRefatorado(){
        Pis pis = new Pis();
        IcmsParana icmsParana = new IcmsParana();
        IcmsSantaCatarina icmsSantaCatarina = new IcmsSantaCatarina();

        ArrayList<AbstractImpostoFederal> impostosFederais
                = new ArrayList<AbstractImpostoFederal>();
        impostosFederais.add(pis);

        ArrayList<AbstractImpostoEstadual> impostosEstaduais
                = new ArrayList<AbstractImpostoEstadual>();
        impostosEstaduais.add(icmsParana);
        impostosEstaduais.add(icmsSantaCatarina);

        ProdutoRefatorado cocaCola
                = new ProdutoRefatorado("COCA COLA 350 ML",
                    7.49, impostosFederais, impostosEstaduais);
        ProdutoRefatorado batataFrita
                = new ProdutoRefatorado("BATATA FRITA 400 GR",
                    25.90, impostosFederais, impostosEstaduais);

        VendaRefatorada venda = new VendaRefatorada(TipoEstado.Parana);
        venda.addProduto(cocaCola);
        venda.addProduto(batataFrita);

        System.out.println(venda.toString());
    }
}
