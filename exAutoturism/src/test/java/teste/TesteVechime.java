package teste;

import ex.Motocicleta;
import ex.TipCombustibil;

import java.time.LocalDate;
import ex.Motocicleta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteVechime {
    @Test
    void test1()
    {
        Motocicleta m1=new Motocicleta("Bmw", TipCombustibil.BENZINA, LocalDate.of(2014,7,8));
        assertEquals(11,m1.getVechime());
    }

    @Test
    void test2()
    {
        Motocicleta m2=new Motocicleta("Audi", TipCombustibil.MOTORINA, LocalDate.of(2010,2,18));
        assertTrue(m2.getVechime()==15);
    }
}
