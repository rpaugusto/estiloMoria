/*
 * BackUpBanco.java
 *
 * Created on 29 de Setembro de 2011, 10:20
 */

package View;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author  Familia-Silva
 */
public class BackUpBanco extends javax.swing.JFrame {
    
    /** Creates new form BackUpBanco */
    public BackUpBanco() {
        initComponents();
        setResizable(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        btnconsulta = new java.awt.Button();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Back Up - DB");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Back Up - Stillo Mori\u00e1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 200, 14);

        btnconsulta.setFont(new java.awt.Font("Dialog", 1, 12));
        btnconsulta.setLabel("Inicializar");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });

        getContentPane().add(btnconsulta);
        btnconsulta.setBounds(60, 60, 80, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-217)/2, (screenSize.height-146)/2, 217, 146);
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
       
                        String nome = "Deseja realizar o Back Up do Banco de Dados agora?";
                        int opcao_escolha = JOptionPane.showConfirmDialog(null,nome,"Aten��o", JOptionPane.YES_NO_OPTION);
                        if(opcao_escolha==JOptionPane.YES_OPTION){
                            
                            try {
// TODO add your handling code here:
                              
                                //Runtime.getRuntime().exec("C:\\Program Files (x86)\\PostgreSQL\\9.0\\bin\\pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -v -f C:\\BackupBanco\\Moria.backup Moria1" ).getInputStream();
                                Runtime.getRuntime().exec("C:\\Arquivos de Programas\\PostgreSQL\\9.0\\bin\\pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -v -f C:\\BackupBanco\\Moria.backup Moria1" ).getInputStream();
                                JOptionPane.showMessageDialog(null,"Back Up Moria.backup gerado com sucesso!");
                              
                            } catch (IOException ex) {
                              //  ex.printStackTrace();
                                
                                JOptionPane.showMessageDialog(null,"O BackUp S� pode ser realizado pelo PC Principal.");
                                
                            }
                            
                            
                        }else{
                        
                        dispose();
                   
        }
    }//GEN-LAST:event_btnconsultaActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackUpBanco().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnconsulta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
