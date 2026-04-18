public class SistemKesehatan {
    public void makan(AnakKost anakKost, SistemKejadian kejadian) {
        if(kejadian.adaGangguanTeman) {
            System.out.println(">> Makan sambil dengar curhat teman... (Lapar +15, Stress +5)");
            anakKost.setLapar(anakKost.getLapar() + 15);
            anakKost.setStress(anakKost.getStress() + 5);
        } else {
            System.out.println(">> Makan enak (Lapar -20, Stress -10, Uang -20rb)");
            anakKost.setLapar(anakKost.getLapar() - 20);
            anakKost.setStress(anakKost.getStress() - 10);
            anakKost.setUang(anakKost.getUang() - 20000);
        }
   
    }
}