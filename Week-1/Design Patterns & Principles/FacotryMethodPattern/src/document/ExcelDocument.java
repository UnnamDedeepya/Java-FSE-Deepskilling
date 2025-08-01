package document;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("📄 Excel Document opened.");
    }
}