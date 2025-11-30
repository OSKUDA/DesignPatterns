package structural.proxy.downloader;

public class Video {

    private final String id;

    private final String title;

    private final String data;

    public Video(String id, String title, String data) {
        this.id = id;
        this.title = title;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
