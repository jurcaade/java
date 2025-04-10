package ex;

import java.time.LocalDate;

public class Animal {
    private String nume;
    private int inaltime;
    private LocalDate data_nasterii;
    private TipTalie talia;

    public Animal(String nume, int inaltime, LocalDate data_nasterii, TipTalie talia) {
        this.nume = nume;
        this.inaltime = inaltime;
        this.data_nasterii = data_nasterii;
        this.talia = talia;
    }

    public Animal() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public LocalDate getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(LocalDate data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public TipTalie getTalia() {
        return talia;
    }

    public void setTalia(TipTalie talia) {
        this.talia = talia;
    }

    public int getVarsta()
    {
        LocalDate data_curenta = LocalDate.now();
        int varsta = data_curenta.getYear()- this.data_nasterii.getYear();
        return varsta;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "nume='" + nume + '\'' +
                ", inaltime=" + inaltime +
                ", data_nasterii=" + data_nasterii +
                ", talia=" + talia +", "
                ;
    }
}
