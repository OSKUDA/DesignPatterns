package structural.bridge.remote;

import java.util.TreeMap;

public class Remote {

    private final Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void nextChannel() {
        TreeMap<Integer, String> deviceChannel = (TreeMap<Integer, String>) device.getChannel();
        int currentChannel = device.getCurrentChannel();
        Integer next = deviceChannel.higherKey(currentChannel)  ;
        if (next == null) {
            next = deviceChannel.firstKey();
        }
        device.setChannel(next);
    }

    public void previousChannel() {
        TreeMap<Integer, String> deviceChannel = (TreeMap<Integer, String>)device.getChannel();
        int currentChannel = device.getCurrentChannel();
        Integer previous = deviceChannel.lowerKey(currentChannel);
        if (previous == null) {
            previous = deviceChannel.lastKey();
        }
        device.setChannel(previous);
    }

    public void volumeUp() {
        int currentVolume = device.getVolume();
        device.setVolume(Math.min(100, currentVolume + 1));
    }

    public void volumeDown() {
        int currentVolume = device.getVolume();
        device.setVolume(Math.max(0, currentVolume - 1));
    }

    public Device getDevice() {
        return this.device;
    }
}
