/*     */ package de.legan100.api.listener;
/*     */ 
/*     */ import de.legan100.api.api.MoneyAPI;
/*     */ import de.legan100.api.commands.CMD_Chat;
/*     */ import java.io.File;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*     */ 
/*     */ public class ChatListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onChat(AsyncPlayerChatEvent e) {
/*  17 */     Player p = e.getPlayer();
/*  18 */     String name = p.getDisplayName();
/*  19 */     String message = e.getMessage();
/*  20 */     MoneyAPI api = new MoneyAPI();
/*  21 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/*  22 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*     */     
/*  24 */     if (CMD_Chat.onChatEnable == true) {
/*     */       
/*  26 */       if (message.equalsIgnoreCase("7l") || message.equalsIgnoreCase("7lobby") || message.equalsIgnoreCase("7hub") || message.equalsIgnoreCase("7perks") || message.equalsIgnoreCase("7money")) {
/*  27 */         e.setCancelled(true);
/*  28 */         e.getPlayer().sendMessage("Keine Angst. Du warst die 7. Person, welche ein 7fail gemacht hat.");
/*     */       } 
/*     */       
/*  31 */       if (p.hasPermission("System.block") && (
/*  32 */         message.equalsIgnoreCase("/ver") || message.equalsIgnoreCase("/version") || message.equalsIgnoreCase("/about") || message.equalsIgnoreCase("/icanhasbukkit"))) {
/*  33 */         e.setCancelled(true);
/*  34 */         e.getPlayer().sendMessage(cfg1.getString("Message.unknownCMD"));
/*     */       } 
/*     */ 
/*     */       
/*  38 */       if (message.contains("$") || message.contains("%") || message.contains("|")) {
/*  39 */         e.setCancelled(true);
/*  40 */         e.getPlayer().sendMessage("Folgende Zeichen darfst du nutzen:");
/*  41 */         e.getPlayer().sendMessage("A-Z und Zeichen außer |, $ und %");
/*     */       } 
/*  43 */       if (p.hasPermission("System.Admin")) {
/*  44 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  45 */           message = message.replace("&", "§");
/*  46 */           e.setFormat("§dAdmin " + name + ": §f" + message);
/*     */         } 
/*  48 */       } else if (p.hasPermission("System.Dev")) {
/*     */         
/*  50 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  51 */           message = message.replace("&", "§");
/*  52 */           e.setFormat("§bDeveloper " + name + ":§f" + message);
/*     */         }
/*     */       
/*  55 */       } else if (p.hasPermission("System.Content")) {
/*     */         
/*  57 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  58 */           message = message.replace("&", "§");
/*  59 */           e.setFormat("§bContent " + name + ":§f" + message);
/*     */         }
/*     */       
/*  62 */       } else if (p.hasPermission("System.SrMod")) {
/*  63 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  64 */           message = message.replace("&", "§");
/*  65 */           e.setFormat("§cModerator+" + name + ":§f " + message);
/*     */         } 
/*  67 */       } else if (p.hasPermission("System.Mod")) {
/*  68 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  69 */           message = message.replace("&", "§");
/*  70 */           e.setFormat("§cModerator " + name + ":§f " + message);
/*     */         } 
/*  72 */       } else if (p.hasPermission("System.Sup")) {
/*  73 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  74 */           message = message.replace("&", "§");
/*  75 */           e.setFormat("§9Helfer " + name + ":§f " + message);
/*     */         } 
/*  77 */       } else if (p.hasPermission("System.Builder")) {
/*  78 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  79 */           message = message.replace("&", "§");
/*  80 */           e.setFormat("§2Builder " + name + ":§f " + message);
/*     */         } 
/*  82 */       } else if (p.hasPermission("System.Designer")) {
/*  83 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  84 */           message = message.replace("&", "§");
/*  85 */           e.setFormat("§aDesigner " + name + ":§f " + message);
/*     */         } 
/*  87 */       } else if (p.hasPermission("System.Techniker")) {
/*  88 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  89 */           message = message.replace("&", "§");
/*  90 */           e.setFormat("§3Techniker " + name + ":§f " + message);
/*     */         } 
/*  92 */       } else if (p.hasPermission("System.Clan")) {
/*  93 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  94 */           message = message.replace("&", "§");
/*  95 */           e.setFormat("§eClanmitglied " + name + ":§f " + message);
/*     */         } 
/*  97 */       } else if (p.hasPermission("System.Media")) {
/*  98 */         if (p.getServer().getPort() == 1 || p.getServer().getPort() == 300) {
/*  99 */           message = message.replace("&", "§");
/* 100 */           e.setFormat("§5Media " + name + ":§f " + message);
/*     */         } 
/* 102 */       } else if (p.hasPermission("System.Premium")) {
/* 103 */         e.setFormat("§6Premium " + name + ":§f " + message);
/*     */       } else {
/* 105 */         e.setFormat("§8Spieler " + name + ":§f " + message);
/*     */       } 
/*     */     } else {
/*     */       
/* 109 */       e.setCancelled(true);
/* 110 */       p.sendMessage(cfg1.getString("Message.prefix") + "Der Chat wurde deaktiviert.");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\listener\ChatListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */