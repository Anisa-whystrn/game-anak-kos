public class SistemKejadian {
    public boolean adaTugasPrint = false; 
    public boolean adaGangguanTeman = false;
    public boolean isMatiLampu = false;

    public void munculMasalah(AnakKost ak) {
        adaGangguanTeman = false;
        adaTugasPrint = false; // Reset setiap waktu aksi

        int angkaAcak = new java.util.Random().nextInt(10);
        
        if (angkaAcak == 1) {
            System.out.println("(!) KEJADIAN: Teman datang curhat!");
            adaGangguanTeman = true;
        } else if (angkaAcak == 2) {
            System.out.println("(!) KEJADIAN: Dosen kirim instruksi: Print Laporan sekarang!");
            adaTugasPrint = true; 
        } else if (angkaAcak == 0 && !isMatiLampu) {
            System.out.println("(!) KEJADIAN: Token Listrik Habis!");
            isMatiLampu = true;
        } else {
            System.out.println("(!) KEJADIAN: Suasana tenang.");
        }
    }
}