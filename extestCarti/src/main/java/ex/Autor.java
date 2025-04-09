package ex;

import java.time.LocalDate;
import java.util.List;

public class Autor {
    private String nume;
    private TipOpera tip_opera;
    private LocalDate data_nasterii;
    private List<Carte> lista_carti;

    public Autor(String nume, TipOpera tip_opera, LocalDate data_nasterii, List<Carte> lista_carti) {
        this.nume = nume;
        this.tip_opera = tip_opera;
        this.data_nasterii = data_nasterii;
        this.lista_carti = lista_carti;
    }

    public Autor() {
    }

    public TipOpera getTip_opera() {
        return tip_opera;
    }

    public void setTip_opera(TipOpera tip_opera) {
        this.tip_opera = tip_opera;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDate getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(LocalDate data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public List<Carte> getLista_carti() {
        return lista_carti;
    }

    public void setLista_carti(List<Carte> lista_carti) {
        this.lista_carti = lista_carti;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Autor{" +
                "nume=" + nume +
                ", data_nasterii=" + data_nasterii +
                ", lista_carti=" + lista_carti +
                '}';
    }
}
