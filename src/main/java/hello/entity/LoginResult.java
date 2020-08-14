package hello.entity;

public class LoginResult extends Result<User> {
    boolean isLogin;

    public static LoginResult failure(String message) {
        return new LoginResult("fail", message, false,null);
    }

    public static LoginResult success(String message, User user) {
        return new LoginResult("ok", message, true, user);
    }

    public static LoginResult success(String message) {
        return new LoginResult("ok", message, false,null);
    }

    public LoginResult(String status, String msg, User user) {
        super(status, msg, user);
    }

    protected LoginResult(String status, String msg, boolean isLogin, User user) {
        super(status, msg, user);
        this.isLogin = isLogin;
    }


    public boolean isLogin() {
        return isLogin;
    }
}
