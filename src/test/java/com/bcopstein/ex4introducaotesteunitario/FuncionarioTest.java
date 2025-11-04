package com.bcopstein.ex4introducaotesteunitario;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class FuncionarioTest{
    @Test
    void salarioLiquidoMaior5ke2k(){

        //O objetivo desse teste é verificar quando o salário bruto for
        //maior que 5k (limite do INSS) e maior que 2k500 (começa a pagar IR)
        //Serão apresentados os cálculos intermediários
        //utilizaremos o salario de 8000,00
        Funcionario funcionario;
        // Salário: R$ 8000,00
        // INSS: 5000 * 0.045 = R$ 225,00
        // IRPF: 8000 > 2500? Sim, então: (8000 - 2500) * 0.12 = 5500 * 0.12 = R$ 660,00
        // Salário líquido: 8000 - 225 - 660 = R$ 7115,00
        funcionario = new Funcionario(8000.0);
        assertEquals(225.0, funcionario.getINSS(), 0.01);
        assertEquals(660.0, funcionario.getIRPF(), 0.01);
        assertEquals(7115.0, funcionario.getSalarioLiquido(), 0.01);
    }
    @Test
    void salarioLiquido2k(){
        // O objetivo deste teste é verificar quando o salário bruto for
        // 2k (não deve pagar IRPF, deve pagar INSS sobre o salário inteiro)
        // Salário: R$ 2000,00
        // INSS: 2000 * 0.045 = R$ 90,00
        // IRPF: 2000 > 2500? Não -> 0.00
        // Salário líquido: 2000 - 90 - 0 = R$ 1910,00
        Funcionario funcionario = new Funcionario(2000.0);
        assertEquals(90.0, funcionario.getINSS(), 0.01);
        assertEquals(0.0, funcionario.getIRPF(), 0.01);
        assertEquals(1910.0, funcionario.getSalarioLiquido(), 0.01);
    }

    @Test
    void setSalarioBrutoNegativo(){
        // Verifica que setSalarioBruto lança IllegalArgumentException quando o valor é negativo
        Funcionario funcionario = new Funcionario(1000.0);
        assertThrows(IllegalArgumentException.class, () -> funcionario.setSalarioBruto(-500.0));
    }

    @Test
    void construtorComSalarioNegativo(){
        // Verifica que o construtor lança IllegalArgumentException quando o salário inicial for negativo
        assertThrows(IllegalArgumentException.class, () -> new Funcionario(-1000.0));
    }

    @Test
    void setSalarioBrutoZeroAceito(){
        // Verifica que setSalarioBruto aceita 0.0 (não lança exceção) e se atualiza os impostos corretamente
        Funcionario funcionario = new Funcionario(1000.0);
        funcionario.setSalarioBruto(0.0);
        assertEquals(0.0, funcionario.getSalarioBruto(), 0.01);
        assertEquals(0.0, funcionario.getINSS(), 0.01);
        assertEquals(0.0, funcionario.getIRPF(), 0.01);
        assertEquals(0.0, funcionario.getSalarioLiquido(), 0.01);
    }
    //todos esses testes passaram sem nenhum erro
}