package id.ac.uniska.pbo2.uts;

public enum Kategori {
    ALAT_TULIS("Alat Tulis"),
    MAKANAN("Makanan"),
    MINUMAN("Minuman"),
    LAINNYA("Lainnya");

    private final String nama;

    Kategori(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}
