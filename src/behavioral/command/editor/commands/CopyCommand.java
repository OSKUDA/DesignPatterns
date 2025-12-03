package behavioral.command.editor.commands;

import behavioral.command.editor.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        String selected = editor.textField.getSelectedText();
        if (selected == null || selected.isEmpty()) return false;
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
