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
/*    */ public class CMD_Pay
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 17 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 18 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/* 19 */     if (sender instanceof Player) {
/* 20 */       Player p = (Player)sender;
/* 21 */       if (args.length == 2) {
/* 22 */         MoneyAPI api = new MoneyAPI();
/* 23 */         int check = api.getMoney(p.getUniqueId().toString());
/* 24 */         int amount = Integer.valueOf(args[1]).intValue();
/* 25 */         p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Money.usage"));
/* 26 */         Player target = Bukkit.getPlayer(args[0]);
/* 27 */         if (target != null) {
/* 28 */           if (check >= -1) {
/* 29 */             if (amount >= 1) {
/* 30 */               if (amount <= api.getMoney(p.getUniqueId().toString())) {
/* 31 */                 api.removeMoney(p.getUniqueId(), amount);
/* 32 */                 p.sendMessage(cfg1.getString("Message.prefix") + "Du hast dem Spieler " + target.getDisplayName() + " " + amount + " Münzen gepayed.");
/* 33 */                 api.addMoney(target.getUniqueId(), amount);
/* 34 */                 target.sendMessage(cfg1.getString("Message.prefix") + "Du hast von " + p.getDisplayName() + " " + amount + " Münzen bekommen.");
/*    */               } else {
/* 36 */                 p.sendMessage(cfg1.getString("Message.Money.notEnough"));
/*    */               } 
/*    */             } else {
/* 39 */               p.sendMessage(cfg1.getString("Message.Money.MimiumOne"));
/*    */             } 
/*    */           } else {
/* 42 */             Bukkit.broadcastMessage(cfg1.getString("Message.prefix") + "Der Spieler " + p.getDisplayName() + " hat versucht mit Geld zu bezahlen. Bitte melde dies einem Teamler");
/*    */           } 
/*    */         } else {
/* 45 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.offlinePlayer"));
/*    */         } 
/*    */       } else {
/* 48 */         p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Money.usage"));
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 53 */       sender.sendMessage(cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Pay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */