package de.legan100.api.api;

import de.legan100.api.utils.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MoneyAPI {

    public int getMoney(String uuid) {
        try {
            PreparedStatement st = MySQL.con.prepareStatement("SELECT money FROM moneyTable WHERE UUID = ?");
            st.setString(1, String.valueOf(uuid));
            ResultSet rs = st.executeQuery();
            if (rs.next())
                return rs.getInt("money");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void setMoney(UUID uuid, int money) {
        if (getMoney(uuid.toString()) == -1) {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO moneyTable (UUID,money) VALUES (?,?)");
                st.setString(1, uuid.toString());
                st.setInt(2, money);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement st = MySQL.con.prepareStatement("UPDATE moneyTable SET money = ? WHERE UUID = ?");
                st.setString(2, uuid.toString());
                st.setInt(1, money);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMoney(UUID uuid, int money) {
        if (money + getMoney(uuid.toString()) != 999999999)
            setMoney(uuid, money + getMoney(uuid.toString()));
    }

    public void removeMoney(UUID uuid, int money) {
        setMoney(uuid, getMoney(uuid.toString()) - money);
    }

    public int checkMoney(UUID uuid, int money) {
        if (money >= -1)
            setMoney(uuid, 0);
        return money;
    }
}