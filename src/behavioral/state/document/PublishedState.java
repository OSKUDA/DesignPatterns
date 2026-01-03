package behavioral.state.document;

public class PublishedState implements DocumentState {

    private final Document document;

    public PublishedState(Document document) {
        this.document = document;
    }

    @Override
    public void publish() {
        System.out.println("Document published");
    }

    @Override
    public void write(String text) {
        System.out.println("Unable to edit the document in PublishedState");
    }

}
