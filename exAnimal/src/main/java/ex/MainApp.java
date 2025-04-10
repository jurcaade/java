package ex;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainApp {


    public static void scriere(List<Animal> lista) {
        File file = new File("src/main/resources/animale.csv");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Animal animal : lista) {
                if (animal instanceof Pisica) {
                    Pisica pisica = (Pisica) animal;
                    writer.printf("%s,%d,%s,%s,%.2f,%s%n",
                            pisica.getNume(),
                            pisica.getInaltime(),
                            pisica.getData_nasterii(),
                            pisica.getTalia(),
                            pisica.getGreutate(),
                            pisica.getRasa()
                    );
                } else if (animal instanceof Caine) {
                    Caine caine = (Caine) animal;
                    writer.printf("%s,%d,%s,%s,%s%n",
                            caine.getNume(),
                            caine.getInaltime(),
                            caine.getData_nasterii(),
                            caine.getTalia(),
                            caine.isEsteAdoptat()
                    );
                } else {
                    writer.printf("%s,%d,%s,%s%n",
                            animal.getNume(),
                            animal.getInaltime(),
                            animal.getData_nasterii(),
                            animal.getTalia()
                    );
                }
            }
            System.out.println("Date scrise cu succes în " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }


    public static List citire() {
        List<Animal> lista_animale = new ArrayList<>();
        File file = new File("src/main/resources/animale.csv");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                try {
                    if (parts.length == 4) {
                        lista_animale.add(new Animal(parts[0].trim(),
                                Integer.parseInt(parts[1].trim()),
                                LocalDate.parse(parts[2].trim()),
                                TipTalie.valueOf(parts[3].trim())));
                    } else if (parts.length == 6) {
                        lista_animale.add(new Pisica(parts[0].trim(),
                                Integer.parseInt(parts[1].trim()),
                                LocalDate.parse(parts[2].trim()),
                                TipTalie.valueOf(parts[3].trim()),
                                Float.parseFloat(parts[4].trim()),
                                parts[5].trim()
                        ));

                    } else {
                        lista_animale.add(new Caine(parts[0].trim(),
                                Integer.parseInt(parts[1].trim()),
                                LocalDate.parse(parts[2].trim()),
                                TipTalie.valueOf(parts[3].trim()),
                                Boolean.parseBoolean(parts[4].trim())
                        ));
                    }
                } catch (Exception e) {
                    System.err.println("Eroare la parsarea liniei: " + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fișierul nu a fost găsit: " + e.getMessage());
        }
        return lista_animale;
    }

    public static void main(String[] args) {
        List<Animal> lista_animale = new ArrayList<>();
//        lista_animale.add(new Pisica("Pisica", 17, LocalDate.of(2014, 6, 6), TipTalie.MARE, 16.7f, "Sfinx"));
//        lista_animale.add(new Animal("Animal", 78, LocalDate.of(2014, 5, 6), TipTalie.MICA));
//        scriere(lista_animale);

        System.out.println("Animale din fisier: ");
        lista_animale = citire();
        lista_animale.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        String n;
        while (true) {
            System.out.println("Introduceti n: ");
            n = sc.nextLine();

            if (n.matches("[0-9]+$"))
                break;

            System.out.println("n invalid - trb sa contina doar cifre");
        }

        if (lista_animale.get(0).getInaltime() == Integer.parseInt(n)) {
            System.out.println("Primul animal din lista are inaltimea " + Integer.parseInt(n));
        } else
            System.out.println("Primul animal din lista nu are inaltimea " + n);

        String rasa_citita;
        System.out.println("Introduceti rasa: ");
        rasa_citita = sc.nextLine();


        lista_animale.stream()
                .filter(a -> a instanceof Pisica)
                .map(a -> (Pisica) a)
                .filter(a -> a.getRasa().equals(rasa_citita))
                .sorted(Comparator.comparingDouble(a -> a.getGreutate()))
                .forEach(System.out::println);

        System.out.println("Dati nr luni: ");
        int nr;
        nr = sc.nextInt();
        LocalDate data_curenta = LocalDate.now();
        LocalDate dataLimita = data_curenta.minusMonths(nr);

        System.out.println("Cainii adoptati care s au nascut in ultimele " + nr + "  luni: ");
        lista_animale.stream()
                .filter(a -> a instanceof Caine)
                .map(a -> (Caine) a)
                .filter(a -> a.isEsteAdoptat() == true)
                .filter(a->a.getData_nasterii().isAfter(dataLimita))
                .forEach(System.out::println);
    }

}
