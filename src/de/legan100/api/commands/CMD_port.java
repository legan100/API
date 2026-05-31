package de.legan100.api.commands;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_port implements CommandExecutor {

    File messageDE = new File("plugins//API//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player p) {
            if (p.hasPermission("system.vorstand")) {
                p.sendMessage(cfg1.getString("message.prefix") + "Server hat den Port " + p.getServer().getPort() + ".");
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + "Der Server hat den Port " + sender.getServer().getPort() + ".");
        }
        return false;
    }
}