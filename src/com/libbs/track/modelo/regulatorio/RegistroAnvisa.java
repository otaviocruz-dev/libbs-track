package com.libbs.track.modelo.regulatorio;

import com.libbs.track.modelo.produto.Medicamento;

import java.time.LocalDate;

public class RegistroAnvisa {
    private String numeroRegistro;
    private Medicamento medicamentoRegistrado;
    private LocalDate dataConcessao;
    private LocalDate dataVencimentoRegistro;
    private String categoriaRegistro;
    private LocalDate dataEmissao;

    public RegistroAnvisa(String numeroRegistro, Medicamento medicamentoRegistrado, LocalDate dataConcessao, LocalDate dataVencimentoRegistro, String categoriaRegistro) {
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Medicamento getMedicamentoRegistrado() {
        return medicamentoRegistrado;
    }

    public void setMedicamentoRegistrado(Medicamento medicamentoRegistrado) {
        this.medicamentoRegistrado = medicamentoRegistrado;
    }

    public LocalDate getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(LocalDate dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public LocalDate getDataVencimentoRegistro() {
        return dataVencimentoRegistro;
    }

    public void setDataVencimentoRegistro(LocalDate dataVencimentoRegistro) {
        this.dataVencimentoRegistro = dataVencimentoRegistro;
    }

    public String getCategoriaRegistro() {
        return categoriaRegistro;
    }

    public void setCategoriaRegistro(String categoriaRegistro) {
        this.categoriaRegistro = categoriaRegistro;
    }

    public boolean estaValido(int mesesDeValidade) {
        LocalDate expiracao = dataEmissao.plusMonths(mesesDeValidade);
        return LocalDate.now().isBefore(expiracao);
    }
}
