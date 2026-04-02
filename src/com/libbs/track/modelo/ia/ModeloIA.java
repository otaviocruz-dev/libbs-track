package com.libbs.track.modelo.ia;

import java.time.LocalDate;

/**
 * Representa o modelo de machine learning utilizado para previsões.
 * Modelar o modelo como objeto permite trocar o algoritmo sem alterar o resto do sistema.
 */
public class ModeloIA {

    private String    nomeModelo;        // ex: "LSTM-Demanda-v2"
    private String    algoritmo;         // ex: "LSTM", "Random Forest", "XGBoost"
    private LocalDate dataTreinamento;
    private Double    acuraciaMedia;     // ex: 0.91 = 91%
    private String    versao;            // ex: "2.1.0"

    public ModeloIA(String nomeModelo, String algoritmo,
                    LocalDate dataTreinamento, Double acuraciaMedia, String versao) {
        this.nomeModelo       = nomeModelo;
        this.algoritmo        = algoritmo;
        this.dataTreinamento  = dataTreinamento;
        this.acuraciaMedia    = acuraciaMedia;
        this.versao           = versao;
    }

    public String    getNomeModelo()      { return nomeModelo; }
    public String    getAlgoritmo()       { return algoritmo; }
    public LocalDate getDataTreinamento() { return dataTreinamento; }
    public Double    getAcuraciaMedia()   { return acuraciaMedia; }
    public String    getVersao()          { return versao; }

    @Override
    public String toString() {
        return "ModeloIA{nome='" + nomeModelo + "', algoritmo='" + algoritmo + "', acuracia=" + (acuraciaMedia * 100) + "%, versao='" + versao + "'}";
    }
}