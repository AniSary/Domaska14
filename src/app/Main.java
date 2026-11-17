package app;

public class Main {
    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();

        printer.print(new MessagePrinter.Message("Привіт!", "Іван"));
        printer.print(new MessagePrinter.Message("Привіт!", null));
        printer.print(new MessagePrinter.Message(null, null));
    }
}