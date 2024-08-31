package de.legan100.api.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_GM implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if(sender instanceof Player p) {
            if(p.hasPermission("gm.use")) {
                if(args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(cfg1.getString("message.prefix") + "§eDu bist nun im §cSuvival-Gamemode§e.");
                } else if(args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(cfg1.getString("message.prefix") + "§eDu bist nun im §cCreativ-Gamemode§e.");
                } else if(args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(cfg1.getString("message.prefix") + "§eDu bist nun im §cAdventure-Gamemode§e.");
                } else if(args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(cfg1.getString("message.prefix") + "§eDu bist nun im §cSpectator-Gamemode§e.");
                }
            }
        }
        return false;
    }
}
