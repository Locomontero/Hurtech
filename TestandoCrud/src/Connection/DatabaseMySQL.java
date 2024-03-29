
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick
 */
public class DatabaseMySQL implements Database{

    @Override
    public Connection getConnection() {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "");
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
                return null;
                }
            }
    
}
