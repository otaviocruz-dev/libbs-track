package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.ItemEstoque;
import java.util.ArrayList;
import java.util.List;

public class Armazem {

    private String codigoArmazem;
    private String localizacao;
    private Integer capacidadeMaxima;
    private Double temperaturaControladaC;
    private List<ItemEstoque> itensArmazenados = new ArrayList<>();

    public Armazem(String codigoArmazem, String localizacao,
                   Integer capacidadeMaxima, Double temperaturaControladaC) {
        this.codigoArmazem = codigoArmazem;
        this.localizacao = localizacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.temperaturaControladaC = temperaturaControladaC;
    }

    public String getCodigoArmazem() { return codigoArmazem; }
    public String getLocalizacao() { return localizacao; }
    public Integer getCapacidadeMaxima() { return capacidadeMaxima; }
    public Double getTemperaturaControladaC() { return temperaturaControladaC; }
    public List<ItemEstoque> getItensArmazenados() { return itensArmazenados; }
}
