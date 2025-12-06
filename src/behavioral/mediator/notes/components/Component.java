package behavioral.mediator.notes.components;

import behavioral.mediator.notes.mediator.Mediator;

public interface Component {

    void setMediator(Mediator mediator);

    String getName();

}
