public class JVkBotThread {

    private boolean isSuspend;

    JVkBotThread(boolean isSuspend) {
        this.isSuspend = isSuspend;
    }

    void parse () {
        Messages messages = new Messages();

        while (true) {
            try {
                if (!isSuspend) {
                    messages.getDialogs();
                }
                Thread.sleep(3500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
