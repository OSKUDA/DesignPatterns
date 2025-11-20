package structural.bridge.remote.client;

import structural.bridge.remote.AdvancedRemote;
import structural.bridge.remote.Radio;
import structural.bridge.remote.Remote;
import structural.bridge.remote.TV;

/**
 * Demonstrates the Bridge Design Pattern using a remote control abstraction
 * and various device implementations (TV, Radio).
 *
 * <p>
 * The Bridge pattern is a structural design pattern used to decouple an
 * abstraction from its implementation so both can vary independently.
 * This example models a real-world scenario: different types of remotes
 * controlling different types of electronic devices.
 * </p>
 *
 * <h2>Pattern Summary</h2>
 * <ul>
 *   <li><b>Abstraction</b> – The high-level control layer that the client interacts with.
 *       In this project, {@link structural.bridge.remote.Remote} is the abstraction.</li>
 *
 *   <li><b>Refined Abstraction</b> – A more advanced or extended version of the abstraction.
 *       Here, {@link structural.bridge.remote.AdvancedRemote} adds extra behavior such as printing channels.</li>
 *
 *   <li><b>Implementor</b> – The interface defining operations that concrete devices must implement.
 *       The {@link structural.bridge.remote.Device} interface plays this role.</li>
 *
 *   <li><b>Concrete Implementors</b> – The actual implementations of different devices.
 *       Here we have {@link structural.bridge.remote.TV} and {@link structural.bridge.remote.Radio}.</li>
 * </ul>
 *
 * <h2>Why Bridge Pattern?</h2>
 * <p>
 * Without the Bridge pattern, you might end up with a class explosion:
 * RemoteForTV, RemoteForRadio, AdvancedRemoteForTV, AdvancedRemoteForRadio, etc.
 * The Bridge eliminates this by separating:
 * </p>
 *
 * <pre>
 * Abstraction (Remote controls)
 * from
 * Implementation (Devices)
 * </pre>
 *
 * <p>
 * This lets you freely mix and match:
 * </p>
 *
 * <pre>
 * new Remote(new TV());
 * new Remote(new Radio());
 * new AdvancedRemote(new TV());
 * new AdvancedRemote(new Radio());
 * </pre>
 *
 * <h2>Example Flow</h2>
 * <ol>
 *   <li>A TV and a Radio are created and initialized.</li>
 *   <li>Two basic remotes operate each device independently.</li>
 *   <li>A refined remote ({@link AdvancedRemote}) is used with the TV
 *       to perform advanced operations such as printing the channel list.</li>
 *   <li>Calls like power, volume control, and channel navigation are delegated
 *       from the remote to the device implementation.</li>
 * </ol>
 *
 * <h2>Key Takeaways</h2>
 * <ul>
 *   <li>Abstractions and implementations evolve independently.</li>
 *   <li>Reduces class hierarchy complexity and avoids combinatorial explosion.</li>
 *   <li>Ideal for scenarios where you have multiple variants of controllers and devices.</li>
 *   <li>Promotes loose coupling and clean object-oriented design.</li>
 * </ul>
 *
 * <p>
 * This Client class demonstrates real usage of the Bridge: multiple remotes controlling
 * multiple devices with no dependency between remote type and device type.
 * </p>
 */
public class Client {

    public static void main(String[] args) {

        TV tv = new TV();
        Radio radio = new Radio();

        Remote tvRemote = new Remote(tv);
        Remote radioRemote = new Remote(radio);

        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.nextChannel();
        tvRemote.nextChannel();

        radioRemote.togglePower();
        radioRemote.previousChannel();
        radioRemote.volumeDown();

        tvRemote.togglePower();

        AdvancedRemote advancedRemote = new AdvancedRemote(tv);
        advancedRemote.togglePower();
        advancedRemote.printChannels();

    }
}
