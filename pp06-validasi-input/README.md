# Praktikum PBO 2 Pertemuan 6
## Validasi Input dan Kegunaan

### Identitas

| Keterangan | Detail |
|---|---|
| Nama | Nur Adli Rosyadan |
| NPM | 2410010348 |
| Mata Kuliah | Pemrograman Berbasis Objek 2 |
| Pertemuan | 6 |
| Materi | Validasi Input dan Kegunaan |
| Proyek | `p06-validasi-input` |

---

## 1. Peer Review

**Nama peninjau:** Muhammad Ivanda Stevhany  
**Nama pemilik form:** Nur Adli Rosyadan

Peer review dilakukan untuk mengevaluasi kemudahan penggunaan dan validasi pada `FormAnggotaPerpustakaan`.

<img width="844" height="1280" alt="7cddde1d-58be-4d26-a7d1-6e6ba9e5039d" src="https://github.com/user-attachments/assets/9ee83a37-e076-4391-bbfa-fd52e9b2581c" />


---

## 2. Jawaban Eksperimen Praktikum 4

### 1. Ketik huruf pada isian NPM. Apa yang terjadi dan baris mana di `npmFieldKeyTyped` yang menyebabkannya?

**Jawaban:**

Huruf tidak dapat dimasukkan ke dalam kolom NPM karena program hanya mengizinkan karakter angka. Hal tersebut diatur oleh kondisi:

```java
if (!Character.isDigit(evt.getKeyChar()) || panjang >= 10) {
    evt.consume();
}
```

`Character.isDigit()` memeriksa apakah karakter yang diketik merupakan angka. Jika bukan angka, `evt.consume()` membatalkan input tersebut. Kondisi `panjang >= 10` juga mencegah pengguna memasukkan lebih dari 10 digit.

### 2. Isi email dengan `siti@`, lalu tekan Tab. Kapan pesan kesalahan muncul?

**Jawaban:**

Pesan kesalahan muncul ketika fokus berpindah dari kolom email setelah tombol Tab ditekan. Perpindahan fokus memicu event `focusLost`, kemudian program menjalankan validasi email. Karena `siti@` belum merupakan alamat email yang valid, pesan kesalahan ditampilkan dan kolom email diberi tanda visual kesalahan.

### 3. Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?

**Jawaban:**

Tidak ada pesan kesalahan karena kolom Nama masih kosong dan validasi saat kehilangan fokus hanya dijalankan jika kolom tersebut sudah berisi teks. Hal ini mencegah pengguna langsung mendapatkan tanda kesalahan sebelum mulai mengisi formulir. Kolom kosong tetap akan diperiksa ketika tombol Daftar ditekan.

### 4. Centang persetujuan, lalu klik Daftar dengan form kosong. Isian mana yang mendapat fokus?

**Jawaban:**

Fokus diarahkan ke kolom NPM sebagai isian pertama yang tidak valid. Program memeriksa kolom secara berurutan, menghitung jumlah kesalahan, lalu menyimpan komponen pertama yang bermasalah untuk diberi fokus setelah dialog ringkasan kesalahan ditampilkan.

### 5. Tekan tombol Alt bersama huruf N. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?

**Jawaban:**

Pada rancangan praktikum, kombinasi Alt+N digunakan untuk memindahkan fokus ke kolom NPM. Fitur ini diatur menggunakan properti `displayedMnemonic` pada JLabel dan `labelFor` yang menghubungkan label dengan komponen input.

**Catatan penyesuaian pada kode saat ini:** Di `FormAnggotaPerpustakaan.java` yang diperiksa, `npmLabel` menggunakan `setDisplayedMnemonic('P')`, bukan `'N'`. Jadi, dengan kode saat ini kombinasi yang sesuai adalah **Alt+P**. Jika ingin jawaban eksperimen Alt+N sesuai instruksi, ubah menjadi:

```java
npmLabel.setDisplayedMnemonic('N');
npmLabel.setLabelFor(npmField);
```

### 6. Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?

**Jawaban:**

Ya, data tetap ada. Pilihan No pada dialog konfirmasi membatalkan proses pengosongan formulir. Method `kosongkanForm()` hanya dijalankan apabila pengguna memilih Yes, sehingga seluruh isian yang sudah dimasukkan tetap dipertahankan ketika memilih No.

---

## 3. Deklarasi Penggunaan AI

Saya menggunakan **ChatGPT** sebagai alat bantu dalam pengerjaan praktikum ini. AI digunakan untuk membantu memahami instruksi modul, memberikan saran perbaikan kode Java, membantu menyusun jawaban eksperimen Praktikum 4, serta merapikan dokumentasi README.md. Pemeriksaan, penyesuaian, pengujian, dan keputusan akhir terhadap kode tetap dilakukan oleh saya.
