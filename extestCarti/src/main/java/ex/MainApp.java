package ex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Autor> autori) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/autori.json");
            mapper.writeValue(file, autori);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Autor> citire() {
        try {
            File file = new File("src/main/resources/autori.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Autor> autori = mapper.readValue(file, new TypeReference<List<Autor>>() {
            });
            return autori;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//         List<Autor> autori = new ArrayList<>();
//         Carte c1 = new Carte("Cartea junglei",100,false);
//         Carte c2 = new Carte("Cartea junglei 2",300,true);
//            Carte c3 = new Carte("Tarzan",600,true);
//          autori.add( new Autor("Mihai Eminescu",TipOpera.HORROR, LocalDate.of(1990,5,10), Arrays.asList(c1,c2,c3)));
//          autori.add(new Autor("Lucian Blaga",TipOpera.HORROR, LocalDate.of(1972,3,4),Arrays.asList(c1)));
//          scriere(autori);

        List<Autor> autori = citire();
        if (autori != null) {
            autori.forEach(System.out::println);
        }

        String n;
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean ok = true;

            System.out.println("Introduceti n: ");
            n = sc.nextLine();

            for (char c : n.toCharArray()) {
                if (Character.isLetter(c)) {
                    System.out.println("Numar invalid - contine litere");
                    ok = false;
                    break;
                }
            }
            if (ok) {
                break;
            }
        }
        System.out.println("Primele "+n+" carti ale primului autor: ");
        for(int i=0; i<Integer.parseInt(n);i++) {
            System.out.println(autori.get(0).getLista_carti().get(i));
        }

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Dati numarul de carti: ");
        int n2 = sc2.nextInt();

        System.out.println("Numele autorilor horror care s au nascut dupa 1980 si care au publicat un nr de carti mai mare decat "+n2);

//        for(Autor a : autori) {
//            if ( a.getTip_opera()== TipOpera.HORROR && a.getData_nasterii().getYear()>1980 && a.getLista_carti().size()>n2) {
//                System.out.println(a);
//            }
//        }

        autori.stream()
                .filter(a->a.getTip_opera() == TipOpera.HORROR)
                .filter(a->a.getData_nasterii().getYear()>1980)
                .filter(a->a.getLista_carti().size()>n2)
                .map(Autor::getNume)
                .forEach(System.out::println);

        System.out.println("Carti care sunt disponibile ca audiobook uri: ");
        List<String> lista_carti = autori.get(0).getLista_carti().stream()
                .filter(a->a.isEste_audiobook()==true)
                .sorted(Comparator.comparingInt(Carte::getNumar_pagini).reversed())
                .map(Carte::getTitlu)
                .collect(Collectors.toList());


        lista_carti.forEach(System.out::println);
    }



}


