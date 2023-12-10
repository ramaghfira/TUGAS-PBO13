import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LoginMenu loginMenu = new LoginMenu();

            if (loginMenu.login(scanner)) {
                showMainMenu(scanner);
            } else {
                System.out.println("Login gagal. Program berhenti.");
            }
        }
    }

    private static void showMainMenu(Scanner scanner) {
        System.out.println("NIMINOT MARKET");
        System.out.println("Tanggal : " + getCurrentDate());
        System.out.println("Waktu   : " + getCurrentTime());
        System.out.println("========================");

        // Data pelanggan
        System.out.println("DATA PELANGGAN");
        System.out.println("---------------------");
        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("No. HP                 : ");
        String noHp = scanner.nextLine();
        System.out.print("Alamat                 : ");
        String alamat = scanner.nextLine();
        System.out.println("++++++++++++++++++++++++");

        // Data pembelian barang
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("------------------------------");
        System.out.print("Kode Barang       : ");
        String kodeBarang = scanner.nextLine();
        System.out.print("Nama Barang     : ");
        String namaBarang = scanner.nextLine();
        System.out.print("Harga Barang     : ");
        double hargaBarang = scanner.nextDouble();
        System.out.print("Jumlah Beli         : ");
        int jumlahBeli = scanner.nextInt();

        // Membuat objek Pelanggan dan Barang
        Pelanggan pelanggan = new Pelanggan(namaPelanggan, noHp, alamat);
        Barang barang = new Barang(kodeBarang, namaBarang, hargaBarang);

        // Menghitung total bayar
        double totalBayar = HitungTotalBayar.hitungTotalBayar(barang.getHargaBarang(), jumlahBeli);

        // Menampilkan hasil
        System.out.println("\n\nNIMINOT MARKET");
        System.out.println("Tanggal : " + getCurrentDate());
        System.out.println("Waktu   : " + getCurrentTime());
        System.out.println("========================");
        System.out.println("DATA PELANGGAN");
        System.out.println("---------------------");
        System.out.println("Nama Pelanggan : " + pelanggan.getNamaPelanggan());
        System.out.println("No. HP                 : " + pelanggan.getNoHp());
        System.out.println("Alamat                 : " + pelanggan.getAlamat());
        System.out.println("++++++++++++++++++++++++");
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("------------------------------");
        System.out.println("Kode Barang       : " + barang.getKodeBarang());
        System.out.println("Nama Barang     : " + barang.getNamaBarang());
        System.out.println("Harga Barang     : " + barang.getHargaBarang());
        System.out.println("Jumlah Beli         : " + jumlahBeli);
        System.out.println("TOTAL BAYAR      : " + totalBayar);
        System.out.println("++++++++++++++++++++++++");
        System.out.print("Kasir    : ");
        scanner.next();
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    private static String getCurrentTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");
        return timeFormat.format(new Date());
    }
}