# Penggunaan AI

## AI yang Digunakan

**Claude**

Dalam pembuatan aplikasi `FormTiketTravel`, saya menggunakan Claude sebagai bantuan ketika mengerjakan beberapa bagian program yang berhubungan dengan Java Swing. AI digunakan terutama untuk memahami cara mengambil data dari komponen form, membuat event pada tombol, mengganti tema aplikasi dengan FlatLaf, serta membantu mencari solusi ketika muncul error pada program.

AI digunakan sebagai referensi selama pengerjaan. Kode yang diberikan tidak langsung digunakan semuanya, tetapi saya sesuaikan kembali dengan komponen dan nama variabel yang ada di project.

---

## Prompt 1 – Mengambil Data dari Form

### Prompt

> "Saya sedang membuat form pemesanan tiket travel menggunakan Java Swing. Pada form terdapat input nama, nomor HP, tujuan, pilihan kelas menggunakan JRadioButton, fasilitas menggunakan JCheckBox, dan catatan menggunakan JTextArea. Saya ingin ketika tombol Pesan ditekan, semua data tersebut ditampilkan dalam JOptionPane. Bisa berikan contoh kode yang sederhana?"

### Hasil Bantuan AI

Claude menjelaskan bahwa cara mengambil data tergantung pada komponen yang digunakan. Untuk `JTextField` dan `JTextArea`, data dapat diambil dengan `getText()`. Pada `JComboBox`, pilihan yang sedang dipilih dapat diperoleh menggunakan `getSelectedItem()`. Sedangkan untuk `JRadioButton` dan `JCheckBox`, status pilihannya dapat dicek dengan `isSelected()`.

Contoh kode yang diberikan:

```java
private void prosesPemesanan() {

    String nama = namaPemesanField.getText();
    String hp = nomorHpField.getText();
    String tujuan = (String) kotaTujuanCombo.getSelectedItem();

    String kelas = "Belum dipilih";

    if (ekonomiRadio.isSelected()) {
        kelas = "Ekonomi";
    } else if (bisnisRadio.isSelected()) {
        kelas = "Bisnis";
    } else if (eksekutifRadio.isSelected()) {
        kelas = "Eksekutif";
    }

    String fasilitas = "";

    if (bagasiCheck.isSelected()) {
        fasilitas += "Bagasi ";
    }

    if (makanCheck.isSelected()) {
        fasilitas += "Makan ";
    }

    if (asuransiCheck.isSelected()) {
        fasilitas += "Asuransi";
    }

    if (fasilitas.isEmpty()) {
        fasilitas = "Tidak ada";
    }

    String hasil =
            "DATA PEMESANAN\n"
            + "----------------------\n"
            + "Nama      : " + nama
            + "\nNo. HP    : " + hp
            + "\nTujuan    : " + tujuan
            + "\nKelas     : " + kelas
            + "\nFasilitas : " + fasilitas
            + "\nCatatan   : " + catatanArea.getText();

    JOptionPane.showMessageDialog(
            this,
            hasil,
            "Detail Pemesanan",
            JOptionPane.INFORMATION_MESSAGE
    );
}
```

Kode tersebut kemudian disesuaikan dengan nama komponen yang digunakan pada project `FormTiketTravel`. Fungsinya adalah mengumpulkan data yang telah diisi pengguna lalu menampilkannya sebagai ringkasan pemesanan.

---

## Prompt 2 – Membuat Dark Mode

### Prompt

> "Saya ingin menambahkan Dark Mode pada aplikasi Java Swing yang menggunakan FlatLaf. Saya sudah menggunakan JToggleButton. Jika tombol dinyalakan, tema berubah menjadi FlatDarkLaf dan jika dimatikan kembali ke FlatLightLaf. Bagaimana cara membuatnya?"

### Hasil Bantuan AI

Claude menyarankan untuk menggunakan `isSelected()` pada `JToggleButton` untuk mengetahui apakah tombol sedang aktif atau tidak. Berdasarkan kondisi tersebut, program dapat menentukan tema yang akan digunakan.

Contoh kode:

```java
private void ubahTema() {

    if (temaToggle.isSelected()) {
        FlatDarkLaf.setup();
        temaToggle.setText("Light Mode");
    } else {
        FlatLightLaf.setup();
        temaToggle.setText("Dark Mode");
    }

    FlatLaf.updateUI();
}
```

Kemudian method tersebut dipanggil ketika `JToggleButton` ditekan:

```java
private void temaToggleActionPerformed(
        java.awt.event.ActionEvent evt) {

    ubahTema();
}
```

Dengan cara ini, pengguna dapat mengganti tampilan aplikasi melalui satu tombol tanpa harus menutup dan menjalankan ulang program.

---

## Prompt 3 – Mencari Penyebab Error pada Komponen

### Prompt

> "Di project Java Swing saya muncul error karena ada nama variabel komponen yang tidak dikenali. Project dibuat menggunakan NetBeans GUI Builder. Bagaimana cara mengecek nama variabel komponen dan memperbaikinya tanpa mengubah bagian kode otomatis NetBeans?"

### Hasil Bantuan AI

Claude menjelaskan bahwa error tersebut bisa terjadi jika nama variabel yang digunakan dalam source code tidak sama dengan nama variabel komponen pada GUI Builder.

Untuk mengeceknya, komponen dapat dipilih melalui tampilan **Design** pada NetBeans. Kemudian nama variabelnya dapat dilihat dan diubah melalui pengaturan komponen atau menggunakan fitur **Change Variable Name**.

Contohnya, apabila kode menggunakan:

```java
temaToggle.isSelected();
```

maka komponen `JToggleButton` pada GUI Builder harus mempunyai nama variabel `temaToggle`.

Claude juga menyarankan agar perubahan komponen dilakukan melalui GUI Builder dan bukan dengan mengubah isi `initComponents()` secara manual. Hal ini dilakukan untuk menghindari masalah ketika NetBeans membuat ulang kode form.

---

# Alasan Menggunakan AI

Claude digunakan sebagai bantuan selama proses pengerjaan aplikasi `FormTiketTravel`. Penggunaan AI dilakukan ketika saya mengalami kesulitan memahami cara kerja beberapa komponen Java Swing atau ketika membutuhkan contoh penerapan kode.

Beberapa hal yang dibantu oleh AI antara lain mengambil nilai dari `JTextField`, `JTextArea`, dan `JComboBox`, mengecek pilihan pada `JRadioButton` dan `JCheckBox`, membuat tampilan hasil menggunakan `JOptionPane`, serta menerapkan pergantian tema menggunakan FlatLaf.

AI juga digunakan untuk membantu memahami error yang muncul selama proses coding. Setelah mendapatkan penjelasan dari AI, kode tetap diperiksa dan dicoba kembali pada project untuk memastikan sesuai dengan struktur program yang dibuat.

Kode yang diberikan Claude tidak langsung disalin seluruhnya. Beberapa bagian disesuaikan, terutama nama variabel dan nama komponen yang berbeda dengan contoh dari AI. Pembuatan tampilan form sendiri tetap dilakukan menggunakan **NetBeans GUI Builder**.

Dengan penggunaan AI ini, proses pengerjaan menjadi lebih mudah terutama ketika menemui bagian kode yang belum dipahami. Selain mendapatkan contoh kode, saya juga dapat mengetahui fungsi dari beberapa method seperti `getText()`, `getSelectedItem()`, `isSelected()`, `setText()`, dan `FlatLaf.updateUI()`.

Secara keseluruhan, Claude digunakan sebagai **alat bantu belajar dan mencari solusi**, sedangkan proses pembuatan, penyesuaian, dan pengujian aplikasi tetap dilakukan pada project `FormTiketTravel`.