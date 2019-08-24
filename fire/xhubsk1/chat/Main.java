package fire.xhubsk1.chat;

import fire.xhubsk1.chat.Config.Config;
import fire.xhubsk1.chat.commands.ChatCommand;
import fire.xhubsk1.chat.listeners.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        Config.load(this);
        new ChatCommand(this);
        new ChatListener(this);
    }
}
