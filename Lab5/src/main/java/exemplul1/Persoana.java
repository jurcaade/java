package exemplul1;

public class Persoana {
    private String nume;
    private int varsta;

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public Persoana(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return nume + ", " + varsta;  }
}
