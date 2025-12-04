package behavioral.iterator.app.iterator;

import behavioral.iterator.app.Profile;

public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();

}
