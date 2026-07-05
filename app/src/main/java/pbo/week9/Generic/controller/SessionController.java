package pbo.week9.Generic.controller;
import pbo.week9.Generic.Result;
import pbo.week9.Generic.model.User;    
import pbo.week9.Generic.service.SessionService;

public class SessionController {
    private final SessionService sessionService;
    private User session = null; 

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public Result<User> login(String username, String password) {
        if (session != null) {
            return Result.failure("Sudah login, silahkan logout lebih dahulu");
        }

        Result<User> loginResult = sessionService.login(username, password);
        if (loginResult.isSuccess()) {
            this.session = loginResult.getData(); 
        }
        return loginResult;
    }

    public Result<User> getUserInfo() {
        if (session == null) {
            return Result.failure("Silahkan login dulu");
        }
        return Result.success(session);
    }

    public Result<String> logout() {
        if (session == null) {
            return Result.failure("Silahkan login dulu");
        }
        session = null; 
        return Result.success("Logout berhasil");
    }
}
