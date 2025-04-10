package ex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Carte> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Carte> carti = mapper
                    .readValue(file, new TypeReference<List<Carte>>() {
                    });
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/carti.json");
        List<Carte> carti = new ArrayList<>();
        Autor a1 = new Autor("Andrei", "roman", 18);
        Autor a2 = new Autor("Mircea", "italian", 56);
        Autor a3 = new Autor("Ion", "roman", 28);
        carti.add(new Carte("Tarzan", Gen.FICTIUNE, 1990, Arrays.asList(a1, a2)));
        carti.add(new Carte("Nuj", Gen.FICTIUNE, 2022, Arrays.asList(a1, a2, a3)));
        carti.add(new Carte("Carte3", Gen.NON_FICTIUNE, 1990, Arrays.asList(a2, a3)));
        carti.add(new Carte("Jungla", Gen.STIINTA, 1988, Arrays.asList(a1, a3)));
        carti.add(new Carte("Desertul colorat", Gen.NON_FICTIUNE, 1990, Arrays.asList(a1, a2, a3)));
        scriere(carti);
        carti = citire();
        carti.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        String gen_citit;
        System.out.println("Introduceti gen: ");
        gen_citit = sc.nextLine();
        System.out.println("Cartile de acest gen: ");
        carti.stream()
                .filter(c -> c.getGen().name().equalsIgnoreCase(gen_citit))
                .forEach(System.out::println);

        System.out.println("Autori tineri de fictiune");


        carti.stream()
                .filter(c -> c.getGen() == Gen.FICTIUNE)
                .flatMap(c -> c.getLista_autori().stream())
                .filter(c -> c.getVarsta() < 40)
                .map(Autor::getNume)
                .forEach(System.out::println);


//        List <Carte> carti_fictiune= carti.stream()
//                .filter(c->c.getGen().name() == "FICTIUNE")
//                .collect(Collectors.toList());
//
//        for (int i=0;i<carti_fictiune.size();i++){
//             carti_fictiune.get(i).getLista_autori().stream()
//                    .filter(c->c.getVarsta()<40)
//                    .map(c->c.getNume())
//                     .forEach(System.out::println);
//        }

        Optional an = carti.stream()
                .collect(Collectors.groupingBy(Carte::getAn_publicare, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Anul cu cele mai multe aparitii: " + an);


        System.out.println("Dupa sortare: ");
        carti.sort(Comparator.comparing(Carte::getTitlu));
        carti.forEach(System.out::println);

        System.out.println("Dati n: ");
        int n;
        n=sc.nextInt();
        List <Carte> carti2=carti.stream()
                .filter(c->c.getLista_autori().size() > n)
                .collect(Collectors.toList());
        carti2.forEach(System.out::println);
    }
}

