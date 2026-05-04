package com.libbs.track.modelo.produto;

import com.libbs.track.modelo.estoque.Armazem;
import java.time.LocalDate;

/**
 * Representa a presença de um Lote em um Armazem com quantidade e localização.
 * Separa o conceito de "produto" do conceito de "quanto temos agora e onde".
 * Exemplo de associação múltipla: conecta Lote + Armazem com atributos próprios.
 */
public class ItemEstoque {

    private final Lote      lote;
    private final Armazem   armazem;
    private int             quantidade;
    private final LocalDate dataEntrada;
    private String          localizacaoPrateleira; // ex: "B2-P3-N4"

    public ItemEstoque(Lote lote, Armazem armazem,
                       int quantidade, LocalDate dataEntrada) {
        this.lote                 = lote;
        this.armazem              = armazem;
        this.quantidade           = quantidade;
        this.dataEntrada          = dataEntrada;
        this.localizacaoPrateleira = "NAO_DEFINIDA";
    }

    public ItemEstoque(Lote lote, Armazem armazem, int quantidade,
                       LocalDate dataEntrada, String localizacaoPrateleira) {
        this.lote                 = lote;
        this.armazem              = armazem;
        this.quantidade           = quantidade;
        this.dataEntrada          = dataEntrada;
        this.localizacaoPrateleira = localizacaoPrateleira;
    }

    // Getters
    public Lote      getLote()                  { return lote; }
    public Armazem   getArmazem()               { return armazem; }
    public int       getQuantidade()            { return quantidade; }
    public LocalDate getDataEntrada()           { return dataEntrada; }
    public String    getLocalizacaoPrateleira() { return localizacaoPrateleira; }

    // Setters seletivos
    public void setQuantidade(int quantidade)                        { this.quantidade = quantidade; }
    public void setLocalizacaoPrateleira(String localizacaoPrateleira) { this.localizacaoPrateleira = localizacaoPrateleira; }

    @Override
    public String toString() {
        return "ItemEstoque{" +
                "lote=" + lote.getCodigoLote() +
                ", armazem='" + armazem.getCodigoArmazem() + '\'' +
                ", quantidade=" + quantidade +
                ", prateleira='" + localizacaoPrateleira + '\'' +
                '}';
    }
}