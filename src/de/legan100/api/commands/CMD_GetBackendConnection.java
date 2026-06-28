package de.legan100.api.commands;

import de.legan100.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMD_GetBackendConnection implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(sender instanceof Player p) {
            if(p.hasPermission("system.vorstand")){
                if(API.getBackend().isConnected()){
                    p.sendMessage("API is connected");
                }else {
                    p.sendMessage("API is disconnected");
                }
            }
        }

        return false;
    }
}
