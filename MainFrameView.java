import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.io.FileInputStream;
import javazoom.jl.player.Player; // dari JLayer/

import java.util.Random;

public class MainFrameView extends JFrame {
    Random rand = new Random();
    private Thread soundThread;
    private Player typingPlayer;

    JLabel pertanyaan;  
    JLabel Labelorang;

    private String currentText = "";
    private int index = 0;
    private int index_pertanyaan = 0;
    private Timer timer;

    boolean[] L = new boolean[26]; // index 1..25


    public MainFrameView() {
        setTitle("icik icik");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        renderUI();
    }

    public void renderUI(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        add(mainPanel);

        JLayeredPane headerLayeredPane = new JLayeredPane();
        headerLayeredPane.setPreferredSize(new Dimension(1280, 720));

        JLabel backgroundLabel = new JLabel(new ImageIcon(new ImageIcon("assets/Ruang.png").getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        backgroundLabel.setBounds(0, 0, 1280, 720);;
        
        headerLayeredPane.add(backgroundLabel, Integer.valueOf(0));

        // chatbox
        ImageIcon chatbox = new ImageIcon("assets/chatbox.png");
        Image scaledbox = chatbox.getImage().getScaledInstance(1100, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledbox);

        JLabel chatboxLabel = new JLabel(resizedIcon);
        chatboxLabel.setBounds(50, 480, 1280, 200); // Atur posisi dan ukuran sesuai kebutuhan

        headerLayeredPane.add(chatboxLabel, Integer.valueOf(2));

        // orang
        ImageIcon orang = new ImageIcon("assets/hehe.png");
        Image scaleorang = orang.getImage().getScaledInstance(450, 720, Image.SCALE_SMOOTH);
        ImageIcon resizeorang = new ImageIcon(scaleorang);

        Labelorang = new JLabel(resizeorang);
        Labelorang.setBounds(0, 0, 400, 720); // Atur posisi dan ukuran sesuai kebutuhan

        headerLayeredPane.add(Labelorang, Integer.valueOf(1));

        // aset orang
            ImageIcon benar = new ImageIcon("assets/benar.png");
            Image scalebenar = benar.getImage().getScaledInstance(450, 720, Image.SCALE_SMOOTH);
            ImageIcon gambarBaru = new ImageIcon(scalebenar);
        
        // text
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(null); // Use absolute positioning for precise control
        textPanel.setBounds(200, 520, 950, 100); // Lebar diperbesar agar sesuai chatbox

        pertanyaan = new JLabel();
        pertanyaan.setFont(new Font("Arial", Font.PLAIN, 25));
        pertanyaan.setForeground(Color.BLACK);
        pertanyaan.setVerticalAlignment(SwingConstants.TOP);
        pertanyaan.setBounds(0, 0, 950, 100); // Lebar sesuai panel
        pertanyaan.setOpaque(false);

        // add ke main panel/layar utama
        textPanel.add(pertanyaan);
        headerLayeredPane.add(textPanel, Integer.valueOf(3));
        // mainPanel.add(headerLayeredPane, BorderLayout.CENTER);

        // Daftar pertanyaan
        String[] pertanyaan = {
            "Halo, saya adalah dokter virtual. Saya akan membantu mendiagnosa penyakit Anda berdasarkan gejala yang Anda alami. Silakan jawab pertanyaan berikut dengan jujur ya!",
            "Apakah Anda mengalami BAB cair lebih dari 3x sehari?",   // L01
            "Apakah Anda merasa lesu?",                              // L02
            "Apakah nafsu makan berkurang?",                         // L03
            "Apakah Anda mengalami keram pada perut?",               // L04
            "Apakah Anda merasa perut kembung?",                     // L05
            "Apakah Anda mengalami demam?",                          // L06
            "Apakah Anda muntah?",                                   // L07
            "Apakah Anda mengalami kejang 1–2x sehari?",             // L08
            "Apakah Anda mengalami BAB cair?",                       // L09
            "Apakah Anda merasa sesak nafas?",                       // L10
            "Apakah Anda terlihat sangat mengantuk?",                // L11
            "Apakah Anda mengalami batuk?",                          // L12
            "Apakah Anda mengalami pilek?",                          // L13
            "Apakah Anda mengalami menggigil?",                      // L14
            "Apakah dada terasa sakit?",                             // L15
            "Apakah Anda mengalami sakit kepala?",                   // L16
            "Apakah nafas berbunyi (mengi)?",                        // L17
            "Apakah ada faktor keturunan?",                          // L18
            "Apakah Anda mengalami susah tidur?",                    // L19
            "Apakah anak tampak kurus?",                             // L20
            "Apakah Anda terlihat pucat?",                           // L21
            "Apakah Anda merasa gatal sekitar anus?",                // L22
            "Apakah Anda merasa gelisah/tidak nyaman saat tidur?",   // L23
            "Apakah ada iritasi kulit sekitar anus?",                // L24
            "Apakah Anda sering sakit perut?"                        // L25
        };

        playText(pertanyaan[index_pertanyaan]);
        
        // Membuat objek ImageIcon dari gambar profile.png
        ImageIcon Iconbenar = new ImageIcon("assets/button/centang.png");

        // Mengubah ukuran gambar menjadi 75x75 pixel
        Image scaledbenar = Iconbenar.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon resizedbeanr = new ImageIcon(scaledbenar);

        // Membuat objek JButton dengan gambar profile yang telah diubah ukurannya
        JButton ButtonBenar = new JButton(resizedbeanr);
        ButtonBenar.setBounds(1000, 65, 75, 75);
        ButtonBenar.setContentAreaFilled(false);
        ButtonBenar.setBorderPainted(false);
        ButtonBenar.setFocusPainted(false);
        ButtonBenar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Membuat objek ImageIcon dari gambar profile.png
        ImageIcon IconSALAH = new ImageIcon("assets/button/tetot.png");

        // Mengubah ukuran gambar menjadi 75x75 pixel
        Image scaledSALAH = IconSALAH.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon resizedSALAH = new ImageIcon(scaledSALAH);

        // Membuat objek JButton dengan gambar profile yang telah diubah ukurannya
        JButton ButtonSALAH = new JButton(resizedSALAH);
        ButtonSALAH.setBounds(1000, 165, 75, 75);
        ButtonSALAH.setContentAreaFilled(false);
        ButtonSALAH.setBorderPainted(false);
        ButtonSALAH.setFocusPainted(false);
        ButtonSALAH.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Menambahkan aksi ketika tombol ButtonSALAH diklik
        ButtonSALAH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("salah"); // cek apakah klik terdeteksi
                if (index_pertanyaan < pertanyaan.length - 1) {
                    index_pertanyaan++;
                    playText(pertanyaan[index_pertanyaan]);
                    L[index_pertanyaan] = false; // simpan jawaban ke array L
                    gantiGambar();
                } else {
                    // Semua pertanyaan telah ditampilkan
                    System.out.println("Semua pertanyaan telah ditampilkan.");
                    Labelorang.setIcon(gambarBaru);
                    logic(L); // Panggil metode logic setelah semua pertanyaan selesai
                    
                }
            }
        });

        // Menambahkan aksi ketika tombol ButtonSALAH diklik
        ButtonBenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("benar"); // cek apakah klik terdeteksi
                if (index_pertanyaan < pertanyaan.length - 1) {
                    index_pertanyaan++;
                    playText(pertanyaan[index_pertanyaan]);
                    L[index_pertanyaan] = true; // simpan jawaban ke array L
                    gantiGambar();
                } else {
                    // Semua pertanyaan telah ditampilkan
                    System.out.println("Semua pertanyaan telah ditampilkan.");
                    Labelorang.setIcon(gambarBaru);
                    logic(L); // Panggil metode logic setelah semua pertanyaan selesai
                    
                }
            }
        });

        // Menambahkan komponen ke dalam headerLayeredPane
        headerLayeredPane.add(ButtonBenar, Integer.valueOf(4));
        headerLayeredPane.add(ButtonSALAH, Integer.valueOf(4));

        // Menambahkan headerLayeredPane ke dalam mainPanel
        mainPanel.add(headerLayeredPane, BorderLayout.NORTH);
        playMusic("turip.mp3");
    }

    public void gantiGambar() {
        rand = new Random();
        int pilihan = rand.nextInt(3); // Menghasilkan angka acak antara 0
        
        if (pilihan == 0) {
            ImageIcon orang = new ImageIcon("assets/benar.png");
            Image scaleorang = orang.getImage().getScaledInstance(450, 720, Image.SCALE_SMOOTH);
            ImageIcon gambarBaru = new ImageIcon(scaleorang);
            Labelorang.setIcon(gambarBaru);
        } else if (pilihan == 1) {
            ImageIcon orang = new ImageIcon("assets/salah.png");
            Image scaleorang = orang.getImage().getScaledInstance(450, 720, Image.SCALE_SMOOTH);
            ImageIcon gambarBaru = new ImageIcon(scaleorang);
            Labelorang.setIcon(gambarBaru);
        } else {
            ImageIcon orang = new ImageIcon("assets/berfikir.png");
            Image scaleorang = orang.getImage().getScaledInstance(450, 720, Image.SCALE_SMOOTH);
            ImageIcon gambarBaru = new ImageIcon(scaleorang);
            Labelorang.setIcon(gambarBaru);
            
        }
    }

    public void playText(String text) {
        String ftext = "<html><body style='width: 800px'>" + text + "</body></html>";
        index = 0;
        currentText = "";

        // mulai efek ketik (suara)
        playSound("dialog.mp3");

        timer = new Timer(30, e -> { // 30ms antar karakter
            currentText += ftext.charAt(index);
            pertanyaan.setText(currentText);
            index++;

            if (index >= ftext.length()) {
                timer.stop();
                stopSound(); // stop suara setelah teks selesai
            }
        });
        timer.start();
    }

    // Mainkan mp3 secara looping di background
    private void playSound(String filename) {
        soundThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    FileInputStream fis = new FileInputStream("assets/musik/" + filename);
                    typingPlayer = new Player(fis);
                    typingPlayer.play();
                    fis.close();
                }
            } catch (Exception ex) {
                System.out.println("Gagal memutar suara: " + ex.getMessage());
            }
        });
        soundThread.start();
    }

    // Hentikan suara
    private void stopSound() {
        try {
            if (typingPlayer != null) {
                typingPlayer.close(); // hentikan player
            }
            if (soundThread != null) {
                soundThread.interrupt(); // hentikan loop thread
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void playMusic(String filename) {
        new Thread(() -> {
            try {
                while (true) { // loop tak terbatas
                    FileInputStream fis = new FileInputStream("assets/musik/" + filename);
                    Player player = new Player(fis);
                    player.play(); 
                    fis.close(); // tutup stream biar tidak bocor
                }
            } catch (Exception ex) {
                System.out.println("Gagal memutar suara: " + ex.getMessage());
            }
        }).start();
    }


    private void logic(boolean[] L) {
        boolean adaHasil = false;

        for (int i = 1; i < L.length; i++) {
            System.out.println("L" + String.format("%02d", i) + ": " + L[i]);
        }

        // Aturan T01
        if (L[1] && L[2] && L[3] && L[4] && L[5] && L[6] && L[7]) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>T01 terpenuhi</body></html>");
            adaHasil = true;
        }

        // Aturan T02
        if (L[6] && L[7] && L[8] && L[9] && L[10] && L[11] && L[12] && L[13]) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>T02 terpenuhi</body></html>");
            adaHasil = true;
        }

        // Aturan T03
        if (L[3] && L[6] && L[10] && L[12] && L[14] && L[15] && L[16]) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>T03 terpenuhi</body></html>");
            adaHasil = true;
        }

        // Aturan T04
        if (L[2] && L[10] && L[12] && L[17] && L[18] && L[19]) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>T04 terpenuhi</body></html>");
            adaHasil = true;
        }

        // Aturan T05
        if (L[20] && L[21] && L[22] && L[23] && L[24] && L[25]) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>T05 terpenuhi</body></html>");
            adaHasil = true;
        }

        if (semuaBenar(L)) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>KAMU GAY (kaum FAZA)</body></html>");
            adaHasil = true;
        }

        
        if (!adaHasil) {
            pertanyaan.setText("<html><body style='width:800px'>=== HASIL DIAGNOSA ===<br>Tidak ada aturan yang terpenuhi.</body></html>");
        }
    }
    // Helper method untuk cek semua benar
    private boolean semuaBenar(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) return false;
        }
        return true;
    }
}