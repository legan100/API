/*     */ package de.legan100.api.utils;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileManager
/*     */ {
/*     */   public static void createFile() {
/*  12 */     File file = new File("plugins//API//mysql.yml");
/*  13 */     YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*     */     
/*  15 */     if (!file.exists()) {
/*     */       
/*     */       try {
/*     */         
/*  19 */         cfg.addDefault("MySQL.host", "localhost");
/*  20 */         cfg.addDefault("MySQL.port", "3306");
/*  21 */         cfg.addDefault("MySQL.database", "database");
/*  22 */         cfg.addDefault("MySQL.user", "username");
/*  23 */         cfg.addDefault("MySQL.password", "password");
/*  24 */         cfg.options().copyDefaults(true);
/*  25 */         cfg.save(file);
/*     */       }
/*  27 */       catch (IOException e) {
/*  28 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  32 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/*  33 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*     */     
/*  35 */     if (!messageDE.exists()) {
/*     */       
/*     */       try {
/*     */         
/*  39 */         cfg1.addDefault("Message.prefix", "§aSystem §8>> §e");
/*  40 */         cfg1.addDefault("Message.Error", "§cFehler! Bitte melde dich beim Serverteam.");
/*  41 */         cfg1.addDefault("Message.noPerms", "§cDafür benötigst du einen höheren Rang");
/*  42 */         cfg1.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
/*  43 */         cfg1.addDefault("Message.unknownCMD", "§cUnbekannter Command!");
/*  44 */         cfg1.addDefault("Message.TS", "Unser TS: legendenarmy.de");
/*  45 */         cfg1.addDefault("Message.Discord", "Unser Discord:");
/*  46 */         cfg1.addDefault("Message.Regeln", "Unser Regelwerk");
/*  47 */         cfg1.addDefault("Message.offlinePlayer", "Spieler ist offline");
/*  48 */         cfg1.addDefault("Message.Wartung.disable", "Wartungsmodus deaktivieren");
/*  49 */         cfg1.addDefault("Message.Wartung.enable", "Wartungsmodus aktivieren");
/*  50 */         cfg1.addDefault("Message.Money.Minus", "Du kannst keinem Spieler geld abheben.");
/*  51 */         cfg1.addDefault("Message.Money.notEnough", "Nicht genug geld auf der Hand");
/*  52 */         cfg1.addDefault("Message.Money.usage", "/pay <name> <betrag>");
/*  53 */         cfg1.addDefault("Message.Money.MimiumOne", "Zahle min 1 Münze");
/*  54 */         cfg1.addDefault("Message.addmoney.usage", "/addmoney <name> <betrag>");
/*  55 */         cfg1.addDefault("Message.Rang.Admin", "Du bist Admin");
/*  56 */         cfg1.addDefault("Message.Rang.Content", "Du bist Admin");
/*  57 */         cfg1.addDefault("Message.Rang.Dev", "Du bist Admin");
/*  58 */         cfg1.addDefault("Message.Rang.SrMod", "Du bist Admin");
/*  59 */         cfg1.addDefault("Message.Rang.Mod", "Du bist Admin");
/*  60 */         cfg1.addDefault("Message.Rang.Helfer", "Du bist Admin");
/*  61 */         cfg1.addDefault("Message.Rang.JrHelfer", "Du bist Admin");
/*  62 */         cfg1.addDefault("Message.Rang.Builder", "Du bist Admin");
/*  63 */         cfg1.addDefault("Message.Rang.Designer", "Du bist Admin");
/*  64 */         cfg1.addDefault("Message.Rang.Techniker", "Du bist Admin");
/*  65 */         cfg1.addDefault("Message.Rang.Clan", "Du bist Admin");
/*  66 */         cfg1.addDefault("Message.Rang.Media", "Du bist Admin");
/*  67 */         cfg1.addDefault("Message.Rang.PremiumPlus", "Du bist Admin");
/*  68 */         cfg1.addDefault("Message.Rang.Premium", "Du bist Admin");
/*  69 */         cfg1.addDefault("Message.Rang.Spieler", "Du bist Admin");
/*  70 */         cfg1.addDefault("Message.tell.myself", "du kannst dir nichts selber flüstern");
/*  71 */         cfg1.addDefault("Message.tell.usage", "/msg <name> <nachricht>");
/*  72 */         cfg1.addDefault("Message.Chat.deaktivieren", "Chat wurde deaktiviert");
/*  73 */         cfg1.addDefault("Message.Chat.aktivieren", "Chat wurde aktiviert");
/*  74 */         cfg1.options().copyDefaults(true);
/*  75 */         cfg1.save(messageDE);
/*     */       }
/*  77 */       catch (IOException e1) {
/*     */         
/*  79 */         e1.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     File messageENG = new File("plugins//API//message_eng_GB.yml");
/*  87 */     YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(messageENG);
/*     */     
/*  89 */     if (!messageENG.exists())
/*     */       
/*     */       try {
/*     */         
/*  93 */         cfg2.addDefault("Message.prefix", "§aSystem §8>> §e");
/*  94 */         cfg2.addDefault("Message.Error", "§cFehler! Bitte melde dich beim Serverteam.");
/*  95 */         cfg2.addDefault("Message.noPerms", "§cDafür benötigst du einen höheren Rang");
/*  96 */         cfg2.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
/*  97 */         cfg2.addDefault("Message.unknownCMD", "§cUnbekannter Command!");
/*  98 */         cfg2.options().copyDefaults(true);
/*  99 */         cfg2.save(messageENG);
/*     */       }
/* 101 */       catch (IOException e1) {
/*     */         
/* 103 */         e1.printStackTrace();
/*     */       }  
/*     */   }
/*     */ }


/* Location:              D:\APIs\API.jar!\de\legan100\ap\\utils\FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */