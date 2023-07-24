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
/*    */ public class CMD_msg
/*    */   implements CommandExecutor {
/* 13 */   String message = "";
/* 14 */   File messageDE = new File("plugins//API//message_de_DE.yml");
/* 15 */   YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 18 */     if (sender instanceof Player) {
/* 19 */       Player p = (Player)sender;
/* 20 */       if (args.length >= 2) {
/* 21 */         Player target = Bukkit.getPlayer(args[0]);
/* 22 */         if (target != null) {
/* 23 */           if (p.getDisplayName() == target.getName()) {
/* 24 */             p.sendMessage(this.cfg1.getString("Message.tell.myself"));
/*    */           } else {
/* 26 */             for (int i = 1; i < args.length; i++)
/* 27 */               this.message += args[i] + " "; 
/* 28 */             p.sendMessage("§8[§aDM§8] [§7Ich -> " + target.getDisplayName() + "§8] §e" + this.message);
/* 29 */             target.sendMessage("§8[§aDM§8] [§7" + p.getDisplayName() + " -> Mir§8] §e" + this.message);
/* 30 */             this.message = "";
/*    */           } 
/*    */         } else {
/* 33 */           p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.offlinePlayer"));
/*    */         } 
/*    */       } else {
/* 36 */         p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.tell.usage"));
/*    */       } 
/*    */     } else {
/* 39 */       sender.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.tell.onlyPlayerAllowed"));
/*    */     } 
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_msg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */