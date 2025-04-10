package ex;

import java.io.Serializable;

public class Camion extends Vehicul implements Serializable
{
    private int incarcatura_max;

    public Camion(int viteza_max, String combustibil, int incarcatura_max) {
        super(viteza_max, combustibil);
        this.incarcatura_max = incarcatura_max;
    }

    public Camion() {
    }

    public int getIncarcatura_max() {
        return incarcatura_max;
    }

    public void setIncarcatura_max(int incarcatura_max) {
        this.incarcatura_max = incarcatura_max;
    }

    @Override
    public String toString() {
        return "Camion{" + super.toString() +
                "incarcatura_max=" + incarcatura_max +
                '}';
    }
}
