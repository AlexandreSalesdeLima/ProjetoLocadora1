package visao;

import entidades.Km;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.KmDAO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class TelaListaKmAluguel extends javax.swing.JDialog {
	private Km itemLocacaoSelected;
	
    public Km getItemLocacaoSelected() {
		return itemLocacaoSelected;
	}

	public void setItemLocacaoSelected(Km itemLocacaoSelected) {
		this.itemLocacaoSelected = itemLocacaoSelected;
	}
	private List<Km> listaKm;
    /**
     * Creates new form TelaListakm
     * @param actionListener 
     */
    public TelaListaKmAluguel(ActionListener actionListener) {
    	
        initComponents();
        listarKm(); 
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Marca.
     */
    @SuppressWarnings("unchecked")
    // <Marca-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabkm = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnIncluirActionPerformed(evt);
            	
            	
            }
        });
  
        tabkm.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabkm);

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
    		
    	int linha = tabkm.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um marcaModelo para incluir!");
        } else {
        	
        	int index = tabkm.getSelectedRow();
        	itemLocacaoSelected = listaKm.get(index);        	
        	
        }
        
        this.dispose();
        	  	
    }
    public void listarKm() {
        listaKm = KmDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tabkm.getModel();
        modelo.setRowCount(0); // Limpar os itens da tabela
        for (Km k : listaKm) {
            Object[] linha = {
            	k.getId(),
                k.getmarcaModelo(),
                k.getCategoria().getNome(),
                k.getPreco(),
                k.getNumeroDias()
            };
            modelo.addRow(linha);
        }
    }
    private javax.swing.JButton btnIncluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabkm;
    // End of variables declaration//GEN-END:variables
}
