package de.legan100.api.commands;

import de.legan100.api.api.MoneyAPI;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_PayAll implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            MoneyAPI api = new MoneyAPI();
            if (p.hasPermission("system.vorstand")) {
                if (p.getServer().getPort() == 300) {
                    if (args[0] != null) {
                        int amount = Integer.parseInt(args[0]);
                        int onlinePlayers = Bukkit.getOnlinePlayers().size();
                        if (amount > 99) {
                            int summe = amount * (onlinePlayers - 1);
                            if (summe <= api.getMoney(String.valueOf(p.getUniqueId()))) {
                                for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
                                    if (!onlineplayer.getDisplayName().equals(p.getDisplayName())) {
                                        api.addMoney(onlineplayer.getUniqueId(), amount);
                                        onlineplayer.sendMessage(cfg1.getString("message.prefix") + "Du hast vom Spieler " + p.getDisplayName() + " " + amount + " Münzen erhalten");
                                        continue;
                                    }
                                    p.sendMessage(cfg1.getString("message.prefix") +"Du hast insgesamt " + summe + " Münzen ausgegeben.");
                                    api.removeMoney(p.getUniqueId(), summe);
                                }
                            } else {
                                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.pay.notEnoughMoney"));
                            }
                        }
                    } else {
                        p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.payall.onlyNumbers"));
                    }
                } else {
                    p.sendMessage(cfg1.getString("message.prefis") + cfg1.getString("message.payall.onlyOnRPBuild"));
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefis") + cfg1.getString("message.noPerms"));
            }
        } else {
            sender.sendMessage(cfg1.getString("message.prefis") + cfg1.getString("message.onlyPlayerAllowed"));
        }
        return false;
    }
}