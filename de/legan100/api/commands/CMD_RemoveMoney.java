package de.legan100.api.commands;

import de.legan100.api.api.MoneyAPI;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_RemoveMoney implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            MoneyAPI api = new MoneyAPI();
            if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
                if (args.length == 1) {
                    int amount = Integer.valueOf(args[1]).intValue();
                    if (amount >= api.getMoney(p.getUniqueId().toString()))
                        api.removeMoney(p.getUniqueId(), amount);
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        int amount = Integer.valueOf(args[1]);
                        if (amount <= api.getMoney(p.getUniqueId().toString())) {
                            p.sendMessage(cfg1.getString("message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen genommen.");
                            api.removeMoney(target.getUniqueId(), amount);
                        } else {
                            p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.removemoney.minus"));
                        }
                    } else {
                        p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
                    }
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}
