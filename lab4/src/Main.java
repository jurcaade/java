import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List <Echipament> echipamente = new ArrayList<>();
            try {
                File fisier = new File("src/echipamente.txt");
                Scanner myReader = new Scanner(fisier);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] valori = data.split(";");

                    if(valori.length > 0)
                    {
                        String denumire = valori[0].trim();
                        int nrInventar=Integer.parseInt(valori[1].trim());
                        int pret = Integer.parseInt(valori[2].trim());
                        String zonaMag = valori[3].trim();
                        stare_echipament stare=stare_echipament.valueOf(valori[4].trim());
                        String tipEchipament = valori[5].trim().toLowerCase();

                        switch (tipEchipament)
                        {
                            case "imprimanta":
                                int ppm = Integer.parseInt(valori[6].trim());
                                String[] dpiValues = valori[7].split("x");
                                int dpi = Integer.parseInt(dpiValues[0].trim());
                                int paginiCartus = Integer.parseInt(valori[8].trim());
                                mod_tiparire modTiparire = mod_tiparire.valueOf(valori[9].trim().toUpperCase());
                                echipamente.add(new imprimanta(denumire, nrInventar, pret, zonaMag, stare, ppm, dpi, paginiCartus, modTiparire));
                                break;

                            case "copiator":
                                int paginiToner = Integer.parseInt(valori[6].trim());
                                format_copiere formatCopiere = format_copiere.valueOf(valori[7].trim().toUpperCase());
                                echipamente.add(new copiator(denumire, nrInventar, pret, zonaMag, stare, paginiToner, formatCopiere));
                                break;

                            case "sistem de calcul":
                                String tipMon = valori[6].trim();
                                double vitezaProc = Double.parseDouble(valori[7].trim());
                                int hdd = Integer.parseInt(valori[8].trim());
                                sistemoperare sistemOperare = sistemoperare.valueOf(valori[9].trim().toUpperCase());
                                echipamente.add(new SisCalc(denumire, nrInventar, pret, zonaMag, stare, tipMon, vitezaProc, hdd, sistemOperare));
                                break;

                            default:
                                System.out.println("Tip necunoscut: " + tipEchipament);
                        }
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        System.out.println("\nLista echipamente din fisier");
            for (Echipament e: echipamente)
            {
                System.out.println(e);
            }
        }
    }
