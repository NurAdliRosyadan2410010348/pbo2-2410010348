
package id.ac.uniska.pbo2.p07.mini.proyek;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelBukuModel extends AbstractTableModel {

    private final String[] namaKolom = {
        "Kode Buku",
        "Judul Buku",
        "Penulis",
        "Tahun Terbit",
        "Status"
    };

    private final List<Buku> daftarBuku = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftarBuku.size();
    }

    @Override
    public int getColumnCount() {
        return namaKolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return namaKolom[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Buku buku = daftarBuku.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return buku.getKode();
            case 1:
                return buku.getJudul();
            case 2:
                return buku.getPenulis();
            case 3:
                return buku.getTahun();
            case 4:
                return buku.getStatus();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        int baris = daftarBuku.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public void ubahBuku(int index, Buku buku) {
        daftarBuku.set(index, buku);
        fireTableRowsUpdated(index, index);
    }

    public void hapusBuku(int index) {
        daftarBuku.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Buku ambilBuku(int index) {
        return daftarBuku.get(index);
    }

    public int hitungBukuTersedia() {
        int jumlah = 0;

        for (Buku buku : daftarBuku) {
            if (buku.getStatus() == StatusBuku.TERSEDIA) {
                jumlah++;
            }
        }

        return jumlah;
    }
}
