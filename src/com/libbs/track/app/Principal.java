package com.libbs.track.app;

import com.libbs.track.modelo.SistemaGerenciamentoLibbs;
import com.libbs.track.modelo.estoque.Armazem;
import com.libbs.track.modelo.estoque.ControleDePrazo;
import com.libbs.track.modelo.estoque.RastreabilidadeMovimentacao;
import com.libbs.track.modelo.estoque.Recall;
import com.libbs.track.modelo.ia.AlertaIA;
import com.libbs.track.modelo.ia.ModeloIA;
import com.libbs.track.modelo.ia.PrevisaoDaDemanda;
import com.libbs.track.modelo.logistica.Distribuidor;
import com.libbs.track.modelo.logistica.PedidoEntrega;
import com.libbs.track.modelo.pessoa.Farmaceutico;
import com.libbs.track.modelo.pessoa.Funcionario;
import com.libbs.track.modelo.produto.Biotecnologia;
import com.libbs.track.modelo.produto.ItemEstoque;
import com.libbs.track.modelo.produto.Lote;
import com.libbs.track.modelo.produto.Medicamento;
import com.libbs.track.modelo.produto.OrdemProducao;
import com.libbs.track.modelo.regulatorio.InspecaoDeQualidade;
import com.libbs.track.modelo.regulatorio.RegistroAnvisa;
import com.libbs.track.modelo.regulatorio.RelatorioRegulatorio;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Ponto de entrada do sistema LibbsTrack.

 * Demonstra os 4 pilares de POO aplicados ao contexto farmacêutico da Libbs:

 *  ENCAPSULAMENTO  — atributos private, final onde cabível, setters seletivos,
 *                    métodos de negócio que escondem lógica interna
 *  HERANÇA         — Farmaceutico extends Funcionario
 *                    Biotecnologia extends Medicamento
 *  POLIMORFISMO    — mesmo metodo getDescricaoCargo() com comportamento diferente
 *                    dependendo do tipo real do objeto em tempo de execução
 *  ASSOCIAÇÃO /    — ItemEstoque agrega Lote + Armazem
 *  COMPOSIÇÃO        Armazem compõe List<ItemEstoque>
 *                    SistemaGerenciamentoLibbs orquestra tudo (Façade)
 */
public class Principal {

    public static void main(String[] args) {

        separador("SISTEMA LIBBS TRACK - INICIALIZANDO");

        // ============================================================
        // 1. CADASTRO DE MEDICAMENTO E REGISTRO NA ANVISA
        //    Medicamento é a entidade central — tudo gira em torno dela
        // ============================================================
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
                LocalDate.of(2030, 3, 15),
                "REFERENCIA"
        );

        System.out.println("Medicamento cadastrado: " + glifage);
        System.out.println("Registro Anvisa: " + registro);
        System.out.println("Registro válido (60 meses)? " + registro.estaValido(60));

        // ============================================================
        // 2. BIOTECNOLOGIA — HERANÇA DE MEDICAMENTO
        //    Biotecnologia extends Medicamento:
        //    toString() sobrescrito → polimorfismo com Medicamento
        // ============================================================
        separador("2. BIOTECNOLOGIA - HERANÇA DE MEDICAMENTO");

        Biotecnologia altekin = new Biotecnologia(
                "Adalimumabe",
                "Altekin 40mg",
                "40mg/0,8mL",
                "Solução injetável",
                "1.0101.0317.002-8",
                "Imunologia",
                "Anticorpo Monoclonal",
                "Libbs Farmacêutica",
                "COMERCIAL",
                "Tratamento de artrite reumatoide"
        );

        // POLIMORFISMO: variável do tipo Medicamento aponta para Biotecnologia
        // toString() da subclasse é chamado — não o da classe pai
        Medicamento medicamentoBio = altekin;
        System.out.println("Via referência Medicamento : " + medicamentoBio);
        System.out.println("Via referência Biotecnologia: " + altekin);
        System.out.println("Área de atuação: " + altekin.getAreaAtuacao());
        System.out.println("Tecnologia: " + altekin.getTecnologiaUtilizada());

        // ============================================================
        // 3. ORDEM DE PRODUÇÃO + LOTE
        //    OrdemProducao inicia o ciclo produtivo
        //    getPercentualConclusao() demonstra metodo de negócio encapsulado
        // ============================================================
        separador("3. ORDEM DE PRODUÇÃO E LOTE");

        Lote lote = new Lote(
                12345,
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2027, 1, 10),
                50000
        );

        OrdemProducao ordem = new OrdemProducao(lote, "Carlos Andrade", 50000);
        ordem.setQuantidadeProduzida(50000);
        ordem.setStatus("CONCLUIDA");

        System.out.println("Ordem de produção: " + ordem);
        System.out.println("Conclusão: " + ordem.getPercentualConclusao() + "%");
        System.out.println("Lote válido? " + lote.estaValido());

        // ============================================================
        // 4. INSPEÇÃO DE QUALIDADE — HERANÇA E POLIMORFISMO
        //    Farmaceutico extends Funcionario
        //    getDescricaoCargo() sobrescrito — polimorfismo explícito
        //    InspecaoDeQualidade agora usa construtor completo
        // ============================================================
        separador("4. INSPEÇÃO DE QUALIDADE");

        // HERANÇA: Farmaceutico é um Funcionario especializado
        Funcionario funcionario = new Farmaceutico(
                "Dra. Ana Beatriz Costa",
                123456,
                "Controle de Qualidade",
                10,
                "Fábrica SP",
                LocalTime.of(8, 0),
                LocalTime.of(17, 0),
                "DIURNO"
        );

        // POLIMORFISMO: mesma assinatura, comportamento diferente por tipo real
        System.out.println("Via referência Funcionario : " + funcionario.getDescricaoCargo());

        Farmaceutico farmaceutico = (Farmaceutico) funcionario;
        System.out.println("Via referência Farmaceutico: " + farmaceutico.getDescricaoCargo());

        // Usando construtor completo — melhor prática: objeto nasce em estado válido
        InspecaoDeQualidade inspecao = new InspecaoDeQualidade(
                lote,
                farmaceutico,
                LocalDate.now(),
                "APROVADO",
                "Nenhuma não-conformidade encontrada. Lote liberado."
        );

        System.out.println("Inspeção: " + inspecao);
        System.out.println("Lote aprovado? " + inspecao.isAprovada());

        // Lote aprovado — atualiza status via setter seletivo
        lote.setStatus("APROVADO");
        System.out.println("Status do lote: " + lote.getStatus());

        // ============================================================
        // 5. ARMAZÉM — COMPOSIÇÃO + MÉTODOS DE NEGÓCIO
        //    adicionarItem() encapsula a adição
        //    getTotalUnidades() e getPercentualOcupacao() são comportamentos
        //    da classe, não lógica espalhada no main
        // ============================================================
        separador("5. ENTRADA NO ARMAZÉM");

        Armazem armazem = new Armazem(
                "ARM-SP-01",
                "Embu das Artes - SP",
                100000,
                20.0
        );

        // ItemEstoque com construtor de 5 argumentos (com prateleira)
        ItemEstoque itemEstoque = new ItemEstoque(
                lote,
                armazem,
                50000,
                LocalDate.now(),
                "B2-P3-N4"
        );

        // COMPOSIÇÃO: usa método encapsulado em vez de acessar a lista diretamente
        armazem.adicionarItem(itemEstoque);

        System.out.println("Armazém: " + armazem);
        System.out.println("Total de unidades: " + armazem.getTotalUnidades());
        System.out.println("Ocupação: " + String.format("%.1f", armazem.getPercentualOcupacao()) + "%");
        System.out.println("Prateleira do item: " + itemEstoque.getLocalizacaoPrateleira());

        // ============================================================
        // 6. CONTROLE DE PRAZO + ALERTA DE IA
        //    precisaDeAlerta() encapsula a lógica de decisão
        //    Lote próximo ao vencimento dispara AlertaIA automaticamente
        // ============================================================
        separador("6. CONTROLE DE PRAZO E ALERTA DE IA");

        Lote loteProximoVencer = new Lote(
                99999,
                LocalDate.of(2023, 6, 1),
                LocalDate.now().plusDays(25),   // vence em 25 dias → status CRITICO
                3000
        );

        ControleDePrazo controle = new ControleDePrazo(loteProximoVencer, 90);

        System.out.println("Controle de prazo: " + controle);

        // precisaDeAlerta() encapsula a regra de negócio — o main não precisa
        // saber quais status disparam alerta, só pergunta se precisa
        if (controle.precisaDeAlerta()) {
            AlertaIA alerta = new AlertaIA(
                    "VALIDADE",
                    controle.getStatusPrazo(),
                    loteProximoVencer,
                    LocalDateTime.now(),
                    "Lote " + loteProximoVencer.getCodigoLote()
                            + " vence em " + controle.getDiasParaVencer()
                            + " dias. Acionar distribuição imediatamente."
            );
            System.out.println(alerta);
        }

        // ============================================================
        // 7. MODELO DE IA + PREVISÃO DE DEMANDA
        //    getAcuraciaFormatada() demonstra método utilitário encapsulado
        // ============================================================
        separador("7. MODELO DE IA E PREVISÃO DE DEMANDA");

        ModeloIA modeloIA = new ModeloIA(
                "LSTM-Demanda-v2",
                "LSTM",
                LocalDate.of(2024, 10, 10),
                0.91,
                "2.1.0"
        );

        PrevisaoDaDemanda previsao = new PrevisaoDaDemanda(
                glifage,
                120000,
                "2025-06",
                modeloIA.getAcuraciaMedia()
        );

        System.out.println("Modelo: " + modeloIA);
        System.out.println("Previsão: " + previsao);
        System.out.println("Acurácia formatada: " + previsao.getAcuraciaFormatada());

        // ============================================================
        // 8. LOGÍSTICA — DISTRIBUIÇÃO E RASTREABILIDADE
        //    RastreabilidadeMovimentacao é imutável — sem setters
        //    Registro criado e nunca mais alterado, como um log auditável
        // ============================================================
        separador("8. DISTRIBUIÇÃO E RASTREABILIDADE");

        Distribuidor drogasil = new Distribuidor(
                "Drogasil",
                "61.412.110/0001-03",
                "FARMACIA",
                "São Paulo - SP",
                "logistica@drogasil.com.br"
        );

        PedidoEntrega pedido = new PedidoEntrega(
                "PED-2025-0198",
                lote,
                drogasil,
                10000,
                LocalDate.now(),
                "ENVIADO"
        );

        // Registro imutável — nasce completo, não tem setters
        RastreabilidadeMovimentacao rastreio = new RastreabilidadeMovimentacao(
                1L,
                lote,
                "ARM-SP-01 | Embu das Artes",
                "Drogasil | São Paulo - SP",
                10000.0
        );

        System.out.println("Pedido: " + pedido);
        System.out.println("Distribuidor: " + drogasil);
        System.out.println("Rastreio: " + rastreio);

        // ============================================================
        // 9. RELATÓRIO REGULATÓRIO
        //    Usando construtor completo — melhor prática aplicada
        //    getCabecalho() e estaValido() são métodos de negócio encapsulados
        // ============================================================
        separador("9. RELATÓRIO REGULATÓRIO");

        // Usando construtor completo (nova melhoria aplicada)
        RelatorioRegulatorio relatorio = new RelatorioRegulatorio(
                "REL-2025-0042",
                "INSPECAO",
                LocalDate.now(),
                farmaceutico,
                "Inspeção do lote 12345 (Glifage XR 500mg) realizada em "
                        + inspecao.getDataInspecao()
                        + ". Resultado: APROVADO. "
                        + "Lote liberado para distribuição conforme BPF Anvisa RDC 658/2022."
        );

        System.out.println("Cabeçalho: " + relatorio.getCabecalho());
        System.out.println("Válido por 12 meses? " + relatorio.estaValido(12));
        System.out.println("Relatório: " + relatorio);

        // ============================================================
        // 10. PROCESSO DE RECALL
        //     Acionado pela detecção de risco via IA
        // ============================================================
        separador("10. PROCESSO DE RECALL");

        Recall recall = new Recall(
                "RC-001",
                loteProximoVencer,
                "Contaminação microbiológica detectada pelo sistema de IA",
                LocalDate.now(),
                "ABERTO"
        );

        System.out.println("Recall iniciado: " + recall);
        recall.setStatusRecall("CONCLUIDO");
        System.out.println("Status atualizado: " + recall.getStatusRecall());

        // ============================================================
        // 11. SISTEMA DE GERENCIAMENTO — ORQUESTRADOR (FAÇADE)
        //     Visão consolidada de todo o estado do sistema
        //     getLotes() retorna lista imutável — encapsulamento protegido
        // ============================================================
        separador("11. SISTEMA DE GERENCIAMENTO LIBBS");

        List<Lote> lotes = new ArrayList<>();
        lotes.add(lote);
        lotes.add(loteProximoVencer);

        List<Medicamento> produtos = new ArrayList<>();
        produtos.add(glifage);
        produtos.add(altekin);

        List<RastreabilidadeMovimentacao> movimentacoes = new ArrayList<>();
        movimentacoes.add(rastreio);

        SistemaGerenciamentoLibbs sistema = new SistemaGerenciamentoLibbs(
                lotes,
                produtos,
                movimentacoes,
                "LibbsTrack",
                "1.0.0",
                farmaceutico.getNome()
        );

        System.out.println("Sistema: " + sistema);
        System.out.println("Lotes gerenciados: " + sistema.getLotes().size());
        System.out.println("Produtos cadastrados: " + sistema.getProdutos().size());
        System.out.println("Movimentações registradas: " + sistema.getMovimentacoes().size());

        // Troca de usuário via setter seletivo
        sistema.setUsuarioAtual("admin.libbs");
        System.out.println("Usuário atualizado: " + sistema.getUsuarioAtual());

        separador("SISTEMA FINALIZADO COM SUCESSO");
    }

    private static void separador(String titulo) {
        System.out.println("\n========================================");
        System.out.println("  " + titulo);
        System.out.println("========================================");
    }
}