/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidades.Categoria;
import entidades.Diaria;
import javax.swing.JOptionPane;
import persistencia.CategoriaDAO;
import persistencia.DiariaDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;


public class TelaCadastroDiaria extends javax.swing.JFrame {

    private Diaria Diaria;
    private TelaListaDiaria telaLista;

  
    public TelaCadastroDiaria(TelaListaDiaria telaLista) {
        initComponents();
        this.Diaria = new Diaria(new Categoria());
        this.telaLista = telaLista;
        for (Categoria c : CategoriaDAO.listarPorTipo('D')) {
            cmbCategoria.addItem(c);
        }
    }
    
    public void setDiaria(Diaria Diaria) {
        this.Diaria = Diaria;
        txtPlaca.setText(Diaria.getPlaca());
        txtDescricao.setText(Diaria.getDescricao());
        txtmarcaModelo.setText(Diaria.getMarcaModelo());
        cmbCategoria.setSelectedItem(Diaria.getCategoria());
        txtPreco.setText(String.valueOf(Diaria.getPreco()));
        txtQtdLugares.setText(String.valueOf(Diaria.getQtdLugares()));
        txtNumeroDias.setText(String.valueOf(Diaria.getNumeroDias()));
    }
        
  

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroDias = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQtdLugares = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmarcaModelo = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel7.setText("Marca / Modelo");
        
        jLabel2.setText("Descri\u00E7\u00E3o");

        jLabel3.setText("Categoria");

        jLabel4.setText("Pre\u00E7o");

        jLabel5.setText("N\u00BA Dias");

        jLabel6.setText("Quant./Lugares");
  
        jLabel1.setText("Placa");
        

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setText("Cadastro de Diarias");
        
        txtDescricao = new JTextArea();
        txtDescricao.setRows(5);
        txtDescricao.setColumns(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2)
        						.addComponent(btnGravar)
        						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(layout.createSequentialGroup()
        											.addGroup(layout.createParallelGroup(Alignment.LEADING)
        												.addComponent(txtQtdLugares, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        												.addComponent(jLabel6))
        											.addPreferredGap(ComponentPlacement.UNRELATED)
        											.addGroup(layout.createParallelGroup(Alignment.LEADING)
        												.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        												.addComponent(jLabel4)))
        										.addComponent(jLabel3)
        										.addComponent(cmbCategoria, 0, 208, Short.MAX_VALUE))
        									.addGap(18)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(jLabel7)
        										.addComponent(jLabel5)
        										.addComponent(txtmarcaModelo, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        										.addComponent(txtNumeroDias, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        									.addPreferredGap(ComponentPlacement.RELATED))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)))
        							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(16))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel8)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(9)
        			.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel2)
        			.addGap(8)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jLabel7))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cmbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtmarcaModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel6)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtQtdLugares, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(11)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel4)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel5)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtNumeroDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnGravar)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
    	
    	Diaria.setMarcaModelo(txtmarcaModelo.getText());
        Diaria.setDescricao(txtDescricao.getText());
        Diaria.setPlaca(txtPlaca.getText());
        Diaria.setQtdLugares(Integer.parseInt(txtQtdLugares.getText()));
        Diaria.setPreco(Double.parseDouble(txtPreco.getText()));
        Diaria.setNumeroDias(Integer.parseInt(txtNumeroDias.getText()));
        Diaria.setCategoria((Categoria)cmbCategoria.getSelectedItem());
        
        if (Diaria.getId() == 0) {
            inserir();
        } else {
            alterar();
        }
    }//GEN-LAST:event_btnGravarActionPerformed
 
    private void inserir() {
        if (DiariaDAO.inserir(Diaria)) {
            JOptionPane.showMessageDialog(this, "Diaria inserido com sucesso!");
            telaLista.listarDiarias(); // Atualizar a lista de Diarias
            dispose(); // Fechar a tela de cadastro
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Diaria!");
        }
    }
    
    private void alterar() {
        if (DiariaDAO.alterar(Diaria)) {
            JOptionPane.showMessageDialog(this, "Diaria alterado com sucesso!");
            telaLista.listarDiarias();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar Diaria!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox<Categoria> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtQtdLugares;
    private javax.swing.JTextField txtNumeroDias;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtmarcaModelo;
    private JTextArea txtDescricao;
}
