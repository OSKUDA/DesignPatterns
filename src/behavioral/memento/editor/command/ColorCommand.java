package behavioral.memento.editor.command;

import behavioral.memento.editor.editor.Editor;
import behavioral.memento.editor.shapes.Shape;

import java.awt.*;

public class ColorCommand implements Command {

    private Editor editor;

    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize : " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape shape : editor.getShapes().getSelected()) {
            shape.setColor(color);
        }
    }
}
