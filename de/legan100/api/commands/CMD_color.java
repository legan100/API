/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMD_color
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
/* 14 */     if (sender instanceof Player) {
/*    */       
/* 16 */       Player p = (Player)sender;
/* 17 */       p.sendMessage("\n§1&1 §2&2 §3&3 §4&4 §5&5 §6&6 §7&7 §8&8 §9&9 §0&0 §a&a §b&b §c&c §d&d §e&e §f&f\n");
/* 18 */       p.sendMessage("   ");
/*    */     } 
/*    */     
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_color.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */