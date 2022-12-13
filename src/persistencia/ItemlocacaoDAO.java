package persistencia;

import entidades.ItemLocacao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ItemlocacaoDAO {
    public static boolean inserir(ItemLocacao itemlocacao) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "";
            if (itemlocacao.getDiaria_id() > 0) {
            	sql = "INSERT INTO itemlocacao (valor,Diaria_id,Locacao_id) "
                        + "VALUES (?,?,?)";
            }else {
            	sql = "INSERT INTO itemlocacao (valor,km_id,Locacao_id) "
                        + "VALUES (?,?,?)";
            }           
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setDouble(1, itemlocacao.getValor());
            
            if (itemlocacao.getDiaria_id() > 0) {
            	comando.setInt(2, itemlocacao.getDiaria_id());
            }else {
            	comando.setInt(2, itemlocacao.getKm_id());
            }
            comando.setDouble(3, itemlocacao.getLocacao_id());
            comando.execute();
            comando.close();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
