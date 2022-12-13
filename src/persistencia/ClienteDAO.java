package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entidades.Cliente;

public class ClienteDAO {
	 public static boolean inserir(Cliente cliente) {
	      
		 try {
	            Connection conexao = Conexao.getConexao();
	            String sql = "INSERT INTO Cliente (nome, email, telefone) VALUES (?,?,?)";
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setString(1, cliente.getNome());
	            ps.setString(2, cliente.getEmail());
	            ps.setString(3, cliente.getTelefone());
	            int resultado = ps.executeUpdate();  
	            ps.close();
	            String sqlId = " Select id from cliente where email = ? ";
	            PreparedStatement st = conexao.prepareStatement(sqlId);
	            st.setString(1, cliente.getEmail());
	            ResultSet res = st.executeQuery();
	            while(res.next()) {
	            	cliente.setId(res.getInt(1));	            	
	            }
	            
	            return resultado > 0;
	        } catch (Exception e) {
	            System.out.println(e);
	            return false;
	        }
	    }

	}


