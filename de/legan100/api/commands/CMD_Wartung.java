package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_Wartung implements CommandExecutor {

    public static boolean isWartung = true;

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("System.Admin")|| p.hasPermission("System.Dev")) {
                if (args.length >= 1) {
                    p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.unknownCMD"));
                } else if (isWartung) {
                    p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Wartung.disable"));
                    isWartung = false;
                } else {
                    p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Wartung.enable"));
                    isWartung = true;
                }
            } else {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
        }
        return false;
    }
}