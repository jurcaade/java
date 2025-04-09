package exercitiul3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scFisier = new Scanner(new File("src/exercitiul3/input.txt"));
        StringBuilder sb=new StringBuilder();
        while (scFisier.hasNextLine()) {
            sb.append(scFisier.nextLine()).append("\n");
        }


        Scanner scTastatura = new Scanner(System.in);
        System.out.println("Introduceti sirul pe care doriti sa l inserati: ");
        String sirIntrodus = scTastatura.nextLine();

        System.out.println("Introduceti pozitia la care doriti sa inserati sirul: ");
        int poz = scTastatura.nextInt();

        sb.insert(poz,sirIntrodus);
      //  PrintStream flux_out = new PrintStream(new File("src/exercitiul3/input.txt"));
        //flux_out.println(sb.toString());

        System.out.println("Sirul din fisier cu inserarea sirului dat arata: "+ sb);
        System.out.println("Dati pozitia de inceput a stergerii");
        int pozstergere =scTastatura.nextInt();
        System.out.println("Cate caractere stergeti? ");
        int caractere =scTastatura.nextInt();

        sb.delete(pozstergere,pozstergere+caractere);
        System.out.println("Sirul dupa stergere: "+sb);

    }
}
