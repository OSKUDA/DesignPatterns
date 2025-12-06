package behavioral.mediator.notes.components;

import behavioral.mediator.notes.Note;
import behavioral.mediator.notes.mediator.Mediator;

import javax.swing.*;

public class List extends JList<Note> implements Component {

    private Mediator mediator;
    private final DefaultListModel<Note> LIST_MODEL;

    public List(DefaultListModel<Note> listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;

        super.setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);

        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(LIST_MODEL);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
            mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Something went wrong : " + e.getMessage());
        }
    }

    public Note getCurrentElement() {
        return this.getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong : " + e.getMessage());
                }
                if (list.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}
