import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        Video video = new Video();
        video.searchVideo("Meriah Carey");
    }

    private static String getRand() {
        int min = 100;
        int max = 2000000000;
        int rand = min + (int) (Math.random() * max);
        return String.valueOf(rand);
    }

    static void sendMessage() {
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
}
