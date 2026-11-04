# Praktikum 5 – Eksperimen JTable, Dialog, dan Menu

## Pendahuluan
Dokumen ini berisi hasil pembahasan eksperimen pada Modul Praktikum PBO 2 Pertemuan 7. Eksperimen dilakukan menggunakan contoh aplikasi Daftar Kontak untuk memahami hubungan antara model data, JTable, dialog, serta menu dan shortcut keyboard.

## Pembahasan Eksperimen

### Eksperimen 1 – Notifikasi perubahan pada TableModel
**Pertanyaan:** Apa yang terjadi jika pemanggilan `fireTableRowsInserted(baris, baris);` dijadikan komentar, kemudian pengguna menambahkan kontak?

**Jawaban:** Kontak tetap masuk ke dalam data yang disimpan oleh model, tetapi tampilan JTable tidak langsung diperbarui. Penyebabnya adalah JTable tidak menerima pemberitahuan bahwa ada baris baru. Method `fireTableRowsInserted()` berfungsi mengirim notifikasi perubahan dari model kepada tabel. Tanpa notifikasi tersebut, isi model dan tampilan tabel dapat menjadi tidak sinkron sampai ada proses pembaruan lain.

### Eksperimen 2 – Perbedaan indeks tampilan dan indeks model
**Pertanyaan:** Setelah method `barisTerpilih()` diubah agar hanya mengembalikan `kontakTable.getSelectedRow()`, cari “ah”, pilih Ahmad Fauzi, lalu tekan Hapus dan pilih No. Nama siapa yang ditampilkan pada konfirmasi?

**Jawaban:** Nama yang berpotensi muncul adalah **Budi Santoso**. Pada hasil penyaringan “ah”, Ahmad Fauzi berada pada baris tampilan kedua (indeks 1), sedangkan data pada indeks 1 di model asli adalah Budi Santoso. Hal ini terjadi karena `getSelectedRow()` memberikan indeks berdasarkan urutan yang sedang terlihat di JTable. Indeks itu tidak boleh langsung dipakai untuk mengambil data dari model ketika tabel sedang disaring atau diurutkan. Solusinya adalah mengonversi indeks menggunakan `convertRowIndexToModel()`.

### Eksperimen 3 – Perilaku dialog modeless
**Pertanyaan:** Apa akibatnya jika argumen modal pada `super(pemilik, judul, true)` diganti menjadi `false`?

**Jawaban:** Dialog berubah menjadi modeless sehingga jendela utama tetap dapat menerima interaksi meskipun dialog masih terbuka. Pemanggilan `setVisible(true)` tidak lagi menunggu dialog ditutup. Karena itu, proses pada jendela utama dapat berlanjut sebelum pengguna menekan Simpan. Jika hasil dialog diperiksa langsung setelah dialog ditampilkan, data yang baru akan diinput belum tersedia untuk ditambahkan ke tabel.

### Eksperimen 4 – Ketergantungan shortcut pada pilihan baris
**Pertanyaan:** Mengapa Ctrl+E dan Ctrl+D tidak berfungsi ketika tidak ada kontak yang dipilih?

**Jawaban:** Shortcut tersebut terhubung dengan perintah Edit dan Hapus. Kedua perintah dinonaktifkan selama belum ada baris yang dipilih. Sebaliknya, Ctrl+N untuk menambah kontak tetap dapat digunakan karena penambahan data tidak membutuhkan pilihan baris sebelumnya. Pengaturan ini mencegah pengguna menjalankan aksi edit atau hapus tanpa menentukan data yang akan diproses.

### Eksperimen 5 – Mengganti accelerator menu Hapus
**Pertanyaan:** Apa perubahan pada `initComponents()` ketika accelerator menu Hapus diatur menjadi tombol Delete tanpa Ctrl?

**Jawaban:** Pengaturan accelerator pada `hapusItem` berubah dari kombinasi Ctrl+D menjadi tombol Delete tanpa modifier. Kode yang dihasilkan GUI Builder menggunakan `KeyEvent.VK_DELETE` dan modifier `0` pada pemanggilan `KeyStroke.getKeyStroke(...)`. Perubahan tersebut menunjukkan bahwa shortcut menu disimpan sebagai properti komponen dan diterjemahkan menjadi kode Java oleh GUI Builder.

Contoh bentuk pengaturannya:

```java
hapusItem.setAccelerator(
    javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_DELETE, 0
    )
);
```

### Eksperimen 6 – Inisialisasi objek model
**Pertanyaan:** Apa penyebab error jika deklarasi `model` hanya `private KontakTableModel model;` dan objeknya baru dibuat setelah `initComponents()`?

**Jawaban:** Deklarasi atribut hanya menyediakan variabel referensi, belum membuat objek `KontakTableModel`. Sebelum baris inisialisasi dijalankan, nilai `model` masih `null`. Jika `initComponents()` atau kode yang dipanggil sebelumnya sudah mencoba menggunakan `model`, program dapat menghasilkan `NullPointerException`. Oleh sebab itu, objek model harus dibuat sebelum komponen atau method lain mengaksesnya. Jika model memang diinisialisasi setelah `initComponents()`, pastikan tidak ada kode di dalam proses inisialisasi yang lebih dahulu menggunakan model tersebut.

## Kesimpulan
Eksperimen ini memperlihatkan beberapa prinsip penting dalam pengembangan aplikasi Java Swing:

- Model harus mengirim notifikasi agar JTable mengetahui perubahan data.
- Indeks baris pada tampilan dapat berbeda dari indeks pada model akibat filter dan sorting.
- Dialog modal dan modeless memiliki perilaku berbeda terhadap jendela utama dan alur program.
- Status aktif atau nonaktif pada menu dapat membatasi aksi berdasarkan kondisi pemilihan data.
- Accelerator menu dapat diatur melalui GUI Builder.
- Objek harus diinisialisasi sebelum digunakan untuk menghindari `NullPointerException`.

## Referensi
Modul Praktikum PBO 2 Pertemuan 7, bagian Eksperimen, halaman 11–12.
