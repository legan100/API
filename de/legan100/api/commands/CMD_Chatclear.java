package de.legan100.api.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_Chatclear implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("System.Admin")||p.hasPermission("System.SrMod")){
                for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                    if (!players.hasPermission("System.Team")) {
                        for (int i = 0; i < 150; i++) {
                            players.sendMessage(" ");
                        }
                        players.sendMessage("§c§lSystem » §7Der Chat wurde von " + p.getName() + " geleert");
                        continue;
                    }
                    players.sendMessage("");
                    players.sendMessage("");
                    players.sendMessage("§c§lSystem » §7Der Chat wurde von " + p.getName() + " geleert");
                    players.sendMessage("");
                    players.sendMessage("");
                }
            } else {
                p.sendMessage(cfg1.getString("message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}