package ex;

import java.io.Serializable;

abstract public class Vehicul implements Serializable {
    private int viteza_max;
    private String combustibil;

    public Vehicul(int viteza_max, String combustibil) {
        this.viteza_max = viteza_max;
        this.combustibil = combustibil;
    }

    public Vehicul() {
    }

    public int getViteza_max() {
        return viteza_max;
    }

    public void setViteza_max(int viteza_max) {
        this.viteza_max = viteza_max;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "viteza_max=" + viteza_max +
                ", combustibil='" + combustibil + '\'' +
                '}';
    }
}
