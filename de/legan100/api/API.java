package de.legan100.api;

import de.legan100.api.commands.*;
import de.legan100.api.listener.ChatListener;
import de.legan100.api.listener.JoinListener;
import de.legan100.api.utils.Broadcaster;
import de.legan100.api.utils.FileManager;
import de.legan100.api.utils.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class API extends JavaPlugin {

    public void onEnable() {
        (new Broadcaster(this)).startBroadcast();
        register();
        FileManager.createFile();
    }

    public void onDisable() {
        //MySQL.disconnect();
    }

    public void register() {
        MySQL.connect();
        MySQL.createTable();
        getCommand("rang").setExecutor(new CMD_Rang());
        getCommand("wartung").setExecutor(new CMD_Wartung());
        getCommand("chat").setExecutor(new CMD_Chat());
        getCommand("discord").setExecutor(new CMD_Discord());
        getCommand("TS").setExecutor(new CMD_TS());
        getCommand("Teamspeak").setExecutor(new CMD_TS());
        getCommand("regeln").setExecutor(new CMD_Regeln());
        getCommand("regel").setExecutor(new CMD_Regeln());
        getCommand("regelwerk").setExecutor(new CMD_Regeln());
        getCommand("apiver").setExecutor(new CMD_APIver());
        getCommand("apiversion").setExecutor(new CMD_APIver());
        getCommand("gruss").setExecutor(new CMD_gruss());
        getCommand("msg").setExecutor(new CMD_msg());
        getCommand("tell").setExecutor(new CMD_msg());
        getCommand("whisper").setExecutor(new CMD_msg());
        getCommand("DM").setExecutor(new CMD_msg());
        getCommand("port").setExecutor(new CMD_port());
        getCommand("color").setExecutor(new CMD_color());
        getCommand("farbe").setExecutor(new CMD_color());
        getCommand("farben").setExecutor(new CMD_color());
        getCommand("cc").setExecutor(new CMD_Chatclear());
        getCommand("chatclear").setExecutor(new CMD_Chatclear());
        getCommand("money").setExecutor(new CMD_Money());
        getCommand("addmoney").setExecutor(new CMD_addMoney());
        getCommand("payall").setExecutor(new CMD_PayAll());
        getCommand("pay").setExecutor(new CMD_Pay());
        getCommand("removemoney").setExecutor(new CMD_RemoveMoney());
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    public API getInstance(){
        return this;
    }

}
