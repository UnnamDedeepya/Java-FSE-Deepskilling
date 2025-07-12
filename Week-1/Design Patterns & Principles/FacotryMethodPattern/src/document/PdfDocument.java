package document;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("📄 PDF Document opened.");
    }
}