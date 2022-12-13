package visao;

import entidades.Diaria;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.DiariaDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class TelaListaDiariaAluguel extends javax.swing.JDialog {
	private Diaria itemLocacaoSelected;
	
    public Diaria getItemLocacaoSelected() {
		return itemLocacaoSelected;
	}

	public void setItemLocacaoSelected(Diaria itemLocacaoSelected) {
		this.itemLocacaoSelected = itemLocacaoSelected;
	}
	private List<Diaria> listaDiarias;
    /**
     * Creates new form TelaListaDiaria
     * @param actionListener 
     */
    public TelaListaDiariaAluguel(ActionListener actionListener) {
    	
        initComponents();
        listarDiarias();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDiarias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnIncluirActionPerformed(evt);
            	
            	
            }
        });
        tabDiarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id","marcaModelo", "Categoria", "Preco", "N_Dias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabDiarias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        				.addComponent(btnIncluir, Alignment.TRAILING))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(16, Short.MAX_VALUE)
        			.addComponent(btnIncluir)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </Marca-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
    		
    	int linha = tabDiarias.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um marcaModelo para incluir!");
        } else {
        	
        	int index = tabDiarias.getSelectedRow();
        	itemLocacaoSelected = listaDiarias.get(index);        	
        }
        
        this.dispose();  	
    }
   
    public void listarDiarias() {
        listaDiarias = DiariaDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tabDiarias.getModel();
        modelo.setRowCount(0); // Limpar os itens da tabela
        for (Diaria j : listaDiarias) {
            Object[] linha = {
            	j.getId(),
                j.getMarcaModelo(),
                j.getCategoria().getNome(),
                j.getPreco(),
                j.getNumeroDias()
            };
            modelo.addRow(linha);
        }
    }
    private javax.swing.JButton btnIncluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDiarias;
    // End of variables declaration//GEN-END:variables
}
