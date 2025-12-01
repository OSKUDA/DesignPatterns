package behavioral.chain.of.responsibility;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Component {

    protected List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
        component.setContainer(this);
    }
}
