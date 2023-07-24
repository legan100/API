/*    */ package de.legan100.api.utils;
/*    */ 
/*    */ import de.legan100.api.API;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.md_5.bungee.api.ChatColor;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class Broadcaster
/*    */ {
/*    */   private API plugin;
/*    */   private FileConfiguration config;
/*    */   
/*    */   public Broadcaster(API plugin) {
/* 19 */     this.plugin = plugin;
/* 20 */     this.config = plugin.getConfig();
/* 21 */     createDefaults();
/*    */   }
/*    */   
/*    */   public void startBroadcast() {
/* 25 */     Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin)this.plugin, new Runnable() {
/*    */           public void run() {
/* 27 */             Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Broadcaster.this.pickMessage()));
/*    */           }
/*    */         }0L, 6000L);
/*    */   }
/*    */   
/*    */   private void createDefaults() {
/* 33 */     if (this.config.contains("BroadcastMessages"))
/*    */       return; 
/* 35 */     List<String> defaults = new ArrayList<>();
/* 36 */     for (int i = 0; i < 3; i++)
/* 37 */       defaults.add("&6Nachricht Nr. &3" + i); 
/* 38 */     this.config.set("BroadcastMessages", defaults);
/* 39 */     this.plugin.saveConfig();
/*    */   }
/*    */   
/*    */   private String pickMessage() {
/* 43 */     List<String> messages = this.config.getStringList("BroadcastMessages");
/* 44 */     int random = (new Random()).nextInt(messages.size());
/* 45 */     return messages.get(random);
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\ap\\utils\Broadcaster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */