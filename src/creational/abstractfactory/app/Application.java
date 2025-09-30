package creational.abstractfactory.app;

import creational.abstractfactory.app.button.Button;
import creational.abstractfactory.app.checkbox.Checkbox;
import creational.abstractfactory.app.factory.GUIFactory;

public class Application {

    private Button button;

    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

}
