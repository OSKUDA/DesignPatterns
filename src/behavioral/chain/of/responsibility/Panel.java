package behavioral.chain.of.responsibility;

public class Panel extends Container {

    private final String modalHelpText;

    public Panel(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelpMessage() {
        if (modalHelpText != null) {
            System.out.println("HELP TEXT : " + modalHelpText);
        } else {
            super.showHelpMessage();
        }
    }
}
