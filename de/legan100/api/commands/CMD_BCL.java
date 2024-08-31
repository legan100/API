package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_BCL implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("System.Admin")) {
                if (args.length >= 1) {
                    String bcMessage = "";
                    for (String arg : args) {
                        bcMessage = bcMessage + " " + arg;
                    }
                    if (bcMessage.contains("&")) {
                        bcMessage.replace("§", "&");
                    }
                    p.getServer().broadcastMessage("§9-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    p.getServer().broadcastMessage("");
                    p.getServer().broadcastMessage(bcMessage);
                    p.getServer().broadcastMessage("");
                    p.getServer().broadcastMessage("§9-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                } else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.bcl.usage"));
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
