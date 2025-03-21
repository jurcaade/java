public class Echipament {
    private String denumire;
    private int nr_inv;
    private int pret;
    private String zona_mag;
    private stare_echipament stare_echipament;

    public Echipament(String denumire, int nr_inv, int pret, String zona_mag, stare_echipament stare_echipament) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare_echipament = stare_echipament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }




    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare_echipament='" + stare_echipament + '\'' +
                '}';
    }
}
