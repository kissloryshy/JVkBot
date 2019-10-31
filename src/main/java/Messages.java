import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Messages {
    String getRand() {
        int min = 100;
        int max = 2000000000;
        int rand = min + (int) (Math.random() * max);
        return String.valueOf(rand);
    }

    void sendMessage(String message) {
        //send message
        String mes = message;
        String r = "https://api.vk.com/method/messages.send?user_id=" + Variables.getFromId()
                + "&random_id=" +getRand()
                + "&peer_id=" + Variables.getFromId()
                + "&message=" + mes
                + "&access_token=" + Variables.getAccess_token_community()
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void getDialogs() {
        String count = "1";
        String r = "https://api.vk.com/method/messages.getConversations?count=" + count
                + "&filter=unread&"
                + "group_id" + "187747735"
                + "&access_token=" + Variables.getAccess_token_community()
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("getDialogs " + response.body());

            JSONObject root = new JSONObject(response.body());
            JSONObject second = root.getJSONObject("response");
            if (second.getInt("count") == 0)
                return;
            JSONArray three = second.getJSONArray("items");
            JSONObject four = three.getJSONObject(0);
            JSONObject five = four.getJSONObject("last_message");
            String msg = five.getString("text");
            System.out.println("Message = " + msg);
            long lng = five.getLong("from_id");
            Variables.setFromId(String.valueOf(lng));

            Parser parser = new Parser();
            parser.parse(msg);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void sendMessageWithAttachment(String msg, String attachment) {
        msg = msg.replaceAll(" ", "+");
        String r = "https://api.vk.com/method/messages.send?user_id=" + Variables.getFromId()
                + "&random_id=" +getRand()
                + "&peer_id=" + Variables.getFromId()
                + "&message=" + msg
                + "&attachment=" + attachment
                + "&access_token=" + Variables.getAccess_token_community()
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
