/*     */ package de.legan100.api.api;
/*     */ 
/*     */ import de.legan100.api.API;
/*     */ import de.legan100.api.utils.MySQL;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MoneyAPI
/*     */ {
/*     */   public API api;
/*     */   boolean wartung;
/*     */   boolean onlinestatus;
/*     */   boolean enableChat;
/*     */   String version;
/*     */   String author;
/*     */   
/*     */   public API getApi() {
/*  25 */     return this.api;
/*     */   }
/*     */   
/*     */   public void setApi(API api) {
/*  29 */     this.api = api;
/*     */   }
/*     */   
/*     */   public String getVersion() {
/*  33 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/*  37 */     this.version = version;
/*     */   }
/*     */   
/*     */   public String getAuthor() {
/*  41 */     return this.author;
/*     */   }
/*     */   
/*     */   public void setAuthor(String author) {
/*  45 */     this.author = author;
/*     */   }
/*     */   
/*     */   public boolean isWartung() {
/*  49 */     return this.wartung;
/*     */   }
/*     */   
/*     */   public void setWartung(boolean wartung) {
/*  53 */     this.wartung = wartung;
/*     */   }
/*     */   
/*     */   public boolean isOnlinestatus() {
/*  57 */     return this.onlinestatus;
/*     */   }
/*     */   
/*     */   public void setOnlinestatus(boolean onlinestatus) {
/*  61 */     this.onlinestatus = onlinestatus;
/*     */   }
/*     */   
/*     */   public int getMoney(String uuid) {
/*     */     try {
/*  66 */       PreparedStatement st = MySQL.con.prepareStatement("SELECT money FROM moneyTable WHERE UUID = ?");
/*  67 */       st.setString(1, String.valueOf(uuid));
/*  68 */       ResultSet rs = st.executeQuery();
/*  69 */       if (rs.next())
/*  70 */         return rs.getInt("money"); 
/*  71 */     } catch (SQLException e) {
/*  72 */       e.printStackTrace();
/*     */     } 
/*  74 */     return -1;
/*     */   }
/*     */   
/*     */   public void setMoney(UUID uuid, int money) {
/*  78 */     if (getMoney(uuid.toString()) == -1) {
/*     */       try {
/*  80 */         PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO moneyTable (UUID,money) VALUES (?,?)");
/*  81 */         st.setString(1, uuid.toString());
/*  82 */         st.setInt(2, money);
/*  83 */         st.executeUpdate();
/*  84 */       } catch (SQLException e) {
/*  85 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       try {
/*  89 */         PreparedStatement st = MySQL.con.prepareStatement("UPDATE moneyTable SET money = ? WHERE UUID = ?");
/*  90 */         st.setString(2, uuid.toString());
/*  91 */         st.setInt(1, money);
/*  92 */         st.executeUpdate();
/*  93 */       } catch (SQLException e) {
/*  94 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addMoney(UUID uuid, int money) {
/* 100 */     if (money + getMoney(uuid.toString()) != 999999999)
/* 101 */       setMoney(uuid, money + getMoney(uuid.toString())); 
/*     */   }
/*     */   
/*     */   public void removeMoney(UUID uuid, int money) {
/* 105 */     setMoney(uuid, getMoney(uuid.toString()) - money);
/*     */   }
/*     */   
/*     */   public int checkMoney(UUID uuid, int money) {
/* 109 */     if (money >= -1)
/* 110 */       setMoney(uuid, 0); 
/* 111 */     return money;
/*     */   }
/*     */   
/*     */   public boolean isEnableChat() {
/* 115 */     return this.enableChat;
/*     */   }
/*     */   
/*     */   public void setEnableChat(boolean enableChat) {
/* 119 */     this.enableChat = enableChat;
/*     */   }
/*     */ }


/* Location:              D:\APIs\API.jar!\de\legan100\api\api\MoneyAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */