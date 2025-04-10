package ex;

public class Autoturism {
    private String firma;
    private TipCombustibil combustibil;

    public Autoturism(String firma, TipCombustibil combustibil) {
        this.firma = firma;
        this.combustibil = combustibil;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public TipCombustibil getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(TipCombustibil combustibil) {
        this.combustibil = combustibil;
    }

    @Override
    public String toString() {
        return "Autoturism{" +
                "firma='" + firma + '\'' +
                ", combustibil=" + combustibil +
                '}';
    }
}
