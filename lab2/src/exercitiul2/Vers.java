package exercitiul2;

public class Vers {
    private String linie;

    public Vers (String linie)
    {
        this.linie=linie;
    }
    public int nrCuvinte()
    {
        return linie.trim().split("\\s+").length;
    }

    public int nrVocale()
    {
        int nrvoc=0;
        String vocale="AEIOUaeiou";
        for (char c :  linie.toCharArray())
        {
            if (vocale.indexOf(c)>=0)
                nrvoc++;
        }
        return nrvoc;
    }

    public boolean terminatie(String sufix)
    {
        return linie.endsWith(sufix);
    }

    public String getVers()
    {
        return linie;
    }
}
