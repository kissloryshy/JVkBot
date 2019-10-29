public class JVkBotThread {

    private boolean isStarted;

    JVkBotThread(boolean isStarted) {
        this.isStarted = isStarted;
    }

    void parse () {
        Messages messages = new Messages();

        if (isStarted) {
            while (true) {
                try {
                    messages.getDialogs();
                    Thread.sleep(3000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
