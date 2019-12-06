package Connection;

import bean.Cliente;
import bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Patrick
 */
public class ProdutoDAO {
     private final DatabaseMySQL db = new DatabaseMySQL();
     
        public boolean inserirProduto(Produto p) throws SQLException {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO produto (modelo, cor, prazo, codigo_cliente)VALUES(?,?,?,?)");
            Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setString(1, p.getModelo());
            stmt.setString(2, p.getCor());
            stmt.setInt(3, p.getPrazo());
            stmt.setInt(4,p.getCliente().getCodigo()); //PEGA CHAVE ESTRANGEIRA.
                          
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
        
        public boolean deletarProduto(Produto p) throws SQLException {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM produto WHERE codigoP =?");
            Connection conn = db.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            
            stmt.setInt(1,p.getCodigoP());
            
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
        public List <Produto> lerProduto() throws SQLException{
            Connection conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List <Produto> produtos = new ArrayList <>();
            
        try {
            stmt = conn.prepareStatement("select c.codigo as codigo, c.nome as nome, c.cpf as cpf, p.modelo as modelo, p.cor as cor, "
                                           + "p.prazo as prazo, p.codigoP as codigoP\n" +
                                            "from cliente as c\n" +
                                            "inner join produto as p\n" +
                                            "on c.codigo= p.codigo_cliente;");
            
            rs= stmt.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                Cliente cliente = new Cliente();
                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setPrazo(rs.getInt("prazo"));
                p.setCodigoP(rs.getInt("codigoP"));
                p.setCliente(cliente);
                
                produtos.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            conn.close();
        }         
        return produtos;      
    }
        public List <Produto> pesquisarProduto(String nome) throws SQLException{
            Connection conn = db.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List <Produto> produtos = new ArrayList <>();
            
        try {
            stmt = conn.prepareStatement("select c.codigo as codigo, c.nome as nome, c.cpf as cpf, p.modelo as modelo, p.cor as cor,"
                                          + "p.prazo as prazo, p.codigoP as codigoP\n" +
                                            "from cliente as c\n" +
                                            "inner join produto as p\n" +
                                            "on c.codigo= p.codigo_cliente "
                                            + "WHERE nome LIKE ?");
            stmt.setString(1,"%"+nome+"%");
            rs= stmt.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                Cliente cliente = new Cliente();
                
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                p.setModelo(rs.getString("modelo"));
                p.setCor(rs.getString("cor"));
                p.setPrazo(rs.getInt("prazo"));
                p.setCodigoP(rs.getInt("codigoP"));
                p.setCliente(cliente);
                
                produtos.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }  finally {
            conn.close();
        }         
        return produtos;      
    }
        
       
     
}
