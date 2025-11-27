package structural.decorator.app;

import java.util.List;

public interface DataSource {

    void appendData(String data);

    void writeData(String data, int lineNumber);

    List<String> readData();

    String readMetaData();

    List<String> readRawData();

}
