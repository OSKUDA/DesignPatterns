package structural.proxy.downloader;

import java.util.HashMap;
import java.util.Map;

public class YouTubeLibCacheProxy implements YouTubeLib {

    private final YouTubeLib youTubeLib;

    private final Map<String, Video> cacheVideos;

    public YouTubeLibCacheProxy() {
        this.youTubeLib = new YouTubeLibImpl();
        this.cacheVideos = new HashMap<>();
    }

    @Override
    public Map<String, Video> getPopularVideos() {
        if (!cacheVideos.isEmpty()) {
            System.out.println("Found popular video in cache");
            return cacheVideos;
        }
        cacheVideos.putAll(youTubeLib.getPopularVideos());
        return cacheVideos;
    }

    @Override
    public Video getVideo(String id) {
        Video video = cacheVideos.get(id);
        if (video != null) {
            System.out.println("Found the video in cache");
            return video;
        }
        video = youTubeLib.getVideo(id);
        cacheVideos.put(video.getId(), video);
        return video;
    }
}
