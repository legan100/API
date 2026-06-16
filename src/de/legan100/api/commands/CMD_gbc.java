package de.legan100.api.commands;

import de.legan100.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_gbc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command,  String s,  String [] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if(sender instanceof Player p ) {
            if(p.hasPermission("system.vorstand")){
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
                    API.getBackend().send("bc_globalbroadcast_" + bcMessage);
                } else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.bcl.usage"));
                }
            }
        }

        return false;
    }
}
