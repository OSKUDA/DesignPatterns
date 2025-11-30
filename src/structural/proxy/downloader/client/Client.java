package structural.proxy.downloader.client;

import structural.proxy.downloader.YouTubeDownloader;
import structural.proxy.downloader.YouTubeLibCacheProxy;

/**
 * ============================================================
 *              PROXY PATTERN — CLIENT NOTES
 * ============================================================
 *
 * INTENT
 * ------
 * Proxy provides a **substitute / placeholder** for another object
 * to control access to it while keeping the same interface.
 *
 * Client talks to the Proxy as if it were the real object.
 *
 *
 * WHY PROXY IS USEFUL
 * -------------------
 * ✔ Add behavior without changing the real class:
 *      - caching
 *      - lazy loading
 *      - access control / security
 *      - logging / monitoring / throttling
 * ✔ Hide expensive operations (network, DB, remote calls).
 *
 *
 * PARTICIPANTS IN THIS EXAMPLE
 * -----------------------------
 * Subject (interface):
 *      YouTubeLib
 *      - defines operations used by client
 *
 * RealSubject:
 *      YouTubeLibImpl
 *      - simulates expensive network calls (latency)
 *      - returns Video objects / popular list
 *
 * Proxy:
 *      YouTubeLibCacheProxy
 *      - implements same interface as RealSubject
 *      - stores results in cache (HashMap)
 *      - returns cached data when available
 *      - delegates to RealSubject only on cache miss
 *
 * Client:
 *      YouTubeDownloader / Client
 *      - depends only on YouTubeLib
 *      - unaware if it’s talking to proxy or real service
 *
 *
 * CLIENT FLOW
 * -----------
 * 1. Client creates downloader with Proxy:
 *        new YouTubeDownloader(new YouTubeLibCacheProxy())
 *
 * 2. listPopularVideos():
 *      - Proxy checks cache:
 *            if cached -> returns immediately
 *            else -> calls RealSubject, caches result, returns it
 *
 * 3. playVideo(id):
 *      - Proxy checks cache for that video:
 *            if cached -> returns immediately
 *            else -> calls RealSubject, caches video, returns it
 *
 * Result:
 *      First call is slow (network simulated),
 *      subsequent calls are fast (cache hit).
 *
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Proxy and RealSubject share the same interface.
 * ✔ Proxy controls access and may add extra logic.
 * ✔ Client code stays unchanged when adding proxy.
 * ✔ Good for expensive/remote resources.
 *
 * ============================================================
 */
public class Client {

    public static void main(String[] args) {

        YouTubeDownloader downloader = new YouTubeDownloader(new YouTubeLibCacheProxy());
        downloader.listPopularVideos();
        downloader.playVideo("1");

    }
}
