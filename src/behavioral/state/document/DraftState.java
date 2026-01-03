package behavioral.state.document;

public class DraftState implements DocumentState {

    private final Document document;

    public DraftState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Document ready for review");
        document.changeState(new ReviewState(this.document));
    }

    @Override
    public void write(String text) {
        this.document.addText(text);
    }
}
