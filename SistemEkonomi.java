public class SistemEkonomi {
    public void kerja(AnakKost anakKost, SistemKejadian kejadian) {
        System.out.println(">> Kamu kerja part-time (Uang +80rb, Lapar +20, Nilai -10)");
        anakKost.setUang(anakKost.getUang() + 80000);
        anakKost.setLapar(anakKost.getLapar() + 20);
        anakKost.setNilai(anakKost.getNilai() - 10);
        if (kejadian.isMatiLampu) anakKost.setStress(anakKost.getStress() + 20);
    }

    public void beliToken(AnakKost anakKost, SistemKejadian kejadian) {
        if (anakKost.getUang() >= 50000 && kejadian.isMatiLampu) {
            System.out.println(">> Kamu beli token listrik (Uang -50rb)");
            anakKost.setUang(anakKost.getUang() - 50000);
            kejadian.isMatiLampu = false;
        } else {
            System.out.println(">> Uang tidak cukup untuk beli token!");
        }
    }
}