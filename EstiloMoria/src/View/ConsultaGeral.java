/*
 * ConsultaGeral.java
 *
 * Created on 8 de Setembro de 2011, 14:10
 */

package View;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import Controle.conexao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Relatorio.*;
/**
 *
 * @author  Familia-Silva
 */
public class ConsultaGeral extends javax.swing.JFrame {
    private int numeroRegistros=0;
    private MaskFormatter FormatoData;
    private conexao con_fornecedor, con_vendedor, con_terceirizada, con_cliente;
    /** Creates new form ConsultaGeral */
    public ConsultaGeral() {
        initComponents();
        enter();
         setResizable(false);
        preencheTabela();
        Runtime rt = Runtime.getRuntime();
		int MB = 1048576; // total de bytes em 1MB

		double total = rt.maxMemory() / MB;
		double inicio = total - (carregarMemoria()/MB);
		
		//System.out.println(total);
		//System.out.println(inicio);
		
		// Metodo de limpaza
		rt.runFinalization();
		rt.gc();
		
		double fim = total - rt.freeMemory()/ MB;
		System.out.println("In�cio = " +inicio + "Fim = " + fim);
    }
     public void enter(){
// Enter simula tecla Tab
        HashSet conj = new HashSet(getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbcliente = new javax.swing.JRadioButton();
        rdbterceirizada = new javax.swing.JRadioButton();
        rdbfornecedor = new javax.swing.JRadioButton();
        rdbvendedor = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rdbnome = new javax.swing.JRadioButton();
        rdbtodo = new javax.swing.JRadioButton();
        txtnome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnconsulta = new javax.swing.JButton();
        btnlimpa = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        btnsair1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Geral");
        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));
        buttonGroup1.add(rdbcliente);
        rdbcliente.setText("Cliente");
        rdbcliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbcliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(rdbcliente);
        rdbcliente.setBounds(10, 30, 70, 15);

        buttonGroup1.add(rdbterceirizada);
        rdbterceirizada.setText("Terceirizada");
        rdbterceirizada.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbterceirizada.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(rdbterceirizada);
        rdbterceirizada.setBounds(90, 60, 90, 15);

        buttonGroup1.add(rdbfornecedor);
        rdbfornecedor.setText("Fornecedor");
        rdbfornecedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbfornecedor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(rdbfornecedor);
        rdbfornecedor.setBounds(90, 30, 90, 15);

        buttonGroup1.add(rdbvendedor);
        rdbvendedor.setText("Vendedor");
        rdbvendedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbvendedor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(rdbvendedor);
        rdbvendedor.setBounds(10, 60, 80, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 190, 90);

        jPanel2.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Consulta"));
        buttonGroup2.add(rdbnome);
        rdbnome.setText("Nome");
        rdbnome.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbnome.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbnome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbnomeItemStateChanged(evt);
            }
        });

        jPanel2.add(rdbnome);
        rdbnome.setBounds(10, 30, 60, 15);

        buttonGroup2.add(rdbtodo);
        rdbtodo.setText("Todos");
        rdbtodo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbtodo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbtodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtodoItemStateChanged(evt);
            }
        });

        jPanel2.add(rdbtodo);
        rdbtodo.setBounds(70, 30, 60, 15);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(210, 40, 140, 60);

        txtnome.setEditable(false);
        getContentPane().add(txtnome);
        txtnome.setBounds(360, 80, 280, 20);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 60, 40, 14);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Cliente", "CPF", "CNPJ", "Logradouro", "N�", "Complemento", "Bairro", "Cidade", "CEP", "Tel1", "Tel2"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });

        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 120, 760, 190);

        btnconsulta.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnconsulta.setText("Consulta");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        getContentPane().add(btnconsulta);
        btnconsulta.setBounds(10, 320, 90, 30);

        btnlimpa.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnlimpa.setText("Limpar");
        btnlimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpaActionPerformed(evt);
            }
        });

        getContentPane().add(btnlimpa);
        btnlimpa.setBounds(110, 320, 90, 30);

        btnsair.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnsair.setText("Sair");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        getContentPane().add(btnsair);
        btnsair.setBounds(310, 320, 90, 30);

        btnsair1.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnsair1.setText("Imprimir");
        btnsair1.setEnabled(false);
        btnsair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsair1ActionPerformed(evt);
            }
        });

        getContentPane().add(btnsair1);
        btnsair1.setBounds(210, 320, 90, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-400)/2, 800, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsair1ActionPerformed
// TODO add your handling code here:
        if(rdbcliente.isSelected() && rdbtodo.isSelected()){
            new Rel_Cliente();
        }
        if(rdbcliente.isSelected() && rdbnome.isSelected()){
            new Rel_Cliente_Nome();
        }
        if(rdbfornecedor.isSelected()){
  JOptionPane.showMessageDialog(null,"         Est� opera��o n�o est� habilitada. \n Favor entrar em contato com o desenvolvedor!");            
            
        }
         if(rdbvendedor.isSelected()){
  JOptionPane.showMessageDialog(null,"         Est� opera��o n�o est� habilitada. \n Favor entrar em contato com o desenvolvedor!");            
            
        }
         if(rdbterceirizada.isSelected()){
  JOptionPane.showMessageDialog(null,"         Est� opera��o n�o est� habilitada. \n Favor entrar em contato com o desenvolvedor!");            
            
        }
    }//GEN-LAST:event_btnsair1ActionPerformed
    
    private void rdbtodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtodoItemStateChanged
// TODO add your handling code here:
        if(rdbtodo.isSelected()){
            txtnome.setEditable(false);
            
            
        }
    }//GEN-LAST:event_rdbtodoItemStateChanged
     public static long carregarMemoria(){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<1000000; i++){
		list.add(i);	
		}
		return Runtime.getRuntime().freeMemory();
	}   
    private void rdbnomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbnomeItemStateChanged
// TODO add your handling code here:
        if(rdbnome.isSelected()){
            txtnome.setEditable(true);
            txtnome.requestFocus();
            
        }
    }//GEN-LAST:event_rdbnomeItemStateChanged
    
    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsairActionPerformed
    
    private void btnlimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpaActionPerformed
// TODO add your handling code here:
        ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
        jTable1.updateUI();
        numeroRegistros = 1;
        txtnome.setEditable(false);
        txtnome.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        btnsair1.setEnabled(false);
        
        
    }//GEN-LAST:event_btnlimpaActionPerformed
    
    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
// TODO add your handling code here:
        if(rdbcliente.isSelected() && rdbtodo.isSelected()){
            btnsair1.setEnabled(true);
            preenchejTablaCliente();
        }
         if(rdbcliente.isSelected() && rdbnome.isSelected() &&  !txtnome.getText().equals("")){
            preenchejTablaClienteNome();
            btnsair1.setEnabled(true);
        }
          
        if(rdbvendedor.isSelected() && rdbnome.isSelected() &&  !txtnome.getText().equals("")){
            preenchejTablaVendedorNome();
            btnsair1.setEnabled(true);
        }
        if(rdbvendedor.isSelected() && rdbtodo.isSelected()){
            preenchejTablaVendedor();
            btnsair1.setEnabled(true);
        }
        if(rdbfornecedor.isSelected() && rdbtodo.isSelected()){
            
            preenchejTablaFornecedor();
            btnsair1.setEnabled(true);
        }
         if(rdbfornecedor.isSelected() && rdbnome.isSelected() &&  !txtnome.getText().equals("")){
            preenchejTablaFornecedorNome();
            btnsair1.setEnabled(true);
            
        }
        
        if(rdbterceirizada.isSelected() && rdbtodo.isSelected()){
            
            preenchejTablaTerceirizada();
            btnsair1.setEnabled(true);
        }
         if(rdbterceirizada.isSelected() && rdbnome.isSelected() &&  !txtnome.getText().equals("")){
            
            preenchejTablaTerceirizadaNome();
            btnsair1.setEnabled(true);
        }
    }//GEN-LAST:event_btnconsultaActionPerformed
    public void preenchejTablaCliente(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_cliente= new conexao();
            con_cliente.conecta();
            con_cliente.executeSQL("Select c.cd_cliente, c.cd_cpf_cliente, c.cd_cnpj_cliente, c.nm_cliente, c.nm_fantasia_cliente, c.dt_dia_nascimento, c.dt_mes_nascimento,c.dt_ano_nascimento,c.cd_rg_cliente, c.ic_sexo_cliente, t.*, en.*, e.nm_email1 FROM Cliente c Left Join Telefone t ON (c.cd_cliente=t.cd_cliente) left join email e on (c.cd_cliente=e.cd_cliente) left join endereco en on (c.cd_cliente=en.cd_cliente) order by nm_cliente");
            
            while(con_cliente.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_cliente.resultset.getString("nm_cliente"), con_cliente.resultset.getString("cd_cpf_cliente"),con_cliente.resultset.getString("cd_cnpj_cliente"),con_cliente.resultset.getString("nm_logradouro"),con_cliente.resultset.getString("cd_numero"),con_cliente.resultset.getString("nm_complemento"),
                con_cliente.resultset.getString("nm_bairro"), con_cliente.resultset.getString("nm_cidade"),con_cliente.resultset.getString("cd_cep"), con_cliente.resultset.getString("cd_tel1"), con_cliente.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
     public void preenchejTablaClienteNome(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_cliente= new conexao();
            con_cliente.conecta();
            con_cliente.executeSQL("Select c.nm_cliente,c.cd_cpf_cliente, c.cd_cnpj_cliente, t.cd_tel1, t.cd_tel2, t.cd_tel3, t.cd_tel4, en.nm_logradouro, en.cd_numero, en.cd_cep,en.nm_complemento,en.nm_bairro,en.nm_cidade,en.sg_ufederativa,  e.nm_email1 FROM Cliente c Left Join Telefone t ON (c.cd_cliente=t.cd_cliente) left join email e on (c.cd_cliente=e.cd_cliente) left join endereco en on (c.cd_cliente=en.cd_cliente) where nm_cliente LIKE  '"
				+ txtnome.getText().toUpperCase() + "%' order by nm_cliente");
            
            while(con_cliente.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_cliente.resultset.getString("nm_cliente"), con_cliente.resultset.getString("cd_cpf_cliente"),con_cliente.resultset.getString("cd_cnpj_cliente"),con_cliente.resultset.getString("nm_logradouro"),con_cliente.resultset.getString("cd_numero"),con_cliente.resultset.getString("nm_complemento"),
                con_cliente.resultset.getString("nm_bairro"), con_cliente.resultset.getString("nm_cidade"),con_cliente.resultset.getString("cd_cep"), con_cliente.resultset.getString("cd_tel1"), con_cliente.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
    public void preenchejTablaTerceirizada(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_terceirizada= new conexao();
            con_terceirizada.conecta();
            con_terceirizada.executeSQL("Select c.cd_terceirizada, c.cd_cpf_terceirizada, c.nm_contato, t.*, en.*, e.nm_email1 FROM Terceirizada c Left Join Telefone t ON (c.cd_terceirizada=t.cd_terceirizada) left join email e on (c.cd_terceirizada=e.cd_terceirizada) left join endereco en on (c.cd_terceirizada=en.cd_terceirizada) order by nm_contato");
            
            while(con_terceirizada.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_terceirizada.resultset.getString("nm_contato"), con_terceirizada.resultset.getString("cd_cpf_terceirizada"),"",con_terceirizada.resultset.getString("nm_logradouro"),con_terceirizada.resultset.getString("cd_numero"),con_terceirizada.resultset.getString("nm_complemento"),
                con_terceirizada.resultset.getString("nm_bairro"), con_terceirizada.resultset.getString("nm_cidade"),con_terceirizada.resultset.getString("cd_cep"), con_terceirizada.resultset.getString("cd_tel1"), con_terceirizada.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
    public void preenchejTablaTerceirizadaNome(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_terceirizada= new conexao();
            con_terceirizada.conecta();
            con_terceirizada.executeSQL("Select c.cd_terceirizada, c.cd_cpf_terceirizada, c.nm_contato, t.*, en.*, e.nm_email1 FROM Terceirizada c Left Join Telefone t ON (c.cd_terceirizada=t.cd_terceirizada) left join email e on (c.cd_terceirizada=e.cd_terceirizada) left join endereco en on (c.cd_terceirizada=en.cd_terceirizada) where nm_contato LIKE  '"
				+ txtnome.getText().toUpperCase() + "%' order by nm_contato");
            
            while(con_terceirizada.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_terceirizada.resultset.getString("nm_contato"), con_terceirizada.resultset.getString("cd_cpf_terceirizada"),"",con_terceirizada.resultset.getString("nm_logradouro"),con_terceirizada.resultset.getString("cd_numero"),con_terceirizada.resultset.getString("nm_complemento"),
                con_terceirizada.resultset.getString("nm_bairro"), con_terceirizada.resultset.getString("nm_cidade"),con_terceirizada.resultset.getString("cd_cep"), con_terceirizada.resultset.getString("cd_tel1"), con_terceirizada.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
      public void preenchejTablaVendedor(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_vendedor= new conexao();
            con_vendedor.conecta();
            con_vendedor.executeSQL("Select c.cd_vendedor, c.cd_cpf_vendedor, c.nm_vendedor, t.*, en.*, e.nm_email1 FROM Vendedor c Left Join Telefone t ON (c.cd_vendedor=t.cd_vendedor) left join email e on (c.cd_vendedor=e.cd_vendedor) left join endereco en on (c.cd_vendedor=en.cd_vendedor) order by nm_vendedor");
            
            while(con_vendedor.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_vendedor.resultset.getString("nm_vendedor"), con_vendedor.resultset.getString("cd_cpf_vendedor"),"",con_vendedor.resultset.getString("nm_logradouro"),con_vendedor.resultset.getString("cd_numero"),con_vendedor.resultset.getString("nm_complemento"),
                con_vendedor.resultset.getString("nm_bairro"), con_vendedor.resultset.getString("nm_cidade"),con_vendedor.resultset.getString("cd_cep"), con_vendedor.resultset.getString("cd_tel1"), con_vendedor.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
       public void preenchejTablaVendedorNome(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_vendedor= new conexao();
            con_vendedor.conecta();
            con_vendedor.executeSQL("Select c.cd_vendedor, c.cd_cpf_vendedor, c.nm_vendedor, t.*, en.*, e.nm_email1 FROM Vendedor c Left Join Telefone t ON (c.cd_vendedor=t.cd_vendedor) left join email e on (c.cd_vendedor=e.cd_vendedor) left join endereco en on (c.cd_vendedor=en.cd_vendedor) where nm_vendedor LIKE  '"
				+ txtnome.getText().toUpperCase() + "%' order by nm_vendedor");
            
            while(con_vendedor.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_vendedor.resultset.getString("nm_vendedor"), con_vendedor.resultset.getString("cd_cpf_vendedor"),"",con_vendedor.resultset.getString("nm_logradouro"),con_vendedor.resultset.getString("cd_numero"),con_vendedor.resultset.getString("nm_complemento"),
                con_vendedor.resultset.getString("nm_bairro"), con_vendedor.resultset.getString("nm_cidade"),con_vendedor.resultset.getString("cd_cep"), con_vendedor.resultset.getString("cd_tel1"), con_vendedor.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
     public void preenchejTablaFornecedor(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_fornecedor = new conexao();
            con_fornecedor.conecta();
            con_fornecedor.executeSQL("Select f.*, t.*, en.*, e.nm_email1 FROM Fornecedor f Left Join Telefone t ON (f.cd_fornecedor=t.cd_fornecedor) left join email e on (f.cd_fornecedor=e.cd_fornecedor) left join endereco en on (f.cd_fornecedor=en.cd_fornecedor) order by nm_razaosocial_fornecedor");
            
            while(con_fornecedor.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_fornecedor.resultset.getString("nm_razaosocial_fornecedor"), "",con_fornecedor.resultset.getString("cd_cnpj_fornecedor"),con_fornecedor.resultset.getString("nm_logradouro"),con_fornecedor.resultset.getString("cd_numero"),con_fornecedor.resultset.getString("nm_complemento"),
                con_fornecedor.resultset.getString("nm_bairro"), con_fornecedor.resultset.getString("nm_cidade"),con_fornecedor.resultset.getString("cd_cep"), con_fornecedor.resultset.getString("cd_tel1"), con_fornecedor.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
    public void preenchejTablaFornecedorNome(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        try {
            con_fornecedor = new conexao();
            con_fornecedor.conecta();
            con_fornecedor.executeSQL("Select f.*, t.*, en.*, e.nm_email1 FROM Fornecedor f Left Join Telefone t ON (f.cd_fornecedor=t.cd_fornecedor) left join email e on (f.cd_fornecedor=e.cd_fornecedor) left join endereco en on (f.cd_fornecedor=en.cd_fornecedor) where nm_razaosocial_fornecedor LIKE  '"
				+ txtnome.getText().toUpperCase() + "%' order by nm_razaosocial_fornecedor");
            
            while(con_fornecedor.resultset.next())
                
                
                modelo.addRow(new Object []{numeroRegistros++,con_fornecedor.resultset.getString("nm_razaosocial_fornecedor"), "",con_fornecedor.resultset.getString("cd_cnpj_fornecedor"),con_fornecedor.resultset.getString("nm_logradouro"),con_fornecedor.resultset.getString("cd_numero"),con_fornecedor.resultset.getString("nm_complemento"),
                con_fornecedor.resultset.getString("nm_bairro"), con_fornecedor.resultset.getString("nm_cidade"),con_fornecedor.resultset.getString("cd_cep"), con_fornecedor.resultset.getString("cd_tel1"), con_fornecedor.resultset.getString("cd_tel2")});
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }
    
    public void preencheTabela(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(85);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(85);
        
        
        modelo.setNumRows(0);
        numeroRegistros=1;
    }
    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusGained
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaGeral().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnlimpa;
    private javax.swing.JButton btnsair;
    private javax.swing.JButton btnsair1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdbcliente;
    private javax.swing.JRadioButton rdbfornecedor;
    private javax.swing.JRadioButton rdbnome;
    private javax.swing.JRadioButton rdbterceirizada;
    private javax.swing.JRadioButton rdbtodo;
    private javax.swing.JRadioButton rdbvendedor;
    public static volatile javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables
    
}