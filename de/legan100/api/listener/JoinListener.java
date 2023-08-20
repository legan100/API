package de.legan100.api.listener;

import de.legan100.api.api.MoneyAPI;
import de.legan100.api.commands.CMD_Wartung;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        MoneyAPI api = new MoneyAPI();
        if (!p.hasPlayedBefore() && p != null && Bukkit.getPort() == 1024) {
            api.addMoney(p.getUniqueId(), 1001);
        }
        if (CMD_Wartung.isWartung == true) {
            if (p.hasPermission("System.Team")) {
                p.sendMessage("Der Wartungsmodus ist aktiviert.");
            } else if(p.hasPermission("System.Join")){}
              else {
                  p.kickPlayer("\n\n§cZurzeit befinden wir uns im Wartungsmodus.\n\n§aAllerdings freuen wir uns, wenn wir dich auf unserem TeamSpeak LegendenArmy.de begrüßen dürfen.");
            }
        } else if (p.hasPermission("System.Team")) {
            p.sendMessage("Der Wartungsmodus ist deaktiviert");
        }
    }
}