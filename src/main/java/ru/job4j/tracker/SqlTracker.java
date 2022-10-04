package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SqlTracker implements Store, AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public SqlTracker() {

    }


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
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement
                             ("INSERT INTO items(name, created) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet keyGen = preparedStatement.getGeneratedKeys()) {
                if (keyGen.next()) {
                    item.setId(keyGen.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            rsl = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            rsl = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                rsl.add(createNewItemFromDB(resultSet));
            }
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rsl.add(createNewItemFromDB(resultSet));
            }
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (PreparedStatement preparedStatement = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rsl = createNewItemFromDB(resultSet);
            }
        } catch (SQLException e) {
            LOG.debug(e);
        }
        return rsl;
    }

    public Item createNewItemFromDB(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getTimestamp(3).toLocalDateTime());
    }
}
