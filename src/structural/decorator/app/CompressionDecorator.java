package structural.decorator.app;

import java.util.ArrayList;
import java.util.List;

public class CompressionDecorator extends DataSourceDecorator {

    private static final String DELIMITER = "-";

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data, int lineNumber) {
        System.out.println("WRITE-COMPRESSION : LineNumber " + lineNumber + " Input data " + data);
        String compressedData = compress(data);
        System.out.println("WRITE-COMPRESSION : LineNumber " + lineNumber + " Compressed data " + compressedData);
        super.writeData(compressedData, lineNumber);
    }

    @Override
    public void appendData(String data) {
        System.out.println("WRITE-COMPRESSION : Input data " + data);
        String compressedData = compress(data);
        System.out.println("WRITE-COMPRESSION : Compressed data " + compressedData);
        super.appendData(compressedData);
    }

    @Override
    public List<String> readData() {
        List<String> compressedList = super.readData();
        List<String> decompressedList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        // avoid compressing/decompressing meta data
        decompressedList.add(compressedList.get(0));

        for (int i = 1; i < compressedList.size(); i++) {
            String data = compressedList.get(i);
            System.out.println("READ-COMPRESSION : Compressed data " + data);

            String decompressedData = decompress(data, builder);
            System.out.println("READ-COMPRESSION : Decompressed data : " + decompressedData);

            decompressedList.add(decompressedData);
        }

        return decompressedList;
    }

    private String compress(String data) {
        StringBuilder builder = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= data.length(); i++) {
            if (i < data.length() && data.charAt(i) == data.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count).append(DELIMITER).append(data.charAt(i - 1));
                count = 1;
            }
        }
        return builder.toString();
    }

    private String decompress(String data, StringBuilder builder) {
        builder.setLength(0);

        int index = 0;
        while (index < data.length()) {
            // read up to delimiter
            int delimiterIndex = data.indexOf(DELIMITER, index);
            if (delimiterIndex == -1) throw new IllegalArgumentException("Invalid RLE");

            int count = Integer.parseInt(data.substring(index, delimiterIndex));
            char c = data.charAt(delimiterIndex + 1);

            builder.append(String.valueOf(c).repeat(count));
            index = delimiterIndex + 2;
        }
        return builder.toString();
    }

}
