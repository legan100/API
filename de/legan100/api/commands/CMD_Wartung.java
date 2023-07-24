/*    */ package de.legan100.api.commands;
/*    */ 
/*    */ import de.legan100.api.api.MoneyAPI;
/*    */ import java.io.File;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMD_Wartung
/*    */   implements CommandExecutor
/*    */ {
/*    */   public static boolean isWartung = false;
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
/* 19 */     File messageDE = new File("plugins//API//message_de_DE.yml");
/* 20 */     YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
/*    */     
/* 22 */     if (sender instanceof Player) {
/* 23 */       Player p = (Player)sender;
/* 24 */       if (p.hasPermission("System.Admin")) {
/* 25 */         MoneyAPI api = new MoneyAPI();
/* 26 */         if (args.length >= 1) {
/* 27 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.unknownCMD"));
/* 28 */         } else if (isWartung == true) {
/* 29 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Wartung.disable"));
/* 30 */           isWartung = false;
/*    */         } else {
/* 32 */           p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.Wartung.enable"));
/* 33 */           isWartung = true;
/*    */         } 
/*    */       } else {
/* 36 */         p.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.noPerms"));
/*    */       } 
/*    */     } else {
/* 39 */       sender.sendMessage(cfg1.getString("Message.prefix") + cfg1.getString("Message.onlyPlayerAllowed"));
/*    */     } 
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\commands\CMD_Wartung.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */