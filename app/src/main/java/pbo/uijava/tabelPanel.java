package pbo.uijava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class tabelPanel extends JPanel {
    private JTable tabel;
    private DefaultTableModel model;
    private JTextField txtSearch;
    private aplikasiMahasiswa mainFrame;

    public tabelPanel(aplikasiMahasiswa frame) {
        this.mainFrame = frame;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        txtSearch = new JTextField(20);
        searchPanel.add(txtSearch);
        
        JButton btnReset = new JButton("Reset");
        searchPanel.add(btnReset);
        topPanel.add(searchPanel, BorderLayout.WEST);

        JButton btnTambah = new JButton("+ Tambah Mahasiswa");
        btnTambah.setBackground(new Color(40, 167, 69));
        btnTambah.setForeground(Color.WHITE);
        topPanel.add(btnTambah, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        String[] kolom = {"NIM", "Nama", "Email"};
        model = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tabel = new JTable(model);
        add(new JScrollPane(tabel), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEdit = new JButton("Edit Terpilih");
        btnEdit.setBackground(new Color(255, 193, 7));
        
        JButton btnDelete = new JButton("Delete Terpilih");
        btnDelete.setBackground(new Color(220, 53, 69));
        btnDelete.setForeground(Color.WHITE);
        
        bottomPanel.add(btnEdit);
        bottomPanel.add(btnDelete);
        add(bottomPanel, BorderLayout.SOUTH);

    
        txtSearch.addCaretListener(e -> filterData());

        btnReset.addActionListener(e -> {
            txtSearch.setText("");
            refreshTable(mainFrame.getListMahasiswa());
        });

        btnTambah.addActionListener(e -> {
            mainFrame.getFormPanel().siapkanForm(null, -1);
            mainFrame.navigasiKe("FORM");
        });

        btnEdit.addActionListener(e -> {
            int selectedRow = tabel.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih baris data dulu!");
                return;
            }
            
            String nim = (String) model.getValueAt(selectedRow, 0);
            int idxAsli = -1;
            for (int i = 0; i < mainFrame.getListMahasiswa().size(); i++) {
                if (mainFrame.getListMahasiswa().get(i).getNim().equals(nim)) {
                    idxAsli = i;
                    break;
                }
            }
            
            mahasiswa mhs = mainFrame.getListMahasiswa().get(idxAsli);
            mainFrame.getFormPanel().siapkanForm(mhs, idxAsli);
            mainFrame.navigasiKe("FORM");
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = tabel.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
                return;
            }

            String nim = (String) model.getValueAt(selectedRow, 0);
            int konfirmasi = JOptionPane.showConfirmDialog(this, 
                    "Hapus mahasiswa dengan NIM: " + nim + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (konfirmasi == JOptionPane.YES_OPTION) {
                mainFrame.getListMahasiswa().removeIf(mhs -> mhs.getNim().equals(nim));
                refreshTable(mainFrame.getListMahasiswa());
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            }
        });
    }

    public void refreshTable(ArrayList<mahasiswa> list) {
        model.setRowCount(0);
        for (mahasiswa mhs : list) {
            model.addRow(new Object[]{mhs.getNim(), mhs.getNama(), mhs.getEmail()});
        }
    }

    private void filterData() {
        String query = txtSearch.getText().toLowerCase().trim();
        ArrayList<mahasiswa> filtered = new ArrayList<>();
        for (mahasiswa mhs : mainFrame.getListMahasiswa()) {
            if (mhs.getNim().toLowerCase().contains(query) || 
                mhs.getNama().toLowerCase().contains(query) || 
                mhs.getEmail().toLowerCase().contains(query)) {
                filtered.add(mhs);
            }
        }
        refreshTable(filtered);
    }
}