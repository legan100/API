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
/*    */ public class CMD_gruss
/*    */   implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 14 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 15 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */ 
/*    */     
/* 18 */     if (sender instanceof Player) {
/* 19 */       Player p = (Player)sender;
/* 20 */       if (args.length == 1) {
/* 21 */         Player target = Bukkit.getPlayer(args[0]);
/* 22 */         if (target != null) {
/* 23 */           if (target.getName() == p.getName()) {
/* 24 */             p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Du darfst dich nicht selber grüßen"));
/*    */           } else {
/* 26 */             target.sendMessage(cfg1.getString("Message.prefix") + "Du wurdest von §c" + p.getDisplayName() + " §egegrüßt.");
/* 27 */             p.sendMessage(cfg1.getString("Message.prefix") + "Du hast den Spieler §c" + target.getDisplayName() + " §egegrüßt.");
/*    */           } 
/*    */         } else {
/* 30 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.offlinePlayer"));
/*    */         } 
/*    */       } else {
/* 33 */         p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.greetingsusage"));
/*    */       } 
/*    */     } else {
/*    */       
/* 37 */       sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.prefix"));
/*    */     } 
/*    */     
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_gruss.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */