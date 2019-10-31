public class Variables {
    static private String access_token_community = "eef95c0ffa7249014b33c18aeae39c65047b6fb2eda930f687a61c327d62be79f7b953bf53b2a4c67d388";
    static private String access_token_user = "bd579531635d15200abfc66bdfecc1b5c936b935d8b308c64ebffd6808b20eda6e4cdb6810d4758961883";
    static private String fromId = "";

    public static String getAccess_token_community() {
        return access_token_community;
    }

    public static void setAccess_token_community(String access_token_community) {
        Variables.access_token_community = access_token_community;
    }

    public static String getAccess_token_user() {
        return access_token_user;
    }

    public static void setAccess_token_user(String access_token_user) {
        Variables.access_token_user = access_token_user;
    }

    public static String getFromId() {
        return fromId;
    }

    public static void setFromId(String fromId) {
        Variables.fromId = fromId;
    }
}
