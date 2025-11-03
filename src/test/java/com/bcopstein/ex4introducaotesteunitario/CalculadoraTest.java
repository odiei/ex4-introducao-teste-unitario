package com.bcopstein.ex4introducaotesteunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
        @Test
    public void somaSimples(){
        int rEsp = 35;
        int rObs = Calculadora.evaluate("10+12+3+5+1+4");
        assertEquals(rEsp, rObs);
    }

    @Test
    public void semSoma(){
        int rEsp = 10;
        int rObs = Calculadora.evaluate("10");
        assertEquals(rEsp, rObs);
    }
/*
    @Test
    public void operadorInvalido(){
        int rEsp = 7;
        int rObs = Calculadora.evaluate("10-3");
        assertEquals(rEsp, rObs);
    }
*/
}
