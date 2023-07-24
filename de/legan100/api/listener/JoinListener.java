/*    */ package de.legan100.api.listener;
/*    */ 
/*    */ import de.legan100.api.api.MoneyAPI;
/*    */ import de.legan100.api.commands.CMD_Wartung;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ 
/*    */ public class JoinListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onJoin(PlayerJoinEvent e) {
/* 16 */     Player p = e.getPlayer();
/*    */     
/* 18 */     MoneyAPI api = new MoneyAPI();
/* 19 */     if (!p.hasPlayedBefore() && p != null && Bukkit.getPort() == 1) {
/* 20 */       api.addMoney(p.getUniqueId(), 1001);
/*    */     }
/* 22 */     if (CMD_Wartung.isWartung == true) {
/* 23 */       if (p.hasPermission("System.Team")) {
/* 24 */         p.sendMessage("Der Wartungsmodus ist aktiviert.");
/*    */       } else {
/* 26 */         p.kickPlayer("\n\n§cZurzeit befinden wir uns im Wartungsmodus.\n\n§aAllerdings freuen wir uns, wenn wir dich auf unserem TeamSpeak LegendenArmy.de begrüßen dürfen.");
/*    */       } 
/* 28 */     } else if (p.hasPermission("System.Wartung.Info")) {
/* 29 */       p.sendMessage("Der Wartungsmodus ist deaktiviert");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\listener\JoinListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */