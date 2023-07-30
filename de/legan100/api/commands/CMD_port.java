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
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                p.sendMessage(this.cfg1.getString("Message.prefix") + "Server hat den Port " + p.getServer().getPort() + ".");
            } else {
                p.sendMessage(this.cfg1.getString("Message.noPerms"));
            }
        } else {
            sender.sendMessage(this.cfg1.getString("Message.prefix") + "Der Server hat den Port " + sender.getServer().getPort() + ".");
        }
        return false;
    }
}