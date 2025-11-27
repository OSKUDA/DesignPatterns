package structural.decorator.app;

import java.util.ArrayList;
import java.util.List;

public class FileDataSource implements DataSource {

    private final List<String> file;

    public FileDataSource(String fileName) {
        this.file = new ArrayList<>();
        file.add("FileName: " + fileName);
    }

    @Override
    public void appendData(String data) {
        file.add(data);
    }

    @Override
    public void writeData(String data, int lineNumber) {
        file.set(lineNumber, data);
    }

    @Override
    public List<String> readData() {
        return List.copyOf(file);
    }

    @Override
    public String readMetaData() {
        return file.get(0);
    }

    @Override
    public List<String> readRawData() {
        return List.copyOf(file);
    }

}
