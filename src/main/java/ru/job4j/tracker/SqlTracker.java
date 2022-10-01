package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
       try(PreparedStatement preparedStatement =
                   cn.prepareStatement
                           ("INSERT INTO tracker(name) VALUES (?)")) {
           preparedStatement.setString(1, item.getName());
           preparedStatement.execute();
       } catch (SQLException e) {
           throw new RuntimeException();
       }
       return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("UPDATE tracker SET name = ? WHERE id = ?")){
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, 1);
            rsl = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("DELETE FROM tracker WHERE id = ?")){
            preparedStatement.setInt(1, id);
            rsl = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try(Statement st = cn.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM tracker");
            while (resultSet.next()) {
                rsl.add(new Item(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getTimestamp(3).toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM tracker WHERE name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rsl.add(new Item(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getTimestamp(3).toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = new Item();
        try (PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM tracker WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rsl = new Item(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getTimestamp(3).toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rsl;
    }


}
