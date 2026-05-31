package de.legan100.api.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_gruss implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (target.getName().equals(p.getName())) {
                        p.sendMessage(cfg1.getString("message.prefix") + "Du darfst dich nicht selber grüßen");
                    } else {
                        target.sendMessage(cfg1.getString("message.prefix") + "Du wurdest von §c" + p.getDisplayName() + " §egegrüßt.");
                        p.sendMessage(cfg1.getString("message.prefix") + "Du hast den Spieler §c" + target.getDisplayName() + " §egegrüßt.");
                    }
                } else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.offlinePlayer"));
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.greeting.usage"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.prefix"));
        }
        return false;
    }
}