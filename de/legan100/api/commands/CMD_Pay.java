package de.legan100.api.commands;

import de.legan100.api.api.MoneyAPI;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Pay implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (args.length == 2) {
                MoneyAPI api = new MoneyAPI();
                int check = api.getMoney(p.getUniqueId().toString());
                int amount = Integer.valueOf(args[1]);
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.pay.usage"));
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (check >= -1) {
                        if (amount >= 1) {
                            if (amount <= api.getMoney(p.getUniqueId().toString())) {
                                api.removeMoney(p.getUniqueId(), amount);
                                p.sendMessage(cfg1.getString("message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen gepayed.");
                                api.addMoney(target.getUniqueId(), amount);
                                target.sendMessage(cfg1.getString("message.prefix") + "Du hast von " + p.getDisplayName() + " " + amount + " Münzen bekommen.");
                            } else {
                                p.sendMessage(cfg1.getString("message.prefix") +cfg1.getString("message.pay.notEnoughMoney"));
                            }
                        } else {
                            p.sendMessage(cfg1.getString("message.prefix") +cfg1.getString("message.pay.minOne"));
                        }
                    } else {
                        Bukkit.broadcastMessage(cfg1.getString("message.prefix") + "Der Spieler " + p.getDisplayName() + " hat versucht mit Geld zu bezahlen. Bitte melde dies einem Teamler");
                    }
                } else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.offlinePlayer"));
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.pay.usage"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") +cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}