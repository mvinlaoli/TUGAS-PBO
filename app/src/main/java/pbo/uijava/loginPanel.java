package pbo.uijava;

import javax.swing.*;
import java.awt.*;

public class loginPanel extends JPanel {
    public loginPanel(aplikasiMahasiswa frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("LOGIN SISTEM", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        
        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField(15);
        
        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField(15);
        
        JButton btnLogin = new JButton("Login");
        JLabel lblError = new JLabel("", JLabel.CENTER);
        lblError.setForeground(Color.RED);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitle, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        add(lblUsername, gbc);
        gbc.gridx = 1; add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblPassword, gbc);
        gbc.gridx = 1; add(txtPassword, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(btnLogin, gbc);

        gbc.gridy = 4; add(lblError, gbc);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("admin") && password.equals("admin123")) {
                lblError.setText(""); 
                txtUsername.setText("");
                txtPassword.setText("");
                frame.navigasiKe("TABEL");
            } else {
                lblError.setText("Username atau Password Salah!");
            }
        });
    }
}