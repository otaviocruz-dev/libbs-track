package com.libbs.track.modelo.estoque;

import com.libbs.track.modelo.produto.ItemEstoque;

import java.util.List;

public class Armazem {
    private String codigoArmazem;
    private String localizacao;
    private Integer capacidadeMaxima;
    private Double temperaturaControladaC;
    private List<ItemEstoque> itensArmazenados;
}
