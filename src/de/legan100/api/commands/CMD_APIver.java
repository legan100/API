package de.legan100.api.commands;

import de.legan100.api.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class CMD_APIver implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (sender instanceof Player p) {
            if (p.hasPermission("system.vorstand"))
                sender.sendMessage(cfg1.getString("message.prefix") + "Das Plugin ist in der Version " + API.getInstance().getPluginMeta().getVersion());
            else
                p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.noPerms"));
        } else {
            sender.sendMessage(cfg1.getString("message.prefix") + "Das Plugin ist in der Version " + API.getInstance().getPluginMeta().getVersion());
        }
        return true;
    }
}