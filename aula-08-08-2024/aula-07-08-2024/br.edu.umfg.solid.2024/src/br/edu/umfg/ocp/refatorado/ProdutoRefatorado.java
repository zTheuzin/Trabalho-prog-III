package br.edu.umfg.ocp.refatorado;

import java.util.ArrayList;

public class ProdutoRefatorado {
    private String descricao;
    private Double valor;
    private ArrayList<AbstractImpostoFederal> impostosFederais
            = new ArrayList<AbstractImpostoFederal>();
    private ArrayList<AbstractImpostoEstadual> impostosEstaduais
            = new ArrayList<AbstractImpostoEstadual>();

    public ProdutoRefatorado(String descricao, Double valor,
                             ArrayList<AbstractImpostoFederal> impostosFederais,
                             ArrayList<AbstractImpostoEstadual> impostosEstaduais) {
        this.descricao = descricao;
        this.valor = valor;
        this.impostosFederais.addAll(impostosFederais);
        this.impostosEstaduais.addAll(impostosEstaduais);
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Double getValorImpostoFederal(){
        final Double[] resultado = {0.0};


        //maneira convencional
        /*Double resultadoTeste = 0.0;

        for (Integer i = 0; i < this.impostosEstaduais.size(); i++){
            //resultadoTeste = resultadoTeste +  ((getValor() / 100) * imposto.getAliquota());
            resultadoTeste += ((getValor() / 100)
                    * this.impostosEstaduais.get(i).getAliquota());
        }

        for (AbstractImpostoFederal imposto : this.impostosFederais){
            //resultadoTeste = resultadoTeste +  ((getValor() / 100) * imposto.getAliquota());
            resultadoTeste += ((getValor() / 100) * imposto.getAliquota());
        }*/

        this.impostosFederais
                .stream()
                .forEach(x -> { resultado[0] += ((getValor() / 100) * x.getAliquota());});

        return resultado[0];
    }

    public Double getValorImpostoEstadual(TipoEstado tipoEstado){
        final Double[] resultado = {0.0};

        //maneira convencional
        /*Double resultadoTeste = 0.0;

        for (AbstractImpostoEstadual imposto : this.impostosEstaduais){
            if (tipoEstado.equals(imposto.getTipoEstado()))
                resultadoTeste += ((getValor() / 100) * imposto.getAliquota());
        }*/

        this.impostosEstaduais
                .stream()
                .filter(x -> tipoEstado.equals(x.getTipoEstado()))
                .forEach(y -> { resultado[0] += ((getValor() / 100) * y.getAliquota()); });

        return resultado[0];
    }
}
