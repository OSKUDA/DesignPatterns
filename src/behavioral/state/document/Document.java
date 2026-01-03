package behavioral.state.document;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private DocumentState state;

    private final List<String> data;

    public Document() {
        this.state = new DraftState(this);
        this.data = new ArrayList<>();
    }

    public void render() {
        System.out.println("<<<Document>>>");
        for (int i = 0; i < data.size(); i++) {
            System.out.println(i + " : " + data.get(i));
        }
        System.out.println("<<<Document EOF>>>");
    }

    public void publish() {
        this.state.publish();
    }

    public void write(String text) {
        this.state.write(text);
    }

    void addText(String text) {
        this.data.add(text);
    }

    public void changeState(DocumentState state) {
        this.state = state;
        System.out.println("Document state updated to : " + state.getClass().getSimpleName());
    }
}
