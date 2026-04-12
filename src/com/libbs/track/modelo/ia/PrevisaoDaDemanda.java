package com.libbs.track.modelo.ia;

import com.libbs.track.modelo.produto.Medicamento;
import java.time.LocalDate;

public class PrevisaoDaDemanda {

    private Medicamento medicamento;
    private int quantidadePrevista;
    private String periodo;
    private LocalDate dataGeracao;
    private double acuracia;

    public PrevisaoDaDemanda(Medicamento medicamento, int quantidadePrevista,
                             String periodo, double acuracia) {
        this.medicamento = medicamento;
        this.quantidadePrevista = quantidadePrevista;
        this.periodo = periodo;
        this.acuracia = acuracia;
        this.dataGeracao = LocalDate.now();
    }
}