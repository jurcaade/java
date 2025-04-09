package exercitiul4;

import java.util.Scanner;
import java.util.Vector;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Dati numarul de persoane: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Vector<Persoana> persoane = new Vector<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Persoana: " + (i + 1));
            System.out.print("Nume: ");
            String nume = sc.nextLine();
            String cnp;
            while (true) {
                System.out.print("CNP: ");
                cnp = sc.nextLine();
                if (isCnpValid(cnp))
                    break;
                else
                    System.out.println("CNP invalid");
            }
            persoane.add(new Persoana(nume, cnp));
        }

        System.out.println("Datele introduse: ");
        for (Persoana p : persoane)
            System.out.println("Nume: " +p.getNume() +", CNP: " +p.getCnp()+", Varsta: "+p.getVarsta(p.getCnp()));

        sc.close();
    }

    public static boolean isCnpValid(String cnp) {
        if (cnp.length() != 13) return false;
        if (!cnp.matches("\\d{13}")) return false;

        char primaCifra = cnp.charAt(0);
        if ("1256".indexOf(primaCifra) == -1) return false;

        int[] control = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * control[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) cifraControl = 1;

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
}


