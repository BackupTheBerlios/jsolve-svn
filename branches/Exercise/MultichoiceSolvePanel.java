package Exercise;

import java.util.List;

public class MultichoiceSolvePanel extends SolvePanel {
	
	
	/**
	 * Generated serialversion id
	 */
	private static final long serialVersionUID = -321090750862029735L;
	
	/**
	 * Constructor
	 */
	public MultichoiceSolvePanel(List<String> possibilities) {
		initComponents();
		jTextField1.setText(possibilities.get(0));
		jTextField2.setText(possibilities.get(1));
		jTextField3.setText(possibilities.get(2));
		jTextField4.setText(possibilities.get(3));
	}
	
	/**
	 * Returns the index of the selected checkbox/radiobutton
	 * @return selected index, starting by 0
	 */
	public int getSelected() {
		/**
         * hardcoded
         */
        int juist;
        if (jRadioButton1.isSelected()){
            juist = 1;
        }else if (jRadioButton2.isSelected()){
            juist = 2;
        }else if (jRadioButton3.isSelected()){
            juist = 3;
        }else {
            juist = 4;
        }
        return juist;
	}
	
	/**
	 * Initialises the components needed for the panel.
	 */
	private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel1.setText("Duid het juiste antwoord aan.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(113, 113, 113)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jRadioButton1)
                            .add(jRadioButton2)
                            .add(jRadioButton3)
                            .add(jRadioButton4))
                        .add(21, 21, 21)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))))
                .add(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jRadioButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jRadioButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jRadioButton3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jRadioButton4))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }
    
    /**
     * Variables for panelcomponents
     */
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel jTextField1;
    private javax.swing.JLabel jTextField2;
    private javax.swing.JLabel jTextField3;
    private javax.swing.JLabel jTextField4;
}
