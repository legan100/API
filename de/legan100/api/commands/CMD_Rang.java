/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_Rang
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 14 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 15 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/* 16 */     if (sender instanceof Player) {
/* 17 */       Player p = (Player)sender;
/* 18 */       if (args.length >= 0) {
/* 19 */         if (p.hasPermission("System.Admin")) {
/* 20 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Admin"));
/* 21 */         } else if (p.hasPermission("System.Dev")) {
/* 22 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Dev"));
/* 23 */         } else if (p.hasPermission("System.Content")) {
/* 24 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Content"));
/* 25 */         } else if (p.hasPermission("System.SrMod")) {
/* 26 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.SrMod"));
/* 27 */         } else if (p.hasPermission("System.Mod")) {
/* 28 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Mod"));
/* 29 */         } else if (p.hasPermission("System.Sup")) {
/* 30 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Sup"));
/* 31 */         } else if (p.hasPermission("System.Builder")) {
/* 32 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Builder"));
/* 33 */         } else if (p.hasPermission("System.Techniker")) {
/* 34 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Techniker"));
/* 35 */         } else if (p.hasPermission("System.Designer")) {
/* 36 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Designer"));
/* 37 */         } else if (p.hasPermission("System.Media")) {
/* 38 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Media"));
/* 39 */         } else if (p.hasPermission("System.Clan")) {
/* 40 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Clan"));
/* 41 */         } else if (p.hasPermission("System.Premium")) {
/* 42 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Premium"));
/*    */         } else {
/* 44 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Rang.Spieler"));
/*    */         } 
/*    */       } else {
/* 47 */         p.sendMessage(cfg1.getString("Message.unkownCMD"));
/*    */       } 
/*    */     } else {
/* 50 */       sender.sendMessage("hast den Rang: Konsole");
/*    */     } 
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Rang.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */