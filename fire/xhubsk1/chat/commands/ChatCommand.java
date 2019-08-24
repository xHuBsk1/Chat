package fire.xhubsk1.chat.commands;

import fire.xhubsk1.chat.Config.Config;
import fire.xhubsk1.chat.Main;
import fire.xhubsk1.chat.managers.ChatManager;
import fire.xhubsk1.chat.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatCommand implements CommandExecutor {
    public ChatCommand(Main main) {
        main.getCommand("chat").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player)sender;
        if (!p.hasPermission(Config.chat)) {
            p.sendMessage(Util.fix(" &8>> &7Nie posiadasz permissji!"));
            return false;
        }
        if (args.length == 0) {
            p.sendMessage(Util.fix(" &8>> &7Poprawne uzycie &6/chat <on/cc/off>"));
            return false;
        }
        switch (args[0]) {
            case "on": {
                for (int i = 0; i < 60; ++i) {
                    Bukkit.broadcastMessage("");
                }
                for (String msg : Config.chaton) {
                    Bukkit.broadcastMessage(Util.fix(msg).replace("{ADMIN}", p.getName()));
                }
                ChatManager.setChat(true);
                break;
            }
            case "off": {
                for (int i = 0; i < 60; ++i) {
                    Bukkit.broadcastMessage("");
                }
                for (String msg : Config.chatoff) {
                    Bukkit.broadcastMessage(Util.fix(msg).replace("{ADMIN}", p.getName()));
                }
                ChatManager.setChat(false);
                break;
            }
            case "cc": {
                for (int i = 0; i < 60; ++i) {
                    Bukkit.broadcastMessage("");
                }
                for (String msg : Config.chatcc) {
                    Bukkit.broadcastMessage(Util.fix(msg).replace("{ADMIN}", p.getName()));
                }
                break;
            }
        }
        return false;
    }
}
