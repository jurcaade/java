package ex;

public class Masina extends Autoturism{
    private float pret;
    private String model;

    public Masina(String firma, TipCombustibil combustibil, float pret, String model) {
        super(firma, combustibil);
        this.pret = pret;
        this.model = model;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return super.toString() +
                "pret=" + pret +
                ", model='" + model + '\'' +
                '}';
    }
}
