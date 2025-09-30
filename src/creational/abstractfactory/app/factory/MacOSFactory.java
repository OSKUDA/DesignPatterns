package creational.abstractfactory.app.factory;

import creational.abstractfactory.app.button.Button;
import creational.abstractfactory.app.button.MacOSButton;
import creational.abstractfactory.app.checkbox.Checkbox;
import creational.abstractfactory.app.checkbox.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
