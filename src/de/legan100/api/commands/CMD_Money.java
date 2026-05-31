package de.legan100.api.commands;

import de.legan100.api.api.MoneyAPI;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Money implements CommandExecutor {

    File messageDE = new File("plugins//API//message_de_DE.yml");
    YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player p) {
            MoneyAPI api = new MoneyAPI();
            if (args.length == 0) {
                api.getMoney(p.getUniqueId().toString());
                if(api.getMoney(p.getUniqueId().toString()) == -1){
                    p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.error.player"));
                }else
                    p.sendMessage(cfg1.getString("message.prefix") + "Du besitzt momentan " + api.getMoney(p.getUniqueId().toString()) + " Münzen.");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                assert target != null;
                if(target.getDisplayName() != null){

                }

                /*if (target != null) {
                    api.getMoney(target.getUniqueId().toString());
                    p.sendMessage(this.cfg1.getString("Message.prefix") + "Der Spieler " + target.getDisplayName() + " besitzt mmomentan " + api.getMoney(target.getUniqueId().toString()) + "Münzen.");
                } else {
                    p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.offlinePlayer"));
                }*/
            }
        }
        return false;
    }
}