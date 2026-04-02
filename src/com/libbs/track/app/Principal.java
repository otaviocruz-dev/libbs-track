package com.libbs.track.app;

import com.libbs.track.modelo.estoque.*;
import com.libbs.track.modelo.ia.*;
import com.libbs.track.modelo.logistica.*;
import com.libbs.track.modelo.pessoa.*;
import com.libbs.track.modelo.produto.*;
import com.libbs.track.modelo.regulatorio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * VAMOS TENTAR FAZER ISSO AQUI:
 *   1. Cadastro de medicamento e registro Anvisa
 *   2. Produção e criação de lote
 *   3. Inspeção de qualidade por farmacêutico
 *   4. Entrada no armazém como item de estoque
 *   5. Monitoramento de prazo com alerta de IA
 *   6. Previsão de demanda pelo modelo de IA
 *   7. Geração de relatório regulatório
 *   8. Pedido de entrega para distribuidor com rastreabilidade
 *   9. Polimorfismo: Farmaceutico se comporta como Funcionario
 */

public class Principal {

    public static void main(String[] args) {

        separador("SISTEMA LIBBS TRACK - INICIALIZANDO");

        // 1. MEDICAMENTO + REGISTRO ANVISA

        separador("1. CADASTRO DE MEDICAMENTO");

        Medicamento glifage = new Medicamento("Metformina", "Glifage XR 500mg", "500mg", "Comprimido de liberação prolongada", "1.0101.0317.001-0");

        RegistroAnvisa registroGlifage = new RegistroAnvisa("1.0101.0317.001-0", glifage, LocalDate.of(2020, 3, 15), LocalDate.of(2025, 3, 15), "REFERENCIA");

        System.out.println("Medicamento cadastrado: " + glifage);
        System.out.println("Registro Anvisa: " + registroGlifage);
        System.out.println("Registro valido: " + registroGlifage.estaValido(60));
    }


    // Separador de texto, igual o que fizemos no Elgin Printer
    private static void separador ( String titulo) {
        System.out.println("\n========================================");
        System.out.println("  " + titulo);
        System.out.println("========================================");
    }
}