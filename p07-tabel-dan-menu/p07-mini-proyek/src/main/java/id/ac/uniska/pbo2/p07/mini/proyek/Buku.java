
package id.ac.uniska.pbo2.p07.mini.proyek;

public class Buku {

    private String kode;
    private String judul;
    private String penulis;
    private int tahun;
    private StatusBuku status;

    public Buku(String kode, String judul, String penulis,
                int tahun, StatusBuku status) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
        this.status = status;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahun() {
        return tahun;
    }

    public StatusBuku getStatus() {
        return status;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setStatus(StatusBuku status) {
        this.status = status;
    }
}
