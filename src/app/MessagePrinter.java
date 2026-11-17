package app;

public class MessagePrinter implements Printer<MessagePrinter.Message> {

    public static class Message {
        private String text;
        private String sender;

        public Message(String text, String sender) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public String getSender() { return sender; }
        public void setSender(String sender) { this.sender = sender; }
    }

    private static boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    @Override
    public void print(Message m) {
        if (isEmpty(m.getText()) && isEmpty(m.getSender())) {
            // анонімний клас для пустого повідомлення
            Printer<Message> emptyHandler = new Printer<>() {
                @Override
                public void print(Message msg) {
                    System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
                }
            };
            emptyHandler.print(m);
        } else if (isEmpty(m.getSender())) {
            System.out.println("Анонімний користувач відправив повідомлення: " + m.getText());
        } else {
            System.out.println("Користувач " + m.getSender() + " відправив повідомлення: " + m.getText());
        }
    }
}