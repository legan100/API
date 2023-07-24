/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_APIver implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 10 */     if (sender instanceof Player) {
/* 11 */       Player p = (Player)sender;
/* 12 */       if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev") || p.hasPermission("System.Content"))
/* 13 */         sender.sendMessage("Das Plugin ist in der Version 1.1"); 
/*    */     } else {
/* 15 */       sender.sendMessage("Das Plugin ist in der Version 1.1");
/*    */     } 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_APIver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */