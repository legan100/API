package de.legan100.api.listener;

import de.legan100.api.commands.CMD_Chat;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (!CMD_Chat.onChatEnable)  {
            e.setCancelled(true);
            p.sendMessage(cfg1.getString("message.prefix") + cfg1.getString("message.chat.deaktiviert"));
        }
    }
}