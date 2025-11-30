package structural.flyweight.forest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest {

    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType treeType = TreeTypeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, treeType);
        trees.add(tree);
    }

    public void draw(Graphics2D graphics2D) {
        trees.forEach(
                tree -> tree.draw(graphics2D)
        );
    }

    public List<Tree> getTrees() {
        return List.copyOf(trees);
    }
}
