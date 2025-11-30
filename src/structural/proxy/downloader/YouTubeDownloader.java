package structural.proxy.downloader;

import java.util.Map;

public class YouTubeDownloader {

    private final YouTubeLib youTubeLib;

    public YouTubeDownloader(YouTubeLib youTubeLib) {
        this.youTubeLib = youTubeLib;
    }

    public void playVideo(String id) {
        Video video = youTubeLib.getVideo(id);
        System.out.println("Playing video");
        System.out.println(video.toString());
    }

    public void listPopularVideos() {
        Map<String, Video> popularVideos = youTubeLib.getPopularVideos();
        System.out.println("Popular video list : ");
        popularVideos.forEach(
                (id, video) -> {
                    System.out.println("VideoId " + id + " details : " + video);
                }
        );
    }
}
