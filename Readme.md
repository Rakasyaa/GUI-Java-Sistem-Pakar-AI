# Sistem Pakar Diagnosa Penyakit - Java GUI

Proyek ini merupakan implementasi **Graphical User Interface (GUI)** menggunakan bahasa pemrograman **Java** untuk membuat aplikasi **sistem pakar** sederhana. Sistem pakar ini bertujuan membantu mendiagnosa penyakit berdasarkan gejala yang dialami pengguna, dengan pendekatan berbasis aturan (rule-based).

## Fitur Utama

- **Antarmuka Interaktif**: Menggunakan Java Swing untuk menampilkan pertanyaan secara dinamis dan respons pengguna melalui tombol.
- **Animasi & Suara**: Efek ketik pada pertanyaan dan suara latar untuk meningkatkan pengalaman pengguna.
- **Logika Diagnosa**: Sistem akan menampilkan hasil diagnosa berdasarkan jawaban pengguna sesuai aturan yang telah ditentukan.
- **Visualisasi**: Gambar dan ikon yang berubah sesuai interaksi pengguna.

## Cara Kerja

1. Pengguna akan menjawab serangkaian pertanyaan terkait gejala penyakit.
2. Jawaban disimpan dan diproses menggunakan aturan logika.
3. Hasil diagnosa ditampilkan di akhir sesi.

## Struktur File

- `MainFrameView.java`: Kode utama aplikasi GUI dan logika sistem pakar.
- `assets/`: Folder berisi gambar, ikon, dan file suara yang digunakan aplikasi.

## Prasyarat

- Java Development Kit (JDK)
- Library eksternal: [JLayer](http://www.javazoom.net/javalayer/javalayer.html) untuk pemutaran file MP3

## Menjalankan Aplikasi

1. Pastikan semua file aset (gambar, suara) tersedia di folder yang sesuai.
2. Kompilasi dan jalankan `MainFrameView.java` menggunakan IDE atau terminal.

```bash
javac MainFrameView.java
java MainFrameView
```

## Catatan

- Proyek ini hanya contoh sederhana dan dapat dikembangkan lebih lanjut sesuai kebutuhan.
- Pastikan path file aset sesuai dengan struktur folder pada komputer Anda.

---

**Author:**  
Sistem Pakar AI - Semester 5  