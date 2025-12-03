package behavioral.command.editor.commands;

import behavioral.command.editor.Editor;

public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty())
            return false;

        super.backup();
        if (editor.textField.getSelectedText() != null) {
            editor.textField.replaceSelection(editor.clipboard);
        } else {
            editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        }
        return true;
    }
}
