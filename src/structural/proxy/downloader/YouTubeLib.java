package structural.proxy.downloader;

import java.util.Map;

public interface YouTubeLib {

    Map<String, Video> getPopularVideos();

    Video getVideo(String id);

}
