package behavioral.chain.of.responsibility;

public class Dialog extends Container {

    private final String wikiPageUrl;

    public Dialog(String wikiPageUrl) {
        this.wikiPageUrl = wikiPageUrl;
    }

    @Override
    public void showHelpMessage() {
        if (wikiPageUrl != null) {
            System.out.println("HELP TEXT : " + wikiPageUrl);
        } else {
            super.showHelpMessage();
        }
    }
}
