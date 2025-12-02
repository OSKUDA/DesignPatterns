package behavioral.chain.of.responsibility.app.server;

import behavioral.chain.of.responsibility.app.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Server {

    private final Map<String, String> users;

    private Middleware middleware;

    public Server() {
        this.users = new HashMap<>();
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorized to access the server");
            String token = UUID.randomUUID().toString();
            System.out.println("Token : " + token);
            System.out.println("Login success");
            return true;
        }
        System.out.println("Login failed");
        return false;
    }

    public boolean registerUser(String email, String password) {
        if (users.containsKey(email)) {
            System.out.println(email + " is already registered");
            return false;
        }
        users.put(email, password);
        System.out.println(email + " registered successfully");
        return true;
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        String pass = users.get(email);
        return pass != null && pass.equals(password);
    }

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }
}
