package exercitiul1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti latimea dreptunghiului: ");
        int latime = input.nextInt();
        System.out.println("Introduceti lungimea dreptunghiului: ");
        int lungime = input.nextInt();
        int perimetru = 2*(latime+lungime);
        int arie = latime * lungime;
        System.out.println("Perimetru: " + perimetru);
        System.out.println("Arie: "+arie);
        input.close();
    }
}
