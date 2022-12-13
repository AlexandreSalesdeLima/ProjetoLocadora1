/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidades.Categoria;
import entidades.Km;
import javax.swing.JOptionPane;
import persistencia.KmDAO;


public class TesteKm {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(2); // 2 - categoria comédia
        
        Km km = new Km(categoria); // realiza a associação com categoria
        km.setPlaca("kgf-7599");
        km.setQkm(90.0);
        km.setPreco(2.5);
        km.setNumeroDias(5);
        km.setmarcaModelo("gm onix");
        km.setDescricao("km");
        
        /*
        if (kmDAO.inserir(km)) {
            JOptionPane.showMessageDialog(null, "km inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir km.");
        }*/
        /*
        km.setId(5);
        if (kmDAO.alterar(km)) {
            JOptionPane.showMessageDialog(null, "km alterar com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar km.");
        }*/
        if (KmDAO.excluir(5)) {
            JOptionPane.showMessageDialog(null, "km excluir com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir km.");
        }
        
        
        System.out.println(KmDAO.listar());
    }
}
