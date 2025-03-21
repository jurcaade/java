public class copiator extends Echipament {

    private int paginiToner;
    private format_copiere formatCopiere;

    public copiator(String denumire, int nr_inv, int pret, String zona_mag, stare_echipament stare_echipament, int paginiToner, format_copiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, stare_echipament);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    public format_copiere getFormat() {
        return formatCopiere;
    }


    public void setPaginiToner(int paginiToner) {
        this.paginiToner = paginiToner;
    }

    public void setFormatCopiere(format_copiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return "copiator{" +
                "paginiToner=" + paginiToner +
                ", formatCopiere=" + formatCopiere +
                "} " + super.toString();
    }
}
