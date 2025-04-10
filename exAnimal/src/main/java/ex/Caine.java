package ex;

import java.time.LocalDate;

public class Caine extends Animal {
    private boolean esteAdoptat;

    public Caine(String nume, int inaltime, LocalDate data_nasterii, TipTalie talia, boolean esteAdoptat) {
        super(nume, inaltime, data_nasterii, talia);
        this.esteAdoptat = esteAdoptat;
    }

    public Caine() {
    }

    public boolean isEsteAdoptat() {
        return esteAdoptat;
    }

    public void setEsteAdoptat(boolean esteAdoptat) {
        this.esteAdoptat = esteAdoptat;
    }


    @Override
    public String toString() {
        return "Caine{" + super.toString() + "esteAdoptat=" + esteAdoptat + '}';

    }
}
