package vozila;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class EvidencijaVozila {
    private ArrayList<Vozilo> vozila;
    public EvidencijaVozila() {
        vozila = new ArrayList<>();
    }
    public void dodajVozilo(Vozilo vozilo) {
        vozila.add(vozilo);
    }
    public ArrayList<Vozilo> getVozila() {
        return vozila;
    }

    public void spremiPodatkeUDatoteku (String datoteka) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(datoteka, true));
        for (Vozilo v : vozila) {
            try {
                bw.write(v.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            bw.newLine();
        }
        bw.close();
    }
    public void ucitajPodatkeIzDatoteke (String datoteka) throws IOException, NeispravniPodaciException {
        vozila.clear();
        BufferedReader br = new BufferedReader(new FileReader(datoteka));
        String red;
        while ((red = br.readLine()) != null) {
            String [] podaci = red.split(";");
            if (podaci[0].equals("AUTOMOBIL")) {
                vozila.add(new Automobil(podaci[1], podaci[2], Integer.parseInt(podaci[3]), Integer.parseInt(podaci[4])));
            } else if (podaci[0].equals("MOTOCIKL")) {
                vozila.add(new Motocikl(podaci[1], podaci[2], Integer.parseInt(podaci[3]),podaci[4]));
            }
        }
        br.close();
    }
}
