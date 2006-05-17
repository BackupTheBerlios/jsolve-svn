package Exercise;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdesktop.layout.GroupLayout.ParallelGroup;
import org.jdesktop.layout.GroupLayout.SequentialGroup;

public class MultichoiceAddPanel extends AddPanel {
    
    /**
	 * Generated serialversion id
	 */
	private static final long serialVersionUID = -7974016593794838344L;
	private static final int AMOUNT = 10;
	
	/**
     * Constructor
     */
    public MultichoiceAddPanel() {
        initComponents();
    }
    
    /**
     * Returns the possible answers from which we can choose
     * @return list of possible answers as a list of strings
     */
    public List<String> getPossibilities(){
        List<String> output = new ArrayList<String>();
        
        for (int i = 0; i < textfield.length; i++)
        	output.add(textfield[i].getText());
        
        return output;
    }
    
    /**
     * Returns correct answer, starting with 0.
     * @return index (>= 0) of correct solution
     */
    public int getCorrectSolution(){
        for (int i = 0; i < radiobutton.length; i++) {
        	if (radiobutton[i].isSelected())
        		return i;
        }
        return 0;
    }
    
    /** 
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {
    	textfield = new JTextField[AMOUNT];
    	radiobutton = new JRadioButton[textfield.length];
    	for (int i = 0; i < textfield.length; i++) {
    		textfield[i] = new JTextField();
    		radiobutton[i] = new JRadioButton();
    	}
    	
        buttonGroup = new ButtonGroup();
        label = new JLabel();

        for (int i = 0; i < radiobutton.length; i++) {
        	buttonGroup.add(radiobutton[i]);
        	radiobutton[i].setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        	radiobutton[i].setMargin(new java.awt.Insets(0, 0, 0, 0));
        }

        label.setText("Vul verschillende opties in, in duid het juiste antwoord aan.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        
        ParallelGroup pg1 = layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING);
        for (int i = 0; i < textfield.length; i++)
        	pg1.add(org.jdesktop.layout.GroupLayout.TRAILING, textfield[i], org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE);
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
        seq2.add(label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE);
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
        seq3.add(label);
        seq3.add(15, 15, 15);
        for (int i = 0; i < textfield.length; i++) {
        	seq3.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
        			.add(textfield[i], org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        			.add(radiobutton[i]));
        	if (i != textfield.length-1)
        		seq3.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED);
        	else
        		seq3.addContainerGap(45, Short.MAX_VALUE);
        }        
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(seq3));
    }
    
    /**
     * Variables for panelcomponents.
     */
    private ButtonGroup buttonGroup;
    private JLabel label;
    private JRadioButton[] radiobutton;
    private JTextField[] textfield;   
}
