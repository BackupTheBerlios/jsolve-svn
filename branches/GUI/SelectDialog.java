/*
 * SelectDialog.java
 *
 * Created on 10 mei 2006, 14:33
 */

package GUI;

import Exercise.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author  Kurt Deklerck
 */
public class SelectDialog extends javax.swing.JDialog {
    
    private List<Exercise> sList;
    private List<String> types;
    private List<String> themes;
    //private javax.swing.JList selectNamenList;
    private GUImodel gModel;
    
    
    /** Creates new form SelectDialog */
    
    
    /**
     * TODO eventueel enkel namen meegeven, en dan namen adden, ipv namen eerst uit oefn halen
     */
    
    public SelectDialog(java.awt.Frame parent, boolean modal, List<Exercise> selectList,List<String> typeList, List<String> themeList, GUImodel model) {
        super(parent, modal);
        sList = selectList;
        types = typeList;
        themes = themeList;
        gModel = model;
        
        initComponents();
        /**
         * lijst met oefn weergeven, eerst model maken
         */
        DefaultListModel sModel = new DefaultListModel();
        if (selectList.size() >0){
            for (int i=0; i<selectList.size() ; i++)
                sModel.addElement(selectList.get(i).getTitle());
        }
        
        
        //selectNamenList = new javax.swing.JList(sModel);
        jList3.setModel(sModel);
        
         /**
         * lijst met types weergeven, eerst model maken
         */
        DefaultListModel tModel = new DefaultListModel();
        if (types.size() >0){
            for (int i=0; i<types.size() ; i++)
                tModel.addElement(types.get(i));
        }
        jList1.setModel(tModel);
        
         /**
         * lijst met thema's weergeven, eerst model maken
         */
        DefaultListModel themeModel = new DefaultListModel();
        if (themes.size() >0){
            for (int i=0; i<themes.size() ; i++)
                themeModel.addElement(themes.get(i));
        }
        
        jList2.setModel(tModel);
        
    }
    
    
    public boolean showInlogDialog(){
        
        // todo meerdere oefn openen
        
        int[] selected = jList3.getSelectedIndices();
        for(int i = 0; i <1 ; i ++){
            
        }
        setVisible(true);
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        filterPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jScrollPanelExercises = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        openButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecteer oefening");
        setModal(true);
        setName("selectDialog");
        getAccessibleContext().setAccessibleName("selectDialog");
        getAccessibleContext().setAccessibleParent(this);
        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Type:");

        jLabel2.setText("Genre:");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jButton1.setText("Filter");

        org.jdesktop.layout.GroupLayout filterPanelLayout = new org.jdesktop.layout.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 173, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 70, Short.MAX_VALUE)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(29, 29, 29))
        );

        filterPanelLayout.linkSize(new java.awt.Component[] {jScrollPane1, jScrollPane2}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(filterPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .add(jLabel2)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .add(jLabel1)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        filterPanelLayout.linkSize(new java.awt.Component[] {jScrollPane1, jScrollPane2}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPanelExercises.setViewportView(jList3);

        openButton.setText("Openen");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oefnOpenen(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPanelExercises, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, filterPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(229, 229, 229)
                .add(openButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .add(241, 241, 241))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(filterPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPanelExercises, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 393, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(openButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oefnOpenen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oefnOpenen
       
        // TODO  meerdere oefeningen openen
        DefaultListModel model = (DefaultListModel) jList3.getModel();
        int[] geselecteerdeIndexen = jList3.getSelectedIndices(); 
        List<String> selectedNamen = new ArrayList<String>();
        //String[] selectedNamen = (String[]) jList3.getSelectedValues();
        for( int i =0 ; i< geselecteerdeIndexen.length; i ++ ){
            String naam = (String) model.get(i);
            selectedNamen.add(naam);
        }
        
        gModel.addExercises( selectedNamen);
        setVisible(false);
    }//GEN-LAST:event_oefnOpenen
    
    /**
     * @param args the command line arguments
     */

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel filterPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPanelExercises;
    private javax.swing.JButton openButton;
    // End of variables declaration//GEN-END:variables
    
}
