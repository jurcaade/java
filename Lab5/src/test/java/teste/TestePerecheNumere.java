package teste;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import exercitiul1.PerecheNumere;

public class TestePerecheNumere {
    @Test
    void test1_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(1,2);
        assertTrue(p.isFibonacci());
    }
    @Test
    void test2_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(1,4);
        assertFalse(p.isFibonacci());
    }
    @Test
    void test3_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(1,1);
        assertTrue(p.isFibonacci());
    }
    @Test
    void test1_cmmmc()
    {
        PerecheNumere p = new PerecheNumere(1,2);
        assertEquals(2,p.cmmmc());
    }

    @Test
    void test2_cmmmc() {
        PerecheNumere p = new PerecheNumere(4, 5);
        assertEquals(20, p.cmmmc());
    }

    @Test
    void test3_cmmmc() {
        PerecheNumere p = new PerecheNumere(6, 3);
        assertTrue(p.cmmmc() == 6);
    }


}