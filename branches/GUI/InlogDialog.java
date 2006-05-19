/*
 * InlogDialog.java
 *
 * 
 */

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 
 */
public class InlogDialog extends javax.swing.JDialog {
    
    private javax.swing.JButton lastPressed;
    
    
    /** Creates new form InlogDialog */
    public InlogDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    
    
    
    /**
     *  toont dialog, geeft 0 terug als dialog gesloten werd
     *                      1 als leerkrachtButton
     *                      2 als leerling
     */  
    public int showInlogDialog(){
        lastPressed = null;
        int status = 0;
        setVisible(true);
        if (lastPressed == leerkrachtButton)
            status = 1;
        else if(lastPressed == leerlingButton)
            status = 2;    
        
        return status;
    }
    
  
    
   
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        leerlingButton = new javax.swing.JButton();
        leerkrachtButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inlog");
        setModal(true);
        getAccessibleContext().setAccessibleParent(this);
        leerlingButton.setText("Leerling");
        leerlingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inlogButtonKlikAction2(evt);
            }
        });

        leerkrachtButton.setText("Leerkracht");
        leerkrachtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inlogButtonKlikAction(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(105, 105, 105)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, leerkrachtButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, leerlingButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .add(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(84, 84, 84)
                .add(leerlingButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(leerkrachtButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {leerkrachtButton, leerlingButton}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inlogButtonKlikAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inlogButtonKlikAction
         lastPressed =(javax.swing.JButton) evt.getSource();
         setVisible (false);
    }//GEN-LAST:event_inlogButtonKlikAction

    private void inlogButtonKlikAction2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inlogButtonKlikAction2
         lastPressed =(javax.swing.JButton) evt.getSource();
         setVisible (false);
    }//GEN-LAST:event_inlogButtonKlikAction2
    

    
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton leerkrachtButton;
    private javax.swing.JButton leerlingButton;
    // End of variables declaration//GEN-END:variables
    
}
