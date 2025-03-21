public class SisCalc extends Echipament {

    private String tip_mon;
    private double vit_proc;
    private int hdd;
    private sistemoperare sistemOperare;


    public SisCalc(String denumire, int nr_inv, int pret, String zona_mag, stare_echipament stare_echipament, String tip_mon, double vit_proc, int hdd, sistemoperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stare_echipament);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.hdd = hdd;
        this.sistemOperare = sistemOperare;
    }

    public int getC_hdd() {
        return hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.hdd = hdd;
    }

    public sistemoperare getSistemoperate() {
        return sistemOperare;
    }

    public void setSistemoperate(String sistemoperate) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return "SisCalc{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", hdd=" + hdd +
                ", sistemOperare=" + sistemOperare +
                "} " + super.toString();
    }
}
