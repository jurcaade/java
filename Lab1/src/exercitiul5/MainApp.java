package exercitiul5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        int x;
        Random rand = new Random();
        x = rand.nextInt(21);
        System.out.println("Numarul generat este " + x);
        int a=0, b=1;

        while(b<x){
            int temp=b;
            b=a+b;
            a=temp;
        }

        if (b==x)
            System.out.println(x+" face parte din sirul Fibonacci.");
        else
            System.out.println(x+" nu face parte din sirul Fibonacci.");

    }
}
