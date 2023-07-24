/*    */ package de.legan100.api;
/*    */ import de.legan100.api.api.MoneyAPI;
/*    */ import de.legan100.api.commands.CMD_APIver;
/*    */ import de.legan100.api.commands.CMD_Regeln;
/*    */ import de.legan100.api.commands.CMD_TS;
/*    */ import de.legan100.api.commands.CMD_color;
/*    */ import de.legan100.api.commands.CMD_msg;
/*    */ import de.legan100.api.utils.MySQL;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class API extends JavaPlugin {
/*    */   public void onEnable() {
/* 15 */     MoneyAPI api = new MoneyAPI();
/* 16 */     api.setApi(this);
/* 17 */     api.setAuthor("legan100");
/* 18 */     api.setVersion("1.0.1");
/* 19 */     api.setOnlinestatus(true);
/* 20 */     (new Broadcaster(this)).startBroadcast();
/* 21 */     FileManager.createFile();
/* 22 */     register();
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 26 */     MySQL.disconnect();
/* 27 */     MoneyAPI api = new MoneyAPI();
/* 28 */     api.setOnlinestatus(false);
/*    */   }
/*    */   
/*    */   public void register() {
/* 32 */     MySQL.connect();
/* 33 */     MySQL.createTable();
/*    */     
/* 35 */     getCommand("rang").setExecutor((CommandExecutor)new CMD_Rang());
/* 36 */     getCommand("wartung").setExecutor((CommandExecutor)new CMD_Wartung());
/* 37 */     getCommand("chat").setExecutor((CommandExecutor)new CMD_Chat());
/* 38 */     getCommand("discord").setExecutor((CommandExecutor)new CMD_Discord());
/* 39 */     getCommand("TS").setExecutor((CommandExecutor)new CMD_TS());
/* 40 */     getCommand("Teamspeak").setExecutor((CommandExecutor)new CMD_TS());
/* 41 */     getCommand("regeln").setExecutor((CommandExecutor)new CMD_Regeln());
/* 42 */     getCommand("regel").setExecutor((CommandExecutor)new CMD_Regeln());
/* 43 */     getCommand("regelwerk").setExecutor((CommandExecutor)new CMD_Regeln());
/* 44 */     getCommand("apiver").setExecutor((CommandExecutor)new CMD_APIver());
/* 45 */     getCommand("apiversion").setExecutor((CommandExecutor)new CMD_APIver());
/* 46 */     getCommand("gruss").setExecutor((CommandExecutor)new CMD_gruss());
/* 47 */     getCommand("msg").setExecutor((CommandExecutor)new CMD_msg());
/* 48 */     getCommand("tell").setExecutor((CommandExecutor)new CMD_msg());
/* 49 */     getCommand("whisper").setExecutor((CommandExecutor)new CMD_msg());
/* 50 */     getCommand("DM").setExecutor((CommandExecutor)new CMD_msg());
/* 51 */     getCommand("port").setExecutor((CommandExecutor)new CMD_port());
/* 52 */     getCommand("addMoney").setExecutor((CommandExecutor)new CMD_addMoney());
/* 53 */     getCommand("money").setExecutor((CommandExecutor)new CMD_Money());
/* 54 */     getCommand("pay").setExecutor((CommandExecutor)new CMD_Pay());
/* 55 */     getCommand("removeMoney").setExecutor((CommandExecutor)new CMD_RemoveMoney());
/* 56 */     getCommand("color").setExecutor((CommandExecutor)new CMD_color());
/* 57 */     getCommand("farbe").setExecutor((CommandExecutor)new CMD_color());
/* 58 */     getCommand("farben").setExecutor((CommandExecutor)new CMD_color());
/* 59 */     getCommand("cc").setExecutor((CommandExecutor)new CMD_Chatclear());
/* 60 */     getCommand("chatclear").setExecutor((CommandExecutor)new CMD_Chatclear());
/* 61 */     getCommand("payall").setExecutor((CommandExecutor)new CMD_PayAll());
/* 62 */     getServer().getPluginManager().registerEvents((Listener)new ChatListener(), (Plugin)this);
/* 63 */     getServer().getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\API.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */