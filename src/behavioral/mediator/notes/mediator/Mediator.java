package behavioral.mediator.notes.mediator;

import behavioral.mediator.notes.Note;
import behavioral.mediator.notes.components.Component;

import javax.swing.*;

public interface Mediator {

    void addNewNote(Note note);
    void deleteNote();
    void getInfoFromList(Note note);
    void saveChanges();
    void markNote();
    void clear();
    void sendToFilter(ListModel listModel);
    void setElementsList(ListModel listModel);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void createGUI();
}
