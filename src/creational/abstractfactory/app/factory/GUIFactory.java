package creational.abstractfactory.app.factory;

import creational.abstractfactory.app.button.Button;
import creational.abstractfactory.app.checkbox.Checkbox;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();

}
