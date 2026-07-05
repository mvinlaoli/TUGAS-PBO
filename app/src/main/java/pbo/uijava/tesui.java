package pbo.uijava;

import javax.swing.*;
import java.awt.*;

public class tesui {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Aplikasi Mahasiswa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            // Tambahkan panel login ke frame
            loginPanel loginPanel = new loginPanel(new aplikasiMahasiswa());
            frame.add(loginPanel);

            frame.setVisible(true);
        });
        JPanel panel = new JPanel();
        panel.add(new JLabel("LOGIN SISTEM")); // mirip <h1>
        panel.add(new JLabel("Username:")); // mirip <label>
        panel.add(new JTextField(15)); // mirip <input type="text">
        panel.add(new JPasswordField(15)); // mirip <input type="password">
        panel.add(new JButton("Login")); // mirip


    }

}
