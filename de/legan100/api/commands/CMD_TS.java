/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_TS
/*    */   implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 13 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 14 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/* 15 */     if (sender instanceof Player) {
/* 16 */       Player p = (Player)sender;
/* 17 */       p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.TS"));
/*    */     } else {
/* 19 */       sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_TS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */