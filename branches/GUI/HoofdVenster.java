

package GUI;




import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.util.List;
import Exercise.*;

/*
 * window.java
 *
 * Created on 10 mei 2006, 12:44
 */

/**
 *
 * @author  Kurt Deklerck
 */
public class HoofdVenster extends javax.swing.JFrame implements ChangeListener{
    
    private boolean teacherMode;
    private GUImodel gModel;
    private List<String> nameList;
    
    
    


    
    
    
    /** Creates new form window */
    public HoofdVenster(GUImodel model) {
        initComponents();        
        
        // navigatePanel onzichtbaar maken en seperater
        navigatePanel.setVisible(false);
        jSeparator1.setVisible(false);
        
        
        
        
//        
//        testPanel tPanel = new testPanel();
//        test2Panel t2Panel = new test2Panel();
//        
//        exercisePanel.add(t2Panel);
//        
//        MultichoiceExercise2 mEx = new MultichoiceExercise2();
//        MultiCreateAnswerPanel answerPanel = mEx.getCreateAnswerPanel();
//        exercisePanel.add(answerPanel);
        
        
        
        
        /**
         * TODO  oefn Oplossen
         */
        //OplosMenuItem.setVisible(false);
        
        
        
        
        /**
         * registreerd model bij het GUImodel
         */
        gModel = model;
        gModel.addChangeListener(this);
        
        
        /**
         * inlogDialog weergeven
         */
        gModel.showInlogDialog(this);
       

        /**
         * initialiseer mogelijke type menuItems
         */
        initialiseerTypeMenuItems();
       
        this.setVisible(true);
    }
    
    
    public void stateChanged(ChangeEvent e){
        editorMenu.setVisible(gModel.getTeacherMode());
        if ( gModel.getLastShowedExercise()!= gModel.getActiveExercise()){
            Exercise ex = gModel.getActiveExercise();
            showExercise(ex);
        }
        
        if (gModel.getLastShowedExercise() != null){
            saveMenuItem.setVisible(true);
        }
    }
    
    
    /**
     *  geeft oefening weer in hoofdpaneel
     */
    public void showExercise(Exercise ex){
        //ExercisePanel ePanel = new ePanel(ex.getTitle()), ex.getQuestion(), ex.getAnswerPanel()};
//        gModel.setNewExercisePanel(ePanel);
        //hoofdPaneel = ePanel;
          
    }
    
    public HoofdVenster getThisVenster(){
        return this;
    }
    
    /**
     *  methode zorgt dat het hoofdpaneel helemaal leeg is
     */ 
    public void clearScreen(){
        jSeparator1.setVisible(false);
        navigatePanel.setVisible(false);
        exercisePanel.removeAll();
        validate();
    }
    
    
    
    /**
     * initialiseer mogelijke type menuItems
     */
    private void initialiseerTypeMenuItems(){
        nameList = gModel.getOefnTypes();
        for (int i = 0 ; i < nameList.size(); i ++){
            javax.swing.JMenuItem item = new javax.swing.JMenuItem(nameList.get(i));
            item.addActionListener(new typeOefnListener());
            nieuweOefnMenu.add(item);
        }
    }
        
       
    
    
    /**
     * luisteraar bij de Type Oefeningen menu items
     * vraagt juiste NewExercisePanel, en plaatst die dan in het hoofdpaneel
     */
    private class typeOefnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            NewExercisePanel newExPanel = gModel.createNewExercisePanel(e, getThisVenster());
            exercisePanel.removeAll();
            exercisePanel.add(newExPanel);
            
//        MultichoiceExercise2 mEx = new MultichoiceExercise2();
//        MultiCreateAnswerPanel answerPanel = mEx.getCreateAnswerPanel();
//        exercisePanel.add(answerPanel);
            
            
           // exercisePanel.setLayout(new FlowLayout()); //.add(newExPanel);
            //
//            org.jdesktop.layout.GroupLayout hoofdPaneelLayout = new org.jdesktop.layout.GroupLayout(hoofdPaneel);
//            hoofdPaneel.setLayout(hoofdPaneelLayout);
//            hoofdPaneelLayout.setHorizontalGroup(
//                hoofdPaneelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//                .add(hoofdPaneelLayout.createSequentialGroup()
//                    .add(newExPanel)
//                    .addContainerGap(922, Short.MAX_VALUE))
//            );
//            hoofdPaneelLayout.setVerticalGroup(
//                hoofdPaneelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
//                .add(hoofdPaneelLayout.createSequentialGroup()
//                    .add(newExPanel)
//                    .addContainerGap(761, Short.MAX_VALUE))
//            );
//            hoofdPaneel.validate();
            
        }
    }
    
    
    
    private class navigateListener implements ActionListener{
        private String command;
        public navigateListener(String com){
            command = com;
        } 
        public void actionPerformed(java.awt.event.ActionEvent e){
                gModel.navigate(e, command);
            }
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        hoofdPaneel = new javax.swing.JPanel();
        exercisePanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        navigatePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        oefeningMenu = new javax.swing.JMenu();
        OplosMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAllMenuItem = new javax.swing.JMenuItem();
        loadMenuItem = new javax.swing.JMenuItem();
        inlogMenuItem = new javax.swing.JMenuItem();
        editorMenu = new javax.swing.JMenu();
        nieuweOefnMenu = new javax.swing.JMenu();
        aanpasMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        infoMenuItem = new javax.swing.JMenuItem();
        onlineHelpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("J-Solve");
        exercisePanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                compAdded(evt);
            }
        });

        jButton1.setText("<< vorige");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("volgende >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout navigatePanelLayout = new org.jdesktop.layout.GroupLayout(navigatePanel);
        navigatePanel.setLayout(navigatePanelLayout);
        navigatePanelLayout.setHorizontalGroup(
            navigatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, navigatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(621, 621, 621)
                .add(jButton2)
                .addContainerGap())
        );
        navigatePanelLayout.setVerticalGroup(
            navigatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.BASELINE, navigatePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton2))
        );

        org.jdesktop.layout.GroupLayout hoofdPaneelLayout = new org.jdesktop.layout.GroupLayout(hoofdPaneel);
        hoofdPaneel.setLayout(hoofdPaneelLayout);
        hoofdPaneelLayout.setHorizontalGroup(
            hoofdPaneelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(navigatePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
            .add(exercisePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        hoofdPaneelLayout.setVerticalGroup(
            hoofdPaneelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, hoofdPaneelLayout.createSequentialGroup()
                .add(exercisePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(navigatePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        oefeningMenu.setMnemonic('o');
        oefeningMenu.setText("Oefening");
        OplosMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OplosMenuItem.setText("Oefening oplossen");
        OplosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oefnOplossen(evt);
            }
        });

        oefeningMenu.add(OplosMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("Oefening opslaan");
        saveMenuItem.setEnabled(false);
        oefeningMenu.add(saveMenuItem);

        saveAllMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        saveAllMenuItem.setText("Alle oefeningen opslaan");
        saveAllMenuItem.setEnabled(false);
        oefeningMenu.add(saveAllMenuItem);

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadMenuItem.setText("Oefeningen laden");
        loadMenuItem.setEnabled(false);
        oefeningMenu.add(loadMenuItem);

        inlogMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        inlogMenuItem.setText("Inloggen");
        inlogMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opnieuwInloggen(evt);
            }
        });

        oefeningMenu.add(inlogMenuItem);

        menuBar.add(oefeningMenu);

        editorMenu.setMnemonic('E');
        editorMenu.setText("Editor");
        nieuweOefnMenu.setText("Cre\u00eber nieuwe oefening");
        editorMenu.add(nieuweOefnMenu);

        aanpasMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        aanpasMenuItem.setText("Oefening wijzigen");
        aanpasMenuItem.setEnabled(false);
        editorMenu.add(aanpasMenuItem);

        removeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        removeMenuItem.setText("Oefening verwijderen");
        removeMenuItem.setEnabled(false);
        editorMenu.add(removeMenuItem);

        menuBar.add(editorMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");
        infoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        infoMenuItem.setText("Info");
        infoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInfoDialog(evt);
            }
        });

        helpMenu.add(infoMenuItem);

        onlineHelpMenuItem.setText("Online help raadplegen");
        onlineHelpMenuItem.setEnabled(false);
        helpMenu.add(onlineHelpMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(hoofdPaneel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(hoofdPaneel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_compAdded
        validate();
    }//GEN-LAST:event_compAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        gModel.navigate(evt, "volgende");
        validate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gModel.navigate(evt, "vorige");
        validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showInfoDialog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInfoDialog
        gModel.showInfoDialog(this);
        validate();
    }//GEN-LAST:event_showInfoDialog

    private void oefnOplossen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oefnOplossen
        gModel.showSelectDialog(this); 
        validate();
    }//GEN-LAST:event_oefnOplossen

    private void opnieuwInloggen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opnieuwInloggen
          gModel.opnieuwInloggen(evt);
          clearScreen();
//        if (iDialog.showInlogDialog()){
//            gModel.setTeacherMode(true);  
//        }else 
//            gModel.setTeacherMode(false);
    }//GEN-LAST:event_opnieuwInloggen
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUI().setVisible(true);
//            }
//        });
//    }
     
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OplosMenuItem;
    private javax.swing.JMenuItem aanpasMenuItem;
    private javax.swing.JMenu editorMenu;
    private javax.swing.JPanel exercisePanel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel hoofdPaneel;
    private javax.swing.JMenuItem infoMenuItem;
    private javax.swing.JMenuItem inlogMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel navigatePanel;
    private javax.swing.JMenu nieuweOefnMenu;
    private javax.swing.JMenu oefeningMenu;
    private javax.swing.JMenuItem onlineHelpMenuItem;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem saveAllMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    
}

       




















