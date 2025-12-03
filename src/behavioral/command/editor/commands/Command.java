package behavioral.command.editor.commands;

import behavioral.command.editor.Editor;

public abstract class Command {

    protected final Editor editor;

    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    protected final void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();

}
