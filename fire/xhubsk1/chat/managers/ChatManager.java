package fire.xhubsk1.chat.managers;

public class ChatManager {
    private static boolean chat = true;

    public static boolean isChat() {
        return chat;
    }

    public static void setChat(boolean zmien) {
        chat = zmien;
    }
}
