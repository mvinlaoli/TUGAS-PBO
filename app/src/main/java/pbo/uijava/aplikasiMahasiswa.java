package pbo.uijava;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class aplikasiMahasiswa extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ArrayList<mahasiswa> listMahasiswa;

    private loginPanel loginPanel;
    private tabelPanel tablePanel;
    private formPanel formPanel;

    public aplikasiMahasiswa() {
        setTitle("Aplikasi Data Mahasiswa");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new mahasiswa("1122001", "Jolvin", "jolvin@ithb.ac.id"));
        listMahasiswa.add(new mahasiswa("1122002", "Budi Santoso", "budi@gmail.com"));
        listMahasiswa.add(new mahasiswa("1122003", "Siti Aminah", "siti@gmail.com"));
        listMahasiswa.add(new mahasiswa("1122004", "Agus Salim", "agus@gmail.com"));
        listMahasiswa.add(new mahasiswa("1122005", "Rina Wijaya", "rina@gmail.com"));
    
        

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPanel = new loginPanel(this);
        tablePanel = new tabelPanel(this);
        formPanel = new formPanel(this);

        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(tablePanel, "TABEL");
        mainPanel.add(formPanel, "FORM");

        add(mainPanel);
        cardLayout.show(mainPanel, "LOGIN");
    }

    public void navigasiKe(String namaHalaman) {
        if (namaHalaman.equals("TABEL")) {
            tablePanel.refreshTable(listMahasiswa);
        }
        cardLayout.show(mainPanel, namaHalaman);
    }

    public ArrayList<mahasiswa> getListMahasiswa() { return listMahasiswa; }
    public formPanel getFormPanel() { return formPanel; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new aplikasiMahasiswa().setVisible(true);
        });
    }
}