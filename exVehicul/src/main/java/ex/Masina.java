package ex;

import java.io.Serializable;

public class Masina extends Vehicul implements Serializable {
    private int nr_locuri;
    private String firma;

    public Masina(int viteza_max, String combustibil, int nr_locuri, String firma) {
        super(viteza_max, combustibil);
        this.nr_locuri = nr_locuri;
        this.firma = firma;
    }

    public Masina() {
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "Masina{" + super.toString() +
                "nr_locuri=" + nr_locuri +
                ", firma='" + firma + '\'' +
                '}';
    }
}
