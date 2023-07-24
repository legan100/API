/*    */ package de.legan100.api.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MySQL
/*    */ {
/*    */   public static Connection con;
/*    */   
/*    */   public static void connect() {
/* 16 */     File file = new File("plugins//API//mysql.yml");
/* 17 */     YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
/*    */     
/* 19 */     if (!isConnected()) {
/*    */       try {
/* 21 */         con = DriverManager.getConnection("jdbc:mysql://" + cfg.get("MySQL.host") + ":" + cfg.get("MySQL.port") + "/" + cfg.get("MySQL.database") + "?autoReconnect=true", String.valueOf(cfg.get("MySQL.user")), String.valueOf(cfg.get("MySQL.password")));
/* 22 */         System.out.println("System >> Die Datenbank wurde erfolgreich verbunden!");
/* 23 */       } catch (SQLException e) {
/* 24 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static void disconnect() {
/* 30 */     if (isConnected())
/*    */       try {
/* 32 */         con.close();
/* 33 */         System.out.println("System >> Die Datenbank wurde disconnected!");
/* 34 */       } catch (SQLException e) {
/* 35 */         e.printStackTrace();
/*    */       }  
/*    */   }
/*    */   
/*    */   public static boolean isConnected() {
/* 40 */     return (con != null);
/*    */   }
/*    */   
/*    */   public static void createTable() {
/*    */     try {
/* 45 */       con.prepareStatement("CREATE TABLE IF NOT EXISTS moneyTable (UUID VARCHAR(100), money INT(16))").executeUpdate();
/* 46 */     } catch (SQLException e) {
/* 47 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\APIs\API.jar!\de\legan100\ap\\utils\MySQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */