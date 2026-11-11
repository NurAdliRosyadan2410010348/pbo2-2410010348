# PBO 2 Pertemuan 5 — Event Handling

## Identitas Mahasiswa

| Keterangan | Data |
|---|---|
| Nama | Nur Adli Rosyadan |
| NPM | 2410010348 |
| Kelas | 5A |
| Mata Kuliah | Pemrograman Berbasis Objek 2 |
| Pertemuan | 5 — Event Handling |

## 1. Tabel Pengamatan Praktikum 2 — Mengamati Event

Tabel berikut berisi event yang diharapkan tercatat ketika setiap tindakan dilakukan pada aplikasi `PengamatEvent`.

| No. | Tindakan | Event yang tercatat |
|---:|---|---|
| 1 | Arahkan kursor ke tombol, lalu jauhkan | `MouseEvent`: `mouseEntered` ketika kursor masuk ke tombol dan `mouseExited` ketika kursor meninggalkan tombol. |
| 2 | Klik tombol **Klik saya** | `ActionEvent`: `actionPerformed` ketika tombol diklik. |
| 3 | Centang lalu hapus centang **Aktifkan fitur** | `ItemEvent`: `itemStateChanged` ketika checkbox dicentang dan ketika centangnya dihapus. |
| 4 | Ganti pilihan dari **Pagi** menjadi **Malam** | `ItemEvent`: `itemStateChanged` terjadi ketika pilihan berubah. Dengan pemeriksaan `ItemEvent.SELECTED`, pencatatan dilakukan untuk pilihan baru, yaitu **Malam**. |
| 5 | Klik isian, lalu ketik `abc` | `FocusEvent`: `focusGained` ketika isian mendapat fokus. Selanjutnya `KeyEvent`: `keyTyped` tercatat untuk karakter `a`, `b`, dan `c`. |
| 6 | Klik tombol setelah mengetik di isian | `FocusEvent`: `focusLost` ketika fokus meninggalkan isian, kemudian `ActionEvent`: `actionPerformed` ketika tombol diklik. `MouseEvent` `mouseEntered` juga dapat tercatat jika kursor masuk ke tombol. |

## 2. Jawaban Eksperimen Praktikum 3 — Konversi Suhu

### Eksperimen 1 — Menghapus pemeriksaan `ItemEvent.SELECTED`

Pesan `item berubah` akan tercetak **dua kali** setiap pilihan Combo Box diganti. Hal ini terjadi karena `itemStateChanged` dipanggil untuk dua perubahan, yaitu item pilihan lama yang berstatus `DESELECTED` dan item pilihan baru yang berstatus `SELECTED`. Pemeriksaan `ItemEvent.SELECTED` diperlukan agar aksi hanya dijalankan untuk pilihan yang baru dipilih.

### Eksperimen 2 — Mengganti `keyReleased` dengan `keyPressed`

Hasil konversi terlihat terlambat satu karakter karena `keyPressed` dipanggil ketika tombol keyboard ditekan, sebelum karakter baru dimasukkan ke dalam `JTextField`. Akibatnya, method `konversi()` membaca isi kolom yang belum memuat karakter tersebut. Berbeda dengan `keyReleased`, event ini terjadi setelah tombol dilepas sehingga karakter sudah masuk ke kolom isian.

### Eksperimen 3 — Menghapus blok `try-catch`

Ketika huruf dimasukkan, `Double.parseDouble()` tidak dapat mengubah teks tersebut menjadi angka sehingga menghasilkan `NumberFormatException`. Jika blok `try-catch` dihapus, exception tidak ditangani oleh method `konversi()` dan informasi kesalahan berupa stack trace akan muncul di jendela **Output** NetBeans. Program tidak dapat menampilkan pesan validasi melalui `hasilLabel` dari blok `catch` karena blok tersebut sudah dihapus.

## 3. Jawaban Eksperimen Praktikum 4 — Kalkulator Sederhana

### Eksperimen 1 — Memasang dua listener pada tombol perkalian

Jika event `actionPerformed` dibuat melalui GUI Builder tanpa menghapus lambda `kaliButton.addActionListener(e -> hitung('x'))` di konstruktor, tombol perkalian memiliki dua listener. Ketika tombol diklik, kedua listener dijalankan sehingga pesan `kali` tercetak **dua kali** jika perintah `System.out.println("kali");` ditambahkan pada kedua tempat.

Satu tombol sebaiknya hanya menggunakan satu cara untuk menangani aksi yang sama agar proses tidak dijalankan dua kali dan kode lebih mudah dipelihara.

### Eksperimen 2 — Menambahkan operator modulus (`%`)

Perubahan yang diperlukan adalah:

- **Tab Design:** Menambahkan tombol `%` pada panel operator, mengatur teks tombol dan nama variabelnya, serta menyesuaikan layout agar tombol tersebut dapat ditampilkan.
- **Tab Source:** Menghubungkan tombol dengan pemanggilan `hitung('%')`, kemudian menambahkan kondisi operator `%` pada method `hitung()` dengan operasi `a % b`.

Operator modulus digunakan untuk mendapatkan sisa hasil pembagian. Contohnya, `10 % 3` menghasilkan `1`.

### Eksperimen 3 — Fokus setelah tombol Hapus ditekan

Kursor langsung berada di isian angka pertama karena method `hapus()` menjalankan perintah `angka1Field.requestFocusInWindow()`. Perintah tersebut meminta komponen `angka1Field` mendapatkan fokus kembali setelah kedua kolom dikosongkan.

## 4. Peta Event — Form Anggota Perpustakaan

| No. | Komponen | Menu Events | Aksi yang diharapkan |
|---:|---|---|---|
| 1 | Checkbox persetujuan (`setujuCheck`) | `Item` → `itemStateChanged` | Tombol **Daftar** hanya aktif jika checkbox dicentang. |
| 2 | Tombol **Batal** (`batalButton`) | `Action` → `actionPerformed` | Mengosongkan seluruh isian dan mengembalikan fokus ke kolom NPM. |
| 3 | Tombol **Daftar** (`daftarButton`) | `Action` → `actionPerformed` | Menampilkan ringkasan data anggota menggunakan `JOptionPane`. |
| 4 | Isian NPM (`npmField`) | `Key` → `keyReleased` | Menampilkan jumlah digit NPM, misalnya `8 dari 10 digit`. |
| 5 | Form (`FormAnggotaPerpustakaan`) | `Window` → `windowClosing` | Meminta konfirmasi sebelum aplikasi ditutup. |

### Pengaturan form

- `defaultCloseOperation` diatur menjadi `DO_NOTHING_ON_CLOSE`.
- Properti `enabled` pada tombol **Daftar** diatur menjadi `false` saat aplikasi pertama kali dibuka.
- Event dibuat melalui menu **Events** pada GUI Builder sesuai instruksi modul.
- Pada event `itemStateChanged`, aksi checkbox mengikuti status pilihan checkbox agar tombol Daftar aktif hanya ketika persetujuan dicentang.

## 5. Jawaban Pertanyaan Refleksi

### 1. Jelaskan peran sumber event, object event, dan listener dengan contoh dari kode Anda.

- **Sumber event** adalah komponen tempat suatu kejadian terjadi. Contohnya `klikButton`, yaitu tombol yang menjadi sumber event ketika diklik.
- **Object event** adalah objek yang membawa informasi tentang kejadian tersebut. Contohnya `ActionEvent` yang diterima oleh parameter `evt` pada method `klikButtonActionPerformed`.
- **Listener** adalah objek yang menerima dan menangani kejadian setelah didaftarkan pada komponen. Contohnya `ActionListener` yang menjalankan method `actionPerformed()` ketika tombol diklik.

Ketiganya bekerja bersama agar aplikasi dapat merespons tindakan pengguna.

### 2. Mengapa `KeyListener` tidak dapat ditulis dengan lambda, dan bagaimana NetBeans mengatasinya saat Anda memilih event `keyReleased`?

`KeyListener` tidak dapat ditulis dengan lambda biasa karena memiliki tiga method abstrak, yaitu `keyPressed()`, `keyReleased()`, dan `keyTyped()`. Lambda hanya dapat digunakan pada interface fungsional yang memiliki satu method abstrak. Saat event `keyReleased` dipilih melalui GUI Builder, NetBeans menggunakan `KeyAdapter` yang sudah menyediakan implementasi kosong untuk method lainnya. Dengan begitu, kita cukup menulis method `keyReleased()` yang diperlukan.

### 3. Apa keuntungan memisahkan `KonverterSuhu` dari form `KonversiSuhu`?

Pemisahan membuat kode perhitungan tidak bercampur dengan kode tampilan. Kelas `KonverterSuhu` berisi logika konversi, sedangkan `KonversiSuhu` menangani input, event, dan tampilan hasil. Dengan cara ini, logika konversi lebih mudah diuji, diperbaiki, dan digunakan kembali oleh form atau program lain tanpa harus membuat tampilan baru.

### 4. Mengapa aksi pada `itemStateChanged` perlu memeriksa `ItemEvent.SELECTED`?

Karena ketika pilihan pada Combo Box berubah, event `itemStateChanged` dapat dipanggil dua kali: sekali untuk pilihan lama yang dilepas (`DESELECTED`) dan sekali untuk pilihan baru yang dipilih (`SELECTED`). Pemeriksaan `ItemEvent.SELECTED` memastikan aksi hanya dijalankan untuk pilihan baru sehingga tidak terjadi pemrosesan atau pencatatan dua kali.

### 5. Kapan Anda memakai event handler dari GUI Builder, lambda, atau method reference?

- **Event handler GUI Builder** digunakan ketika membuat event pada komponen form melalui menu **Events**, terutama untuk event yang perlu dikelola langsung oleh GUI Builder.
- **Lambda** digunakan untuk aksi singkat pada interface fungsional, misalnya `ActionListener` pada tombol perkalian.
- **Method reference** digunakan ketika aksi sudah tersedia dalam method tersendiri dan ingin dihubungkan langsung ke listener, misalnya `hapusButton.addActionListener(this::hapus)`.

Pemilihan cara disesuaikan dengan kebutuhan agar kode tetap jelas dan satu aksi tidak terhubung melalui lebih dari satu listener.

## 6. Deklarasi Penggunaan AI

Saya menggunakan **ChatGPT** sebagai alat bantu untuk memahami materi event handling, membantu menyusun dan memeriksa kode Java, serta menyusun draft jawaban eksperimen, pertanyaan refleksi, dan dokumentasi README. Hasil kode dan jawaban tetap perlu diperiksa serta diuji kembali melalui Apache NetBeans.

## 7. Checklist Pengumpulan

- [ ] Repository GitHub berisi proyek `p05-event-handling`.
- [ ] File `FormAnggotaPerpustakaan.java` dan `FormAnggotaPerpustakaan.form` tersedia di repository.
- [ ] File `.java` dan `.form` untuk form praktikum yang diminta tersedia.
- [ ] Tabel pengamatan Praktikum 2 telah diperiksa berdasarkan hasil pengujian aplikasi.
- [ ] Jawaban eksperimen Praktikum 3 dan Praktikum 4 telah dicantumkan.
- [ ] Peta event Form Anggota Perpustakaan sesuai dengan event pada file `.form`.
- [ ] Screenshot asli Properties bagian **Events** pada tombol Daftar dilampirkan.
- [ ] Screenshot asli dialog ringkasan pendaftaran dilampirkan.
- [ ] Screenshot asli dialog konfirmasi keluar dilampirkan.
- [ ] Commit Git menggunakan pesan yang menjelaskan perubahan.

## 8. Referensi

1. Oracle. *The Java Tutorials: Writing Event Listeners*. https://docs.oracle.com/javase/tutorial/uiswing/events/
2. Apache NetBeans. *Handling Events in the GUI Builder*. https://netbeans.apache.org/
3. Horstmann, C. S. *Core Java, Volume I: Fundamentals*. Edisi ke-13. Pearson/Oracle Press, 2024.
