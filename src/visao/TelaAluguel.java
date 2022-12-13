package visao;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entidades.Cliente;
import entidades.Diaria;
import entidades.ItemLocacao;
import entidades.Km;
import entidades.Locacao;
import persistencia.ClienteDAO;
import persistencia.ItemlocacaoDAO;
import persistencia.LocacaoDAO;
import java.awt.event.ActionEvent;


public class TelaAluguel extends javax.swing.JFrame {

	private TelaListaKmAluguel telaListaKm;
	private TelaListaDiariaAluguel telaListaDiario;
	private List<Km> ListItensKm;
	private List<Diaria> ListItensDiaria;
	private Double valor = 0.0;
	
	
    /**
     * Creates new form TelaAluguel
     */
    public TelaAluguel() {
    	
    	ListItensKm =  new ArrayList<Km>();
    	ListItensDiaria =  new ArrayList<Diaria>();
    	ClienteDAO clienteDao = new ClienteDAO();
    	ItemlocacaoDAO itemlocacao = new ItemlocacaoDAO();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabItems = new javax.swing.JTable();
        btnAlugar = new javax.swing.JButton();
        btnAlugar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		if(txtNome.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "Os Campos n�o podem estar vazio!","Aviso",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		if(txtEmail.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "Os Campos n�o podem estar vazio!","Aviso",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		if(txtTelefone.getText().equals("")) {
        			JOptionPane.showMessageDialog(null, "Os Campos n�o pode estar vazio!","Aviso",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
                Cliente cliente = new Cliente();
                cliente.setNome(txtNome.getText());
                cliente.setEmail(txtEmail.getText());
                cliente.setTelefone(txtTelefone.getText()); 
        		ClienteDAO.inserir(cliente);
        		
        		Locacao locacao = new Locacao();
        		locacao.setCliente(cliente);
        		locacao.setValor(valor);
        		LocacaoDAO.inserir(locacao);
        		
        		
        		//Salvar no banco a aloca��o(ou seja, os campos da tela e adicionar os itens selecionados)
        	
        		for (Diaria itemLocacao : ListItensDiaria) {
        			ItemLocacao itemDiaria = new ItemLocacao();
        			itemDiaria.setDiaria_id(itemLocacao.getId());
        			itemDiaria.setLocacao_id(locacao.getId());
        			itemDiaria.setValor(itemLocacao.getPreco());        			
					ItemlocacaoDAO.inserir(itemDiaria);
				}

        		for (Km itemLocacao : ListItensKm) {
        			ItemLocacao itemKm = new ItemLocacao();
        			itemKm.setKm_id(itemLocacao.getId());
        			itemKm.setLocacao_id(locacao.getId());
        			itemKm.setValor(itemLocacao.getPreco());        			
					ItemlocacaoDAO.inserir(itemKm);
				}
        		JOptionPane.showMessageDialog(null, "Loca��o realizada com sucesso.");
        		
        		limparCampos();
        	}
        });
        lblTotal = new javax.swing.JLabel();
        btnAdicionarKm = new javax.swing.JButton();
        btnAdicionarKm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		telaListaKm = new TelaListaKmAluguel(this);
        		telaListaKm.setModal(true);
        		telaListaKm.setVisible(true);
        		ListItensKm.add(
        				telaListaKm.getItemLocacaoSelected()
        				);
        		refreshTable();
        		
        	}
        });
        btnAdicionarDiaria = new javax.swing.JButton();
        btnAdicionarDiaria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		telaListaDiario = new TelaListaDiariaAluguel(this);
        		telaListaDiario.setModal(true);        		
        		telaListaDiario.setVisible(true);
        		ListItensDiaria.add(
        				telaListaDiario.getItemLocacaoSelected()
        				);
        		refreshTable();
        	}
        });
        btnExcluir = new javax.swing.JButton();
        btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int index = tabItems.getSelectedRow();
        		ListItensKm.remove(index);
        		ListItensDiaria.remove(index);
        		refreshTable();
        		
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("E-mail");

        jLabel3.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-## ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tabItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "marcaModelo", "categoria", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tabItems);

        btnAlugar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-aluguel-32x32.png"))); // NOI18N
        btnAlugar.setText("Alugar");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total:  0,00");

        btnAdicionarKm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarKm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-filmes-32x32.png"))); // NOI18N
        btnAdicionarKm.setText("Adicionar Km");

        btnAdicionarDiaria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarDiaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-jogos-32x32.png"))); // NOI18N
        btnAdicionarDiaria.setText("Adicionar Diaria");

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-excluir-32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnAdicionarKm, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAdicionarDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarKm)
                    .addComponent(btnAdicionarDiaria)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void refreshTable() {
    	double total = 0;
    	DefaultTableModel modelo = (DefaultTableModel)tabItems.getModel();
    	modelo.setRowCount(0);// limpando a tabela 
    	for (Diaria diaria : ListItensDiaria) {
    		Object[] linha = {
                	diaria.getMarcaModelo(),
                	diaria.getCategoria().getNome(),
                	diaria.getPreco()
                };
                modelo.addRow(linha);
            total = total + diaria.getPreco();
		}
    	
    	//for para listar itens do KM
    	for (Km k : ListItensKm) {
    		Object[] linha = {
                	k.getmarcaModelo(),
                	k.getCategoria().getNome(),
                	k.getPreco()
                };
                modelo.addRow(linha);
            total = total + k.getPreco();
		}
   	
    	valor = total;
    	lblTotal.setText("Total: "+total);
    }
   
    private void limparCampos() {
    	DefaultTableModel modelo = (DefaultTableModel)tabItems.getModel();
    	modelo.setRowCount(0);// limpando a tabela
    	txtEmail.setText("");
    	txtNome.setText("");
    	txtTelefone.setText("");
    	lblTotal.setText("Total : 0");
    	
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarKm;
    private javax.swing.JButton btnAdicionarDiaria;
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabItems;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
	public void setDiaria(Diaria diaria) {
		// TODO Auto-generated method stub
		
	}
}
