package com.libbs.track.app;

import com.libbs.track.modelo.estoque.Armazem;
import com.libbs.track.modelo.estoque.Recall;
import com.libbs.track.modelo.ia.ModeloIA;
import com.libbs.track.modelo.pessoa.Farmaceutico;
import com.libbs.track.modelo.pessoa.Funcionario;
import com.libbs.track.modelo.produto.ItemEstoque; //
import com.libbs.track.modelo.produto.Lote;
import com.libbs.track.modelo.produto.Medicamento;
import com.libbs.track.modelo.regulatorio.InspecaoDeQualidade;
import com.libbs.track.modelo.regulatorio.RegistroAnvisa;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe Principal do sistema LIBBS TRACK.
 *
 * Demonstra conceitos de:
 * - Orientação a Objetos
 * - Encapsulamento
 * - Herança
 * - Polimorfismo explícito
 * - Integração entre domínios
 */
public class Principal {

    public static void main(String[] args) {

        separador("SISTEMA LIBBS TRACK - INICIALIZANDO");

        /*
         * 1. CADASTRO DE MEDICAMENTO E REGISTRO NA ANVISA
         */
        separador("1. CADASTRO DE MEDICAMENTO");

        Medicamento glifage = new Medicamento(
                "Metformina",
                "Glifage XR 500mg",
                "500mg",
                "Comprimido de liberação prolongada",
                "1.0101.0317.001-0"
        );

        RegistroAnvisa registro = new RegistroAnvisa(
                "1.0101.0317.001-0",
                glifage,
                LocalDate.of(2020, 3, 15),
                LocalDate.of(2025, 3, 15),
                "REFERENCIA"
        );

        System.out.println("Registro válido (60 meses)? "
                + registro.estaValido(60));

        /*
         * 2. PRODUÇÃO E CRIAÇÃO DE LOTE
         */
        separador("2. PRODUÇÃO E CRIAÇÃO DE LOTE");

        Lote lote = new Lote(
                12345,
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2027, 1, 10),
                50000
        );

        System.out.println("Lote criado: " + lote.getCodigoLote());

        /*
         * 3. INSPEÇÃO DE QUALIDADE (POLIMORFISMO EXPLÍCITO)
         */
        separador("3. INSPEÇÃO DE QUALIDADE");

        Funcionario funcionario = new Farmaceutico(
                "João Silva",
                123456,
                "Controle de Qualidade",
                10,
                "Fábrica SP",
                LocalTime.of(8, 0),
                LocalTime.of(17, 0),
                "DIURNO"
        );

        // Polimorfismo: método sobrescrito é resolvido em tempo de execução
        System.out.println(funcionario.getDescricaoCargo());

        InspecaoDeQualidade inspecao = new InspecaoDeQualidade();
        inspecao.setLoteInspecionado(lote);
        inspecao.setFarmaceuticoResponsavel((Farmaceutico) funcionario);
        inspecao.setDataInspecao(LocalDate.now());
        inspecao.setResultado("APROVADO");

        System.out.println("Inspeção realizada com sucesso.");

        /*
         * 4. ENTRADA DO LOTE NO ARMAZÉM
         */
        separador("4. ENTRADA NO ARMAZÉM");

        Armazem armazem = new Armazem(
                "ARM-SP-01",
                "São Paulo - SP",
                100000,
                20.0
        );

        ItemEstoque itemEstoque = new ItemEstoque(
                lote,
                armazem,
                50000,
                LocalDate.now()
        );

        System.out.println("Lote armazenado no armazém.");

        /*
         * 5. MODELO DE INTELIGÊNCIA ARTIFICIAL
         */
        separador("5. MODELO DE IA");

        ModeloIA modeloIA = new ModeloIA(
                "LSTM-Demanda-v2",
                "LSTM",
                LocalDate.of(2024, 10, 10),
                0.91,
                "2.1.0"
        );

        System.out.println("Modelo de IA carregado: " + modeloIA);

        /*
         * 6. PROCESSO DE RECALL
         */
        separador("6. PROCESSO DE RECALL");

        Recall recall = new Recall(
                "RC-001",
                lote,
                "Contaminação microbiológica",
                LocalDate.now(),
                "ABERTO"
        );

        System.out.println("Recall iniciado: " + recall);

        recall.setStatusRecall("CONCLUIDO");
        System.out.println("Recall finalizado.");

        separador("SISTEMA FINALIZADO COM SUCESSO");
    }

    private static void separador(String titulo) {
        System.out.println("\n========================================");
        System.out.println("  " + titulo);
        System.out.println("========================================");
    }
}