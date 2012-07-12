/*
 * ConsultaEntradaMateriaPrima.java
 *
 * Created on 7 de Setembro de 2011, 20:40
 */

package View;
import Controle.conexao;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author  Familia-Silva
 */
public class ConsultaEntradaMateriaPrima extends javax.swing.JFrame {
    private conexao con_produto, con_cor, con_aviamento, con_email,con_produtoacbado1,con_produtoacbado2,con_produtoacbado3,con_produtoacbado4,con_produtoacbado,con_produtoacbado5,con_produtoacbado6;
    private int numeroRegistros = 1;
    private int iniciacombo=0;
    /** Creates new form ConsultaEntradaMateriaPrima */
    public ConsultaEntradaMateriaPrima() {
        initComponents();
        cmbaviamento.setVisible(false);
        cmbtecido.setVisible(false);
        preencheTabela();
        con_produto=new conexao();
        con_produto.conecta();
        con_cor=new conexao();
        con_cor.conecta();
        con_aviamento=new conexao();
        con_aviamento.conecta();
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        con_produtoacbado = new conexao();
        con_produtoacbado.conecta();
         setResizable(false);
        con_cor.executeSQL("select * from cor order by nm_cor");
        con_produto.executeSQL("select * from Tecido order by nm_tecido");
        con_aviamento.executeSQL("select * from Aviamento order by nm_aviamento");
        try {
            
            while(con_cor.resultset.next())
                cmbcor.addItem(con_cor.resultset.getString("nm_cor"));
            while(con_produto.resultset.next())
                cmbtecido.addItem(con_produto.resultset.getString("nm_tecido"));
            while(con_aviamento.resultset.next())
                cmbaviamento.addItem(con_aviamento.resultset.getString("nm_aviamento"));
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
        enter();
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
     public static long carregarMemoria(){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<1000000; i++){
		list.add(i);	
		}
		return Runtime.getRuntime().freeMemory();
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
        consulta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbsimples = new javax.swing.JRadioButton();
        rdbgeral = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        cmbtipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cmbtecido = new javax.swing.JComboBox();
        cmbcor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbaviamento = new javax.swing.JComboBox();
        cmbcontrole = new javax.swing.JComboBox();
        lblcodaviamento = new javax.swing.JLabel();
        lblcodtecido = new javax.swing.JLabel();
        lblcodcor = new javax.swing.JLabel();
        lblmetro = new javax.swing.JLabel();
        lblkilo = new javax.swing.JLabel();
        lblaviamento = new javax.swing.JLabel();
        lblcor = new javax.swing.JLabel();
        lblpeca = new javax.swing.JLabel();
        lbltamanho = new javax.swing.JLabel();
        lblvalor = new javax.swing.JLabel();
        lbltecido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnconsulta = new javax.swing.JButton();
        btnlimpar = new javax.swing.JButton();
        btnsair = new javax.swing.JButton();
        lblfornecedor = new javax.swing.JLabel();
        lblnf = new javax.swing.JLabel();
        lbldata = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Entrada Mat\u00e9ria Prima");
        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Consulta"));
        consulta.add(rdbsimples);
        rdbsimples.setText("Simples");
        rdbsimples.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbsimples.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbsimples.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbsimplesItemStateChanged(evt);
            }
        });

        jPanel1.add(rdbsimples);
        rdbsimples.setBounds(10, 30, 80, 15);

        consulta.add(rdbgeral);
        rdbgeral.setText("Geral");
        rdbgeral.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rdbgeral.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rdbgeral.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbgeralItemStateChanged(evt);
            }
        });

        jPanel1.add(rdbgeral);
        rdbgeral.setBounds(10, 50, 60, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 100, 80);

        jPanel2.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mat\u00e9ria Prima"));
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "AVIAMENTO", "TECIDO" }));
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });

        jPanel2.add(cmbtipo);
        cmbtipo.setBounds(10, 50, 100, 20);

        jLabel1.setText("Tipo");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 30, 50, 14);

        cmbtecido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtecidoActionPerformed(evt);
            }
        });

        jPanel2.add(cmbtecido);
        cmbtecido.setBounds(120, 50, 300, 20);

        cmbcor.setMaximumRowCount(5);
        cmbcor.setEnabled(false);
        cmbcor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcorActionPerformed(evt);
            }
        });

        jPanel2.add(cmbcor);
        cmbcor.setBounds(430, 50, 300, 20);

        jLabel2.setText("Produto");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(120, 30, 80, 14);

        jLabel3.setText("Cor");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(430, 30, 80, 14);

        cmbaviamento.setMaximumRowCount(5);
        cmbaviamento.setEnabled(false);
        cmbaviamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbaviamentoActionPerformed(evt);
            }
        });

        jPanel2.add(cmbaviamento);
        cmbaviamento.setBounds(120, 50, 300, 20);

        cmbcontrole.setMaximumRowCount(5);
        cmbcontrole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanel2.add(cmbcontrole);
        cmbcontrole.setBounds(120, 50, 300, 20);

        lblcodaviamento.setText("aviamento");
        jPanel2.add(lblcodaviamento);
        lblcodaviamento.setBounds(190, 50, 60, 14);

        lblcodtecido.setText("tecido");
        jPanel2.add(lblcodtecido);
        lblcodtecido.setBounds(190, 50, 60, 14);

        lblcodcor.setText("Cor");
        jPanel2.add(lblcodcor);
        lblcodcor.setBounds(370, 50, 80, 14);

        lblmetro.setText("metro");
        jPanel2.add(lblmetro);
        lblmetro.setBounds(380, 50, 50, 14);

        lblkilo.setText("kilo");
        jPanel2.add(lblkilo);
        lblkilo.setBounds(350, 50, 50, 14);

        lblaviamento.setText("aviamento");
        jPanel2.add(lblaviamento);
        lblaviamento.setBounds(350, 50, 50, 14);

        lblcor.setText("cor");
        jPanel2.add(lblcor);
        lblcor.setBounds(240, 50, 50, 14);

        lblpeca.setText("peca");
        jPanel2.add(lblpeca);
        lblpeca.setBounds(220, 50, 50, 14);

        lbltamanho.setText("tamanho");
        jPanel2.add(lbltamanho);
        lbltamanho.setBounds(190, 50, 50, 14);

        lblvalor.setText("valor");
        jPanel2.add(lblvalor);
        lblvalor.setBounds(180, 50, 50, 14);

        lbltecido.setText("tecido");
        jPanel2.add(lbltecido);
        lbltecido.setBounds(130, 50, 50, 14);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(120, 10, 750, 80);

        jScrollPane1.setAutoscrolls(true);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Produto", "Cor", "Kilo", "Metro", "Pe�a", "Tamanho", "V. Unit.", "Fornecedor", "N.F", "Data"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 860, 260);

        btnconsulta.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnconsulta.setText("Consulta");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        getContentPane().add(btnconsulta);
        btnconsulta.setBounds(10, 370, 90, 30);

        btnlimpar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnlimpar.setText("Limpar");
        btnlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparActionPerformed(evt);
            }
        });

        getContentPane().add(btnlimpar);
        btnlimpar.setBounds(110, 370, 90, 30);

        btnsair.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnsair.setText("Sair");
        btnsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsairActionPerformed(evt);
            }
        });

        getContentPane().add(btnsair);
        btnsair.setBounds(210, 370, 90, 30);

        lblfornecedor.setText("fornecedor");
        getContentPane().add(lblfornecedor);
        lblfornecedor.setBounds(780, 110, 50, 14);

        lblnf.setText("nf");
        getContentPane().add(lblnf);
        lblnf.setBounds(790, 110, 50, 14);

        lbldata.setText("data");
        getContentPane().add(lbldata);
        lbldata.setBounds(780, 110, 50, 14);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-886)/2, (screenSize.height-450)/2, 886, 450);
    }// </editor-fold>//GEN-END:initComponents
    
    private void rdbgeralItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbgeralItemStateChanged
// TODO add your handling code here:
        if(rdbgeral.isSelected()){
            cmbaviamento.setVisible(false);
            cmbaviamento.setSelectedIndex(0);
            cmbtecido.setVisible(false);
            cmbtecido.setSelectedIndex(0);
            cmbcor.setSelectedIndex(0);
            cmbcor.setEnabled(false);
            cmbtipo.setSelectedIndex(0);
            cmbcontrole.setEnabled(false);
            cmbcontrole.setVisible(true);
        }
    }//GEN-LAST:event_rdbgeralItemStateChanged
    
    private void cmbaviamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbaviamentoActionPerformed
// TODO add your handling code here:
        if(iniciacombo == 1){
            try {
                
                con_aviamento.resultset.first();
                String igual = "n";
                while(igual == "n"){
                    if(con_aviamento.resultset.getString("nm_aviamento").equals(cmbaviamento.getSelectedItem())){
                        igual = "s";
                    } else
                        con_aviamento.resultset.next();
                }
                lblcodaviamento.setText(con_aviamento.resultset.getString(String.valueOf("cd_aviamento")));
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
        iniciacombo=1;
    }//GEN-LAST:event_cmbaviamentoActionPerformed
    
    private void cmbcorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcorActionPerformed
// TODO add your handling code here:
        if(iniciacombo == 1){
            try {
                
                con_cor.resultset.first();
                String igual = "n";
                while(igual == "n"){
                    if(con_cor.resultset.getString("nm_cor").equals(cmbcor.getSelectedItem())){
                        igual = "s";
                    } else
                        con_cor.resultset.next();
                }
                lblcodcor.setText(con_cor.resultset.getString(String.valueOf("cd_cor")));
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
        iniciacombo=1;
    }//GEN-LAST:event_cmbcorActionPerformed
    
    private void cmbtecidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtecidoActionPerformed
// TODO add your handling code here:
        if(iniciacombo == 1){
            try {
                
                con_produto.resultset.first();
                String igual = "n";
                while(igual == "n"){
                    if(con_produto.resultset.getString("nm_tecido").equals(cmbtecido.getSelectedItem())){
                        igual = "s";
                    } else
                        con_produto.resultset.next();
                }
                lblcodtecido.setText(con_produto.resultset.getString(String.valueOf("cd_tecido")));
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
        iniciacombo=1;
    }//GEN-LAST:event_cmbtecidoActionPerformed
    
    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
// TODO add your handling code here:
        if(rdbsimples.isSelected() && cmbtipo.getSelectedItem().equals("TECIDO")){
            cmbcontrole.setVisible(false);
            cmbaviamento.setVisible(false);
            cmbaviamento.setSelectedIndex(0);
            cmbtecido.setVisible(true);
            
        }
        if(rdbsimples.isSelected() && cmbtipo.getSelectedItem().equals("AVIAMENTO")){
            cmbcontrole.setVisible(false);
            cmbaviamento.setVisible(true);
            cmbtecido.setVisible(false);
            cmbtecido.setSelectedIndex(0);
        }
        if(rdbsimples.isSelected() && cmbtipo.getSelectedItem().equals("-")){
            cmbcontrole.setVisible(true);
            cmbaviamento.setVisible(false);
            cmbtecido.setVisible(false);
            cmbtecido.setSelectedIndex(0);
            cmbaviamento.setSelectedIndex(0);
            cmbcor.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cmbtipoActionPerformed
    
    private void rdbsimplesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbsimplesItemStateChanged
// TODO add your handling code here:
        if(rdbsimples.isSelected()){
            cmbaviamento.setEnabled(true);
            cmbtecido.setEnabled(true);
            cmbcor.setEnabled(true);
            
            
        }
    }//GEN-LAST:event_rdbsimplesItemStateChanged
    
    private void btnsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsairActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsairActionPerformed
    
    private void btnlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparActionPerformed
// TODO add your handling code here:
        ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
        jTable1.updateUI();
        numeroRegistros = 1;
        cmbtecido.setSelectedIndex(0);
        cmbaviamento.setSelectedIndex(0);
        cmbcontrole.setSelectedIndex(0);
        cmbcor.setSelectedIndex(0);
        consulta.clearSelection();
        cmbaviamento.setVisible(false);
        cmbtecido.setVisible(false);
        cmbcontrole.setVisible(true);
        cmbcor.setEnabled(false);
        cmbtipo.setSelectedIndex(0);
    }//GEN-LAST:event_btnlimparActionPerformed
    
    public void preenchejTablaAviamento(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
        
        // modelo.setNumRows(0);
        // numeroRegistros=1;
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        
        
        
        try {
            con_produtoacbado1 = new conexao();
            con_produtoacbado1.conecta();
            con_produtoacbado1.executeSQL("Select  a.nm_aviamento, cc.nm_cor, m.nm_tamanho, m.qt_metro, m.qt_kilo, m.qt_peca, m.cd_notafiscal,f.cd_fornecedor,f.nm_razaosocial_fornecedor, m.vl_valor, m.dt_entrada FROM MateriaPrima as m natural join fornecedor  as f natural join cor  as cc natural join aviamento as a where cd_aviamento <> '"
                    + 0 + "' order by dt_entrada ");
            
            while(con_produtoacbado1.resultset.next())
                
                // lblaviamento.setText(con_produtoacbado1.resultset.getString("nm_aviamento"));
                modelo.addRow(new Object []{numeroRegistros++,con_produtoacbado1.resultset.getString("nm_aviamento"), con_produtoacbado1.resultset.getString("nm_cor"),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_metro")),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_kilo")),con_produtoacbado1.resultset.getString("qt_peca"),con_produtoacbado1.resultset.getString("nm_tamanho"),
                converterDoubleString(con_produtoacbado1.resultset.getDouble("vl_valor")), con_produtoacbado1.resultset.getString("nm_razaosocial_fornecedor"),con_produtoacbado1.resultset.getString("cd_notafiscal"), new SimpleDateFormat("dd/MM/yyyy").format(con_produtoacbado1.resultset.getDate("dt_entrada"))});
            // modelo.addRow(new Object []{numeroRegistros++,cmbaviamento.getSelectedItem(), cmbcor.getSelectedItem(),cmbtamanho.getSelectedItem(),lblmetro.getText(),"0.00","0"});
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
            
            
        }
    }
    
    public void preenchejTablaTecido(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
        
        // modelo.setNumRows(0);
        // numeroRegistros=1;
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        
        
        
        try {
            con_produtoacbado1 = new conexao();
            con_produtoacbado1.conecta();
            con_produtoacbado1.executeSQL("Select  a.nm_tecido, cc.nm_cor, m.nm_tamanho, m.qt_metro, m.qt_kilo, m.qt_peca, m.cd_notafiscal,f.cd_fornecedor,f.nm_razaosocial_fornecedor, m.vl_valor, m.dt_entrada FROM MateriaPrima as m natural join fornecedor  as f natural join cor  as cc natural join tecido as a where cd_tecido <> '"
                    + 0 + "' order by dt_entrada");
            
            while(con_produtoacbado1.resultset.next())
                
                // lblaviamento.setText(con_produtoacbado1.resultset.getString("nm_aviamento"));
                modelo.addRow(new Object []{numeroRegistros++,con_produtoacbado1.resultset.getString("nm_tecido"), con_produtoacbado1.resultset.getString("nm_cor"),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_metro")),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_kilo")),con_produtoacbado1.resultset.getString("qt_peca"),con_produtoacbado1.resultset.getString("nm_tamanho"),
                converterDoubleString(con_produtoacbado1.resultset.getDouble("vl_valor")), con_produtoacbado1.resultset.getString("nm_razaosocial_fornecedor"),con_produtoacbado1.resultset.getString("cd_notafiscal"), new SimpleDateFormat("dd/MM/yyyy").format(con_produtoacbado1.resultset.getDate("dt_entrada"))});
            // modelo.addRow(new Object []{numeroRegistros++,cmbaviamento.getSelectedItem(), cmbcor.getSelectedItem(),cmbtamanho.getSelectedItem(),lblmetro.getText(),"0.00","0"});
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
            
            
        }
    }
    public void preenchejTablaTecidoSimples(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
       jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
        
        // modelo.setNumRows(0);
        // numeroRegistros=1;
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        
        
        
        try {
            con_produtoacbado1 = new conexao();
            con_produtoacbado1.conecta();
            con_produtoacbado1.executeSQL("Select  a.nm_tecido, cc.nm_cor, m.nm_tamanho, m.qt_metro, m.qt_kilo, m.qt_peca, m.cd_notafiscal,f.cd_fornecedor,f.nm_razaosocial_fornecedor, m.vl_valor, m.dt_entrada FROM MateriaPrima as m natural join fornecedor  as f natural join cor  as cc natural join tecido as a where cd_tecido = '"
                    + lblcodtecido.getText() + "' and cd_cor = '" + lblcodcor.getText() + "' order by dt_entrada");
            
            while(con_produtoacbado1.resultset.next())
                
                // lblaviamento.setText(con_produtoacbado1.resultset.getString("nm_aviamento"));
                modelo.addRow(new Object []{numeroRegistros++,con_produtoacbado1.resultset.getString("nm_tecido"), con_produtoacbado1.resultset.getString("nm_cor"),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_metro")),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_kilo")),con_produtoacbado1.resultset.getString("qt_peca"),con_produtoacbado1.resultset.getString("nm_tamanho"),
                converterDoubleString(con_produtoacbado1.resultset.getDouble("vl_valor")), con_produtoacbado1.resultset.getString("nm_razaosocial_fornecedor"),con_produtoacbado1.resultset.getString("cd_notafiscal"), new SimpleDateFormat("dd/MM/yyyy").format(con_produtoacbado1.resultset.getDate("dt_entrada"))});
            // modelo.addRow(new Object []{numeroRegistros++,cmbaviamento.getSelectedItem(), cmbcor.getSelectedItem(),cmbtamanho.getSelectedItem(),lblmetro.getText(),"0.00","0"});
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
            
            
        }
    }
    public void preenchejTablaAviamentoSimples(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
       jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
        
        // modelo.setNumRows(0);
        // numeroRegistros=1;
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        
        
        
        try {
            con_produtoacbado1 = new conexao();
            con_produtoacbado1.conecta();
            con_produtoacbado1.executeSQL("Select  a.nm_aviamento, cc.nm_cor, m.nm_tamanho, m.qt_metro, m.qt_kilo, m.qt_peca, m.cd_notafiscal,f.cd_fornecedor,f.nm_razaosocial_fornecedor, m.vl_valor, m.dt_entrada FROM MateriaPrima as m natural join fornecedor  as f natural join cor  as cc natural join aviamento as a where cd_aviamento = '"
                    + lblcodaviamento.getText()
                    + "' and cd_cor = '"
                    + lblcodcor.getText()
                    + "' order by dt_entrada");
            
            while(con_produtoacbado1.resultset.next())
                
                // lblaviamento.setText(con_produtoacbado1.resultset.getString("nm_aviamento"));
                modelo.addRow(new Object []{numeroRegistros++,con_produtoacbado1.resultset.getString("nm_aviamento"), con_produtoacbado1.resultset.getString("nm_cor"),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_metro")),converterDoubleString(con_produtoacbado1.resultset.getDouble("qt_kilo")),con_produtoacbado1.resultset.getString("qt_peca"),con_produtoacbado1.resultset.getString("nm_tamanho"),
                converterDoubleString(con_produtoacbado1.resultset.getDouble("vl_valor")), con_produtoacbado1.resultset.getString("nm_razaosocial_fornecedor"),con_produtoacbado1.resultset.getString("cd_notafiscal"), new SimpleDateFormat("dd/MM/yyyy").format(con_produtoacbado1.resultset.getDate("dt_entrada"))});
            // modelo.addRow(new Object []{numeroRegistros++,cmbaviamento.getSelectedItem(), cmbcor.getSelectedItem(),cmbtamanho.getSelectedItem(),lblmetro.getText(),"0.00","0"});
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
            
            
        }
    }
     public static String converterDoubleString(double precoDouble) {  
   /*Transformando um double em 2 casas decimais*/  
   DecimalFormat fmt = new DecimalFormat("0.00");    //limita o n�mero de casas decimais     
   String string = fmt.format(precoDouble);  
   String[] part = string.split("[,]");  
   String preco = part[0]+"."+part[1];  
   return preco;  
}  
    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
// TODO add your handling code here:
        if(cmbtipo.getSelectedItem().equals("AVIAMENTO") && rdbgeral.isSelected()==true){
            preenchejTablaAviamento();
            
        }
        if(cmbtipo.getSelectedItem().equals("TECIDO") && rdbgeral.isSelected()==true){
            preenchejTablaTecido();
            
        }
        if(cmbtipo.getSelectedItem().equals("TECIDO") && rdbsimples.isSelected()==true){
            preenchejTablaTecidoSimples();
            
        }
         if(cmbtipo.getSelectedItem().equals("AVIAMENTO") && rdbsimples.isSelected()==true){
            preenchejTablaAviamentoSimples();
            
        }
        
        
    }//GEN-LAST:event_btnconsultaActionPerformed
    public void preencheTabela(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(225);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
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
                new ConsultaEntradaMateriaPrima().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnlimpar;
    private javax.swing.JButton btnsair;
    private javax.swing.JComboBox cmbaviamento;
    private javax.swing.JComboBox cmbcontrole;
    private javax.swing.JComboBox cmbcor;
    private javax.swing.JComboBox cmbtecido;
    private javax.swing.JComboBox cmbtipo;
    private javax.swing.ButtonGroup consulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblaviamento;
    private javax.swing.JLabel lblcodaviamento;
    private javax.swing.JLabel lblcodcor;
    private javax.swing.JLabel lblcodtecido;
    private javax.swing.JLabel lblcor;
    private javax.swing.JLabel lbldata;
    private javax.swing.JLabel lblfornecedor;
    private javax.swing.JLabel lblkilo;
    private javax.swing.JLabel lblmetro;
    private javax.swing.JLabel lblnf;
    private javax.swing.JLabel lblpeca;
    private javax.swing.JLabel lbltamanho;
    private javax.swing.JLabel lbltecido;
    private javax.swing.JLabel lblvalor;
    private javax.swing.JRadioButton rdbgeral;
    private javax.swing.JRadioButton rdbsimples;
    // End of variables declaration//GEN-END:variables
    
}
