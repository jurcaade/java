package ex;

import java.time.LocalDate;

public class Pisica extends Animal{
    private float greutate;
    private String rasa;

    public Pisica(String nume, int inaltime, LocalDate data_nasterii, TipTalie talia, float greutate, String rasa) {
        super(nume, inaltime, data_nasterii, talia);
        this.greutate = greutate;
        this.rasa = rasa;
    }

    public Pisica() {
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    @Override
    public String toString() {
        return "Pisica{" + super.toString() + "greutate=" + greutate + ", rasa=" + rasa + '}';

    }
}

