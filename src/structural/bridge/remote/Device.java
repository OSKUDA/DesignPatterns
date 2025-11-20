package structural.bridge.remote;

import java.util.SortedMap;
import java.util.TreeMap;

public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percentage);

    TreeMap<Integer, String> getChannel();

    void setChannel(int channelNumber);

    int getCurrentChannel();

}
