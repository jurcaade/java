package ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tren {
    private int numarTren;
    private int numarVagoane;
    private Calendar dataUltimeiRevizii;

    public Tren(int numarTren, int numarVagoane, Calendar dataUltimeiRevizii) {
        this.numarTren = numarTren;
        this.numarVagoane = numarVagoane;
        this.dataUltimeiRevizii = dataUltimeiRevizii;
    }

    public Tren() {
    }

    public int getNumarTren() {
        return numarTren;
    }

    public void setNumarTren(int numarTren) {
        this.numarTren = numarTren;
    }

    public int getNumarVagoane() {
        return numarVagoane;
    }

    public void setNumarVagoane(int numarVagoane) {
        this.numarVagoane = numarVagoane;
    }

    public Calendar getDataUltimeiRevizii() {
        return dataUltimeiRevizii;
    }

    public void setDataUltimeiRevizii(Calendar dataUltimeiRevizii) {
        this.dataUltimeiRevizii = dataUltimeiRevizii;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Tren{" +
                "numarTren=" + numarTren +
                ", numarVagoane=" + numarVagoane +
                ", dataUltimeiRevizii=" + sdf.format(dataUltimeiRevizii.getTime()) +
                '}';
    }
}
