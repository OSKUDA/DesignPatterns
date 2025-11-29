package structural.flyweight.forest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest {

    private final List<Tree> trees = new ArrayList<>();

    public void platTree(int x, int y, String name, String color, String texture) {
        TreeType treeType = TreeTypeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, treeType);
        trees.add(tree);
    }

    public void draw(Canvas canvas) {
        trees.forEach(
                tree -> tree.draw(canvas)
        );
    }
}
