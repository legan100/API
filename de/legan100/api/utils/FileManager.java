package de.legan100.api.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager{

    public static void createFile() {

        File file = new File("plugins//API//mysql.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                cfg.addDefault("MySQL.host", "localhost");
                cfg.addDefault("MySQL.port", "3306");
                cfg.addDefault("MySQL.database", "database");
                cfg.addDefault("MySQL.user", "username");
                cfg.addDefault("MySQL.password", "password");
                cfg.options().copyDefaults(true);
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File messageDE = new File("plugins//API//message_de_DE.yml");
        YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(messageDE);
        if (!messageDE.exists()) {
            try {
                cfg1.addDefault("Message.prefix", "§aSystem §8>> §e");
                cfg1.addDefault("Message.Error", "§cFehler! Bitte melde dich beim Serverteam.");
                cfg1.addDefault("Message.noPerms", "§cDafür benötigst du einen höheren Rang");
                cfg1.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
                cfg1.addDefault("Message.unknownCMD", "§cUnbekannter Command!");
                cfg1.addDefault("Message.TS", "Unser TS: legendenarmy.de");
                cfg1.addDefault("Message.Discord", "Unser Discord:");
                cfg1.addDefault("Message.Regeln", "Unser Regelwerk");
                cfg1.addDefault("Message.offlinePlayer", "Spieler ist offline");
                cfg1.addDefault("Message.Wartung.disable", "Wartungsmodus deaktivieren");
                cfg1.addDefault("Message.Wartung.enable", "Wartungsmodus aktivieren");
                cfg1.addDefault("Message.Money.Minus", "Du kannst keinem Spieler geld abheben.");
                cfg1.addDefault("Message.Money.notEnough", "Nicht genug geld auf der Hand");
                cfg1.addDefault("Message.Money.usage", "/pay <name> <betrag>");
                cfg1.addDefault("Message.Money.MimiumOne", "Zahle min 1 Münze");
                cfg1.addDefault("Message.Money.addMoneyUsage", "/addmoney <name> <betrag>");
                cfg1.addDefault("Message.Rang.Leader", "Du bist Admin");
                cfg1.addDefault("Message.Rang.CoLeader", "Du bist Admin");
                cfg1.addDefault("Message.Rang.Dev", "Du bist Admin");
                cfg1.addDefault("Message.Rang.Member", "Du bist Admin");
                cfg1.addDefault("Message.Rang.Spieler", "Du bist Admin");
                cfg1.addDefault("Message.tell.myself", "du kannst dir nichts selber flüstern");
                cfg1.addDefault("Message.tell.usage", "/msg <name> <nachricht>");
                cfg1.addDefault("Message.Chat.deaktivieren", "Chat wurde deaktiviert");
                cfg1.addDefault("Message.Chat.aktivieren", "Chat wurde aktiviert");
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
                cfg2.addDefault("Message.Error", "§cFehler! Bitte melde dich beim Serverteam.");
                cfg2.addDefault("Message.noPerms", "§cDafür benötigst du einen höheren Rang");
                cfg2.addDefault("Message.onlyPlayerAllowed", "Dieser Befehl ist nur für Spieler gedacht.");
                cfg2.addDefault("Message.unknownCMD", "§cUnbekannter Command!");
                cfg2.addDefault("Message.TS", "Unser TS: legendenarmy.de");
                cfg2.addDefault("Message.Discord", "Unser Discord:");
                cfg2.addDefault("Message.Regeln", "Unser Regelwerk");
                cfg2.addDefault("Message.offlinePlayer", "Spieler ist offline");
                cfg2.addDefault("Message.Wartung.disable", "Wartungsmodus deaktivieren");
                cfg2.addDefault("Message.Wartung.enable", "Wartungsmodus aktivieren");
                cfg2.addDefault("Message.Money.Minus", "Du kannst keinem Spieler geld abheben.");
                cfg2.addDefault("Message.Money.notEnough", "Nicht genug geld auf der Hand");
                cfg2.addDefault("Message.Money.usage", "/pay <name> <betrag>");
                cfg2.addDefault("Message.Money.MimiumOne", "Zahle min 1 Münze");
                cfg2.addDefault("Message.Money.addMoneyUsage", "/addmoney <name> <betrag>");
                cfg2.addDefault("Message.Rang.Leader", "Du bist Admin");
                cfg2.addDefault("Message.Rang.CoLeader", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Dev", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Member", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Spieler", "Du bist Admin");
                cfg2.addDefault("Message.tell.myself", "du kannst dir nichts selber flüstern");
                cfg2.addDefault("Message.tell.usage", "/msg <name> <nachricht>");
                cfg2.addDefault("Message.Chat.deaktivieren", "Chat wurde deaktiviert");
                cfg2.addDefault("Message.Chat.aktivieren", "Chat wurde aktiviert");
                cfg2.options().copyDefaults(true);
                cfg2.save(messageENG);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}