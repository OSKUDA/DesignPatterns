package behavioral.state.document;

public class ReviewedState implements DocumentState {

    private final Document document;

    public ReviewedState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Publishing the document");
        this.document.changeState(new PublishedState(this.document));
    }

    @Override
    public void write(String text) {
        System.out.println("Unable to edit the document in ReviewedState");
    }
}
