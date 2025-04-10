package teste;

import ex.Animal;
import ex.TipTalie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVarstaAnimal {
    @Test
    void test1() {
        Animal animal = new Animal("Animal1", 12, LocalDate.of(2004, 1, 1), TipTalie.MEDIE);
        assertEquals(21, animal.getVarsta());
    }

    @Test
    void test2() {
        Animal animal = new Animal("Animal1", 12, LocalDate.of(2014, 1, 1), TipTalie.MEDIE);
        assertTrue(animal.getVarsta() == 11);
    }
}

