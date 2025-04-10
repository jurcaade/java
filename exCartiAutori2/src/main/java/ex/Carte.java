package ex;

import java.util.List;

public class Carte {
    private String titlu;
    private Gen gen;
    private int an_publicare;
    private List<Autor> lista_autori;

    public Carte(String titlu, Gen gen, int an_publicare, List<Autor> lista_autori) {
        this.titlu = titlu;
        this.gen = gen;
        this.an_publicare = an_publicare;
        this.lista_autori = lista_autori;
    }

    public Carte() {
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", gen=" + gen +
                ", an_publicare=" + an_publicare +
                ", lista_autori=" + lista_autori +
                '}';
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public int getAn_publicare() {
        return an_publicare;
    }

    public void setAn_publicare(int an_publicare) {
        this.an_publicare = an_publicare;
    }

    public List<Autor> getLista_autori() {
        return lista_autori;
    }

    public void setLista_autori(List<Autor> lista_autori) {
        this.lista_autori = lista_autori;
    }
}
