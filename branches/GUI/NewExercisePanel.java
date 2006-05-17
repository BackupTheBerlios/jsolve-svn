/*
 * NewExercisPanel.java
 *
 * Created on 15 mei 2006, 0:50
 */

package GUI;

import Exercise.MultiCreateAnswerPanel;
import Exercise.MultichoiceExercise2;

/**
 *
 * @author  Kurt Deklerck
 */
public class NewExercisePanel extends javax.swing.JPanel {
    
    private GUImodel gModel;
    private MultichoiceExercise2 mEx;
    private HoofdVenster hoofdVenster;
    /** Creates new form NewExercisPanel */
    public NewExercisePanel(GUImodel guiModel, MultichoiceExercise2 mExercise, HoofdVenster hoofdV) {
        initComponents();
        gModel = guiModel; 
        mEx = mExercise;
        hoofdVenster = hoofdV;
        
        MultiCreateAnswerPanel answerPanel = mEx.getCreateAnswerPanel();
        jPanel3.add(answerPanel);
        
        /**
         *  Hardcoded:  MultichoiceExercise
         */
        
        // Bert
        //mEx.drawAddPanel(jPanel3);
        


//testPanel testP = new testPanel();
        //antwoordPanel.add(testP);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toevoegButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        titelLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        themaLabel = new javax.swing.JLabel();
        themaBox = new javax.swing.JComboBox();
        vraagLabel = new javax.swing.JLabel();
        antwoordLabel = new javax.swing.JLabel();
        vraagTextArea = new javax.swing.JTextArea();
        antwoordPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        toevoegButton.setText("Toevoegen");
        toevoegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oefeningToevoegen(evt);
            }
        });

        titelLabel.setText("Titel:");

        themaLabel.setText("Thema:");

        themaBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "algemeen", "java exceptions", "java syntax", "C++ syntax", "GUI" }));

        vraagLabel.setText("Vraag:");

        antwoordLabel.setText("Antwoord:");

        vraagTextArea.setColumns(20);
        vraagTextArea.setRows(5);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(antwoordLabel)
                    .add(vraagLabel)
                    .add(themaLabel)
                    .add(titelLabel))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(17, 17, 17)
                            .add(titleTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                            .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                            .add(themaBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 216, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(474, 474, 474)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(vraagTextArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 678, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(titelLabel)
                    .add(titleTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(themaLabel)
                    .add(themaBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vraagLabel)
                    .add(vraagTextArea, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(antwoordLabel)
                .add(113, 113, 113))
        );

        org.jdesktop.layout.GroupLayout antwoordPanelLayout = new org.jdesktop.layout.GroupLayout(antwoordPanel);
        antwoordPanel.setLayout(antwoordPanelLayout);
        antwoordPanelLayout.setHorizontalGroup(
            antwoordPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        antwoordPanelLayout.setVerticalGroup(
            antwoordPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(antwoordPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(20, 20, 20))
            .add(layout.createSequentialGroup()
                .add(249, 249, 249)
                .add(toevoegButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 272, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(antwoordPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(29, 29, 29)
                .add(toevoegButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void oefeningToevoegen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oefeningToevoegen
        /**
         * TODO nog extra gegevens doorzenden
         */ 
//        bert
//        mEx.putInput();
        
        gModel.saveNewExercise(titleTextField.getText(), (String) themaBox.getSelectedItem(), vraagTextArea.getText(),mEx.getPossibilities(),mEx.getCorrectSolution());
        hoofdVenster.clearScreen();
    }//GEN-LAST:event_oefeningToevoegen
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel antwoordLabel;
    private javax.swing.JPanel antwoordPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox themaBox;
    private javax.swing.JLabel themaLabel;
    private javax.swing.JLabel titelLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton toevoegButton;
    private javax.swing.JLabel vraagLabel;
    private javax.swing.JTextArea vraagTextArea;
    // End of variables declaration//GEN-END:variables
    
}
