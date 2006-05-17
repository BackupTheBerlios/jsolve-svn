package Exercise;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.jdesktop.layout.GroupLayout.ParallelGroup;
import org.jdesktop.layout.GroupLayout.SequentialGroup;

public class MultichoiceSolvePanel extends SolvePanel {
	
	
	/**
	 * Generated serialversion id
	 */
	private static final long serialVersionUID = -321090750862029735L;
	
	/**
	 * Constructor
	 */
	public MultichoiceSolvePanel(List<String> possibilities) {
		initComponents(possibilities.size());
		setPossibilities(possibilities);
	}
	
	public void setPossibilities(List<String> possibilities) {
		for (int i = 0; i < possibilities.size(); i++) {
			label[i].setText(possibilities.get(i));
		}
		
		validate();
		repaint();
	}
	
	/**
	 * Returns the index of the selected checkbox/radiobutton
	 * @return selected index, starting by 0
	 */
	public int getSelected() {
		for (int i = 0; i < radiobutton.length; i++) {
        	if (radiobutton[i].isSelected())
        		return i;
        }
        return 0;
	}
	
	/**
	 * Initialises the components needed for the panel.
	 */
	private void initComponents(int size) {
    	label = new JLabel[size];
    	radiobutton = new JRadioButton[size];
    	for (int i = 0; i < size; i++) {
    		label[i] = new JLabel();
    		radiobutton[i] = new JRadioButton();
    	}
    	
        buttonGroup = new ButtonGroup();
        infoLabel = new JLabel();

        for (int i = 0; i < radiobutton.length; i++) {
        	buttonGroup.add(radiobutton[i]);
        	radiobutton[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        	radiobutton[i].setMargin(new java.awt.Insets(0, 0, 0, 0));
        }

        infoLabel.setText("Duid het juiste antwoord aan.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        
        ParallelGroup pg1 = layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING);
        for (int i = 0; i < label.length; i++)
        	pg1.add(org.jdesktop.layout.GroupLayout.TRAILING, label[i], org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE);
        ParallelGroup pg2 = layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING);
        for (int i = 0; i < radiobutton.length; i++)
        	pg2.add(radiobutton[i]);
        SequentialGroup seq1 = layout.createSequentialGroup();
        seq1.add(113, 113, 113);
        seq1.add(pg2);
        seq1.add(21, 21, 21);
        seq1.add(pg1);
        SequentialGroup seq2 = layout.createSequentialGroup();
        seq2.addContainerGap();
        seq2.add(infoLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE);
        ParallelGroup pg3 = layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING);
        pg3.add(org.jdesktop.layout.GroupLayout.LEADING, seq2);
        pg3.add(seq1);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(pg3)
                    .add(58, 58, 58))
            );
        
        SequentialGroup seq3 = layout.createSequentialGroup();
        seq3.add(infoLabel);
        seq3.add(15, 15, 15);
        for (int i = 0; i < label.length; i++) {
        	seq3.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
        			.add(label[i], org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        			.add(radiobutton[i]));
        	if (i != label.length-1)
        		seq3.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED);
        	else
        		seq3.addContainerGap(45, Short.MAX_VALUE);
        }        
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(seq3));
    }
    
    /**
     * Variables for panelcomponents
     */
    private ButtonGroup buttonGroup;
    private JLabel infoLabel;
    private JRadioButton[] radiobutton;
    private JLabel[] label;
}
