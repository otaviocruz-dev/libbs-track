package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.ItemEstoque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Local físico onde os lotes são armazenados.
 * Composição: um Armazem contém uma lista de ItemEstoque.
 * A rastreabilidade exige saber em qual armazém cada lote está.
 */
public class Armazem {

    private final String codigoArmazem;
    private final String localizacao;
    private final Integer capacidadeMaxima;
    private final Double  temperaturaControladaC;
    private final List<ItemEstoque> itensArmazenados;

    public Armazem(String codigoArmazem, String localizacao,
                   Integer capacidadeMaxima, Double temperaturaControladaC) {
        this.codigoArmazem         = codigoArmazem;
        this.localizacao           = localizacao;
        this.capacidadeMaxima      = capacidadeMaxima;
        this.temperaturaControladaC = temperaturaControladaC;
        this.itensArmazenados      = new ArrayList<>();
    }

    // Getters
    public String  getCodigoArmazem()          { return codigoArmazem; }
    public String  getLocalizacao()            { return localizacao; }
    public Integer getCapacidadeMaxima()       { return capacidadeMaxima; }
    public Double  getTemperaturaControladaC() { return temperaturaControladaC; }

    /**
     * Retorna a lista de itens — permite adicionar itens externamente.
     * Em um sistema real usaríamos um método dedicado para encapsular melhor.
     */
    public List<ItemEstoque> getItensArmazenados() { return itensArmazenados; }

    /** Versão somente-leitura da lista — evita modificações não controladas. */
    public List<ItemEstoque> getItensArmazenadosReadOnly() {
        return Collections.unmodifiableList(itensArmazenados);
    }

    /** Adiciona um item ao armazém de forma encapsulada. */
    public void adicionarItem(ItemEstoque item) {
        itensArmazenados.add(item);
    }

    /** Calcula o total de unidades atualmente no armazém. */
    public int getTotalUnidades() {
        return itensArmazenados.stream()
                .mapToInt(ItemEstoque::getQuantidade)
                .sum();
    }

    /** Percentual de ocupação em relação à capacidade máxima. */
    public double getPercentualOcupacao() {
        if (capacidadeMaxima == null || capacidadeMaxima == 0) return 0;
        return (getTotalUnidades() * 100.0) / capacidadeMaxima;
    }

    @Override
    public String toString() {
        return "Armazem{" +
                "codigo='" + codigoArmazem + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", temperatura=" + temperaturaControladaC + "C" +
                ", itens=" + itensArmazenados.size() +
                ", ocupacao=" + String.format("%.1f", getPercentualOcupacao()) + "%" +
                '}';
    }
}