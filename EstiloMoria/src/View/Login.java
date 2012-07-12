/*
 * Login.java
 *
 * Created on 14 de Setembro de 2011, 14:27
 */

package View;
import Controle.conexao;
import Utilitarios.data;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import Modelo.*;
import Utilitarios.EncriptaSenha;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
/**
 *
 * @author  Familia-Silva
 */
public class Login extends javax.swing.JFrame {
    private conexao con_login;
    private int conta=0;
    
    /** Creates new form Login */
    public Login() {
        initComponents();
        txtnome.setVisible(false);
        btnconsulta1.setVisible(true);
        btnconsulta.setVisible(true);
        txtsenha1.setVisible(true);
        con_login = new conexao();
        con_login.conecta();
        txtsenha1.setText("");
        txtsenha1.setVisible(true);
        
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtsenha1 = new javax.swing.JPasswordField();
        btnconsulta = new java.awt.Button();
        btnconsulta1 = new java.awt.Button();
        lblimagem = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(txtusuario);
        txtusuario.setBounds(60, 70, 190, 20);

        jLabel1.setText("Usu�rio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 73, 60, 14);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 100, 60, 14);
        getContentPane().add(txtsenha1);
        txtsenha1.setBounds(60, 100, 190, 20);

        btnconsulta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnconsulta.setLabel("Acessar");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btnconsulta);
        btnconsulta.setBounds(60, 130, 80, 30);

        btnconsulta1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnconsulta1.setLabel("Sair");
        btnconsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsulta1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnconsulta1);
        btnconsulta1.setBounds(150, 130, 80, 30);

        lblimagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/fundo login9.jpg"))); // NOI18N
        getContentPane().add(lblimagem);
        lblimagem.setBounds(0, 0, 260, 170);

        txtnome.setText("jTextField1");
        getContentPane().add(txtnome);
        txtnome.setBounds(70, 0, 59, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-267)/2, (screenSize.height-198)/2, 267, 198);
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsulta1ActionPerformed
// TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnconsulta1ActionPerformed
        
    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        
        if(txtusuario.getText().equals("")||txtsenha1.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Campo usu�rio ou senha n�o podem ser vazio!");
        
        else {
            if (conta <= 1) {
                try {
                    String sql = "select * from login Where nm_usuario like '"+
                            txtusuario.getText()+"' and cd_senha like '"+
                       EncriptaSenha.encripta(txtsenha1.getText())+"'";
                    con_login.executeSQL(sql);
                    
                    if (con_login.resultset.first()) {
                        txtnome.setText(con_login.resultset.getString("nm_operador"));
                        JOptionPane.showMessageDialog(null,"Ol�, Bom trabalho  "+txtnome.getText() );
                        txtusuario.setText("");
                        txtsenha1.setText("");
                        new Principal().show();
                        
                        Principal.lblusuario.setText(con_login.resultset.getString("nm_operador"));
                        //txtnome.setText(Principal.lblusuario.getText());
                        dispose();
                    } else {
                        conta++;
                        if (conta == 1){
                            txtusuario.setText("");
                            txtsenha1.setText("");
                            JOptionPane.showMessageDialog(null,"Usu�rio ou Senha Incorreta.\n\n Voc� s� tem mais uma tentiva.");
                        } else {
                            txtusuario.setText("");
                            txtsenha1.setText("");
                            
                            JOptionPane.showMessageDialog(null,"Usu�rio n�o autorizada h� utilizar o Sistema.\n\n O Sistema ser� finalizado.");
                            dispose();
                        }
                    }
                    
                } catch(SQLException erro) {
                    
                }
            }
        }
    }//GEN-LAST:event_btnconsultaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtsenha1.setVisible(true);
    }//GEN-LAST:event_formWindowOpened
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnconsulta;
    private java.awt.Button btnconsulta1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblimagem;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha1;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
    
}