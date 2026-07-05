package pbo.uijava;

import javax.swing.*;
import java.awt.*;

public class formPanel extends JPanel {
    private JLabel lblTitle;
    private JTextField txtNim, txtNama, txtEmail;
    private JLabel lblError;
    private aplikasiMahasiswa mainFrame;
    private int indexEdit = -1;

    public formPanel(aplikasiMahasiswa frame) {
        this.mainFrame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblTitle = new JLabel("FORM MAHASISWA", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));

        txtNim = new JTextField(20);
        txtNama = new JTextField(20);
        txtEmail = new JTextField(20);
        
        lblError = new JLabel("", JLabel.CENTER);
        lblError.setForeground(Color.RED);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBackground(new Color(0, 123, 255));
        btnSimpan.setForeground(Color.WHITE);
        JButton btnBatal = new JButton("Batal");

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitle, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1; add(txtNim, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(lblError, gbc);

        gbc.gridy = 5; gbc.gridwidth = 1;
        add(btnSimpan, gbc);
        gbc.gridx = 1; add(btnBatal, gbc);

        btnBatal.addActionListener(e -> mainFrame.navigasiKe("TABEL"));

        btnSimpan.addActionListener(e -> {
            String nim = txtNim.getText().trim();
            String nama = txtNama.getText().trim();
            String email = txtEmail.getText().trim();

            if (nim.isEmpty() || nama.isEmpty() || email.isEmpty()) {
                lblError.setText("Semua field harus diisi!");
                return;
            }

            if (indexEdit == -1) {
                mainFrame.getListMahasiswa().add(new mahasiswa(nim, nama, email));
                JOptionPane.showMessageDialog(this, "Data Berhasil Ditambah!");
            } else { // Mode Edit
                mahasiswa m = mainFrame.getListMahasiswa().get(indexEdit);
                m.setNim(nim); m.setNama(nama); m.setEmail(email);
                JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui!");
            }
            mainFrame.navigasiKe("TABEL");
        });
    }

    public void siapkanForm(mahasiswa mhs, int index) {
        this.indexEdit = index;
        lblError.setText("");
        if (mhs == null) {
            lblTitle.setText("FORM TAMBAH MAHASISWA");
            txtNim.setText(""); txtNim.setEditable(true);
            txtNama.setText(""); txtEmail.setText("");
        } else {
            lblTitle.setText("FORM EDIT MAHASISWA");
            txtNim.setText(mhs.getNim()); txtNim.setEditable(false);
            txtNama.setText(mhs.getNama()); txtEmail.setText(mhs.getEmail());
        }
    }
}