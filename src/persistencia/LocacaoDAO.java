package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entidades.Locacao;

public class LocacaoDAO {
	public static boolean inserir(Locacao locacao) {
	      
		 try {
	            Connection conexao = Conexao.getConexao();
	            String sql = "INSERT INTO locacao (valor, cliente_id) VALUES (?,?)";
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setDouble(1, locacao.getValor());
	            ps.setInt(2, locacao.getCliente().getId());
	            int resultado = ps.executeUpdate();  
	            ps.close();
	            String sqlId = " Select max(id) from locacao";
	            PreparedStatement st = conexao.prepareStatement(sqlId);	            
	            ResultSet res = st.executeQuery();
	            while(res.next()) {
	            	locacao.setId(res.getInt(1));	            	
	            }
	            
	            return resultado > 0;
	        } catch (Exception e) {
	            System.out.println(e);
	            return false;
	        }
	    }
}
