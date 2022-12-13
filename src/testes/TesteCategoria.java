package testes;

import entidades.Categoria;
import persistencia.CategoriaDAO;

public class TesteCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Ação");
        categoria.setTipo('K'); // k - Km D - Diaria
        
        // CategoriaDAO.inserir(categoria);
        // categoria.setId(1);
        // System.out.println(CategoriaDAO.alterar(categoria));
        // System.out.println(CategoriaDAO.excluir(1));
        System.out.println(CategoriaDAO.listar());
    }
}
