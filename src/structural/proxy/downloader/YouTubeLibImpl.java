package structural.proxy.downloader;

import java.util.HashMap;

public class YouTubeLibImpl implements YouTubeLib {

    @Override
    public HashMap<String, Video> getPopularVideos() {
        connectToServer("https://www.youtube.com/popular");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String id) {
        connectToServer("https://www.youtube.com?videoId=" + id);
        return getSomeVideo(id);
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading popular videos");

        experienceNetworkLatency();
        HashMap<String, Video> map = new HashMap<>();

        Video video = new Video("1", "This is my first video", "KSDJAFHALWEHR");
        Video video1 = new Video("2", "My food", "iu4yriuyfod");
        Video video2 = new Video("3", "Trip to Kerala", "mcnvowuhrgpwik");
        Video video3 = new Video("4", "How to repair your bike", "oeugwojfsdkjfpwe");

        map.put(video.getId(), video);
        map.put(video1.getId(), video1);
        map.put(video2.getId(), video2);
        map.put(video3.getId(), video3);

        System.out.println("Done!");
        return map;
    }

    private Video getSomeVideo(String id) {
        System.out.println("Downloading video");

        experienceNetworkLatency();
        Video video = new Video(id, "Video Title", "BINARY DATA");

        System.out.println("Done!");
        return video;
    }

    private void connectToServer(String url) {
        System.out.println("Connecting to server at " + url);
        experienceNetworkLatency();
        System.out.println("Connected");
    }

    // fake methods to demonstrate network latency
    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("ERROR : Something went wrong " + ex.getMessage());
            }
        }
    }


}
