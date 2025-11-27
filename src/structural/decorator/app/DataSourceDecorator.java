package structural.decorator.app;

import java.util.List;

public class DataSourceDecorator implements DataSource {

    private final DataSource dataSource;

    public DataSourceDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void appendData(String data) {
        dataSource.appendData(data);
    }

    @Override
    public void writeData(String data, int lineNumber) {
        dataSource.writeData(data, lineNumber);
    }

    @Override
    public List<String> readData() {
        return dataSource.readData();
    }

    @Override
    public String readMetaData() {
        return dataSource.readMetaData();
    }

    @Override
    public List<String> readRawData() {
        return dataSource.readRawData();
    }
}
