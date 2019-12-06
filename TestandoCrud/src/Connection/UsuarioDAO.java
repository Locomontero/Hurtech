
package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick
 */
public class UsuarioDAO {
    private final DatabaseMySQL db = new DatabaseMySQL();
    
    public boolean checkLogin(String login, String senha) throws SQLException{
            Connection conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            boolean check =false;
         
        try {
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE login=? and senha=?");
            stmt.setString(1,login);
            stmt.setString(2,senha);
            
            rs= stmt.executeQuery();
            
            if(rs.next()){                
               
                check = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            conn.close();
        }         
        return check;      
    }
}
