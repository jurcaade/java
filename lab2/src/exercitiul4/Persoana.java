package exercitiul4;

import java.time.LocalDate;
import java.time.Period;

public class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta(String cnp)
    {
        String an,luna,ziua;
        an=cnp.substring(1,3);
        luna=cnp.substring(3,5);
        ziua=cnp.substring(5,7);

        //determinam anul complet
        int anInt = Integer.parseInt(an);
        if (cnp.charAt(0)=='1' || cnp.charAt(0)=='2')
            anInt+=1900;
        else
            anInt+=2000;

        LocalDate datanasterii=LocalDate.of(anInt,Integer.parseInt(luna),Integer.parseInt(ziua));
        LocalDate azi=LocalDate.now();
        Period period= Period.between(datanasterii,azi);
        return period.getYears();
    }
}
