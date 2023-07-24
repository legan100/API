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
/*    */ public class CMD_Money
/*    */   implements CommandExecutor {
/* 14 */   File messageDE = new File("plugins//API//message_de_DE.yml");
/* 15 */   YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 18 */     Player p = (Player)sender;
/* 19 */     MoneyAPI api = new MoneyAPI();
/* 20 */     if (args.length == 0) {
/* 21 */       api.getMoney(p.getUniqueId().toString());
/* 22 */       p.sendMessage(this.cfg1.getString("Message.prefix") + "Du besitzt momentan " + api.getMoney(p.getUniqueId().toString()) + " Münzen.");
/*    */     } else {
/* 24 */       Player target = Bukkit.getPlayer(args[0]);
/* 25 */       if (target != null) {
/* 26 */         api.getMoney(target.getUniqueId().toString());
/* 27 */         p.sendMessage(this.cfg1.getString("Message.prefix") + "Der Spieler " + target.getDisplayName() + " besitzt mmomentan " + api.getMoney(target.getUniqueId().toString()) + "Münzen.");
/*    */       } else {
/* 29 */         p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.offlinePlayer"));
/*    */       } 
/*    */     } 
/* 32 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Money.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */