package com.libbs.track.modelo.produto;

import com.libbs.track.modelo.estoque.Armazem;

import java.time.LocalDate;

public class ItemEstoque {
    private Lote Lote;
    private Armazem Armazem;
    private Integer quantidadeDisponivel;
    private LocalDate dataEntrada;
    private String localizacaoPrateleira;

    public Lote getLote() {
        return Lote;
    }

    public void setLote(Lote lote) {
        Lote = lote;
    }

    public Armazem getArmazem() {
        return Armazem;
    }

    public void setArmazem(Armazem armazem) {
        Armazem = armazem;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getLocalizacaoPrateleira() {
        return localizacaoPrateleira;
    }

    public void setLocalizacaoPrateleira(String localizacaoPrateleira) {
        this.localizacaoPrateleira = localizacaoPrateleira;
    }
}
