package creational.factory.factory;

import creational.factory.button.Button;
import creational.factory.button.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
