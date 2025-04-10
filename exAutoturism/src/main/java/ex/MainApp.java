package ex;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(List<Autoturism> lista) {
        File file = new File("src/main/resources/autoturisme.csv");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Autoturism vehicle : lista) {
                if (vehicle instanceof Masina) {
                    Masina car = (Masina) vehicle;
                    writer.printf("%s,%s,%.2f,%s%n",
                            car.getFirma(),
                            car.getCombustibil(),
                            car.getPret(),
                            car.getModel());
                } else if (vehicle instanceof Motocicleta) {
                    Motocicleta bike = (Motocicleta) vehicle;
                    writer.printf("%s,%s,%s%n",
                            bike.getFirma(),
                            bike.getCombustibil(),
                            bike.getDataFabricatiei());
                } else {
                    writer.printf("%s,%s%n",
                            vehicle.getFirma(),
                            vehicle.getCombustibil());
                }
            }
            System.out.println("Date scrise cu succes în " + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }

    public static List<Autoturism> citire() {
        List<Autoturism> vehicles = new ArrayList<>();
        File file = new File("src/main/resources/autoturisme.csv");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                try {
                    if (parts.length == 2) {
                        // Basic Autoturism
                        vehicles.add(new Autoturism(
                                parts[0].trim(),
                                TipCombustibil.valueOf(parts[1].trim())
                        ));
                    } else if (parts.length == 4) {
                        // Masina
                        vehicles.add(new Masina(
                                parts[0].trim(),
                                TipCombustibil.valueOf(parts[1].trim()),
                                Float.parseFloat(parts[2].trim()),
                                parts[3].trim()
                        ));
                    } else if (parts.length == 3) {
                        // Motocicleta
                        vehicles.add(new Motocicleta(
                                parts[0].trim(),
                                TipCombustibil.valueOf(parts[1].trim()),
                                LocalDate.parse(parts[2].trim())
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
        return vehicles;
    }

    public static void main(String[] args) {
        List<Autoturism> autoturisme = new ArrayList<>();
        autoturisme.add(new Autoturism("Bmw", TipCombustibil.MOTORINA));
        autoturisme.add(new Masina("Bmw", TipCombustibil.MOTORINA, 7.8f, "X3"));
        autoturisme.add(new Masina("Audi", TipCombustibil.BENZINA, 56.5f, "A4"));
        autoturisme.add(new Motocicleta("Motto", TipCombustibil.BENZINA, LocalDate.of(2014, 10, 12)));
        autoturisme.add(new Motocicleta("Bmw", TipCombustibil.MOTORINA, LocalDate.of(2019, 11, 1)));
        scriere(autoturisme);

        List<Autoturism> citite = citire();

        System.out.println("\nAutoturisme citite:");
        citite.forEach(System.out::println);

        String firma_citita;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Introduceti o firma: ");
            firma_citita = scanner.nextLine();

            if(firma_citita.matches("[a-zA-z]+$"))
            {
                break;
            }
            System.out.println("nume firma invalid - contine cifre");
        }

        if(autoturisme.get(0).getFirma().equals(firma_citita))
        {
            System.out.println("Primul autoturism din lista este produs de firma citita, "+ firma_citita);
        }
        else
        {
            System.out.println("Primul autoturism din lista nu este produs de firma citita, "+ firma_citita + ", ci de "+ autoturisme.get(0).getFirma());
        }

        Scanner scanner2 = new Scanner(System.in);
        String tipCombustibil_citit;
        while(true)
        {
            System.out.println("Dati un tip de combustibil: ");
             tipCombustibil_citit=scanner2.nextLine();
            if (tipCombustibil_citit.equals("BENZINA") || tipCombustibil_citit.equals("MOTORINA")) {
                break;
            }
            System.out.println("Tip combustibil invalid - introdu MOTORINA sau BENZINA" );
        }

        String finalTipCombustibil_citit = tipCombustibil_citit;
        autoturisme.stream()
                .filter(a->a.getCombustibil().name().equals(finalTipCombustibil_citit))
                .forEach(System.out::println);


//        List <Motocicleta> motocicleta_veche =autoturisme.stream()
//                .filter(a->a instanceof Motocicleta)
//                .map(a -> (Motocicleta) a)
//                .collect(Collectors.toList());
//
//        int max=Integer.MIN_VALUE;
//        Motocicleta aux=null;
//        for(Motocicleta motocicleta : motocicleta_veche)
//        {
//            if (motocicleta.getVechime()>max) {
//                max = motocicleta.getVechime();
//                aux=motocicleta;
//            }
//        }
//
//        if (motocicleta_veche.isEmpty())
//            System.out.println("Nu exista nicio motocicleta!");
//        else
//            System.out.println("Cea mai veche motocicleta: " + aux);

        Optional<Motocicleta> ceaMaiVeche = autoturisme.stream()
                .filter(Motocicleta.class::isInstance)
                .map(Motocicleta.class::cast)
                .max(Comparator.comparingInt(Motocicleta::getVechime));

        ceaMaiVeche.ifPresentOrElse(
                m -> System.out.println("Cea mai veche motocicletă: " + m),
                () -> System.out.println("Nu există nicio motocicletă!")
        );


    }
}