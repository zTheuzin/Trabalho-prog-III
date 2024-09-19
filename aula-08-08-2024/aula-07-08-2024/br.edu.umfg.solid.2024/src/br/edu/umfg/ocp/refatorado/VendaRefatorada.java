package br.edu.umfg.ocp.refatorado;

import java.util.ArrayList;

public class VendaRefatorada {
    private TipoEstado tipoEstado;
    private ArrayList<ProdutoRefatorado> produtos
            = new ArrayList<ProdutoRefatorado>();

    public VendaRefatorada(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public void addProduto(ProdutoRefatorado produto){
        this.produtos.add(produto);
    }

    public void removeProduto(ProdutoRefatorado produto){
        this.produtos.remove(produto);
    }

    @Override
    public String toString() {
        String resultado = this.tipoEstado + "\n";
        Double totalProdutos = 0.0;
        Double totalImpostos = 0.0;

        for (ProdutoRefatorado produto : this.produtos){
            Double valorProduto = produto.getValor();
            Double impostosFederais = produto.getValorImpostoFederal();
            Double impostosEstaduais = produto.getValorImpostoEstadual(this.tipoEstado);

            resultado += produto.getDescricao() + " | " + valorProduto + " | " +
                    impostosFederais + " | " + impostosEstaduais + "\n";
            totalProdutos += valorProduto;
            totalImpostos += (impostosFederais + impostosEstaduais);
        }

        resultado += "TOTAL R$: " + totalProdutos + "\n";
        resultado += "TOTAL IMPOSTOS R$: " + totalImpostos + "\n";
        resultado += "TOTAL VENDA R$: " + (totalProdutos + totalImpostos) + "\n";

        return resultado;
    }
}
