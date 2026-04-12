package com.libbs.track.modelo.produto;

import com.libbs.track.modelo.estoque.Armazem;
import java.time.LocalDate;

public class ItemEstoque {

    private Lote lote;
    private Armazem armazem;
    private int quantidade;
    private LocalDate dataEntrada;

    public ItemEstoque(Lote lote, Armazem armazem,
                       int quantidade, LocalDate dataEntrada) {
        this.lote = lote;
        this.armazem = armazem;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
    }
}
