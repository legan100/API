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
/*    */ public class CMD_PayAll
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 17 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 18 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 20 */     if (sender instanceof Player) {
/*    */       
/* 22 */       MoneyAPI api = new MoneyAPI();
/*    */       
/* 24 */       Player p = (Player)sender;
/* 25 */       if (p.hasPermission("System.Admin")) {
/* 26 */         if (p.getServer().getPort() == 300) {
/* 27 */           if (!args[0].equals(null)) {
/* 28 */             int amount = Integer.parseInt(args[0]);
/* 29 */             int onlinePlayers = Bukkit.getOnlinePlayers().size();
/*    */             
/* 31 */             if (amount > 99) {
/* 32 */               int summe = amount * (onlinePlayers - 1);
/* 33 */               if (summe <= api.getMoney(String.valueOf(p.getUniqueId()))) {
/* 34 */                 for (Player onlineplayer : Bukkit.getOnlinePlayers()) {
/* 35 */                   if (onlineplayer.getDisplayName() != p.getDisplayName()) {
/* 36 */                     api.addMoney(onlineplayer.getUniqueId(), amount);
/* 37 */                     onlineplayer.sendMessage("Du hast vom Spieler " + p.getDisplayName() + " " + amount + " Münzen erhalten"); continue;
/*    */                   } 
/* 39 */                   p.sendMessage("Du hast insgesamt " + summe + " Münzen ausgegeben.");
/* 40 */                   api.removeMoney(p.getUniqueId(), summe);
/*    */                 } 
/*    */               } else {
/*    */                 
/* 44 */                 p.sendMessage(cfg1.getString("Message.prefis") + "Du hast nicht genug Geld.");
/*    */               } 
/*    */             } 
/*    */           } else {
/* 48 */             p.sendMessage(cfg1.getString("Message.prefis") + "Bitte geb eine Zahl ein");
/*    */           } 
/*    */         } else {
/* 51 */           p.sendMessage(cfg1.getString("Message.prefis") + "Nur auf RPBuild erlaubt.");
/*    */         } 
/*    */       } else {
/* 54 */         p.sendMessage(cfg1.getString("Message.prefis") + cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } else {
/* 57 */       sender.sendMessage(cfg1.getString("Message.prefis") + cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/*    */     
/* 60 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_PayAll.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */