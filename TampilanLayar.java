public class TampilanLayar {
    // Ubah dari (int hari, AnakKost ak) menjadi (AnakKost ak) saja
    public void cetakStatus(AnakKost ak) {
        System.out.println("[ STATUS: " + ak.getNama() + " ]");
        System.out.println("Uang   : Rp" + ak.getUang());
        System.out.println("Lapar  : " + ak.getLapar() + "/100");
        System.out.println("Stress : " + ak.getStress() + "/100");
        System.out.println("Nilai  : " + ak.getNilai() + "/100");
        System.out.println("Nyawa  : " + ak.getNyawa());
        System.out.println("-------------------------");
        System.out.println("PILIHAN AKSI:");
        System.out.println("1. Belajar");
        System.out.println("2. Print Makalah");
        System.out.println("3. Kerja Part-Time");
        System.out.println("4. Makan");
        System.out.println("5. Beli Token Listrik");
        System.out.println("6. Minta Transfer (Nyawa)");
    }
}