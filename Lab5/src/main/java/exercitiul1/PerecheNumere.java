package exercitiul1;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public PerecheNumere() {
    }

    public int getNumar1() {
        return numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return this.numar1 + " : " + this.numar2;
    }

    public boolean isFibonacci() {
        int a = 0, b = 1, c;
        c = a + b;
        if ((numar1 == a && numar2 == b) || (numar1 == b && numar2 == c))
            return true;

        while (c <= numar2) {
            a = b;
            b = c;
            c = a + b;
            if (numar1 == b && numar2 == c)
                return true;
        }
        return false;
    }

    public int cmmmc() {
        int a, b;
        a = this.numar1;
        b = this.numar2;

        while (b!=0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        int cm = a;
        return (numar1 * numar2) / cm;
    }

    public boolean isSumaCifrelorEgala() {
        int a = this.numar1, b = this.numar2;
        int ScifreA = 0, ScifreB = 0;
        while (a!=0) {
            ScifreA += a % 10;
            a /= 10;
        }
        while (b!=0) {
            ScifreB += b % 10;
            b /= 10;
        }

        if (ScifreA == ScifreB)
            return true;
        else
            return false;

    }

    public boolean isAcelasiNumarCifrePare() {
        int a = this.numar1, b = this.numar2;
        int cifrePareA = 0, cifrePareB = 0;
        while (a!=0) {
            if (a % 10 % 2 == 0)
                cifrePareA++;
        }
        while (b!=0) {
            if (b % 10 % 2 == 0)
                cifrePareB++;
        }

        if (cifrePareA==cifrePareB)
            return true;
        else
            return false;
    }
}
