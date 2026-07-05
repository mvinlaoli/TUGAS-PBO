package pbo.week9.Generic.view;

import java.util.Scanner;
import pbo.week9.Generic.Result;
import pbo.week9.Generic.controller.SessionController;
import pbo.week9.Generic.model.User;
import pbo.week9.Generic.service.SessionService;

public class SessionView {
    private final SessionController controller;
    private final Scanner scanner = new Scanner(System.in);

    public SessionView(SessionController controller) {
        this.controller = controller;
    }

    public void startMenu() {
        while (true) {
            System.out.println("\n=== MENU SESSION ===");
            System.out.println("1. Login");
            System.out.println("2. Get User Info");
            System.out.println("3. Logout");
            System.out.println("4. Keluar Aplikasi");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleGetUserInfo();
                    break;
                case 3:
                    handleLogout();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Result<User> res = controller.login(username, password);
        if (res.isSuccess()) {
            System.out.println("[SUCCESS] Selamat datang, " + res.getData().getNama() + "! Login berhasil.");
        } else {
            System.out.println("[ERROR] " + res.getErrorMessage());
        }
    }

    private void handleGetUserInfo() {
        Result<User> res = controller.getUserInfo();
        if (res.isSuccess()) {
            User u = res.getData();
            System.out.println("[INFO USER]");
            System.out.println("Nama    : " + u.getNama());
            System.out.println("Email   : " + u.getEmail());
            System.out.println("Username: " + u.getUsername());
        } else {
            System.out.println("[ERROR] " + res.getErrorMessage());
        }
    }

    private void handleLogout() {
        Result<String> res = controller.logout();
        if (res.isSuccess()) {
            System.out.println("[SUCCESS] " + res.getData());
        } else {
            System.out.println("[ERROR] " + res.getErrorMessage());
        }
    }

    
    public static void main(String[] args) {
        SessionService service = new SessionService();
        SessionController controller = new SessionController(service);
        SessionView view = new SessionView(controller);
        view.startMenu();
    }
}
