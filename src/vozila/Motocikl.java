package vozila;

public class Motocikl extends Vozilo{
    private String tipMotora;

    public Motocikl(String godinaProizvodnje, String marka, int registarskiBroj, String tipMotora) throws NeispravniPodaciException {
        super(registarskiBroj, marka, godinaProizvodnje);
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Tip motora: " + tipMotora);
    }

    @Override
    public String toString() {
        return "Motocikl(" + "tipMotora='" + tipMotora + ", " + " godinaProizvodnje=" + godinaProizvodnje + ", " +
                " marka='" + marka + ", " + " registarskiBroj='" + registarskiBroj  + ")"+ "';";
    }
}
