package br.edu.umfg.ocp.legado;

import java.util.ArrayList;

public class Venda {
    private TipoVenda tipoVenda;
    private ArrayList<Produto> produtos =
            new ArrayList<Produto>();

    public Venda(TipoVenda tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public void addProduto(Produto produto){
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        this.produtos.remove(produto);
    }

    @Override
    public String toString() {
        String result = this.tipoVenda + "\n";

        for (Produto produto : this.produtos){
            result += produto.getDescricao() +
                    " | " + produto.getValor() + "\n";
        }

        result += calcularTotalComImpostos();

        return result;
    }

    private String calcularTotalComImpostos(){
        Double totalVenda = 0.0;

        for (Produto produto : this.produtos){
            totalVenda += produto.getValor();
        }

        totalVenda += (totalVenda * 0.165); //ALIQUOTA PIS
        totalVenda += (totalVenda * 0.765); //ALIQUOTA COFINS

        // ALIQUOTA ICMS
        if (TipoVenda.Parana.equals(this.tipoVenda)){
            totalVenda += (totalVenda * 0.19);
        } else if (TipoVenda.SaoPaulo.equals(this.tipoVenda)){
            totalVenda += (totalVenda * 0.18);
        } else if (TipoVenda.SantaCatarina.equals(this.tipoVenda)){
            totalVenda += (totalVenda * 0.17);
        }

        return "TOTAL COM IMPOSTOS: " + totalVenda;
    }
}
