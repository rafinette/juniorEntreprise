
package etudiant;

//import java.sql.*;
//import java.lang.Class.*;
//import oracle.jdbc.driver.OracleDriver;

public class BddConnect extends javax.swing.JFrame {
  
   
    public BddConnect() {
        initComponents();
        list1.setModel(listModel);
        setLocation(200, 150);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList();
        consultation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G E S T I O N       D E S       E M P L O Y E S");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(" empno       ename              job                     mgr             hiredate                 sal                   comm       deptno");

        list1.setBackground(new java.awt.Color(102, 204, 255));
        list1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(list1);

        consultation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        consultation.setText("consultation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(consultation, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultation)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ouvre une connexion stock�e dans la variable conn
 public void openConnection() throws java.sql.SQLException {
        
        String userid = "p0100081";   // A MODIFIER
        String password = "iut2012";  // A MODIFIER
        String URL = "jdbc:oracle:thin:@iuta.univ-lyon1.fr:1521:orcl";	// Adresse de l'hote distant
        java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        conn = java.sql.DriverManager.getConnection(URL, userid, password);

        if (conn == null) {
            listModel.addElement("Probleme de connection.");
            System.exit(1);
        }
    }

    public void closeConnection() throws java.sql.SQLException {
        conn.close();// Fermeture de la connection
    }
/**/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        //For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BddConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BddConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BddConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BddConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                //  try
                //   {
                //          javax.swing.UIManager.setLookAndFeel
                //            ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                //         ou ("com.sun.java.swing.plaf.classic.WindowsLookAndFeel");
                //         ou ("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                //         ou ("com.sun.java.swing.plaf.metal.MetalLookAndFeel");// par d�faut

                BddConnect essai = new BddConnect();
                essai.setVisible(true);
                //  } catch ( Exception e) { }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list1;
    // End of variables declaration//GEN-END:variables
    private javax.swing.DefaultListModel listModel = new javax.swing.DefaultListModel();
    private java.sql.Connection conn;
  
}

