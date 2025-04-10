package ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

public class MainApp {
    public static Set citire() {
        Set lista_trenuri = new HashSet();
        File file = new File("src/main/resources/trenuri.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                try {
                    int numarTren = Integer.parseInt(parts[0].trim());
                    int numarVagoane = Integer.parseInt(parts[1].trim());

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = sdf.parse(parts[2].trim());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);

                    if (parts.length == 3) {
                        lista_trenuri.add(new Tren(numarTren, numarVagoane, calendar));
                    } else if (parts.length == 5) {
                        lista_trenuri.add(new Accelerat(numarTren, numarVagoane, calendar,
                                Integer.parseInt(parts[3].trim()),
                                Boolean.parseBoolean(parts[4].trim())
                        ));
                    } else {
                        lista_trenuri.add(new Marfar(numarTren, numarVagoane, calendar,
                                parts[3].trim()
                        ));
                    }
                } catch (Exception e) {
                    System.out.println("Eroare la parsarea liniei" + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul nu a fost gasit" + e.getMessage());
        }
        return lista_trenuri;

    }

    public static void main(String[] args) {
        Set <Tren> lista_trenuri = new HashSet();

        System.out.println("Trenuri din fisier: ");
        lista_trenuri = citire();
        lista_trenuri.forEach(System.out::println);


    Scanner sc = new Scanner(System.in);
    String n;

    while(true)
    {
        System.out.println("Introduceti n: ");
        n = sc.nextLine();
        if (n.matches("\\d+")) {
            break;
        }
        System.out.println("Valoare invalida");
    }
        String finaln=n;
        lista_trenuri.stream()
                .filter(t -> t instanceof Accelerat)
                .map(t -> (Accelerat) t)
                .filter( t->t.getNumarLocuri() > Integer.parseInt(finaln))  // Apel corect al metodei
                .forEach(System.out::println);  // Folosește System.out.println

        System.out.println("Colectia ordonata dupa nr trenuri:");
        lista_trenuri.stream()
                .sorted(Comparator.comparingInt(t->t.getNumarTren()))
                .forEach(System.out::println);


//        List<Tren> listTrenuri = new ArrayList<>(lista_trenuri);
//        Collections.sort(listTrenuri, Comparator.comparingInt(Tren::getNumarTren));
       // lista_trenuri.forEach(System.out::println);
}
}
