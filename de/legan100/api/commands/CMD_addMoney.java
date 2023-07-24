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
/*    */ 
/*    */ 
/*    */ public class CMD_addMoney
/*    */   implements CommandExecutor
/*    */ {
/* 17 */   File messageDE = new File("plugins//API//message_de_DE.yml");
/* 18 */   YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(this.messageDE);
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 22 */     if (sender instanceof Player) {
/*    */       
/* 24 */       MoneyAPI api = new MoneyAPI();
/*    */       
/* 26 */       Player p = (Player)sender;
/* 27 */       if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
/* 28 */         if (args.length == 1 || args.length == 0)
/* 29 */           p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.addmoney.usage")); 
/* 30 */         if (args.length == 1) {
/* 31 */           int amount = Integer.valueOf(args[1]).intValue();
/* 32 */           api.addMoney(p.getUniqueId(), amount);
/*    */         } else {
/* 34 */           Player target = Bukkit.getPlayer(args[0]);
/* 35 */           if (target != null) {
/* 36 */             int amount = Integer.valueOf(args[1]).intValue();
/* 37 */             p.sendMessage(this.cfg1.getString("Message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen gegeben.");
/* 38 */             api.addMoney(target.getUniqueId(), amount);
/*    */           } else {
/* 40 */             p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.offlinePlayer"));
/*    */           } 
/*    */         } 
/*    */       } else {
/* 44 */         p.sendMessage(this.cfg1.getString("Message.prefix") + this.cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_addMoney.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */