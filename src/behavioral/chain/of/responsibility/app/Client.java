package behavioral.chain.of.responsibility.app;

import behavioral.chain.of.responsibility.app.middleware.Middleware;
import behavioral.chain.of.responsibility.app.middleware.RoleCheckMiddleware;
import behavioral.chain.of.responsibility.app.middleware.ThrottlingMiddleware;
import behavioral.chain.of.responsibility.app.middleware.UserExistsMiddleware;
import behavioral.chain.of.responsibility.app.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ============================================================
 *   CHAIN OF RESPONSIBILITY (CoR) — CLIENT NOTES (AUTH DEMO)
 * ============================================================
 *
 * INTENT
 * ------
 * CoR passes a request through a chain of handlers.
 * Each handler can:
 *   1) handle the request, or
 *   2) forward it to the next handler.
 *
 * This decouples the sender from the concrete receivers and
 * makes the chain easy to extend/reorder.
 *
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Request:
 *   Server.logIn(email, password)
 *
 * Handler base:
 *   Middleware
 *   - stores reference to next handler
 *   - check(...) implemented by subclasses
 *   - checkNext(...) forwards to next in chain
 *
 * Concrete handlers:
 *   1) ThrottlingMiddleware
 *        - blocks too many login attempts per minute
 *   2) UserExistsMiddleware
 *        - validates email exists + password matches
 *   3) RoleCheckMiddleware
 *        - prints user/admin greeting
 *
 * Chain assembly:
 *   Middleware.link(first, ...rest)
 *   => first -> next -> next ...
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. init():
 *      - create Server and register users
 *      - build middleware chain in desired order
 *      - attach chain to Server
 *
 * 2. main():
 *      - loop asking for credentials until logIn succeeds
 *      - Server delegates validation to middleware chain
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Sender (Server/Client) doesn’t know which handler approves/blocks.
 * ✔ Each middleware has one responsibility.
 * ✔ Add new checks by inserting a new Middleware into the chain.
 * ✔ Reordering the chain changes behavior without changing Server.
 *
 * ============================================================
 */
public class Client {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Server server;

    public static void main(String[] args) throws IOException {

        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);

    }

    private static void init() {
        server = new Server();
        server.registerUser("test@test.com", "Password123");
        server.registerUser("admin@oskar.com", "admin");

        // middleware setup
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );
        server.setMiddleware(middleware);
    }
}
