package exercitiul4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        int a,b;
        Random rand=new Random();
        a=rand.nextInt(31);
        b=rand.nextInt(31);
        System.out.println("a="+a+" b="+b);
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        System.out.println(a);
    }
}
