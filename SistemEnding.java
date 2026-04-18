public class SistemEnding {
    public static void cekKalah(AnakKost anakKost) {
        if (anakKost.getLapar() >= 100) System.out.println("\n[ENDING: MASUK RS] Kamu pingsan kelaparan!");
        else if (anakKost.getUang() < 0) System.out.println("\n[ENDING: DIUSIR] Tidak bayar kost, kamu diusir!");
        else if (anakKost.getNilai() <= 0) System.out.println("\n[ENDING: D.O.] Nilai nol, kamu dikeluarkan!");
        else if (anakKost.getStress() >= 100) System.out.println("\n[ENDING: GILA] Tekanan hidup membuatmu depresi berat!");
    }

    public static void cekMenang(AnakKost anakKost) {
        System.out.println("\n===========================================");
        System.out.println("   SELAMAT! KAMU BERHASIL LULUS 30 HARI");
        System.out.println("===========================================");
        
        if (anakKost.getStress() >= 80) {
            System.out.println("RESULT: SELAMAT TAPI GILA");
            System.out.println("Kamu lulus, tapi kesehatan mentalmu hancur.");
        } else if (anakKost.getNilai() >= 85) {
            System.out.println("RESULT: LULUS CUMLAUDE!");
            System.out.println("Kamu lulus dengan nilai sempurna. Ortu bangga!");
        } else {
            System.out.println("RESULT: SURVIVOR");
            System.out.println("Kamu lulus dengan kondisi apa adanya. Yang penting sah!");
        }
        System.out.println("===========================================");
    }
}