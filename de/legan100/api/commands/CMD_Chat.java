/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import de.legan100.api.api.MoneyAPI;
/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_Chat
/*    */   implements CommandExecutor
/*    */ {
/* 15 */   File messageDE = new File("plugins//API//message_de_DE.yml");
/* 16 */   YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
/*    */   
/*    */   public static boolean onChatEnable = true;
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 21 */     if (sender instanceof Player) {
/* 22 */       MoneyAPI api = new MoneyAPI();
/* 23 */       Player p = (Player)sender;
/* 24 */       if (p.hasPermission("System.Admin")) {
/* 25 */         if (onChatEnable == true) {
/* 26 */           onChatEnable = false;
/* 27 */           Bukkit.broadcastMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.Chat.deaktivieren"));
/*    */         } else {
/*    */           
/* 30 */           onChatEnable = true;
/* 31 */           Bukkit.broadcastMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.Chat.aktivieren"));
/*    */         } 
/*    */       } else {
/*    */         
/* 35 */         p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } else {
/* 38 */       sender.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Chat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */