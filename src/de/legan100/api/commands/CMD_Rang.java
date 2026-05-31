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
            if (p.hasPermission("system.vorstand")) {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.rang.vorstand"));
            } else if (p.hasPermission("System.Mod")) {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.rang.mod"));
            } else if (p.hasPermission("System.Media")) {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.rang.media"));
            } else if (p.hasPermission("System.Mitarbeiter")) {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.rang.mitarbeiter"));
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.rang.spieler"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + "Du hast den Rang: §9Konsole");
        }
        return false;
    }
}
