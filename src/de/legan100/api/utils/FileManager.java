package de.legan100.api.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager{

    public static void createFile() {

        File file = new File("plugins/API/mysql.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            cfg.addDefault("MySQL.host", "127.0.0.1");
            cfg.addDefault("MySQL.port", "3307"); // Dein MariaDB Port
            cfg.addDefault("MySQL.database", "lobby");
            cfg.addDefault("MySQL.user", "lobbyuser");
            cfg.addDefault("MySQL.password", "starkesPasswort");
            cfg.options().copyDefaults(true);

            try {
                cfg.save(file);
                System.out.println("System >> mysql.yml wurde erstellt!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (!messageDE.exists()) {
            try {
                cfg1.addDefault("message.prefix", "§aSystem §8>> §e");
                cfg1.addDefault("message.noPerms", "§cDafür benötigst du einen höheren Rang");
                cfg1.addDefault("message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
                cfg1.addDefault("message.offlinePlayer", "Spieler ist offline");
                cfg1.addDefault("message.unknownCMD", "§cUnbekannter Command!");
                cfg1.addDefault("message.addmoney.usage","/addmoney <Spielername> <Betrag>");
                cfg1.addDefault("message.bcl.usage","Nutze bitte &e/bcl <Nachricht>");
                cfg1.addDefault("message.changeGamemode.spectator","Du hast deinen Spielmodus in §cSpectator §egeändert.");
                cfg1.addDefault("message.changeGamemode.adventure","Du hast deinen Spielmodus in §cAdventure §egeändert.");
                cfg1.addDefault("message.changeGamemode.survival","Du hast deinen Spielmodus in §cSurvival §egeändert.");
                cfg1.addDefault("message.changeGamemode.creativ","Du hast deinen Spielmodus in §cKreativ §egeändert.");
                cfg1.addDefault("message.chat.deaktivieren", "Chat wurde deaktiviert");
                cfg1.addDefault("message.chat.aktivieren", "Chat wurde aktiviert");
                cfg1.addDefault("message.chat.deaktiviert","Der Chat wurde deaktiviert");
                cfg1.addDefault("message.discord.discord", "Unser Discord:");
                cfg1.addDefault("message.error.team", "Es ist ein Fehler aufgetreten. Bitte melde dich beim Devteam.");
                cfg1.addDefault("message.error.player", "Es ist ein Fehler aufgetreten. Bitte melde dich beim Serverteam.");
                cfg1.addDefault("message.greeting.usage", "/gruss <name>");
                cfg1.addDefault("message.msg.notTalkToMyself", "du kannst dir nichts selber flüstern");
                cfg1.addDefault("message.msg.usage", "/dm <name> <nachricht>");
                cfg1.addDefault("message.pay.notEnoughMoney","Du hast nicht genug Geld.");
                cfg1.addDefault("message.pay.minOne","Du musst mindestens 1 Münze zahlen.");
                cfg1.addDefault("message.pay.usage","/pay <name> <betrag>");
                cfg1.addDefault("message.payall.onlyNumbers","Nur  Zahlen erlaubt!");
                cfg1.addDefault("message.rang.vorstand", "Du bist Vorstand");
                cfg1.addDefault("message.rang.mod", "Du bist Admin");
                cfg1.addDefault("message.rang.media", "Du bist Media");
                cfg1.addDefault("message.rang.mitarbeiter", "Du bist Admin");
                cfg1.addDefault("message.rang.spieler", "Du bist Admin");
                cfg1.addDefault("message.regeln.regeln", "Unser Regelwerk");
                cfg1.addDefault("message.removemoney.minus", "Du kannst den Spieler nicht ins Minus setzten.");
                cfg1.addDefault("message.ts.ts", "Unser TS: legendenarmy.de");
                cfg1.addDefault("message.wartung.disable", "Wartungsmodus deaktivieren");
                cfg1.addDefault("message.wartung.enable", "Wartungsmodus aktivieren");
                cfg1.options().copyDefaults(true);
                cfg1.save(messageDE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        File messageENG = new File("plugins//API//message_eng_GB.yml");
        YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(messageENG);
        if (!messageENG.exists())
            try {
                cfg2.addDefault("Message.prefix", "§aSystem §8>> §e");
                cfg2.addDefault("Message.error", "§cFehler! Bitte melde dich beim Serverteam.");
                cfg2.addDefault("Message.noPerms", "§cDafür benötigst du einen höheren Rang");
                cfg2.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
                cfg2.addDefault("Message.unknownCMD", "§cUnbekannter Command!");
                cfg2.addDefault("Message.ts", "Unser TS: legendenarmy.de");
                cfg2.addDefault("Message.discord", "Unser Discord:");
                cfg2.addDefault("Message.regeln", "Unser Regelwerk");
                cfg2.addDefault("Message.offlinePlayer", "Spieler ist offline");
                cfg2.addDefault("Message.wartung.disable", "Wartungsmodus deaktivieren");
                cfg2.addDefault("Message.wartung.enable", "Wartungsmodus aktivieren");
                cfg2.addDefault("Message.money.Minus", "Du kannst keinem Spieler geld abheben.");
                cfg2.addDefault("Message.money.notEnough", "Nicht genug geld auf der Hand");
                cfg2.addDefault("Message.money.usage", "/pay <name> <betrag>");
                cfg2.addDefault("Message.money.MimiumOne", "Zahle min 1 Münze");
                cfg2.addDefault("Message.money.addMoneyUsage", "/addmoney <name> <betrag>");
                cfg2.addDefault("Message.rang.Admin", "Du bist Admin");
                cfg2.addDefault("Message.rang.Dev", "Du bist Admin");
                cfg2.addDefault("Message.rang.Content", "Du bist Admin");
                cfg2.addDefault("Message.rang.SrMod", "Du bist Admin");
                cfg2.addDefault("Message.rang.Mod", "Du bist Admin");
                cfg2.addDefault("Message.rang.Sup", "Du bist Admin");
                cfg2.addDefault("Message.rang.Builder", "Du bist Admin");
                cfg2.addDefault("Message.rang.Media", "Du bist Media");
                cfg2.addDefault("Message.rang.Mitarbeiter", "Du bist Admin");
                cfg2.addDefault("Message.rang.Premium", "Du bist Admin");
                cfg2.addDefault("Message.rang.Spieler", "Du bist Admin");
                cfg2.addDefault("Message.tell.myself", "du kannst dir nichts selber flüstern");
                cfg2.addDefault("Message.tell.usage", "/msg <name> <nachricht>");
                cfg2.addDefault("Message.chat.deaktivieren", "Chat wurde deaktiviert");
                cfg2.addDefault("Message.chat.aktivieren", "Chat wurde aktiviert");
                cfg2.options().copyDefaults(true);
                cfg2.save(messageENG);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        File configFile = new File("config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        if(!configFile.exists()){
            try {
                config.addDefault("money.allow","false");
                config.options().copyDefaults(true);
                config.save(configFile);
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
}