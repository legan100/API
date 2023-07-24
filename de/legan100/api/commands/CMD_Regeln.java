/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_Regeln
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 14 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 15 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 17 */     if (sender instanceof Player) {
/* 18 */       Player p = (Player)sender;
/* 19 */       p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Regeln"));
/*    */     } else {
/* 21 */       sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Regeln.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */