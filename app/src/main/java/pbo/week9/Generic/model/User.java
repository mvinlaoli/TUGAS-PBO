package pbo.week9.Generic.model;

public class User {
    private String nama;
    private String email;
    private String username;
    private String password;

    public User(String nama, String email, String username, String password) {
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}