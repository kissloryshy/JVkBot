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

    void sendMessage() {
        //send message
        String access_token_community = "eef95c0ffa7249014b33c18aeae39c65047b6fb2eda930f687a61c327d62be79f7b953bf53b2a4c67d388";
        String id = "95026222";
        String mes = "Hello_world";
        String r = "https://api.vk.com/method/messages.send?user_id=" + id
                + "&random_id=" +getRand()
                + "&peer_id=" + id
                + "&message=" + mes
                + "&access_token=" + access_token_community
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
        String access_token_community = "eef95c0ffa7249014b33c18aeae39c65047b6fb2eda930f687a61c327d62be79f7b953bf53b2a4c67d388";
        String count = "1";
        String id;
        String r = "https://api.vk.com/method/messages.getConversations?count=1&filter=unread&"
                + "group_id" + "187747735"
                + "&access_token=" + access_token_community
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            JSONObject root = new JSONObject(response.body());
            JSONObject secont = root.getJSONObject("response");
            if (secont.getInt("count") == 0)
                return;
            JSONArray three = secont.getJSONArray("items");
            JSONObject four = three.getJSONObject(0);
            JSONObject five = four.getJSONObject("last_message");
            String msg = five.getString("text");
            long lng = five.getLong("from_id");
            String fromId = String.valueOf(lng);

            Video video = new Video();
            video.searchVideo(msg, fromId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void sendMessageWithAttachment(String attachment, String fromId) {
        String access_token_community = "eef95c0ffa7249014b33c18aeae39c65047b6fb2eda930f687a61c327d62be79f7b953bf53b2a4c67d388";
        String id = fromId;
        String mes = "Hello_world";
        String r = "https://api.vk.com/method/messages.send?user_id=" + id
                + "&random_id=" +getRand()
                + "&peer_id=" + fromId
                + "&attachment=" + attachment
                + "&access_token=" + access_token_community
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
