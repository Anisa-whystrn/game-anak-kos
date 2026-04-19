import java.util.Scanner;

public class GameEngine {
    public void mainkan() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== MEMULAI SIMULASI ANAK KOST ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        AnakKost pemain = new AnakKost(input.nextLine());

        // Inisialisasi Sistem
        SistemKejadian kejadian = new SistemKejadian();
        SistemAkademik akademik = new SistemAkademik();
        SistemEkonomi ekonomi = new SistemEkonomi();
        SistemKesehatan kesehatan = new SistemKesehatan();
        SistemNyawa nyawa = new SistemNyawa();
        TampilanLayar layar = new TampilanLayar();

        int hariTanpaBelajar = 0;

        // LOOP UTAMA: 30 HARI
        for (int h = 1; h <= 30; h++) {
            int jumlahBelajarHariIni = 0; 
            
            // Degradasi Harian (Awal Hari)
            if (h > 1) {
                pemain.setLapar(pemain.getLapar() + 10);
            }
            hariTanpaBelajar++;

            if (hariTanpaBelajar > 3) {
                System.out.println("\n(!) Peringatan: Kamu sudah 3 hari tidak menyentuh buku! (Nilai -5)");
                pemain.setNilai(pemain.getNilai() - 5);
            }

            // SUB-LOOP: 3 SHIFT (Pagi, Siang, Malam)
            String[] daftarWaktu = {"PAGI", "SIANG", "MALAM"};
            for (String waktu : daftarWaktu) {
                
                // Cek kondisi kalah setiap pergantian waktu
                if (cekKondisiKritis(pemain)) return;

                System.out.println("\n========================================");
                System.out.println(" HARI " + h + " [" + waktu + "]");
                System.out.println("========================================");
                
                layar.cetakStatus(pemain);
                kejadian.munculMasalah(pemain);

                int pil = 0;
                boolean pilihanValid = false;

                // Loop Validasi Input (Anti-Crash pakai hasNextInt)
                while (!pilihanValid) {
                    System.out.print("Pilih aksi (1-6): ");
                    
                    if (input.hasNextInt()) {
                        pil = input.nextInt();
                        
                        // 1. Cek Range Angka
                        if (pil < 1 || pil > 6) {
                            System.out.println(">> Pilihan tidak tersedia (Masukkan 1-6)!");
                        } 
                        // 2. Logika Teman Curhat
                        else if (kejadian.adaGangguanTeman && (pil == 2 || pil == 3 || pil == 5)) {
                            System.out.println(">> Gak bisa! Ada teman di kamar, tidak sopan kalau kamu pergi.");
                        }
                        else if (kejadian.adaGangguanTeman && pil == 4) {
                            System.out.println(">> Kamu makan sambil dengar curhat teman... (Lapar -20, Stress -5)");
                            pilihanValid = true; // Tetap bisa makan, tapi efeknya sudah diatur di SistemKesehatan
                        }
                        else if (kejadian.adaGangguanTeman && pil == 6) {
                            System.out.println(">> Kamu minta transfer sambil dengar curhat teman... (Nyawa tetap, Uang +200rb)");
                            pilihanValid = true; // Tetap bisa minta transfer, tapi efeknya sudah diatur di SistemNyawa
                        }

                        else if (kejadian.adaGangguanTeman && pil == 1) {
                            System.out.println(">> Kamu mencoba belajar sambil dengar curhat teman...");
                            pilihanValid = true; // Tetap bisa belajar, tapi efeknya sudah diatur di SistemAkademik
                        }
                        //3. logika prit tugas
                        else if (pil != 2 && kejadian.adaTugasPrint) {
                            System.out.println("Kamu tidak mengerjaan tugas  (Nilai -15, Stress +10)");
                            pilihanValid = true; // Tetap bisa pilih aksi lain, tapi efeknya sudah diatur di bawah

                        }
                        // 4. Logika Print Tanpa Tugas
                        else if (pil == 2 && !kejadian.adaTugasPrint) {
                            System.out.println(">> Tidak ada tugas yang perlu di-print saat ini.");
                            pilihanValid = false; // Tidak bisa pilih print jika tidak ada tugas
                        } 
                        // 5. Logika Mati Lampu
                        else if (kejadian.isMatiLampu && pil == 2) {
                            System.out.println(">> Listrik mati! Printer tidak bisa menyala.");
                            pilihanValid = false; // Tidak bisa pilih print saat mati lampu
                        }else if (kejadian.isMatiLampu && pil == 1) {
                            System.out.println(">> Listrik mati! Belajar di kegelapan tidak efektif.");
                            pilihanValid = false; // Tetap bisa pilih belajar, tapi efeknya sudah diatur di SistemAkademik
                        }else if (kejadian.isMatiLampu && pil == 6) {
                            System.out.println(">> Listrik mati! Minta transfer online tidak bisa dilakukan.");
                            pilihanValid = false; // Tidak bisa pilih minta transfer saat mati lampu
                        }else if (kejadian.isMatiLampu && pil == 3 ) {
                            System.out.println(">> Listrik mati! beli dulu token listrik.");
                            pilihanValid = false; // Tidak bisa pilih kerja saat mati lampu
                        }else if (kejadian.isMatiLampu && pil == 4 ) {
                            System.out.println(">> Listrik mati! beli dulu token listrik baru bisa makan nyaman.");
                            pilihanValid = false; // Tidak bisa pilih makan saat mati lampu
                        }
                        else {
                            pilihanValid = true; // Lolos semua pengecekan
                        }
                    } else {
                        // Jika input bukan angka (huruf/simbol)
                        System.out.println("(!) ERROR: Masukkan ANGKA (1-6), jangan huruf!");
                        input.next(); // Buang input yang salah
                    }
                }

                // EFEK SAMPING: Jika ada tugas tapi pilih hal lain
                if (kejadian.adaTugasPrint && pil != 2) {
                    System.out.println("(!) Kamu mengabaikan tugas print! Nilai berkurang -15 & Stress naik +10.");
                    pemain.setNilai(pemain.getNilai() - 15);
                    pemain.setStress(pemain.getStress() + 10);
                }

                // EKSEKUSI AKSI
                switch(pil) {
                    case 1: 
                        akademik.belajar(pemain, kejadian); 
                        hariTanpaBelajar = 0;
                        jumlahBelajarHariIni++; 
                        break;
                    case 2: 
                        akademik.printMakalah(pemain); 
                        break;
                    case 3: 
                        ekonomi.kerja(pemain, kejadian); 
                        break;
                    case 4: 
                        kesehatan.makan(pemain , kejadian); 
                        break;
                    case 5: 
                        ekonomi.beliToken(pemain, kejadian); 
                        break;
                    case 6: 
                        nyawa.mintaTransfer(pemain); 
                        break;
                    default:
                        System.out.println(">> Kamu hanya melamun...");
                        pemain.setStress(pemain.getStress() + 5);
                        break;
                }
            } // End of Sub-Loop

            // Bonus Akhir Hari
            if (jumlahBelajarHariIni == 3) {
                System.out.println("\n(!) WOW: Kamu belajar seharian penuh! (Nilai +10)");
                pemain.setNilai(pemain.getNilai() + 10);
            }
        } // End of 30 Days Loop

        SistemEnding.cekMenang(pemain);
    }

    private boolean cekKondisiKritis(AnakKost pemain) {
        if (pemain.getLapar() >= 100 || pemain.getUang() < 0 || 
            pemain.getNilai() <= 0 || pemain.getStress() >= 100) {
            SistemEnding.cekKalah(pemain);
            return true;
        }
        return false;
    }
}