import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Video {
    void searchVideo(String query, String fromId) {
        query = query.replaceAll(" ", "+");

        String access_token_user = "bd579531635d15200abfc66bdfecc1b5c936b935d8b308c64ebffd6808b20eda6e4cdb6810d4758961883";
        int count = 10;

        String r = "https://api.vk.com/method/video.search?q=" + query
                + "&count=" + count
                + "&sort" + "2"
                + "&access_token=" + access_token_user
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            JSONObject root = new JSONObject(response.body());
            JSONObject second = root.getJSONObject("response");
            System.out.println("count = " + second.getInt("count"));
            JSONArray three = second.getJSONArray("items");
            JSONObject four = three.getJSONObject(0);
            System.out.println("id = " + four.getLong("id"));
            System.out.println("id = " + four.getLong("owner_id"));

            Messages messages = new Messages();
            messages.sendMessageWithAttachment("video" +
                    four.getLong("owner_id") +
                    "_" +
                    four.getLong("id"), fromId);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
