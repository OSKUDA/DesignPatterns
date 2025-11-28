package structural.facade.converter.audio;

import structural.facade.converter.file.VideoFile;

import java.io.File;
import java.io.IOException;

public class AudioMixer {


    public File fix(VideoFile result) {
        System.out.println("AudioMixer : fixing audio...");
        File file = new File("tmp/" + result.getName());
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e.getMessage());
        }
        return file;
    }
}
