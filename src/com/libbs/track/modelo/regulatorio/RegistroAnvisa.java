package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.produto.Medicamento;

import java.time.LocalDate;

/**
 * Representa o registro de um medicamento junto à ANVISA.
 * Sem esse registro, o medicamento não pode ser produzido ou comercializado.
 */
public class RegistroAnvisa {

    private String numeroRegistro;
    private Medicamento medicamentoRegistrado;
    private LocalDate dataConcessao;
    private LocalDate dataVencimentoRegistro;
    private String categoriaRegistro;
    private LocalDate dataEmissao;

    /**
     * Construtor completo.
     * O objeto já nasce em um estado válido.
     */
    public RegistroAnvisa(String numeroRegistro,
                          Medicamento medicamentoRegistrado,
                          LocalDate dataConcessao,
                          LocalDate dataVencimentoRegistro,
                          String categoriaRegistro) {

        this.numeroRegistro = numeroRegistro;
        this.medicamentoRegistrado = medicamentoRegistrado;
        this.dataConcessao = dataConcessao;
        this.dataVencimentoRegistro = dataVencimentoRegistro;
        this.categoriaRegistro = categoriaRegistro;

        // A data de emissão ocorre no momento da concessão
        this.dataEmissao = dataConcessao;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public Medicamento getMedicamentoRegistrado() {
        return medicamentoRegistrado;
    }

    public LocalDate getDataConcessao() {
        return dataConcessao;
    }

    public LocalDate getDataVencimentoRegistro() {
        return dataVencimentoRegistro;
    }

    public String getCategoriaRegistro() {
        return categoriaRegistro;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    /**
     * Verifica se o registro ainda é válido considerando
     * um período em meses a partir da data de emissão.
     */
    public boolean estaValido(int mesesDeValidade) {
        LocalDate dataExpiracao = dataEmissao.plusMonths(mesesDeValidade);
        return LocalDate.now().isBefore(dataExpiracao);
    }

    @Override
    public String toString() {
        return "RegistroAnvisa{" +
                "numeroRegistro='" + numeroRegistro + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", categoriaRegistro='" + categoriaRegistro + '\'' +
                '}';
    }
}