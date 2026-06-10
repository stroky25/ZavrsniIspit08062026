package vozila;

public class Vozilo {
    String registarskiBroj;
    String marka;
    Integer godinaProizvodnje;

    public Vozilo(Integer godinaProizvodnje, String marka, String registarskiBroj) throws NeispravniPodaciException {
        if (godinaProizvodnje < 0) {
            throw new NeispravniPodaciException("Godina proizvodnje ne može biti negativna!");
        }
        this.godinaProizvodnje = godinaProizvodnje;
        this.marka = marka;
        this.registarskiBroj = registarskiBroj;
    }

    public void ucitajPodatke (int godinaProizvodnje, String marka, String registarskiBroj) throws NeispravniPodaciException {
        if (godinaProizvodnje < 0) {
            throw new NeispravniPodaciException("Godina proizvodnje ne može biti negativna!");
        }
        this.godinaProizvodnje = godinaProizvodnje;
        this.marka = marka;
        this.registarskiBroj = registarskiBroj;
    }

    public Integer getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public String getMarka() {
        return marka;
    }

    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    public String toString() {
        return "Vozilo(" + "godina Proizvodnje=" + godinaProizvodnje + ", registarski Broj=" + registarskiBroj +
                ", marka='" + marka  + " + "+ ")" + ";";
    }

    public void  prikaziPodatke() {
        System.out.println("Registarski broj: " + registarskiBroj);
        System.out.println("Marka: " + marka);
        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
    }
}
