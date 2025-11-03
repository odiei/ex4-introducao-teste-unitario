package com.bcopstein.ex4introducaotesteunitario;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class EncomendaTest {
    @Test
    public void testaEncomendaNormal(){
        int[] rEsp = {2,4};
        int[] rObs = Encomenda.qtdadeBarras(10, 5, 22);
        assertArrayEquals(rEsp, rObs);
    }
    
}
