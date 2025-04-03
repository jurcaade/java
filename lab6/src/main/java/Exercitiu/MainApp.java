package Exercitiu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class MainApp {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisare(List<Angajat> lista) {
        for (var angajat : lista)
            System.out.println(angajat);

    }

    public static void afisareAngajatiSalariu(List<Angajat> angajati, Predicate<Angajat> filtru) {
        angajati.stream()
                .filter(filtru)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void angajatiAprilie(List<Angajat> angajati) {
        int anCurent = LocalDate.now().getYear();
        List<Angajat> angajatiConducere = angajati.stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == anCurent - 1)
                .filter(angajat -> angajat.getData_angajarii().getMonthValue() == 4)
                .filter(angajat -> angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director"))
                .collect(Collectors.toList());
        afisare(angajatiConducere);

    }

    public static void angajatiFaraConducere(List<Angajat> angajati) {
        List<Angajat> angajatiFaraConducere = angajati.stream()
                .filter(angajat -> !angajat.getPostul().toLowerCase().contains("director") && !angajat.getPostul().toLowerCase().contains("sef"))
                .sorted(Comparator.comparingDouble(Angajat::getSalariul).reversed())
                .collect(Collectors.toList());
        afisare(angajatiFaraConducere);
    }

    public static void numeAngajatiCuMajuscule(List<Angajat> angajati) {
        List<String> numeAngajatiMajuscule = angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        System.out.println(numeAngajatiMajuscule);
    }

    public static void SalariiMici(List<Angajat> angajati) {
        System.out.println("Salariile mai mici de 3000 RON: ");
        angajati.stream()
                .map(Angajat::getSalariul)
                .filter(salariul -> salariul < 3000)
                .forEach(System.out::println);
    }

    public static void DatePrimulAngajat(List<Angajat> angajati) {
        Optional<Angajat> primulAngajat = angajati.stream()
                .min(Comparator.comparing(Angajat::getData_angajarii));
        primulAngajat.ifPresentOrElse(
                angajat -> System.out.println("Primul angajat al firmei: " + angajat),
                () -> System.out.println("Nu există angajați în firmă.")
        );
    }

    public static void StatisticaSalarii(List<Angajat> angajati) {
        DoubleSummaryStatistics statisticiSalarii = angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariul));
        System.out.println("Statistici salarii:");
        System.out.println("Salariul mediu: " + statisticiSalarii.getAverage());
        System.out.println("Salariul minim: " + statisticiSalarii.getMin());
        System.out.println("Salariul maxim: " + statisticiSalarii.getMax());
    }

    public static void existaIon(List<Angajat> angajati) {
        boolean existaIon = angajati.stream()
                .anyMatch(angajat -> angajat.getNume().equalsIgnoreCase("Ion"));
        System.out.println(existaIon ? "Firma are cel puțin un Ion angajat." : "Firma nu are niciun Ion angajat.");
    }

    public static void numarAngajatiVaraAnulPrecedent(List <Angajat> angajati)
    {
        long numarAngajatiVaraAnulPrecedent = angajati.stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == LocalDate.now().getYear() - 1)
                .filter(angajat -> angajat.getData_angajarii().getMonthValue() >= 6 && angajat.getData_angajarii().getMonthValue() <= 8)
                .count();
        System.out.println(numarAngajatiVaraAnulPrecedent);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List <Angajat>angajati=new ArrayList<>();
        angajati.add(new Angajat("Andrei", "director", LocalDate.parse("2022-10-02"), 23344.0f));
        angajati.add(new Angajat("Maria", "sef", LocalDate.parse("2021-04-15"), 18000.0f));
        angajati.add(new Angajat("Ion", "manager", LocalDate.parse("2020-07-10"), 15000.0f));
        angajati.add(new Angajat("Elena", "asistent", LocalDate.parse("2023-01-20"), 2500.0f));
        angajati.add(new Angajat("George", "consultant", LocalDate.parse("2021-08-12"), 3500.0f));


        scriere(angajati);
        citire();
        int opt=0;
        do {
            System.out.println("1.Afisare");
            System.out.println("2.Afisare angajati salariu");
            System.out.println("3.Angajati aprilie");
            System.out.println("4.Afisare angajati fara conducere");
            System.out.println("5.Nume angajati cu majuscule");
            System.out.println("6.Salarii mai mici de 3000");
            System.out.println("7.Primul angajat");
            System.out.println("Alege optiunea: ");
            opt =scanner.nextInt();
            switch (opt)
            {
                case 1:
                    afisare(angajati);
                    break;
                case 2:
                    break;
                case 3:
                    angajatiAprilie(angajati);
                    break;
                case 4:
                    angajatiFaraConducere(angajati);
                    break;
                case 5:
                    numeAngajatiCuMajuscule(angajati);
                    break;
                case 6:
                    SalariiMici(angajati);
                    break;
                case 7:
                    DatePrimulAngajat(angajati);

            }

        }while(true);
    }
}
