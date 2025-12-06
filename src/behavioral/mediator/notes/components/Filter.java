package behavioral.mediator.notes.components;

import behavioral.mediator.notes.Note;
import behavioral.mediator.notes.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Filter extends JTextField implements Component {

    private Mediator mediator;
    private ListModel<Note> listModel;

    public Filter() {
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        String start = super.getText();
        searchElements(start);
    }

    public void setList(ListModel<Note> listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.isEmpty()) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add(listModel.getElementAt(i));
        }

        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }

        mediator.setElementsList(listModel);
    }


    @Override
    public String getName() {
        return "Filter";
    }
}
