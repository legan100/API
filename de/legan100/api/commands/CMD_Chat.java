package de.legan100.api.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_Chat implements CommandExecutor{

    File messageDE = new File("plugins//API//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
    public static boolean onChatEnable = true;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("System.Admin")|| p.hasPermission("System.Dev")|| p.hasPermission("System.SrMod")) {
                if (onChatEnable) {
                    onChatEnable = false;
                    Bukkit.broadcastMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.Chat.deaktivieren"));
                } else {
                    onChatEnable = true;
                    Bukkit.broadcastMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.Chat.aktivieren"));
                }
            } else {
                p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}