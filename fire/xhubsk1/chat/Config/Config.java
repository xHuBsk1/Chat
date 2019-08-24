package fire.xhubsk1.chat.Config;

import fire.xhubsk1.chat.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {
    public static String chat;
    public static String say;

    public static List<String> chaton;
    public static List<String> chatoff;
    public static List<String> chatcc;

    public static List<String> wchatoff;

    public static void load(Main main) {
        main.saveDefaultConfig();
        FileConfiguration config = main.getConfig();
        chat = config.getString("permission.chat");
        say = config.getString("permission.say");
        chaton = config.getStringList("chat.on");
        chatoff = config.getStringList("chat.off");
        chatcc = config.getStringList("chat.cc");
        wchatoff = config.getStringList("wiadomosc.chatoff");
    }
}
