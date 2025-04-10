package ex;

import java.util.Calendar;

public class Accelerat  extends Tren{
    private int numarLocuri;
    private boolean areVagonRestaurant;


    public Accelerat(int numarTren, int numarVagoane, Calendar dataUltimeiRevizii, int numarLocuri, boolean areVagonRestaurant) {
        super(numarTren, numarVagoane, dataUltimeiRevizii);
        this.numarLocuri = numarLocuri;
        this.areVagonRestaurant = areVagonRestaurant;
    }


    public Accelerat() {
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numarLocuri) {
        this.numarLocuri = numarLocuri;
    }

    public boolean isAreVagonRestaurant() {
        return areVagonRestaurant;
    }

    public void setAreVagonRestaurant(boolean areVagonRestaurant) {
        this.areVagonRestaurant = areVagonRestaurant;
    }

    @Override
    public String toString() {
        return "Accelerat{" + super.toString() +
                "numarLocuri=" + numarLocuri +
                ", areVagonRestaurant=" + areVagonRestaurant +
                '}';
    }
}
