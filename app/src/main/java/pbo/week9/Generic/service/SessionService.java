package pbo.week9.Generic.service;

import java.util.ArrayList;
import java.util.List;
import pbo.week9.Generic.Result;
import pbo.week9.Generic.model.User;

public class SessionService {
    private List<User> userList = new ArrayList<>();

    public SessionService() {
        // Hardcode 5 user awal
        userList.add(new User("Jolvin", "jolvin@mail.com", "jolvin123", "pass123"));
        userList.add(new User("Budi", "budi@mail.com", "budi", "budi123"));
        userList.add(new User("Andi", "andi@mail.com", "andi", "andi123"));
        userList.add(new User("Siti", "siti@mail.com", "siti", "siti123"));
        userList.add(new User("Dewi", "dewi@mail.com", "dewi", "dewi123"));
    }

    public Result<User> login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return Result.success(user);
            }
        }
        return Result.failure("User tidak ditemukan"); 
    }
}
