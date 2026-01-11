package behavioral.template.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ========================= TEMPLATE METHOD PATTERN =========================
 *
 * Intent:
 * --------
 * Define the skeleton of an algorithm in a base class, while allowing
 * subclasses to override specific steps without changing the algorithm’s
 * structure.
 *
 * ---------------------------------------------------------------------------
 * How this example demonstrates Template Method:
 * ---------------------------------------------------------------------------
 *
 * 1. Network (Abstract Class)
 *    - Defines the template method: post()
 *    - Controls the fixed algorithm:
 *        logIn() -> sendData() -> logOut()
 *    - Prevents duplication and enforces execution order
 *
 * 2. Facebook / Twitter (Concrete Classes)
 *    - Implement variable steps:
 *        - Authentication (logIn)
 *        - Message sending (sendData)
 *        - Logout behavior (logOut)
 *    - Do NOT change the algorithm structure
 *
 * 3. Client (this class)
 *    - Chooses the concrete implementation at runtime
 *    - Interacts only with the base class (Network)
 *    - Remains unaware of platform-specific details
 *
 * ---------------------------------------------------------------------------
 * Key Characteristics Highlighted:
 * ---------------------------------------------------------------------------
 * ✔ Code reuse via shared algorithm
 * ✔ Inversion of control (base class controls flow)
 * ✔ Subclasses customize behavior without duplication
 * ✔ Algorithm structure is fixed and protected
 *
 * ---------------------------------------------------------------------------
 * Interview One-Liner:
 * ---------------------------------------------------------------------------
 * "Template Method defines the invariant steps of an algorithm in a base class
 * and lets subclasses override specific steps without altering the flow."
 *
 * ---------------------------------------------------------------------------
 * When to use Template Method:
 * ---------------------------------------------------------------------------
 * - Multiple implementations share the same workflow
 * - You want to avoid duplicate algorithms
 * - You want to control execution order strictly
 *
 * ===========================================================================
 */
public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}