package structural.facade.converter;

import structural.facade.converter.audio.AudioMixer;
import structural.facade.converter.bitrate.BitRateReader;
import structural.facade.converter.codec.Codec;
import structural.facade.converter.codec.CodecFactory;
import structural.facade.converter.codec.MPEG4CompressionCodec;
import structural.facade.converter.codec.OggCompressionCodec;
import structural.facade.converter.file.VideoFile;

import java.io.File;

public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade : conversion started");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;

        switch (format) {
            case "mp4" -> destinationCodec = new MPEG4CompressionCodec();
            case "ogg" -> destinationCodec = new OggCompressionCodec();
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        }

        VideoFile buffer = BitRateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitRateReader.convert(buffer, destinationCodec);

        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade : conversion completed");

        return result;
    }
}
