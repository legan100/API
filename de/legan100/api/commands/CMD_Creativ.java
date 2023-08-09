package de.legan100.api.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_Creativ  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if(sender instanceof Player p){
            if(p.hasPermission("System.Admin")){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.changeGameMode.Kreativ"));
            }
        }
        return false;
    }
}
