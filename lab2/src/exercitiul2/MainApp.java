package exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)  throws FileNotFoundException {
        File inputFile = new File("src/exercitiul2/cantec_in.txt");
        File outputFile = new File("src/exercitiul2/cantec_out.txt");
        String sufix="her";
        Random rand = new Random();
        Scanner input = new Scanner(inputFile);
        PrintStream output = new PrintStream(outputFile);

        while(input.hasNextLine())
        {
            String line = input.nextLine();
            Vers v = new Vers(line);
            double randomValue=rand.nextDouble();
            line=v.getVers();
            if (randomValue<0.1)
            {
               line= line.toUpperCase();
            }

            output.print(line+ " " + v.nrCuvinte() + " " + v.nrVocale() + " " + randomValue + " ");
            if (v.terminatie(sufix))
                output.print('*');
            output.println();
        }


    }
}
