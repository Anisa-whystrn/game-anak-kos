public class SistemAkademik {
    public void belajar(AnakKost anakKost, SistemKejadian kejadian) {
        if (kejadian.isMatiLampu) {
            // Belajar saat mati lampu sangat tidak efektif
            System.out.println(">> Paksa belajar di kegelapan (Nilai +2, Stress +20)");
            anakKost.setNilai(anakKost.getNilai() + 2);
            anakKost.setStress(anakKost.getStress() + 20);
        } else if (kejadian.adaGangguanTeman) {
            // Saat ada teman, fokus terbagi
            System.out.println(">> Belajar sambil dengar curhat (Nilai +3, Stress +15)");
            anakKost.setNilai(anakKost.getNilai() + 3);
            anakKost.setStress(anakKost.getStress() + 15);
        } else {
            // Belajar normal (Nilai kecil, bonus nanti dihitung di GameEngine)
            System.out.println(">> Belajar tenang (Nilai +5, Stress +5)");
            anakKost.setNilai(anakKost.getNilai() + 5);
            anakKost.setStress(anakKost.getStress() + 5);
            anakKost.setLapar(anakKost.getLapar() + 5); // Belajar bikin lapar
        }
    }

    public void printMakalah(AnakKost anakKost) {
        // Aksi ini sekarang memberikan reward besar karena munculnya jarang
        System.out.println(">> Tugas di-print dan dikumpul! Dosen puas. (Nilai +25, Uang -20rb)");
        anakKost.setUang(anakKost.getUang() - 20000);
        anakKost.setNilai(anakKost.getNilai() + 25);
        // Berhasil menyelesaikan tugas juga sedikit mengurangi beban pikiran
        anakKost.setStress(anakKost.getStress() - 5);
    }
}