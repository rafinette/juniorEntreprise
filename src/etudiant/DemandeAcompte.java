package etudiant;

/**
 *
 * Autheurs Rafaèle BONDAZ Mathieu PETINOT
 */
public class DemandeAcompte extends javax.swing.JFrame {

    public DemandeAcompte() {
        initComponents();
        setLocation(400, 200);
        setVisible(true); 
    }

    @SuppressWarnings("unchecked")
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        numconv = new javax.swing.JLabel();
        montant = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        valider = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DEMANDER UN ACOMPTE");

        numconv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numconv.setText("N° convention");

        montant.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        montant.setText("Montant demandé");

        valider.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valider.setText("OK");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider(evt);
            }
        });

        annuler.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        annuler.setText("Annuler");
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annuler(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("N°etudiant");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montant)
                    .addComponent(numconv)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numconv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annuler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annuler
       this.dispose();
    }//GEN-LAST:event_annuler

    private void valider(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider
    
    String c = jTextField1.getText();
    String a = jTextField2.getText();
    String login = jTextField3.getText();
    BddRequest r1 = new BddRequest();
    int numEtu = Integer.parseInt(login);
    int idEtude = Integer.parseInt(c);
    double ac = Double.parseDouble(a);

    if (!r1.conventionExist(idEtude)) {
        javax.swing.JOptionPane.showMessageDialog( this, "ce numero de convention n'éxiste pas",
        "ERREUR", javax.swing.JOptionPane.PLAIN_MESSAGE );
        
     }else {
        if (!r1.etudiantInEtudExist (numEtu, idEtude) ){
            javax.swing.JOptionPane.showMessageDialog( this, "Vous ne faite pas parti de cette étude",
            "ERREUR", javax.swing.JOptionPane.PLAIN_MESSAGE );
        }else {
            if ( !r1.acompteParEtudiant(numEtu,idEtude)){
            javax.swing.JOptionPane.showMessageDialog( this, "Vous avez dépassé le nombre d'acompte autorisé pour cette étude",
            "ERREUR", javax.swing.JOptionPane.PLAIN_MESSAGE );
            }else{
                if (!r1.pourcentageAcompteEtudiant (numEtu, idEtude, ac)){
                javax.swing.JOptionPane.showMessageDialog( this, "Vous avez dépassé le montant autorisé pour cette étude",
                "ERREUR", javax.swing.JOptionPane.PLAIN_MESSAGE );               
                }else{
                    //r1.acompteInsertion(numEtu, idEtude , ac);
                    javax.swing.JOptionPane.showMessageDialog( this, "Demande acceptée",
                    "VALIDATION", javax.swing.JOptionPane.PLAIN_MESSAGE );
                }
            }
        }       
    }  
        
  
    }//GEN-LAST:event_valider
      
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DemandeAcompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemandeAcompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemandeAcompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemandeAcompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemandeAcompte().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annuler;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel montant;
    private javax.swing.JLabel numconv;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
