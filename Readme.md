# 🩺 Sistem Pakar Diagnosa Penyakit - Java GUI  

Aplikasi ini adalah implementasi **Sistem Pakar** sederhana berbasis **Java GUI (Swing)**. Tujuannya untuk membantu pengguna melakukan **diagnosa awal penyakit** berdasarkan gejala yang dialami, dengan pendekatan **rule-based (berbasis aturan)**.  

## ✨ Fitur Utama  

✅ **Antarmuka Interaktif** – Pertanyaan ditampilkan secara dinamis melalui Java Swing.  
✅ **Efek Animasi & Suara** – Efek ketik pada teks pertanyaan + musik/efek suara pendukung.  
✅ **Logika Diagnosa** – Sistem menampilkan hasil diagnosa berdasarkan jawaban pengguna.  
✅ **Visualisasi Dinamis** – Gambar dan ikon dapat berubah sesuai interaksi.  

---

## ⚙️ Cara Kerja  

1. Pengguna menjawab pertanyaan seputar gejala yang dirasakan.  
2. Jawaban diproses oleh sistem dengan aturan tertentu.  
3. Hasil diagnosa ditampilkan dalam antarmuka GUI.  

---

## 📂 Struktur Proyek

```
SistemPakarDiagnosaPenyakit/
├── MainFrameView.java      # Kode utama GUI + logika sistem pakar
├── assets/                # Aset multimedia
│   ├── musik/             # File suara & background music
│   ├── images/            # Gambar & ikon
│   └── sfx/               # Efek suara tambahan
└── README.md              # Dokumentasi proyek
```


---

## 🛠️ Prasyarat  

- **Java Development Kit (JDK)** terinstal.  
- **Library eksternal**: [JLayer](http://www.javazoom.net/javalayer/javalayer.html) → untuk memutar file MP3.  

---

## ▶️ Menjalankan Aplikasi  

1. Pastikan folder `assets/` sudah lengkap (gambar, ikon, musik).  
2. Kompilasi dan jalankan:  

```bash
javac -cp ".;lib/jl1.0.1.jar" .\*.java
java -cp "bin;lib\jl1.0.1.jar" App
