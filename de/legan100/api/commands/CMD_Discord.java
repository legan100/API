/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMD_Discord
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 16 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 17 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 19 */     if (sender instanceof Player) {
/* 20 */       Player p = (Player)sender;
/* 21 */       p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Discord"));
/*    */     } else {
/* 23 */       sender.sendMessage(cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Discord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */