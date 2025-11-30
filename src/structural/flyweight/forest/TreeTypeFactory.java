package structural.flyweight.forest;

import java.util.ArrayList;
import java.util.List;

public class TreeTypeFactory {

    private static final List<TreeType> treeTypes = new ArrayList<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        return treeTypes.stream()
                .filter(treeType -> treeType.getName().equals(name)
                        && treeType.getColor().equals(color)
                        && treeType.getTexture().equals(texture))
                .findFirst()
                .orElseGet(() -> {
                    TreeType treeType = new TreeType(name, color, texture);
                    treeTypes.add(treeType);
                    return treeType;
                });
    }

    public static int getTreeTypeSize() {
        return treeTypes.size();
    }

}
