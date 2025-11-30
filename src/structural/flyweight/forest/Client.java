package structural.flyweight.forest;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ============================================================
 *              FLYWEIGHT PATTERN — CLIENT NOTES
 * ============================================================
 *
 * INTENT
 * ------
 * Flyweight reduces memory usage by sharing **intrinsic (common) state**
 * between many objects, while keeping **extrinsic (unique) state** outside.
 *
 * THINK “MANY OBJECTS, FEW TYPES”
 * ------------------------------
 * When you need millions of similar objects, avoid storing repeated data
 * in each object. Store it once and reuse it.
 *
 * MAPPING TO THIS EXAMPLE
 * -----------------------
 * Extrinsic state (unique per tree):
 *   - Tree.x, Tree.y  -> position in canvas
 *
 * Intrinsic state (shared flyweight):
 *   - TreeType.name, color, texture
 *   - Created and cached in TreeTypeFactory.
 *
 * STRUCTURE
 * ---------
 * Client:
 *   - Creates 1,000,000 Tree objects with random positions.
 *   - Uses a small set of (name/color/texture) combinations.
 *
 * Forest:
 *   - Holds all Tree instances (context objects).
 *   - Delegates drawing to each Tree.
 *
 * Tree:
 *   - Stores only extrinsic state + reference to TreeType.
 *
 * TreeType (Flyweight):
 *   - Stores intrinsic state.
 *   - Knows how to draw itself when given x,y.
 *
 * TreeTypeFactory:
 *   - Returns existing TreeType if same intrinsic state already exists,
 *     otherwise creates & caches a new one.
 *
 * CLIENT FLOW
 * -----------
 * 1. Create Forest.
 * 2. Plant 1M trees with random (x,y).
 * 3. Factory reuses TreeType flyweights across trees.
 * 4. Print:
 *      - Total Tree objects (should be 1,000,000).
 *      - Total TreeType flyweights (should be small, ~18 here).
 * 5. Render forest on Swing panel.
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Massive object counts become feasible.
 * ✔ Memory grows with extrinsic state only.
 * ✔ Flyweight pool size depends on unique intrinsic combinations.
 * ✔ Great for repeated, similar objects (trees, icons, chars, particles).
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {
        final int width = 600;
        final int height = 600;
        final int n = 1000000;

        Forest forest = new Forest();

        // Small set of intrinsic states (Flyweights) reused many times
        String[] names = {"oak", "pine", "maple"};
        String[] colors = {"green", "darkGreen", "pink"};
        String[] textures = {"harsh", "soft"};

        Random rnd = new Random(42);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int x = rnd.nextInt(width);
            int y = rnd.nextInt(height);

            String name = names[rnd.nextInt(names.length)];
            String color = colors[rnd.nextInt(colors.length)];
            String texture = textures[rnd.nextInt(textures.length)];

            forest.plantTree(x, y, name, color, texture);
        }
        long end = System.nanoTime();

        System.out.println("Planted " + n + " trees in " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

         System.out.println("Total Tree objects: " + forest.getTrees().size());
         System.out.println("Total TreeType flyweights: " + TreeTypeFactory.getTreeTypeSize());


        // Start Swing UI on the EDT
        SwingUtilities.invokeLater(() -> createAndShowGUI(forest));
    }

    private static void createAndShowGUI(Forest forest) {
        JFrame frame = new JFrame("Flyweight Forest Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ForestPanel panel = new ForestPanel(forest);
        panel.setPreferredSize(new Dimension(600, 600));

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Simple canvas to render trees from the Forest.
     */
    static class ForestPanel extends JPanel {
        private final Forest forest;

        ForestPanel(Forest forest) {
            this.forest = forest;
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw ground
            g2.setColor(new Color(230, 245, 230));
            g2.fillRect(0, 0, getWidth(), getHeight());

            forest.draw(g2);

            g2.dispose();
        }


    }
}
