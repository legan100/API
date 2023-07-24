/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CMD_port
/*    */   implements CommandExecutor
/*    */ {
/* 13 */   File messageDE = new File("plugins//API//message_de_DE.yml");
/* 14 */   YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
/* 17 */     if (sender instanceof Player) {
/*    */       
/* 19 */       Player p = (Player)sender;
/* 20 */       if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
/* 21 */         p.sendMessage(this.cfg1.getString("Message.prefix") + "Server hat den Port " + p.getServer().getPort() + ".");
/*    */       } else {
/* 23 */         p.sendMessage(this.cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } else {
/* 26 */       sender.sendMessage(this.cfg1.getString("Message.prefix") + "Der Server hat den Port " + sender.getServer().getPort() + ".");
/*    */     } 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_port.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */