package persistencia;

import entidades.Categoria;
import entidades.Km;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class KmDAO {
    public static List<Km> listar() {
        List<Km> lista = new ArrayList<Km>();
        try {
            String sql = "SELECT Km.*,"
                    + "     categoria.nome as categoria,"
                    + "     categoria.tipo "
                    + "FROM Km "
                    + "INNER JOIN categoria ON Km.categoria_id = categoria.id";
            Connection conexao = Conexao.getConexao();
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria"));
                categoria.setTipo(rs.getString("tipo").charAt(0));
                
                Km Km = new Km(categoria);
                Km.setId(rs.getInt("id"));
                Km.setDescricao(rs.getString("descricao"));
                Km.setmarcaModelo(rs.getString("marcaModelo"));
                Km.setQkm(rs.getDouble("qkm"));
                Km.setNumeroDias(rs.getInt("numeroDias"));
                Km.setPreco(rs.getDouble("preco"));
                Km.setPlaca(rs.getString("placa"));
                
                lista.add(Km);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("KmDAO.listar");
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static boolean inserir(Km Km) {
        try {
            String sql = "INSERT INTO Km (marcaModelo, descricao, preco, "
                    + "numeroDias,placa, qkm, categoria_id) VALUES "
                    + "(?,?,?,?,?,?,?)";
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Km.getmarcaModelo());
            ps.setString(2, Km.getDescricao());
            ps.setDouble(3, Km.getPreco());
            ps.setInt(4, Km.getNumeroDias());
            ps.setString(5, Km.getPlaca());
            ps.setDouble(6, Km.getQkm());
            ps.setInt(7, Km.getCategoria().getId());
            
            int inseridos = ps.executeUpdate();
            
            ps.close();
            
            return inseridos > 0;
        } catch (Exception e) {
            System.out.println("KmDAO.inserir: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean alterar(Km Km) {
        try {
            String sql = "UPDATE Km SET marcaModelo=?, descricao=?, preco=?, "
                    + "numeroDias=?, placa=?, qkm=?, categoria_id=? "
                    + "WHERE id = ?";
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Km.getmarcaModelo());
            ps.setString(2, Km.getDescricao());
            ps.setDouble(3, Km.getPreco());
            ps.setInt(4, Km.getNumeroDias());
            ps.setString(5, Km.getPlaca());
            ps.setDouble(6, Km.getQkm());
            ps.setInt(7, Km.getCategoria().getId());
            ps.setInt(8, Km.getId());
            
            int alterados = ps.executeUpdate();
            
            ps.close();
            
            return alterados > 0;
        } catch (Exception e) {
            System.out.println("KmDAO.alterar: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean excluir(int id) {
        try {
            String sql = "DELETE FROM Km WHERE id = ?";
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int excluidos = ps.executeUpdate();
            
            ps.close();
            
            return excluidos > 0;
        } catch (Exception e) {
            System.out.println("KmDAO.excluir: " + e.getMessage());
            return false;
        }
    }
}
