package behavioral.chain.of.responsibility.app.middleware;

public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@oskar.com")) {
            System.out.println("Hello, admin!");
        } else {
            System.out.println("Hello, user!");
        }
        return super.checkNext(email, password);
    }
}
