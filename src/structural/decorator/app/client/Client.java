package structural.decorator.app.client;

import structural.decorator.app.CompressionDecorator;
import structural.decorator.app.DataSource;
import structural.decorator.app.EncryptionDecorator;
import structural.decorator.app.FileDataSource;

/**
 * ============================================================
 *                 DECORATOR PATTERN — CLIENT NOTES
 * ============================================================
 *
 * GOAL OF THIS EXAMPLE
 * --------------------
 * Demonstrate the Structural Decorator Pattern by adding features
 * (Encryption + Compression) to a DataSource dynamically at runtime,
 * without changing the original FileDataSource class.
 *
 *
 * CORE IDEA OF DECORATOR
 * ----------------------
 * 1. All decorators implement the same interface as the component.
 *      -> DataSource is the Component interface.
 *
 * 2. A decorator wraps another DataSource instance.
 *      -> DataSourceDecorator holds a reference to a DataSource.
 *
 * 3. Decorators add behavior before/after delegating to wrapped object.
 *      -> EncryptionDecorator encrypts on write, decrypts on read.
 *      -> CompressionDecorator compresses on write, decompresses on read.
 *
 * 4. Decorators are stackable.
 *      -> We can wrap a DataSource with multiple decorators.
 *
 *
 * PARTICIPANTS IN THIS IMPLEMENTATION
 * -----------------------------------
 * Component Interface:
 *      DataSource
 *
 * Concrete Component (base behavior):
 *      FileDataSource    -> stores raw lines in an internal List<String>
 *
 * Base Decorator:
 *      DataSourceDecorator -> delegates all calls to wrapped DataSource
 *
 * Concrete Decorators:
 *      EncryptionDecorator  -> adds encryption feature
 *      CompressionDecorator -> adds RLE compression feature
 *
 *
 * IMPORTANT BEHAVIORAL CONTRACTS
 * -------------------------------
 * readData():
 *      - Returns "logical/plain" view after applying decorators.
 *      - EncryptionDecorator decrypts data here.
 *      - CompressionDecorator decompresses data here.
 *
 * readRawData():
 *      - Returns actual stored data in the wrapped component.
 *      - Useful to verify that decorators really changed storage format.
 *
 * Metadata Rule:
 *      - Line 0 is treated as metadata; decorators skip transforming it.
 *
 *
 * FLOW IN THIS CLIENT
 * -------------------
 * A) Encryption-only demo:
 *      1. Create FileDataSource.
 *      2. Immediately wrap with EncryptionDecorator (important!)
 *         -> ensures future writes are encrypted.
 *      3. Append plaintext.
 *         -> stored encrypted internally.
 *      4. readData() shows decrypted plaintext.
 *      5. readRawData() shows ciphertext.
 *
 * B) Compression + Encryption stacking demo:
 *      1. Create new FileDataSource for long text.
 *      2. Wrap with CompressionDecorator.
 *         -> text gets RLE compressed before storage.
 *      3. Wrap again with EncryptionDecorator.
 *         -> compressed data is then encrypted.
 *
 * Order matters:
 *      Compress -> Encrypt is correct:
 *        - encrypted data is random-looking and doesn’t compress well,
 *          so compression must happen first.
 *
 *
 * KEY TAKEAWAYS
 * --------------
 * ✔ Decorator adds behavior without modifying existing classes.
 * ✔ Client can add/remove features dynamically at runtime.
 * ✔ Multiple decorators can be combined.
 * ✔ Stacking order changes behavior/output.
 * ✔ Logical view (readData) can differ from physical storage (readRawData).
 *
 * ============================================================
 */
public class Client {
    public static void main(String[] args) {

        DataSource dataSource = new FileDataSource("sensitive.txt");
        System.out.println("FileMetaData : " + dataSource.readMetaData());

        System.out.println("CLIENT lets add encryption feature");
        dataSource = new EncryptionDecorator(dataSource, 5);

        dataSource.appendData("This is simple write");
        System.out.println("CLIENT reads the file : " + dataSource.readData());

        dataSource.appendData("My password is 955OskarBBBAAA44477");
        System.out.println("CLIENT reads the file : " + dataSource.readData());

        System.out.println("CLIENT why is my password not encrypted?");

        dataSource.appendData("My favourite color is navy blue");
        System.out.println("CLIENT reads the file : " + dataSource.readData());

        System.out.println("CLIENT checks raw file : " + dataSource.readRawData());

        DataSource longTextDataSource = new FileDataSource("long_text.txt");
        System.out.println("Client wants to add very long texts");

        System.out.println("Client suggests to add compression techniques to minimize file size");
        longTextDataSource = new CompressionDecorator(longTextDataSource);

        System.out.println("Client suggests to add encryption techniques");
        longTextDataSource = new EncryptionDecorator(longTextDataSource, 4);

        longTextDataSource.appendData("AAAABBBCCDAAAAAEEEEFFFFGGGGGG");
        longTextDataSource.appendData("AAAAAAAABBBBBBCCCCCDDDDAAAAAAAAAAEEEEEEEEEFFFFFFFGGGGGGGGGGGGHHHHHHHHIIIIIIJJJJJKKKKLLLLLLLLMMMMMMMM");

        System.out.println("CLIENT reads the file : " + longTextDataSource.readData());
        System.out.println("CLIENT checks raw file : " + longTextDataSource.readRawData());

    }
}
