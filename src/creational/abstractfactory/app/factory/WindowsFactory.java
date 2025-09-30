package creational.abstractfactory.app.factory;

import creational.abstractfactory.app.button.Button;
import creational.abstractfactory.app.button.WindowsButton;
import creational.abstractfactory.app.checkbox.Checkbox;
import creational.abstractfactory.app.checkbox.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

}
