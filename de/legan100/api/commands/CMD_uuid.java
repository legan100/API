package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_uuid implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if(sender instanceof Player p){
            Player target = null;
            if(args[0].equals(target.getDisplayName())){
                if(sender.hasPermission("System.Admin")){
                    p.sendMessage("Name: " + target.getDisplayName());
                    p.sendMessage(target.getDisplayName()+"'s UUID: " + target.getUniqueId());
                }else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
                }
            } else if(args == null){
                p.sendMessage("§eDein Name: " + p.getDisplayName());
                p.sendMessage("§eDeine UUID: " + p.getUniqueId());
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.onlyPlayerAllowed"));
        }

        return false;
    }
}
