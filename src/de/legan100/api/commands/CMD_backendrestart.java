package de.legan100.api.commands;

import de.legan100.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class CMD_backendrestart implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        File messageDE = new File("plugins//Backend//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if(sender instanceof Player p) {
            if(p.hasPermission("backend.admin") ) {
                if(args.length == 0) {
                    API.getBackend().send("bc_backendrestart");
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.backendrestart.send"));

                }else {
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.backendrestart.usage"));
                }
            }else {
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
            }
        }else {
            sender.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.onlyPlayerAllowed"));
        }

        return false;
    }
}
