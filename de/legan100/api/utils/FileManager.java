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
                cfg1.addDefault("message.rang.admin", "Du bist Admin");
                cfg1.addDefault("message.rang.dev", "Du bist Admin");
                cfg1.addDefault("message.rang.content", "Du bist Admin");
                cfg1.addDefault("message.rang.srMod", "Du bist Admin");
                cfg1.addDefault("message.rang.mod", "Du bist Admin");
                cfg1.addDefault("message.rang.sup", "Du bist Admin");
                cfg1.addDefault("message.rang.builder", "Du bist Admin");
                cfg1.addDefault("message.rang.media", "Du bist Media");
                cfg1.addDefault("message.rang.mitarbeiter", "Du bist Admin");
                cfg1.addDefault("message.rang.premium", "Du bist Admin");
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
                cfg2.addDefault("Message.Rang.Admin", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Dev", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Content", "Du bist Admin");
                cfg2.addDefault("Message.Rang.SrMod", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Mod", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Sup", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Builder", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Media", "Du bist Media");
                cfg2.addDefault("Message.Rang.Mitarbeiter", "Du bist Admin");
                cfg2.addDefault("Message.Rang.Premium", "Du bist Admin");
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