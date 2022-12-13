package persistencia;

import entidades.Categoria;
import entidades.Diaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiariaDAO {
    public static boolean inserir(Diaria diaria) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO diaria (marcaModelo, placa, descricao, preco, numeroDias, "
                    + "qtdLugares, categoria_id ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, diaria.getMarcaModelo());
            ps.setString(2, diaria.getDescricao());
            ps.setDouble(5, diaria.getPreco());
            ps.setInt(4, diaria.getNumeroDias());
            ps.setInt(7, diaria.getCategoria().getId());
            ps.setInt(6, diaria.getQtdLugares());
            ps.setString(3, String.valueOf(diaria.getPlaca()));
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean alterar(Diaria diaria) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE diaria SET "
                    + "marcaModelo=?, descricao=?, preco=?, numeroDias=?, "
                    + "categoria_id=?, qtdLugares=?,placa=? "
                    + "WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setString(1, String.valueOf(diaria.getMarcaModelo()));
            ps.setString(2, diaria.getDescricao());
            ps.setDouble(3, diaria.getPreco());
            ps.setInt(4, diaria.getNumeroDias());
            ps.setInt(5, diaria.getCategoria().getId());
            ps.setInt(6, diaria.getQtdLugares());
            ps.setString(7, diaria.getPlaca());
            ps.setInt(8, diaria.getId());
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean excluir(int id) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM diaria WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
   
    public static List<Diaria> listar() {
        List<Diaria> listaDiarias = new ArrayList<Diaria>();
        try {
            Connection conexao = Conexao.getConexao();
	        String sql = 	"select diaria.*, " + 
		            		"categoria.nome as categoria, " + 
		            		"categoria.tipo as tipo_categoria " + 
		            		"from diaria " + 
		            		"inner join categoria on diaria.categoria_id = categoria.id";
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Categoria c = new Categoria();
                c.setId(res.getInt("categoria_id"));
                c.setNome(res.getString("categoria"));
                c.setTipo(res.getString("tipo_categoria").charAt(0));
                
                Diaria d = new Diaria(c); // Associa a categoria ao Diaria
                d.setDescricao(res.getString("descricao"));
                d.setId(res.getInt("id"));
                d.setQtdLugares(res.getInt("qtdLugares"));
                d.setNumeroDias(res.getInt("numeroDias"));
                d.setPreco(res.getDouble("preco"));
                d.setMarcaModelo(res.getString("marcaModelo"));
                d.setPlaca(res.getString("placa"));
                
                listaDiarias.add(d);
            }
            res.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaDiarias;
    }
}
