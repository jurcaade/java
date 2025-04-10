package ex;

import java.time.LocalDate;

public class Motocicleta extends Autoturism {
    private LocalDate dataFabricatiei;

    public Motocicleta(String firma, TipCombustibil combustibil, LocalDate dataFabricatiei) {
        super(firma, combustibil);
        this.dataFabricatiei = dataFabricatiei;
    }

    public LocalDate getDataFabricatiei() {
        return dataFabricatiei;
    }

    public void setDataFabricatiei(LocalDate dataFabricatiei) {
        this.dataFabricatiei = dataFabricatiei;
    }

    public int getVechime()
    {
        LocalDate dataCurenta=LocalDate.now();
        int vechime=dataCurenta.getYear()- dataFabricatiei.getYear();

        return vechime;
    }

    @Override
    public String toString() {
        return super.toString() +
                "dataFabricatiei=" + dataFabricatiei +
                '}';
    }
}
