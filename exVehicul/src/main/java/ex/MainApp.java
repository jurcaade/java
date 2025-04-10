package ex;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainApp {
    static void scrie(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        static Object citeste (String fis){
            try {
                FileInputStream f = new FileInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(f);
                Object o = ois.readObject();
                ois.close();
                f.close();
                return o;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }


    public static void main(String[] args) {
        List<Vehicul> vehicule = new ArrayList<Vehicul>();
        //File file=new File("src/resources/vehicule.bin");
        vehicule.add(new Masina(200,"motorina",23,"Audi"));
        vehicule.add(new Masina(200,"motorina",2,"Audi"));
        vehicule.add(new Masina(200,"motorina",1,"Audi"));
        vehicule.add(new Camion(100,"motorina",232));
        scrie(vehicule,"vehicule.bin");
        List<Vehicul>vehicule_cititie;
        vehicule_cititie= (List<Vehicul>) citeste("vehicule.bin");
        for (Vehicul v:vehicule_cititie){
            System.out.println(v);
        }

        Optional masinaMax =vehicule_cititie.stream()
                .filter(v -> v instanceof Masina)
                .map(v -> (Masina)v)
                .max(Comparator.comparingInt(Masina::getNr_locuri));
        System.out.println("Masina cu cele mai multe locuri: "+ masinaMax);

        System.out.println("Fisierul dupa stergerea celor cu 3 locuri sau mai putin");
        vehicule_cititie.removeIf(v -> v instanceof Masina && ((Masina) v).getNr_locuri()<=3);
        scrie(vehicule_cititie,"vehicule.bin");
        vehicule_cititie= (List<Vehicul>) citeste("vehicule.bin");
        vehicule_cititie.forEach(System.out::println);

    }
}
