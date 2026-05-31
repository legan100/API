package de.legan100.api.listener;

import de.legan100.api.api.MoneyAPI;
import de.legan100.api.commands.CMD_Wartung;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        Player p = e.getPlayer();
        MoneyAPI api = new MoneyAPI();
        if (!p.hasPlayedBefore() && Bukkit.getPort() == 1024) {
            api.addMoney(p.getUniqueId(), 1001);
        }
        if (CMD_Wartung.isWartung) {
            if (p.hasPermission("system.team")) {
                p.sendMessage("Der Wartungsmodus ist aktiviert.");
            } else if(!p.isWhitelisted()) {
                  p.kickPlayer("\n\n§cZurzeit befinden wir uns im Wartungsmodus.\n\n§aAllerdings freuen wir uns, wenn wir dich auf unserem TeamSpeak LegendenArmy.de begrüßen dürfen.");
            }
        } else if (p.hasPermission("System.Team")) {
            p.sendMessage(cfg1.getString("message.prefix") + "Der Wartungsmodus ist deaktiviert");
        }
    }
}