package de.legan100.api.commands;

import de.legan100.api.api.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_addMoney implements CommandExecutor {

    File messageDE = new File("plugins//API//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            MoneyAPI api = new MoneyAPI();
            if (p.hasPermission("system.vorstand")) {
                if (args.length == 1 || args.length == 0)
                    p.sendMessage(cfg1.getString("message.prefix") + this.cfg1.getString("message.addmoney.usage"));
                else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        int amount = Integer.parseInt(args[1]);
                        p.sendMessage(cfg1.getString("message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen gegeben.");
                        api.addMoney(target.getUniqueId(), amount);
                        target.sendMessage(cfg1.getString("message.prefix") + "Der Spieler " + p.getDisplayName() + " hat dir " + amount + " Münzen gegeben.");
                    } else {
                        p.sendMessage(this.cfg1.getString("message.prefix") + this.cfg1.getString("message.offlinePlayer"));
                    }
                }
            } else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
            }
        }
        return false;
    }
}
