package de.legan100.api.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_Chat implements CommandExecutor{

    public static boolean onChatEnable = true;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("system.vorstand")|| p.hasPermission("System.mod")) {
                if (onChatEnable) {
                    onChatEnable = false;
                    Bukkit.broadcastMessage(cfg1.getString("message.prefix") + cfg1.getString("message.chat.deaktivieren"));
                } else {
                    onChatEnable = true;
                    Bukkit.broadcastMessage(cfg1.getString("message.prefix") + cfg1.getString("message.chat.aktivieren"));
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}