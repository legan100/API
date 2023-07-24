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
/*    */ public class CMD_RemoveMoney
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 16 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 17 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 19 */     if (sender instanceof Player) {
/*    */       
/* 21 */       Player p = (Player)sender;
/*    */       
/* 23 */       MoneyAPI api = new MoneyAPI();
/* 24 */       if (p.hasPermission("System.Admin") || p.hasPermission("System.Dev")) {
/* 25 */         if (args.length == 1) {
/* 26 */           int amount = Integer.valueOf(args[1]).intValue();
/* 27 */           if (amount >= api.getMoney(p.getUniqueId().toString()))
/* 28 */             api.removeMoney(p.getUniqueId(), amount); 
/*    */         } else {
/* 30 */           Player target = Bukkit.getPlayer(args[0]);
/* 31 */           if (target != null) {
/* 32 */             int amount = Integer.valueOf(args[1]).intValue();
/* 33 */             if (amount <= api.getMoney(p.getUniqueId().toString())) {
/* 34 */               p.sendMessage(cfg1.getString("Message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen genommen.");
/* 35 */               api.removeMoney(target.getUniqueId(), amount);
/*    */             } else {
/* 37 */               p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Money.Minus"));
/*    */             } 
/*    */           } else {
/* 40 */             p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
/*    */           } 
/*    */         } 
/*    */       } else {
/* 44 */         p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } else {
/*    */       
/* 48 */       sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 50 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_RemoveMoney.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */