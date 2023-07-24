/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class CMD_Chatclear
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 16 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 17 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 19 */     if (sender instanceof Player) {
/* 20 */       Player p = (Player)sender;
/* 21 */       if (p.hasPermission("System.CMD.ChatClear"))
/*    */       {
/* 23 */         for (Player players : Bukkit.getServer().getOnlinePlayers()) {
/* 24 */           if (!players.hasPermission("System.Team")) {
/* 25 */             for (int i = 0; i < 150; i++) {
/* 26 */               players.sendMessage(" ");
/*    */             }
/* 28 */             players.sendMessage("§c§lSystem » §7Der Chat wurde von " + sender.getName() + " geleert"); continue;
/*    */           } 
/* 30 */           players.sendMessage("");
/* 31 */           players.sendMessage("");
/* 32 */           players.sendMessage("§c§lSystem » §7Der Chat wurde von " + sender.getName() + " geleert");
/* 33 */           players.sendMessage("");
/* 34 */           players.sendMessage("");
/*    */         }
/*    */       
/*    */       }
/*    */       else
/*    */       {
/* 40 */         p.sendMessage(cfg1.getString("Message.noPerms"));
/*    */       }
/*    */     
/*    */     }
/*    */     else {
/*    */       
/* 46 */       sender.sendMessage(cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/*    */ 
/*    */     
/* 50 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Chatclear.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */