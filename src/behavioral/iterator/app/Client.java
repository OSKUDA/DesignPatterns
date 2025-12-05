package behavioral.iterator.app;

import behavioral.iterator.app.social.Facebook;
import behavioral.iterator.app.social.LinkedIn;
import behavioral.iterator.app.social.SocialNetwork;
import behavioral.iterator.app.social.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ============================================================
 *        ITERATOR PATTERN — CLIENT NOTES (SOCIAL DEMO)
 * ============================================================
 *
 * INTENT
 * ------
 * Iterator provides a way to traverse a collection **without exposing**
 * its internal structure. Client uses a common traversal API regardless
 * of how data is stored or fetched.
 *
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Aggregate (collection interface):
 *   SocialNetwork
 *   - defines factory methods for iterators
 *     createFriendsIterator(email)
 *     createCoworkersIterator(email)
 *
 * Concrete Aggregates:
 *   Facebook, LinkedIn
 *   - store Profile data differently (simulated remote APIs)
 *   - create their own iterator implementations
 *
 * Iterator interface:
 *   ProfileIterator
 *   - hasNext(), getNext(), reset()
 *
 * Concrete Iterators:
 *   FacebookIterator, LinkedInIterator
 *   - encapsulate traversal + lazy network loading
 *   - fetch contacts only when iteration begins
 *
 * Client:
 *   SocialSpammer / Client
 *   - works only with SocialNetwork + ProfileIterator
 *   - unaware of concrete storage/API details
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Choose a SocialNetwork (Facebook/LinkedIn).
 * 2. Create SocialSpammer with the chosen network.
 * 3. Spammer asks network for the right iterator:
 *        friendsIterator / coworkersIterator
 * 4. Iterate using common loop:
 *        while(iterator.hasNext()) { iterator.getNext(); }
 * 5. Send spam to each returned Profile.
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Traversal logic is separated from collection internals.
 * ✔ Same iterator API works across different data sources.
 * ✔ New social networks can be added without changing spammer/client.
 * ✔ Lazy loading makes iteration efficient for remote collections.
 *
 * ============================================================
 */
public class Client {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target span tool (default:Facebook)");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");

        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        } else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("oskar@test.com", "Hey! This is Oskar's friend Bot. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("oskar@test.com", "Hey! This is Oskar's boss Bot. Oskar told me you would be interested in [link].");

    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();

        data.add(new Profile("oskar@test.com", "Oskar Test", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;

    }
}
