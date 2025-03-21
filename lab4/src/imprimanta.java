public class imprimanta extends  Echipament{
    private int ppm;
    private int dpi;
    private int pagini_cartus;
    private mod_tiparire modTiparire;


    public imprimanta(String denumire, int nr_inv, int pret, String zona_mag, stare_echipament stare_echipament, int ppm, int dpi, int pagini_cartus, mod_tiparire modTiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare_echipament);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pagini_cartus = pagini_cartus;
        this.modTiparire = modTiparire;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "imprimanta{" +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", pagini_cartus=" + pagini_cartus +
                ", modTiparire=" + modTiparire +
                "} " + super.toString();
    }
}
