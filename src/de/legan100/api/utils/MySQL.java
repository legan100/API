package de.legan100.api.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQL{

    public static Connection con;

    public static void connect() {
        File file = new File("plugins//API//mysql.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + cfg.get("MySQL.host") + ":" + cfg.get("MySQL.port") + "/" + cfg.get("MySQL.database") + "?autoReconnect=true", String.valueOf(cfg.get("MySQL.user")), String.valueOf(cfg.get("MySQL.password")));
                System.out.println("System >> Die Datenbank wurde erfolgreich verbunden!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void disconnect() {
        if (isConnected())
            try {
                con.close();
                System.out.println("System >> Die Datenbank wurde disconnected!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static boolean isConnected() {
        return (con != null);
    }

    public static void createTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS moneyTable (UUID VARCHAR(100), money INT(16))").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}