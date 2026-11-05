package id.ac.uniska.pbo2.uts;

import com.formdev.flatlaf.FlatLightLaf;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class FormDaftarBelanja extends javax.swing.JFrame {
    private final BarangTableModel model = new BarangTableModel();
    private final NumberFormat rupiah = NumberFormat.getNumberInstance(new Locale("id", "ID"));

    public FormDaftarBelanja() {
        initComponents();
        setLocationRelativeTo(null);
        tblBarang.setModel(model);
        tblBarang.setRowHeight(25);
        tblBarang.setFillsViewportHeight(true);
        getRootPane().setDefaultButton(btnTambah);
        btnTambah.addActionListener(e -> tambahBarang());
        btnBersihkan.addActionListener(e -> bersihkanForm());
        txtNama.addActionListener(e -> tambahBarang());
        txtHarga.addActionListener(e -> tambahBarang());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        lblJudul = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblKategori = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        lblHarga = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        spJumlah = new javax.swing.JSpinner();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        lblPesan = new javax.swing.JLabel();
        scrollTabel = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblBayar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Belanja");
        setMinimumSize(new java.awt.Dimension(780, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJudul.setFont(new java.awt.Font("Dialog", 1, 22));
        lblJudul.setText("DAFTAR BELANJA");
        getContentPane().add(lblJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 300, 35));
        lblNama.setText("Nama Barang");
        getContentPane().add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 75, 110, 25));
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 75, 240, 28));
        lblKategori.setText("Kategori");
        getContentPane().add(lblKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 115, 110, 25));
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alat Tulis", "Makanan", "Minuman", "Lainnya" }));
        getContentPane().add(cmbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 115, 240, 28));
        lblHarga.setText("Harga (Rp)");
        getContentPane().add(lblHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 155, 110, 25));
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 155, 240, 28));
        lblJumlah.setText("Jumlah");
        getContentPane().add(lblJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, 110, 25));
        spJumlah.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        getContentPane().add(spJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 195, 90, 28));
        btnTambah.setText("Tambah");
        getContentPane().add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 105, 32));
        btnBersihkan.setText("Bersihkan");
        getContentPane().add(btnBersihkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 240, 105, 32));
        lblPesan.setForeground(new java.awt.Color(255, 0, 0));
        lblPesan.setText(" ");
        getContentPane().add(lblPesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 700, 25));
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal" }
        ));
        scrollTabel.setViewportView(tblBarang);
        getContentPane().add(scrollTabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 315, 720, 155));
        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14));
        lblTotal.setText("Total: Rp0");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 485, 210, 30));
        lblDiskon.setFont(new java.awt.Font("Dialog", 1, 14));
        lblDiskon.setText("Diskon: Rp0");
        getContentPane().add(lblDiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 485, 210, 30));
        lblBayar.setFont(new java.awt.Font("Dialog", 1, 14));
        lblBayar.setText("Bayar: Rp0");
        getContentPane().add(lblBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 485, 210, 30));

        pack();
    }
    // </editor-fold>

    private void tambahBarang() {
        String nama = txtNama.getText().trim();
        if (nama.isEmpty()) {
            gagal("Nama barang wajib diisi", txtNama);
            return;
        }
        if (model.sudahAda(nama)) {
            gagal("Barang " + nama + " sudah ada di daftar", txtNama);
            return;
        }
        String teksHarga = txtHarga.getText().trim();
        if (!teksHarga.matches("[0-9]+")) {
            gagal("Harga harus angka 1 sampai 10000000", txtHarga);
            return;
        }
        long harga;
        try {
            harga = Long.parseLong(teksHarga);
        } catch (NumberFormatException ex) {
            gagal("Harga harus angka 1 sampai 10000000", txtHarga);
            return;
        }
        if (harga < 1 || harga > 10_000_000) {
            gagal("Harga harus angka 1 sampai 10000000", txtHarga);
            return;
        }
        model.tambahBarang(new Barang(nama, (Kategori) cmbKategori.getSelectedItem(),
                harga, (Integer) spJumlah.getValue()));
        lblPesan.setText(" ");
        txtNama.setText("");
        txtHarga.setText("");
        cmbKategori.setSelectedIndex(0);
        spJumlah.setValue(1);
        perbaruiRingkasan();
        txtNama.requestFocusInWindow();
    }

    private void gagal(String pesan, JComponent komponen) {
        lblPesan.setText(pesan);
        komponen.requestFocusInWindow();
        if (komponen instanceof JTextField f) f.selectAll();
    }

    private void bersihkanForm() {
        txtNama.setText("");
        txtHarga.setText("");
        cmbKategori.setSelectedIndex(0);
        spJumlah.setValue(1);
        lblPesan.setText(" ");
        txtNama.requestFocusInWindow();
    }

    private void perbaruiRingkasan() {
        lblTotal.setText("Total: Rp" + rupiah.format(model.hitungTotal()));
        lblDiskon.setText("Diskon: Rp" + rupiah.format(model.hitungDiskon()));
        lblBayar.setText("Bayar: Rp" + rupiah.format(model.hitungBayar()));
    }

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new FormDaftarBelanja().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel lblBayar;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPesan;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JScrollPane scrollTabel;
    private javax.swing.JSpinner spJumlah;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    // End of variables declaration
}
