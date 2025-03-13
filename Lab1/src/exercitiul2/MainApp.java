package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        int suma=0;
        int nr=0;
        int valoare_minima=1000;
        int valoare_maxima=0;
        Scanner scanner = new Scanner(new File("src/exercitiul2/in.txt"));
        System.out.println("Fisierul arata astfel: ");
        while(scanner.hasNextInt()){
            int x=scanner.nextInt();
            System.out.println(x);
            nr++;
            suma+=x;
            if (x<valoare_minima){
                valoare_minima=x;
            }
            if (x>valoare_maxima){
                valoare_maxima=x;
            }
        }
        float media_aritmetica=(float)suma/nr;
        System.out.println("Suma este "+ suma);
        System.out.println("Media aritmetica este " + media_aritmetica);
        System.out.println("Valoarea minima este "+ valoare_minima);
        System.out.println("Valoarea maxima este "+ valoare_maxima);

        PrintStream flux_out = new PrintStream(new File("src/exercitiul2/out.txt"));
        flux_out.println("Suma este "+ suma);
        flux_out.println("Media aritmetica este " + media_aritmetica);
        flux_out.println("Valoarea minima este "+ valoare_minima);
        flux_out.println("Valoarea maxima este "+ valoare_maxima);

    }
}
