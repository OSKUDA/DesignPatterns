package behavioral.state.document;

public class ReviewState implements DocumentState {

    private final Document document;

    public ReviewState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Document reviewed");
        this.document.changeState(new ReviewedState(this.document));
    }

    @Override
    public void write(String text) {
        System.out.println("Unable to edit the document in ReviewState");
    }
}
