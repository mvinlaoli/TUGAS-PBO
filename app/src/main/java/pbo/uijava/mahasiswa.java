package pbo.uijava;

public class mahasiswa {
    private String nim;
    private String nama;
    private String email;

    public mahasiswa(String nim, String nama, String email) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}