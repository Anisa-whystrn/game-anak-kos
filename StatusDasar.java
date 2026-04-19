public class StatusDasar {
    private String nama;
    private int uang, lapar, stress, nilai, nyawa;

    public StatusDasar(String nama, int uang, int lapar, int stress, int nilai, int nyawa) {
        this.nama = nama;
        this.uang = uang;
        this.lapar = lapar;
        this.stress = stress;
        this.nilai = nilai;
        this.nyawa = nyawa;
    }

    public String getNama() { 
        return nama; }
    public int getUang() { 
        return uang; }
    public int getLapar() { 
        return lapar; }
    public int getStress() { 
        return stress; }
    public int getNilai() { 
        return nilai; }
    public int getNyawa() { 
        return nyawa; }

    public void setUang(int uangBaru) { 
        this.uang = uangBaru; }

    public void setLapar(int laparBaru) {
        if (laparBaru > 100) { this.lapar = 100; }
        else if (laparBaru < 0) { this.lapar = 0; }
        else { this.lapar = laparBaru; }
    }
    public void setStress(int stressBaru) {
        if (stressBaru < 0) this.stress = 0;
        else if (stressBaru > 100) this.stress = 100;
        else this.stress = stressBaru;
    }//0-100

    public void setNilai(int nilaiBaru) {
        if (nilaiBaru > 100) { this.nilai = 100; }
        else if (nilaiBaru < 0) { this.nilai = 0; }
        else { this.nilai = nilaiBaru; }
    }
    

    public void setNyawa(int nyawaBaru) { this.nyawa = nyawaBaru; }
}