package com.bcopstein.ex4introducaotesteunitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumeralRomanoTest {
       private NumeralRomano romano;
   
   @BeforeEach
   public void inicializa(){
       romano = new NumeralRomano();
   }

   @Test
   public void testaSoma(){
       int rEsp = 18;
       int rObs = romano.convert("XVIII");
       assertEquals(rEsp,rObs);
   }

   @Test
   public void testaSub(){
       int rEsp = 19;
       int rObs = romano.convert("XIX");
       assertEquals(rEsp,rObs);
   }

   @Test
   public void testaSomaSub(){
       int rEsp = 1919;
       int rObs = romano.convert("MCMXIX");
       assertEquals(rEsp,rObs);
   }
   
   @Test
   public void testaVazio(){
       int rEsp = 0;
       int rObs = romano.convert("");
       assertEquals(rEsp,rObs);
   }
 /* 
   @Test
   public void testa4X(){
       int rEsp = 0;
       int rObs = romano.convert("XXXX");
       assertEquals(rEsp,rObs);
   }
 
   @Test
   public void testaInvalido(){
       int rEsp = 0;
       int rObs = romano.convert("ABZ");
       assertEquals(rEsp,rObs);
   }
*/   
}
