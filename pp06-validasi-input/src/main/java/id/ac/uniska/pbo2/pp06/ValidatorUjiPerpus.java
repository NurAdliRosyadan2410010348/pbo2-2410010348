// Nur Adli Rosyadan
// 2410010348

package id.ac.uniska.pbo2.pp06;

/**
 * Menguji aturan validasi Validator tanpa GUI.
 */
public class ValidatorUjiPerpus {

    private static int gagal = 0;

    private static void cek(String namaPengujian, String hasil, boolean harusValid) {
        boolean valid = (hasil == null);

        if (valid != harusValid) {
            gagal++;
        }

        String status = (valid == harusValid) ? "SESUAI" : "SALAH";
        System.out.println(
            status + " " + namaPengujian + ": " + (valid ? "valid" : hasil)
        );
    }

    public static void main(String[] args) {

        // Pengujian NPM
        cek("NPM kosong", Validator.npm(""), false);
        cek("NPM kurang dari 10 digit", Validator.npm("12345"), false);
        cek("NPM mengandung huruf", Validator.npm("24100103ab"), false);
        cek("NPM benar", Validator.npm("2410010348"), true);

        // Pengujian nama
        cek("Nama kosong", Validator.nama(""), false);
        cek("Nama terlalu pendek", Validator.nama("Al"), false);
        cek("Nama mengandung angka", Validator.nama("Adli123"), false);
        cek("Nama benar", Validator.nama("Nur Adli Rosyadan"), true);

        // Pengujian email
        cek("Email tanpa domain", Validator.email("adli@"), false);
        cek("Email benar", Validator.email("adli@example.com"), true);

        // Pengujian nomor HP
        cek("Nomor HP terlalu pendek", Validator.nomorHp("0812"), false);
        cek("Nomor HP diawali 62", Validator.nomorHp("6281234567890"), false);
        cek("Nomor HP 12 digit", Validator.nomorHp("081234567890"), true);

        System.out.println();

        if (gagal == 0) {
            System.out.println("Semua aturan bekerja sesuai harapan");
        } else {
            System.out.println(gagal + " aturan belum sesuai");
        }
    }
}
