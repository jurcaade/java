package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");
        int n=scanner.nextInt();
        scanner.close();
        int nr=0;
        System.out.println("Divizorii lui "+ n + " sunt: ");
        for (int i=1;i<=n;i++){
            if (n%i==0){
                nr++;
                System.out.print(i+" ");
            }
        }
        System.out.println();
        if (nr==2)
            System.out.println("Numarul e prim");

    }
}
