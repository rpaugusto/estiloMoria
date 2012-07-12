/*
 * ConsultaProdutoAcabado.java
 *
 * Created on 7 de Setembro de 2011, 11:55
 */

package View;

import Controle.conexao;
import Utilitarios.*;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.lang.Integer;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Familia-Silva
 */
public class ConsultaBalanco extends javax.swing.JFrame {
    private conexao con_produto, con_cor, con_cliente,con_cliente1,con_telefone, con_email,con_produtoacbado1,con_produtoacbado2,con_produtoacbado3,con_produtoacbado4,con_produtoacbado,con_produtoacbado5,con_produtoacbado6;
    private int numeroRegistros = 1;
    private int iniciacombo=0;
    
    
    /** Creates new form ConsultaProdutoAcabado */
    public ConsultaBalanco() {
        initComponents();
        
        //colorir a linha selecionada
        //jTable1.setSelectionBackground(Color.YELLOW);
       
        //iniciada essa classe para utilizar cores alternadas na jtable1
        
        jTable1.setDefaultRenderer(Object.class, new ColorRenderer());
        
        con_cliente=new conexao();
        con_cliente.conecta();
        con_cliente1=new conexao();
        con_cliente1.conecta();
        con_cor=new conexao();
        con_cor.conecta();
        preencheTabela();
        enter();
        setResizable(false);
        
        
        
        
        
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblsaldo = new javax.swing.JLabel();
        lblsaldo1 = new javax.swing.JLabel();
        lblsaldo2 = new javax.swing.JLabel();
        lblsaldo3 = new javax.swing.JLabel();
        lblsaldo4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balan\u00e7o Produto Acabado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseMoved(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Produto", "Cor", "P", "M", "G", "GG", "EG", "EXG", "T. Pe�as", "V. Unit.", "V. Total"
            }
        ));
        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jTable1MouseWheelMoved(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTable1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable1MouseMoved(evt);
            }
        });
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 850, 500);

        lblsaldo.setFont(new java.awt.Font("Tahoma", 3, 18));
        lblsaldo.setText("jLabel1");
        getContentPane().add(lblsaldo);
        lblsaldo.setBounds(550, 530, 150, 20);

        lblsaldo1.setFont(new java.awt.Font("Tahoma", 3, 18));
        lblsaldo1.setText("jLabel1");
        getContentPane().add(lblsaldo1);
        lblsaldo1.setBounds(210, 530, 150, 20);

        lblsaldo2.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblsaldo2.setText("Valor Estoque (R$): ");
        getContentPane().add(lblsaldo2);
        lblsaldo2.setBounds(10, 380, 140, 17);

        lblsaldo3.setFont(new java.awt.Font("Tahoma", 3, 18));
        lblsaldo3.setText("Pe\u00e7as em Estoque: ");
        getContentPane().add(lblsaldo3);
        lblsaldo3.setBounds(10, 530, 180, 20);

        lblsaldo4.setFont(new java.awt.Font("Tahoma", 3, 18));
        lblsaldo4.setText("Valor do Estoque - R$");
        getContentPane().add(lblsaldo4);
        lblsaldo4.setBounds(340, 530, 210, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(670, 520, 90, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton2);
        jButton2.setBounds(770, 520, 80, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-873)/2, (screenSize.height-590)/2, 873, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
         ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
        jTable1.updateUI();
        numeroRegistros=1;
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        con_cliente.executeSQL("Select  a.nm_produto, cc.nm_cor, m.qt_p, m.qt_m, m.qt_g, m.qt_gg, m.qt_eg, m.qt_exg, m.vl_unitario FROM produtoacabado as m natural join cor  as cc natural join produto as a where cd_produto <> '"
                +0+ "' order by nm_produto");
        
        try {
            
            while(con_cliente.resultset.next())
                
                modelo.addRow(new Object []{numeroRegistros++, con_cliente.resultset.getString("nm_produto"),con_cliente.resultset.getString("nm_cor"),con_cliente.resultset.getInt("qt_p"),con_cliente.resultset.getInt("qt_m"),con_cliente.resultset.getInt("qt_g"),con_cliente.resultset.getInt("qt_gg"),con_cliente.resultset.getInt("qt_eg"),con_cliente.resultset.getInt("qt_exg"), "",converterDoubleString(con_cliente.resultset.getDouble("vl_unitario"))});
            
            
            int total = 0;
            int total1 = 0;
            double total3 = 0;
            
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                total = Integer.parseInt(jTable1.getValueAt(i, 3).toString())+ Integer.parseInt(jTable1.getValueAt(i, 4).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 5).toString())+ Integer.parseInt(jTable1.getValueAt(i, 6).toString())+ Integer.parseInt(jTable1.getValueAt(i, 7).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 8).toString());
                
                jTable1.setValueAt(total,i,9);
                
                double total2 = 0;
                total2 = (Integer.parseInt(jTable1.getValueAt(i, 3).toString())+ Integer.parseInt(jTable1.getValueAt(i, 4).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 5).toString())+ Integer.parseInt(jTable1.getValueAt(i, 6).toString())+ Integer.parseInt(jTable1.getValueAt(i, 7).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 8).toString())) * Double.parseDouble(jTable1.getValueAt(i, 10).toString()) ;
                
                jTable1.setValueAt((converterDoubleString(total2)),i,11);
                
                
                total3 += Double.parseDouble(jTable1.getValueAt(i, 11)
                .toString());
                total1 += Integer.parseInt(jTable1.getValueAt(i, 9)
                .toString());
                
            }
            lblsaldo.setText(String.valueOf(converterDoubleString(total3)));
            lblsaldo1.setText(String.valueOf((total1)));
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
// TODO add your handling code here:
        //   jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1FocusLost
    
    public static long carregarMemoria(){
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<1000000; i++){
            list.add(i);
        }
        return Runtime.getRuntime().freeMemory();
    }
    
    private void jTable1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jTable1MouseWheelMoved
// TODO add your handling code here:
        //     jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseWheelMoved
    
    private void jTable1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseMoved
// TODO add your handling code here:
        //     jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseMoved
    
    private void jScrollPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseMoved
// TODO add your handling code here:
        //  jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jScrollPane1MouseMoved
    
    private void jTable1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseDragged
// TODO add your handling code here:
        //   jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseDragged
    
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
// TODO add your handling code here:
        //     jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseReleased
    
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
// TODO add your handling code here:
        //     jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MousePressed
    
    private void jTable1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseExited
// TODO add your handling code here:
        //  jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseExited
    
    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
// TODO add your handling code here:
        
        
        //jTable1.setBackground(getBackground().YELLOW);
    }//GEN-LAST:event_jTable1MouseEntered
    public void meta(){
        int row=0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (row % 2 == 0) {
                jTable1.setBackground(Color.red);
                
//            if((jTable1.getValueAt(i, 9).toString().equals(2))){
//                 //  jTable1.setValueAt(getBackground().yellow, i, 9);
//                 //jTable1.setSelectionBackground(Color.YELLOW);
//                  jTable1.setValueAt(getBackground().BLUE, i,9);
//                 jTable1.setBackground(getBackground().red);
//
//            }
            }
        }
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
//        meta();
        
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// TODO add your handling code here:
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        con_cliente.executeSQL("Select  a.nm_produto, cc.nm_cor, m.qt_p, m.qt_m, m.qt_g, m.qt_gg, m.qt_eg, m.qt_exg, m.vl_unitario FROM produtoacabado as m natural join cor  as cc natural join produto as a where cd_produto <> '"
                +0+ "' order by nm_produto");
        
        try {
            
            while(con_cliente.resultset.next())
                
                modelo.addRow(new Object []{numeroRegistros++, con_cliente.resultset.getString("nm_produto"),con_cliente.resultset.getString("nm_cor"),con_cliente.resultset.getInt("qt_p"),con_cliente.resultset.getInt("qt_m"),con_cliente.resultset.getInt("qt_g"),con_cliente.resultset.getInt("qt_gg"),con_cliente.resultset.getInt("qt_eg"),con_cliente.resultset.getInt("qt_exg"), "",converterDoubleString(con_cliente.resultset.getDouble("vl_unitario"))});
            
            
            int total = 0;
            int total1 = 0;
            double total3 = 0;
            
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                total = Integer.parseInt(jTable1.getValueAt(i, 3).toString())+ Integer.parseInt(jTable1.getValueAt(i, 4).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 5).toString())+ Integer.parseInt(jTable1.getValueAt(i, 6).toString())+ Integer.parseInt(jTable1.getValueAt(i, 7).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 8).toString());
                
                jTable1.setValueAt(total,i,9);
      
                double total2 = 0;
                total2 = (Integer.parseInt(jTable1.getValueAt(i, 3).toString())+ Integer.parseInt(jTable1.getValueAt(i, 4).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 5).toString())+ Integer.parseInt(jTable1.getValueAt(i, 6).toString())+ Integer.parseInt(jTable1.getValueAt(i, 7).toString())
                + Integer.parseInt(jTable1.getValueAt(i, 8).toString())) * Double.parseDouble(jTable1.getValueAt(i, 10).toString()) ;
                
                jTable1.setValueAt((converterDoubleString(total2)),i,11);
                
                
                total3 += Double.parseDouble(jTable1.getValueAt(i, 11)
                .toString());
                total1 += Integer.parseInt(jTable1.getValueAt(i, 9)
                .toString());
                
            }
            lblsaldo.setText(String.valueOf(converterDoubleString(total3)));
            lblsaldo1.setText(String.valueOf((total1)));
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
        
        
        
    }//GEN-LAST:event_formWindowOpened
    public static String converterDoubleString(double precoDouble) {
        /*Transformando um double em 2 casas decimais*/
        DecimalFormat fmt = new DecimalFormat("0.00");    //limita o n�mero de casas decimais
        String string = fmt.format(precoDouble);
        String[] part = string.split("[,]");
        String preco = part[0]+"."+part[1];
        return preco;
    }    public void preencheTabela(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(62);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);
        
        modelo.setNumRows(0);
        
        numeroRegistros=1;
    }        public void preenchejTabla1(){
        final DefaultTableModel modelo = (DefaultTableModel)jTable1.getModel();
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(62);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);
        
        // modelo.setNumRows(0);
        // numeroRegistros=1;
        con_produtoacbado1 = new conexao();
        con_produtoacbado1.conecta();
        
        con_produtoacbado2 = new conexao();
        con_produtoacbado2.conecta();
        
        con_produtoacbado3 = new conexao();
        con_produtoacbado3.conecta();
        
        con_produtoacbado4 = new conexao();
        con_produtoacbado4.conecta();
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        try {
            con_cliente= new conexao();
            con_cliente.conecta();
//            con_cliente.executeSQL("Select  a.nm_produto, cc.nm_cor, m.qt_p, m.qt_m, m.qt_g, m.qt_gg, m.qt_eg, m.qt_exg FROM produtoacabado as m natural join cor  as cc natural join produto as a where cd_produto = '"
//                    +lblcodproduto.getText()+ "' order by nm_cor");
            
            while(con_cliente.resultset.next())
                
                modelo.addRow(new Object []{numeroRegistros++, con_cliente.resultset.getString("nm_produto"),con_cliente.resultset.getString("nm_cor"),con_cliente.resultset.getInt("qt_p"),con_cliente.resultset.getInt("qt_m"),con_cliente.resultset.getInt("qt_g"),con_cliente.resultset.getInt("qt_gg"),con_cliente.resultset.getInt("qt_eg"),con_cliente.resultset.getInt("qt_exg")});
            
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"N�o localizou dados "+erro);
        }
        
//
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }//Essas duas linhas � neces�ria
    }
    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
// TODO add your handling code here:
        // jTable1.setBackground(getBackground().YELLOW);
        
    }//GEN-LAST:event_jTable1FocusGained
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaBalanco().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JLabel lblsaldo1;
    private javax.swing.JLabel lblsaldo2;
    private javax.swing.JLabel lblsaldo3;
    private javax.swing.JLabel lblsaldo4;
    // End of variables declaration//GEN-END:variables
    
}
