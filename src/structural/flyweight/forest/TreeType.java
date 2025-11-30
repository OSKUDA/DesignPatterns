package structural.flyweight.forest;

import java.awt.*;

public class TreeType {

    private final String name;

    private final String color;

    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(Graphics2D g2, int x, int y) {

        // Map your string color to an AWT Color
        Color canopyColor = mapColor(this.color);

        int trunkWidth = 8;
        int trunkHeight = 18;
        int canopyRadius = 18;

        // Trunk
        g2.setColor(new Color(101, 67, 33)); // wood brown
        g2.fillRect(x - trunkWidth / 2, y, trunkWidth, trunkHeight);

        // Canopy (circle)
        g2.setColor(canopyColor);
        g2.fillOval(x - canopyRadius, y - canopyRadius, canopyRadius * 2, canopyRadius * 2);

        // Optional label (tree name)
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(g2.getFont().deriveFont(10f));
        g2.drawString(this.name, x - canopyRadius, y - canopyRadius - 2);
    }

    private Color mapColor(String color) {
        if (color == null) return Color.GREEN;
        return switch (color.toLowerCase()) {
            case "green" -> new Color(34, 139, 34);
            case "darkgreen" -> new Color(0, 100, 0);
            case "lightgreen" -> new Color(144, 238, 144);
            case "brown" -> new Color(139, 69, 19);
            case "pink" -> new Color(255, 182, 193);
            case "red" -> Color.RED;
            case "yellow" -> Color.YELLOW;
            case "blue" -> Color.BLUE;
            default -> Color.GREEN;
        };
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }
}
