public class Parser {
    void parse(String text) {
        if (text.contains("!video")) {
            Video video = new Video();
            video.searchVideo(text.substring(6, text.length()));
        }
    }
}
