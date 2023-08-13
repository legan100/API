package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_uuid implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player p){
            p.sendMessage("§eDein Name: " + p.getDisplayName());
            p.sendMessage("§eDeine UUID: " + p.getUniqueId());
        } else {
            File messageDE = new File("plugins//API//message_de_DE.yml");
            YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
            sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
        }

        return false;
    }
}
