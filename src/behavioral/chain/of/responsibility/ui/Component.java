package behavioral.chain.of.responsibility.ui;

public abstract class Component implements ComponentWithContextualHelp {

    private String toolTipMessage;

    private Container container;

    @Override
    public void showHelpMessage() {
        if (toolTipMessage != null && !toolTipMessage.isEmpty()) {
            // show tooltip
            System.out.println("HELP TEXT : " + toolTipMessage);
        } else {
            if (container != null) {
                container.showHelpMessage();
            } else {
                System.out.println("No help text found");
            }
        }
    }

    public void setToolTipMessage(String toolTipMessage) {
        this.toolTipMessage = toolTipMessage;
    }

    public Container getContainer() {
        return this.container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

}
