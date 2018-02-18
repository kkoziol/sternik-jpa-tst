import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class dbAccess {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");

            String database = "jdbc:h2:~/test";

            conn = DriverManager.getConnection(database, "sa", "sa");

             Statement st = conn.createStatement();
             ResultSet res = st.executeQuery("SELECT id, name, desc FROM article");

             while (res.next()) {
                 int id = res.getInt(1);
                 String name = res.getString(2);
                 String desc = res.getString(3);
                 System.out.println("" + id + " " + name + " " + desc);
             }
             st.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
    }
}