import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Video {
    void searchVideo(String query) {
        query = query.replaceAll(" ", "+");

        String access_token_user = "bd579531635d15200abfc66bdfecc1b5c936b935d8b308c64ebffd6808b20eda6e4cdb6810d4758961883";
        int count = 10;

        String r = "https://api.vk.com/method/video.search?q=" + query
                + "&count=" + count
                + "&access_token=" + access_token_user
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
