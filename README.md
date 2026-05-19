# LibbsTrack

Sistema de gerenciamento e rastreabilidade farmacêutica com prevenção de validade logística por Inteligência Artificial, desenvolvido como projeto acadêmico de Orientação a Objetos, com foco em **mostrar os fundamentos de POO.**

> Empresa parceira: **Libbs Farmacêutica**, segmento farmacêutico, com foco em conformidade Anvisa e inovação em gestão de estoque.

---

## Sobre o projeto

A Libbs enfrenta o desafio de rastrear lotes de medicamentos ao longo de toda a cadeia produtiva e logística, garantindo conformidade com as normas da Anvisa e evitando perdas por vencimento. O **LibbsTrack** resolve esse problema modelando o domínio farmacêutico em Java com os princípios de POO e simulando um sistema de IA para monitoramento preditivo de validade.

---

## Funcionalidades

- Cadastro de medicamentos e registro na Anvisa
- Controle de lotes com status automático (`OK`, `ALERTA`, `CRÍTICO`, `VENCIDO`)
- Inspeção de qualidade assinada por farmacêutico habilitado (CRF)
- Gestão de armazém com controle de temperatura e ocupação
- Monitoramento de prazo com alerta automático de IA
- Previsão de demanda via modelo LSTM
- Rastreabilidade completa de movimentações (origem → destino)
- Geração de relatório regulatório conforme BPF Anvisa RDC 658/2022
- Processo de recall de lotes com histórico
- Dashboard visual simulado (frontend estático)

---

## Conceitos de POO demonstrados

| Conceito | Onde aparece |
|---|---|
| **Herança** | `Farmaceutico extends Funcionario` · `Biotecnologia extends Medicamento` |
| **Polimorfismo** | `getDescricaoCargo()` e `toString()` sobrescritos nas subclasses |
| **Encapsulamento** | Atributos `private final`, setters seletivos, métodos de negócio internos |
| **Associação** | `ItemEstoque` agrega `Lote` + `Armazem` |
| **Composição** | `Armazem` compõe `List<ItemEstoque>` |
| **Façade** | `SistemaGerenciamentoLibbs` orquestra todas as entidades |

---

## Estrutura do projeto

```
libbs-track/
├── src/
│   └── com/libbs/track/
│       ├── app/
│       │   └── Principal.java              # Ponto de entrada
│       └── modelo/
│           ├── SistemaGerenciamentoLibbs.java
│           ├── estoque/
│           │   ├── Armazem.java
│           │   ├── ControleDePrazo.java
│           │   ├── RastreabilidadeMovimentacao.java
│           │   └── Recall.java
│           ├── ia/
│           │   ├── AlertaIA.java
│           │   ├── ModeloIA.java
│           │   └── PrevisaoDaDemanda.java
│           ├── logistica/
│           │   ├── Distribuidor.java
│           │   ├── Fornecedor.java
│           │   └── PedidoEntrega.java
│           ├── pessoa/
│           │   ├── Funcionario.java
│           │   └── Farmaceutico.java
│           ├── produto/
│           │   ├── Biotecnologia.java
│           │   ├── ItemEstoque.java
│           │   ├── Lote.java
│           │   ├── Medicamento.java
│           │   └── OrdemProducao.java
│           └── regulatorio/
│               ├── InspecaoDeQualidade.java
│               ├── RegistroAnvisa.java
│               └── RelatorioRegulatorio.java
├── frontend/
│   └── index.html
└── README.md
```

---

## Fluxo do sistema

```
Medicamento → RegistroAnvisa
     ↓
OrdemProducao → Lote → InspecaoDeQualidade
                 ↓
             ItemEstoque → Armazem
                 ↓
           ControleDePrazo → AlertaIA
                 ↓
          PrevisaoDaDemanda (ModeloIA)
                 ↓
    PedidoEntrega → Distribuidor → RastreabilidadeMovimentacao
                 ↓
         RelatorioRegulatorio → Anvisa
```

---

## Tecnologias

- **Java 17**
- **IntelliJ IDEA**

---

Projeto desenvolvido para a disciplina de **Orientação a Objetos**.

> Empresa escolhida: Libbs Farmacêutica  
> Problema/inovação: Gerenciamento e rastreabilidade dentro das normas da Anvisa com IA para prevenção de validade logística
