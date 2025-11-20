package structural.bridge.remote;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Radio implements Device {

    private boolean enabled;

    private int channel;

    private int volume;

    private final TreeMap<Integer, String> channels;

    public Radio() {
        this.enabled = false;
        this.volume = 10;
        this.channel = 0;
        this.channels = new TreeMap<>();

        this.channels.put(0, "Home");
        this.channels.put(1, "NepalRadio");
        this.channels.put(2, "KantipurRadio");
        System.out.println("Radio initialized : " + this.toString());
    }

    @Override
    public boolean isEnabled() {
        System.out.println("Radio is " + (this.enabled ? "on" : "off"));
        return this.enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
        System.out.println("Radio turned on");
    }

    @Override
    public void disable() {
        this.enabled = false;
        System.out.println("Radio turned off");
    }

    @Override
    public int getVolume() {
        if (!this.enabled) {
            throw new IllegalStateException("Radio not on");
        }
        System.out.println("Radio volume is : " + this.volume);
        return this.volume;
    }

    @Override
    public void setVolume(int percentage) {
        if (!this.enabled) {
            throw new IllegalStateException("Radio not on");
        }
        this.volume = percentage;
        System.out.println("Radio volume set to : " + this.volume);
    }

    @Override
    public TreeMap<Integer, String> getChannel() {
        if (!this.enabled) {
            throw new IllegalStateException("Radio not on");
        }
        return this.channels;
    }

    @Override
    public void setChannel(int channelNumber) {
        if (!this.enabled) {
            throw new IllegalStateException("Radio not on");
        }
        this.channel = channelNumber;
        System.out.println("Radio channel set to : " + this.channel);
    }

    @Override
    public int getCurrentChannel() {
        if (!this.enabled) {
            throw new IllegalStateException("Radio not on");
        }
        System.out.println("Radio channel is : " + this.channel);
        return this.channel;
    }
}
