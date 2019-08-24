package fire.xhubsk1.chat.listeners;

import fire.xhubsk1.chat.Config.Config;
import fire.xhubsk1.chat.Main;
import fire.xhubsk1.chat.managers.ChatManager;
import fire.xhubsk1.chat.utils.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    public ChatListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (!ChatManager.isChat()) {
            if (!p.hasPermission(Config.say)) {
                e.setCancelled(true);
                for (String msg : Config.wchatoff) {
                    p.sendMessage(Util.fix(msg).replace("{PLAYER}", p.getName()));
                }
            }
            e.setCancelled(false);
        }
    }
}
