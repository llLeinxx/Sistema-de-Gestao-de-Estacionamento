package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DB {
    private static Connection conn = null;

    public DB() {
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException var2) {
                throw new DbException(var2.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var1) {
                throw new DbException(var1.getMessage());
            }
        }

    }

    private static Properties loadProperties() {
        try {
            FileInputStream fs = new FileInputStream("db.properties");

            Properties var2;
            try {
                Properties props = new Properties();
                props.load(fs);
                var2 = props;
            } catch (Throwable var4) {
                try {
                    fs.close();
                } catch (Throwable var3) {
                    var4.addSuppressed(var3);
                }

                throw var4;
            }

            fs.close();
            return var2;
        } catch (IOException var5) {
            throw new DbException(var5.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException var2) {
                throw new DbException(var2.getMessage());
            }
        }

    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var2) {
                throw new DbException(var2.getMessage());
            }
        }

    }
}
