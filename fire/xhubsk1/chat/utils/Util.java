package fire.xhubsk1.chat.utils;

public class Util {
    public static String fix(String text) {
        return text.replace(">>", "»").replace("&", "§").replace("<<", "«");
    }
}
