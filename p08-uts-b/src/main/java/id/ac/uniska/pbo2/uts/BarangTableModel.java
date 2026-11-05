package id.ac.uniska.pbo2.uts;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BarangTableModel extends AbstractTableModel {
    private final String[] kolom = {
        "Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"
    };
    private final List<Barang> daftar = new ArrayList<>();
    private final NumberFormat rupiah = NumberFormat.getNumberInstance(new Locale("id", "ID"));

    @Override
    public int getRowCount() { return daftar.size(); }

    @Override
    public int getColumnCount() { return kolom.length; }

    @Override
    public String getColumnName(int column) { return kolom[column]; }

    @Override
    public Object getValueAt(int row, int column) {
        Barang b = daftar.get(row);
        return switch (column) {
            case 0 -> b.getNama();
            case 1 -> b.getKategori().toString();
            case 2 -> "Rp" + rupiah.format(b.getHarga());
            case 3 -> b.getJumlah();
            case 4 -> "Rp" + rupiah.format(b.hitungSubtotal());
            default -> "";
        };
    }

    public void tambahBarang(Barang barang) {
        int baris = daftar.size();
        daftar.add(barang);
        fireTableRowsInserted(baris, baris);
    }

    public boolean sudahAda(String nama) {
        return daftar.stream().anyMatch(b -> b.getNama().equalsIgnoreCase(nama.trim()));
    }

    public long hitungTotal() {
        return daftar.stream().mapToLong(Barang::hitungSubtotal).sum();
    }

    public long hitungDiskon() {
        return hitungTotal() >= 100_000 ? (long) Math.floor(hitungTotal() * 0.10) : 0;
    }

    public long hitungBayar() {
        return hitungTotal() - hitungDiskon();
    }
}
