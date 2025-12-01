package behavioral.chain.of.responsibility.ui.client;

import behavioral.chain.of.responsibility.ui.Button;
import behavioral.chain.of.responsibility.ui.Dialog;
import behavioral.chain.of.responsibility.ui.Panel;

/**
 * ============================================================
 *      CHAIN OF RESPONSIBILITY (CoR) — CLIENT NOTES
 * ============================================================
 *
 * INTENT
 * ------
 * CoR lets a request travel through a chain of handlers.
 * Each handler decides to:
 *   - handle the request, OR
 *   - forward it to the next handler.
 *
 * This removes tight coupling between the sender and the receiver.
 *
 *
 * HOW THIS EXAMPLE MAPS TO CoR
 * ----------------------------
 * Request:
 *   showHelpMessage()
 *
 * Handler interface:
 *   ComponentWithContextualHelp
 *
 * Base Handler:
 *   Component
 *   - handles request if toolTipMessage exists
 *   - otherwise forwards to its parent (container)
 *
 * Concrete Handlers:
 *   Button  -> leaf handler (tooltip help)
 *   Panel   -> composite handler (modal help text)
 *   Dialog  -> top-level handler (wiki page help)
 *
 * Chain Link:
 *   Container.add(child) sets:
 *        child.container = this
 *   => Requests move upward: Button -> Panel -> Dialog
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Build UI hierarchy:
 *      Dialog
 *        -> Panel
 *            -> Ok Button
 *            -> Cancel Button
 *
 * 2. Help request cases:
 *    - Ok Button:
 *        Has tooltip -> handles locally.
 *
 *    - Cancel Button:
 *        No tooltip -> forwards to Panel.
 *        Panel has modal help -> handles.
 *        (If Panel had none, it would forward to Dialog.)
 *
 *    - Panel:
 *        Has modal help -> handles locally.
 *
 *    - Dialog:
 *        Has wikiPageUrl -> handles locally.
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Requests are not hardwired to a single receiver.
 * ✔ Chain order controls who gets the chance to handle first.
 * ✔ Adding/removing handlers does not change client code.
 * ✔ Useful for UI events, logging pipelines, approvals, filters.
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {
        Dialog dialog = new Dialog("https://www.wikipage.com");
        Panel panel = new Panel("Panel Help Text");

        Button okButton = new Button();
        okButton.setToolTipMessage("Ok button tooltip message");

        Button cancelButton = new Button();

        panel.add(okButton);
        panel.add(cancelButton);
        dialog.add(panel);


        // assume client requested help on ok button
        okButton.showHelpMessage();

        // assume client requested help on cancel button
        cancelButton.showHelpMessage();

        // assume client requested help on panel
        panel.showHelpMessage();

        // assume client requested help on dialog
        dialog.showHelpMessage();

    }
}
