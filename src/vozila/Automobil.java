package vozila;

public class Automobil extends Vozilo {
    private int brojVrata;
    public Automobil(String godinaProizvodnje, String marka, int registarskiBroj, int brojVrata) throws NeispravniPodaciException {
        super(registarskiBroj, marka, godinaProizvodnje);
        if (brojVrata < 0) {
            throw new NeispravniPodaciException("Broj vrata ne može biti negativan!");
        }
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) throws NeispravniPodaciException {
        if (brojVrata < 0) {
            throw new NeispravniPodaciException("Broj vrata ne može biti negativan!");
        }
        this.brojVrata = brojVrata;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Broj vrata: " + brojVrata);
    }

    @Override
    public String toString() {
        return "Automobil(" + "brojVrata=" + brojVrata + ", " + " godinaProizvodnje=" + godinaProizvodnje + ", " +
                " marka='" + marka + ", " +  " registarskiBroj='" + registarskiBroj + "'" +  ')' + ';' ;
    }
}

