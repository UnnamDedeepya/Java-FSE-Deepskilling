package document;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("📄 Word Document opened.");
    }
}