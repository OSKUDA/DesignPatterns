package structural.decorator.app;

import java.util.ArrayList;
import java.util.List;

public class EncryptionDecorator extends DataSourceDecorator {

    private final int encryptionKey;

    public EncryptionDecorator(DataSource dataSource, int encryptionKey) {
        super(dataSource);
        this.encryptionKey = encryptionKey;
    }

    @Override
    public void writeData(String data, int lineNumber) {
        System.out.println("WRITE-ENCRYPTION : Line number : " + lineNumber + " Input data : " + data);
        String encryptedData = encrypt(data);
        System.out.println("WRITE-ENCRYPTION : Line number : " + lineNumber + " Encrypted data : " + encryptedData);
        super.writeData(encryptedData, lineNumber);
    }

    @Override
    public void appendData(String data) {
        System.out.println("WRITE-ENCRYPTION : Input data : " + data);
        String encryptedData = encrypt(data);
        System.out.println("WRITE-ENCRYPTION : Encrypted data : " + encryptedData);
        super.appendData(encryptedData);
    }

    @Override
    public List<String> readData() {
        List<String> encryptedList = super.readData();
        List<String> decryptedList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        // avoid encrypting/decrypting meta data
        decryptedList.add(encryptedList.get(0));

        for (int i = 1; i < encryptedList.size(); i++) {
            String encryptedData = encryptedList.get(i);

            builder.setLength(0);
            System.out.println("READ-ENCRYPTION : Encrypted data : " + encryptedData);
            String decryptedData = decrypt(encryptedData, builder);
            System.out.println("READ-ENCRYPTION : Decrypted data : " + decryptedData);
            decryptedList.add(decryptedData);
        }

        return decryptedList;
    }

    private String encrypt(String data) {
        StringBuilder builder = new StringBuilder();
        for (char c : data.toCharArray()) {
            int encryptedValue = ((int) c + encryptionKey) % 255;
            builder.append((char) encryptedValue);
        }
        return builder.toString();
    }

    private String decrypt(String encryptedData, StringBuilder builder) {
        builder.setLength(0);
        for (char c : encryptedData.toCharArray()) {
            int decryptedValue = ((int) c - encryptionKey + 255) % 255;
            builder.append((char) decryptedValue);
        }
        return builder.toString();
    }

}
