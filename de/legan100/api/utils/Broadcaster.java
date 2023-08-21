package de.legan100.api.utils;

import de.legan100.api.API;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Broadcaster {
    private API plugin;
    private FileConfiguration config;

    public Broadcaster(API plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        createDefaults();
    }

    public void startBroadcast() {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this.plugin, () -> {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Broadcaster.this.pickMessage()));
        },0L, 6000L);
    }

    private void createDefaults() {
        if (this.config.contains("BroadcastMessages"))
            return;

        List<String> defaults = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            defaults.add("&6Nachricht Nr. &3" + i);
        this.config.set("BroadcastMessages", defaults);
        this.plugin.saveConfig();
    }

    private String pickMessage() {
        List<String> messages = config.getStringList("BroadcastMessages");
        int random = (new Random()).nextInt(messages.size());
        return messages.get(random);
    }
}