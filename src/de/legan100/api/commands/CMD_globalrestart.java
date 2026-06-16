package de.legan100.api.commands;

import de.legan100.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMD_globalrestart implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(sender instanceof Player p) {
            if(p.hasPermission("system.vorstand")){
                API.getBackend().send("bc_globalrestart");
            }
        }

        return false;
    }
}
