package behavioral.state.player;

import behavioral.state.player.ui.UI;

/**
 * ============================================================
 * State Pattern – Notes (Media Player Example)
 * ============================================================
 *
 * Intent:
 * --------
 * The State pattern allows an object to change its behavior
 * dynamically when its internal state changes, without using
 * conditional logic (if/else or switch).
 *
 * In this example:
 * ----------------
 * - Player           → Context
 * - State            → Abstract State
 * - ReadyState       → Concrete State
 * - PlayingState     → Concrete State
 * - LockedState      → Concrete State
 * - UI               → Client / Input source
 *
 * Core Idea:
 * ----------
 * User actions (Play, Stop, Next, Prev) are delegated by the
 * Player to its current State object.
 * Each state defines how the player behaves for the same action.
 *
 * State Responsibilities:
 * -----------------------
 * ReadyState:
 *  - Can start playback
 *  - Transitions to PlayingState
 *
 * PlayingState:
 *  - Can move to next/previous track
 *  - Can pause (go back to ReadyState)
 *  - Can stop and lock (LockedState)
 *
 * LockedState:
 *  - Ignores most actions
 *  - Can unlock back to ReadyState
 *
 * Key Design Benefits:
 * --------------------
 * - Eliminates complex conditional logic in Player
 * - Encapsulates state-specific behavior
 * - Makes state transitions explicit and readable
 * - New states can be added without modifying Player (OCP)
 *
 * Important Design Choice:
 * ------------------------
 * - State objects hold a reference to Player
 * - State objects control transitions via player.changeState()
 * - Player delegates behavior but does not know state logic
 *
 * Interview Talking Point:
 * ------------------------
 * "This media player example shows how the same user actions
 * (Play, Stop, Next, Prev) result in different behavior depending
 * on the current state, with transitions fully encapsulated
 * inside state classes."
 *
 * When to Use State Pattern:
 * --------------------------
 * - Object has multiple states with distinct behaviors
 * - Behavior changes frequently based on state
 * - You want to avoid large conditional blocks
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}