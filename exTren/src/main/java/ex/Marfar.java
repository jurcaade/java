package ex;

import java.util.Calendar;

public class Marfar extends Tren{
    private String marfa;

    public Marfar(int numarTren, int numarVagoane, Calendar dataUltimeiRevizii, String marfa) {
        super(numarTren, numarVagoane, dataUltimeiRevizii);
        this.marfa = marfa;
    }

    public Marfar() {
    }

    public String getMarfa() {
        return marfa;
    }

    public void setMarfa(String marfa) {
        this.marfa = marfa;
    }

    @Override
    public String toString() {
        return "Marfar{" + super.toString() +
                "marfa='" + marfa + '\'' +
                '}';
    }
}
