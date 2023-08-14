package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_Rang implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("System.Admin")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Admin"));
            } else if (p.hasPermission("System.Dev")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Dev"));
            } else if (p.hasPermission("System.Content")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Content"));
            } else if (p.hasPermission("System.SrMod")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.SrMod"));
            } else if (p.hasPermission("System.Mod")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Mod"));
            } else if (p.hasPermission("System.Sup")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Sup"));
            } else if (p.hasPermission("System.Builder")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Builder"));
            } else if (p.hasPermission("System.Techniker")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Techniker"));
            } else if (p.hasPermission("System.Designer")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Designer"));
            } else if (p.hasPermission("System.Media")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Media"));
            } else if (p.hasPermission("System.Mitarbeiter")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Clan"));
            } else if (p.hasPermission("System.Premium")) {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Premium"));
            } else {
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Spieler"));
            }
        } else {
            sender.sendMessage(cfg1.getString("Message.prefix") + "Du hast den Rang: §9Konsole");
        }
        return false;
    }
}
