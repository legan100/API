package de.legan100.api.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_color implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player p) {
            p.sendMessage("\n§1&1 §2&2 §3&3 §4&4 §5&5 §6&6 §7&7 §8&8 §9&9 §0&0 §a&a §b&b §c&c §d&d §e&e §f&f\n");
            p.sendMessage("   ");
        }
        return false;
    }
}