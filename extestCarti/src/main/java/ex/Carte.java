package ex;

public class Carte {
    private String titlu;
    private int numar_pagini;
    private boolean este_audiobook;

    public Carte() {
    }

    public Carte(java.lang.String titlu, int numar_pagini, boolean este_audiobook) {
        this.titlu = titlu;
        this.numar_pagini = numar_pagini;
        this.este_audiobook = este_audiobook;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getNumar_pagini() {
        return numar_pagini;
    }

    public void setNumar_pagini(int numar_pagini) {
        this.numar_pagini = numar_pagini;
    }

    public boolean isEste_audiobook() {
        return este_audiobook;
    }

    public void setEste_audiobook(boolean este_audiobook) {
        this.este_audiobook = este_audiobook;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Carte{" +
                "titlu=" + titlu +
                ", numar_pagini=" + numar_pagini +
                ", este_audiobook=" + este_audiobook +
                '}';
    }
}
