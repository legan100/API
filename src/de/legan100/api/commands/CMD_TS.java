package de.legan100.api.commands;

import java.io.File;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_TS implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.ts.ts"));
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}