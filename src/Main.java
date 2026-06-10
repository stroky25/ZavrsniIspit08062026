import vozila.*;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner mojScanner = new Scanner(System.in);
        String menu;
        File datoteka = new File("vozila.txt");

        EvidencijaVozila evidencija = new EvidencijaVozila();
        try {
            if (datoteka.exists()) {
                System.out.println("Podaci uspješno učitani iz datoteke.");
            } else {
                System.out.println("Datoteka ne postoji ili je prazna.");
            }
            //evidencija.ucitajPodatkeIzDatoteke("vozila.txt");
        } catch (Exception e) {
            System.out.println("Datoteka ne postoji ili je prazna.");
        }
        do {
            System.out.println("\n******* IZBORNIK *********");
            System.out.println("1 - Unos automobila");
            System.out.println("2 - Unos motocikla");
            System.out.println("0 - Izlaz");
            System.out.print("Odaberite opciju: ");
            menu = mojScanner.nextLine();
            switch (menu) {
                case "1":
                    try {
                        System.out.println("Odabrana je opcija unos automobila.");
                        System.out.print("Unesite marku automobila: ");
                        String marka = mojScanner.nextLine();
                        System.out.print("Unesite registarski broj: ");
                        String registarskiBroj = mojScanner.nextLine();
                        System.out.print("Unesite godinu proizvodnje: ");
                        int godinaProizvodnje = Integer.parseInt(mojScanner.nextLine());
                        if (godinaProizvodnje < 0) {
                            throw new NeispravniPodaciException("Godina proizvodnje ne može biti negativna!");
                        }
                        System.out.print("Unesite broj vrata: ");
                        int brojVrata = Integer.parseInt(mojScanner.nextLine());
                        if (brojVrata < 0) {
                            throw new NeispravniPodaciException("Broj vrata ne može biti negativan!");
                        }
                        Automobil a = new Automobil(registarskiBroj, marka, godinaProizvodnje, brojVrata);
                        evidencija.dodajVozilo(a);
                        System.out.println("Automobil uspješno dodan!");
                    } catch (NeispravniPodaciException e) {
                        System.out.println("Greška u podacima: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Morate unijeti brojčanu vrijednost!");
                    }
                    break;
                case "2":
                    try {
                        System.out.println("Odabrana je opcija unos motocikla.");
                        System.out.print("Unesite marku motocikla: ");
                        String marka = mojScanner.nextLine();
                        System.out.print("Unesite registarski broj: ");
                        String registarskiBroj = mojScanner.nextLine();
                        System.out.print("Unesite godinu proizvodnje: ");
                        int godinaProizvodnje = Integer.parseInt(mojScanner.nextLine());
                        System.out.print("Unesite tip motora: ");
                        String tipMotora = mojScanner.nextLine();
                        Motocikl m = new Motocikl(registarskiBroj, marka, godinaProizvodnje, tipMotora);
                        evidencija.dodajVozilo(m);
                        System.out.println("Motocikl uspješno dodan!");
                    } catch (NeispravniPodaciException e) {
                        System.out.println("Greška u podacima: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Morate unijeti brojčanu vrijednost!");
                    }
                    break;
                case "0":
                    try {
                        evidencija.spremiPodatkeUDatoteku("vozila.txt");
                        System.out.println("Podaci spremljeni u datoteku.");
                    } catch (Exception e) {
                        System.out.println("Greška pri spremanju: " + e.getMessage());
                    }
                    System.out.println("Izlaz iz programa.");
                    break;
                default:
                    System.out.println("Pogrešan odabir.");
            }
        } while (!menu.equals("0"));

        System.out.println("\n----- VOZILA U EVIDENCIJI -----");

        for (Vozilo v : evidencija.getVozila()) {
            v.prikaziPodatke();
            System.out.println();
        }

        mojScanner.close();
    }
}