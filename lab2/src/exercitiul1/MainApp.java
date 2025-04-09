package exercitiul1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/exercitiul1/judete_in.txt"));
        int nrjudete=0;
        //citim fisierul pt numarul de judete
        while (scanner.hasNextLine()) {
            nrjudete++;
            scanner.nextLine();
        }
        scanner.close();

        //citim fisierul pt a salva judetele intr un string
        scanner = new Scanner(new File("src/exercitiul1/judete_in.txt"));
        String[] tablou = new String[nrjudete];
        for (int i=0;i<nrjudete;i++)
        {
            tablou[i]=scanner.nextLine();
        }
        scanner.close();
        Arrays.sort(tablou);

        for (int i=0;i<nrjudete;i++)
        {
            System.out.println(tablou[i]);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti numele judetului: ");
        String judetul = input.nextLine();
        input.close();

        int poz=Arrays.binarySearch(tablou,judetul);
        if (poz>=0)
            System.out.println("Judetul cautat se afla in fisierul sortat pe pozitia "+ poz);
        else
            System.out.println("Judetul cautat nu se afla in fisier.");
    }
}
