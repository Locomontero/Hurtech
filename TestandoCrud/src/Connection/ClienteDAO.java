
package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Patrick
 */
public class ClienteDAO {
    private final DatabaseMySQL db = new DatabaseMySQL();
    
        public boolean inserir(Cliente c) throws SQLException {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO cliente(nome, cpf, endereco, telefone) VALUES(?,?,?,?)");
            Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getTelefone());
            
            stmt.execute();
 
            JOptionPane.showMessageDialog (null, "Inserido com sucesso!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null, "Erro ao inserir!");
            return false;
        } finally {
            conn.close();
        }
    }    
    public List <Cliente> ler() throws SQLException{
            Connection conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List <Cliente> clientes = new ArrayList <>();
            
        try {
            stmt = conn.prepareStatement("SELECT * FROM cliente");
            rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente c = new Cliente();
                
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            conn.close();
        }         
        return clientes;      
    }
    public boolean editar(Cliente c) throws SQLException {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE cliente SET nome =?, cpf =?, endereco =?, telefone =? WHERE codigo =?");
            Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getTelefone());
            stmt.setInt(5,c.getCodigo());
            
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog (null, "Editado com sucesso!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null, "Erro ao editar!");
            return false;
        } finally {
            conn.close();
        }
    }
    public boolean deletar(Cliente c) throws SQLException {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM cliente WHERE codigo =?");
            Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            
            stmt.setInt(1,c.getCodigo());
            
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog (null, "Excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog (null, "Erro ao excluir!");
            return false;
        } finally {
            conn.close();
        }
    }
    public List <Cliente> pesquisar(String nome) throws SQLException{
            Connection conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List <Cliente> clientes = new ArrayList <>();
            
        try {
            stmt = conn.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
            stmt.setString(1,"%"+nome+"%");
            rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente c = new Cliente();
                
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            conn.close();
        }         
        return clientes;      
    }
    
}
