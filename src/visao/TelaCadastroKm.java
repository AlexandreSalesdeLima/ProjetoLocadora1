/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidades.Categoria;
import entidades.Km;
import javax.swing.JOptionPane;
import persistencia.CategoriaDAO;
import persistencia.KmDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;


public class TelaCadastroKm extends javax.swing.JFrame {

    private Km Km;
    private TelaListaKm telaLista;
    

    /**
     * Creates new form TelaCadastroKm
     */
    public TelaCadastroKm(TelaListaKm telaLista) {
        initComponents();
        this.Km = new Km(new Categoria());
        this.telaLista = telaLista;
        for (Categoria D : CategoriaDAO.listarPorTipo('K')) {
            cmbCategoria.addItem(D);
        }
    }
    
    public void setKm(Km Km) {
        this.Km = Km;
        txtPlaca.setText(Km.getPlaca());
        txtDescricao.setText(Km.getDescricao());
        cmbCategoria.setSelectedItem(Km.getCategoria());
        txtMarcaMod.setText(Km.getmarcaModelo());
        txtPreco.setText(String.valueOf(Km.getPreco()));
        txtQKm.setText(String.valueOf(Km.getQkm()));
        txtNumeroDias.setText(String.valueOf(Km.getNumeroDias()));
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        txtQKm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMarcaMod = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Placa");

        jLabel2.setText("Descri\u00E7\u00E3o");

        jLabel3.setText("Categoria");

        jLabel4.setText("Pre\u00E7o");

        jLabel5.setText("N\u00BA Dias");

        jLabel6.setText("Quant / Km");

        jLabel7.setText("Marca / Modelo");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setText("Cadastro de Km");
        
        txtDescricao = new JTextArea();
        txtDescricao.setRows(5);
        txtDescricao.setColumns(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addComponent(jLabel2)
        				.addComponent(btnGravar)
        				.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(txtDescricao)
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(txtQKm, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        										.addComponent(jLabel6))
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        										.addComponent(jLabel4)))
        								.addComponent(jLabel3)
        								.addComponent(cmbCategoria, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel7)
        								.addComponent(txtNumeroDias, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5)
        								.addComponent(txtMarcaMod, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))))
        					.addGap(4)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel8)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
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
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txtMarcaMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cmbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel6)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtQKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
        Km.setPlaca( txtPlaca.getText());
        Km.setDescricao(txtDescricao.getText());
        Km.setmarcaModelo(txtMarcaMod.getText());
        Km.setQkm(Double.parseDouble(txtQKm.getText()));
        Km.setPreco(Double.parseDouble(txtPreco.getText()));
        Km.setNumeroDias(Integer.parseInt(txtNumeroDias.getText()));
        Km.setCategoria((Categoria)cmbCategoria.getSelectedItem());
        
        if (Km.getId() == 0) {
            inserir();
        } else {
            alterar();
        }
    }//GEN-LAST:event_btnGravarActionPerformed
 
    private void inserir() {
        if (KmDAO.inserir(Km)) {
            JOptionPane.showMessageDialog(this, "Km inserido com sucesso!");
            telaLista.montarlistaKm();// Atualizar a lista de Kms
            dispose(); // Fechar a tela de cadastro
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Km!");
        }
    }
    
    private void alterar() {
        if (KmDAO.alterar(Km)) {
            JOptionPane.showMessageDialog(this, "Km alterado com sucesso!");
            telaLista.montarlistaKm();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar Km!");
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
    private javax.swing.JTextField txtMarcaMod;
    private javax.swing.JTextField txtQKm;
    private javax.swing.JTextField txtNumeroDias;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField  txtPlaca;
    private JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}