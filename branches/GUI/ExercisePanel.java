/*
 * ExercisePanel.java
 *
 * 
 */
package GUI;

import Exercise.Exercise;
import GUImodel.GUImodel;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
/**
 *
 * 
 */
public class ExercisePanel extends javax.swing.JPanel {
    
    private GUImodel gModel;
    
    /** Creates new form ExercisePanel */
    public ExercisePanel(Exercise ex, GUImodel gModel) {
    	ex.init();
        initComponents();
        this.gModel = gModel; 
        titelLabel.setText(ex.getTitle());
        vraag.setText(ex.getQuestion());
        jPanel1.add(ex.createSolvePanel());
        validate();
        repaint();
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        titelLabel = new javax.swing.JLabel();
        vraag = new javax.swing.JLabel();
        antwoordLabel = new javax.swing.JLabel();
        vraagLabel = new javax.swing.JLabel();
        feedbackPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackList = new javax.swing.JList();
        antwoordPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        valideerButton = new javax.swing.JButton();

        titelLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        titelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titelLabel.setText("jLabel1");

        vraag.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        antwoordLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        antwoordLabel.setText("Antwoord:");

        vraagLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        vraagLabel.setText("Vraag:");

        feedbackPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Feedback"));
        jScrollPane1.setViewportView(feedbackList);

        org.jdesktop.layout.GroupLayout feedbackPanelLayout = new org.jdesktop.layout.GroupLayout(feedbackPanel);
        feedbackPanel.setLayout(feedbackPanelLayout);
        feedbackPanelLayout.setHorizontalGroup(
            feedbackPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        feedbackPanelLayout.setVerticalGroup(
            feedbackPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(feedbackPanelLayout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout antwoordPanelLayout = new org.jdesktop.layout.GroupLayout(antwoordPanel);
        antwoordPanel.setLayout(antwoordPanelLayout);
        antwoordPanelLayout.setHorizontalGroup(
            antwoordPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        antwoordPanelLayout.setVerticalGroup(
            antwoordPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(antwoordPanelLayout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        valideerButton.setText("Valideer");
        valideerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validate(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(antwoordLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(antwoordPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(vraagLabel)
                        .add(64, 64, 64)
                        .add(vraag, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(200, 200, 200)
                .add(valideerButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .add(239, 239, 239))
            .add(layout.createSequentialGroup()
                .add(feedbackPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(titelLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .add(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titelLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vraagLabel)
                    .add(vraag, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(antwoordLabel)
                    .add(antwoordPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(valideerButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(feedbackPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void validate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validate
        
        DefaultListModel lModel = new DefaultListModel();
        feedbackList.removeAll();
      
        List<String> comment = gModel.validate();
        for(int i = 0; i< comment.size(); i ++){
            lModel.addElement(comment.get(i));
        }
          feedbackList.setModel(lModel);
        
    }//GEN-LAST:event_validate
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel antwoordLabel;
    private javax.swing.JPanel antwoordPanel;
    private javax.swing.JList feedbackList;
    private javax.swing.JPanel feedbackPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titelLabel;
    private javax.swing.JButton valideerButton;
    private javax.swing.JLabel vraag;
    private javax.swing.JLabel vraagLabel;
    // End of variables declaration//GEN-END:variables
    
}
