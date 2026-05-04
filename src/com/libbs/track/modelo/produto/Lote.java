package com.libbs.track.modelo.produto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Conjunto de unidades de um medicamento fabricadas no mesmo processo.
 * É a unidade de rastreabilidade exigida pela Anvisa — tudo é rastreado
 * no nível de lote, não de unidade.
 */
public class Lote {

    private final int       codigoLote;
    private final LocalDate dataFabricacao;
    private final LocalDate dataValidade;
    private int             quantidade;
    private String          status;  // "ATIVO", "APROVADO", "REPROVADO", "VENCIDO", "RECALL"

    public Lote(int codigoLote, LocalDate dataFabricacao,
                LocalDate dataValidade, int quantidade) {
        this.codigoLote    = codigoLote;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade  = dataValidade;
        this.quantidade    = quantidade;
        this.status        = "ATIVO";
    }

    // Getters
    public int       getCodigoLote()    { return codigoLote; }
    public LocalDate getDataFabricacao(){ return dataFabricacao; }
    public LocalDate getDataValidade()  { return dataValidade; }
    public int       getQuantidade()    { return quantidade; }
    public String    getStatus()        { return status; }

    // Setters seletivos — datas e código são imutáveis após fabricação
    public void setStatus(String status)       { this.status = status; }
    public void setQuantidade(int quantidade)  { this.quantidade = quantidade; }

    /** Verifica se o lote está dentro do prazo de validade. */
    public boolean estaValido() {
        return LocalDate.now().isBefore(dataValidade);
    }

    @Override
    public String toString() {
        return "Lote{" +
                "codigo=" + codigoLote +
                ", validade=" + dataValidade +
                ", quantidade=" + quantidade +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lote)) return false;
        Lote l = (Lote) o;
        return codigoLote == l.codigoLote;
    }

    @Override
    public int hashCode() { return Objects.hash(codigoLote); }
}