public class SistemNyawa {
    public void mintaTransfer(AnakKost anakKost) {
        if (anakKost.getNyawa() > 0) {
            System.out.println(">> NYAWA: Ortu transfer 200rb!");
            anakKost.setUang(anakKost.getUang() + 200000);
            anakKost.setNyawa(0);
        } else {
            System.out.println(">> Jatah nyawa sudah habis!");
        }
    }
}