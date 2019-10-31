import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Video {
    void searchVideo(String query) {
        query = query.replaceAll(" ", "+");

        String r = "https://api.vk.com/method/video.search?q=" + query
                + "&count=10"
                + "&sort=2"
                + "&adult=1"
                + "&access_token=" + Variables.getAccess_token_user()
                + "&v=5.103";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(r)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("videoSearch " + response.body());

            int countItems;
            String attachment = "";

            JSONObject root = new JSONObject(response.body());
            JSONObject second = root.getJSONObject("response");
            JSONArray three = second.getJSONArray("items");
            countItems = three.length();
            if (countItems == 0) {
                Messages messages = new Messages();
                messages.sendMessage("Видео по запросу " + query + "не найдено");
                return;
            }

            for (int i = 0; i < countItems; i++) {
                JSONObject four = three.getJSONObject(i);
                attachment += "video" + four.getLong("owner_id") + "_" + four.getLong("id") + ",";
            }

            String msg = "Видео по запросу: " + query;
            Messages messages = new Messages();
            messages.sendMessageWithAttachment(msg, attachment);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
