package structural.bridge.remote;

public class AdvancedRemote extends Remote {


    public AdvancedRemote(Device device) {
        super(device);
    }

    public void printChannels() {
        System.out.println("Channels : " + super.getDevice().getChannel());
    }
}
