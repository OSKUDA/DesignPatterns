package structural.facade.converter;

import java.io.File;

/**
 * ============================================================
 *                FACADE PATTERN — CLIENT NOTES
 * ============================================================
 *
 * INTENT
 * ------
 * The Facade Pattern provides a **simple, unified interface** to a complex
 * subsystem. The client interacts with the facade instead of dealing with
 * multiple classes and steps directly.
 *
 * WHY IT’S USED HERE
 * ------------------
 * Video conversion requires several coordinated steps (codec detection,
 * bitrate reading/conversion, audio fixing, file output). Exposing all those
 * classes to the client would make client code harder to read and maintain.
 *
 * In this example, the client only knows about:
 *      `VideoConversionFacade.convertVideo(fileName, format)`
 *
 * PARTICIPANTS IN THIS EXAMPLE
 * -----------------------------
 * Client:
 *   - Calls the facade.
 *   - Has zero knowledge of subsystem internals.
 *
 * Facade:
 *   - `VideoConversionFacade`
 *   - Orchestrates the workflow end‑to‑end.
 *
 * Subsystem classes (hidden from client):
 *   - `VideoFile`           : represents input/output video.
 *   - `CodecFactory`        : detects source codec.
 *   - `MPEG4CompressionCodec` / `OggCompressionCodec` : destination codecs.
 *   - `BitRateReader`       : reads and converts streams.
 *   - `AudioMixer`          : final audio fix + output file creation.
 *
 * CLIENT FLOW
 * -----------
 * 1. Create the facade.
 * 2. Request conversion by giving only file name + target format.
 * 3. Receive a ready-to-use File object.
 *
 * KEY TAKEAWAYS
 * -------------
 * ✔ Client code stays minimal and readable.
 * ✔ Subsystem complexity is centralized in the facade.
 * ✔ Changing subsystem internals does not affect the client.
 * ✔ Facade does NOT replace subsystem classes; it just simplifies access.
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        VideoConversionFacade converter = new VideoConversionFacade();
        File convertedFile = converter.convertVideo("oskar_youtube.mp4", "ogg");
        System.out.println("FilePath : " + convertedFile.getAbsolutePath());
    }
}
