package de.legan100.api.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CMD_msg implements CommandExecutor {

    String message = "";
    File messageDE = new File("plugins//API//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (p.getDisplayName().equals(target.getName())) {
                        p.sendMessage(cfg1.getString("Message.tell.myself"));
                    } else {
                        for (int i = 1; i < args.length; i++)
                            this.message += args[i] + " ";
                        p.sendMessage("§8[§aDM§8] [§7Ich -> " + target.getDisplayName() + "§8] §e" + this.message);
                        target.sendMessage("§8[§aDM§8] [§7" + p.getDisplayName() + " -> Mir§8] §e" + this.message);
                        this.message = "";
                    }
                } else {
                    p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.offlinePlayer"));
                }
            } else {
                p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.tell.usage"));
            }
        } else {
            sender.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.tell.onlyPlayerAllowed"));
        }
        return false;
    }
}
