package structural.bridge.remote;

import java.util.TreeMap;

public class TV implements Device {

    private boolean enabled;

    private int volume;

    private final TreeMap<Integer, String> channels;

    private int channel;

    public TV() {
        this.enabled = false;
        this.volume = 10;
        this.channels = new TreeMap<>();
        this.channel = 0;

        this.channels.put(0, "Home");
        this.channels.put(1, "ZeeTv");
        this.channels.put(2, "ESPN");
        System.out.println("TV initialized : " + this.toString());
    }

    @Override
    public boolean isEnabled() {
        System.out.println("TV is " + (this.enabled ? "on" : "off"));
        return this.enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
        System.out.println("TV turned on");
    }

    @Override
    public void disable() {
        this.enabled = false;
        System.out.println("TV turned off");
    }

    @Override
    public int getVolume() {
        if (!this.enabled) {
            throw new IllegalStateException("TV not on");
        }
        System.out.println("TV volume is " + this.volume);
        return this.volume;
    }

    @Override
    public void setVolume(int percentage) {
        if (!this.enabled) {
            throw new IllegalStateException("TV not on");
        }
        this.volume = percentage;
        System.out.println("TV volume set to " + this.volume);
    }

    @Override
    public TreeMap<Integer, String> getChannel() {
        if (!this.enabled) {
            throw new IllegalStateException("TV not on");
        }
        System.out.println("TV channels : " + this.channels);
        return this.channels;
    }

    @Override
    public void setChannel(int channelNumber) {
        if (!this.enabled) {
            throw new IllegalStateException("TV not on");
        }
        this.channel = channelNumber;
        System.out.println("TV channel set to : " + this.channel);
    }

    @Override
    public int getCurrentChannel() {
        if (!this.enabled) {
            throw new IllegalStateException("TV not on");
        }
        System.out.println("TV channel is : " + this.channel);
        return this.channel;
    }

    @Override
    public String toString() {
        return "TV{" +
                "enabled=" + enabled +
                ", volume=" + volume +
                ", channels=" + channels +
                ", channel=" + channel +
                '}';
    }
}
