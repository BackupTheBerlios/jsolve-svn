
package Exercise;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Subclass of exercise specificly for multiple choise exercises.
 */
public class MultichoiceExercise extends Exercise {

/**
 * <p>The list of possible answers.</p>
 * 
 */
    private List<String> possibilities;

/**
 * <p>Represents the index of the right answer in the list.</p>
 * 
 */
    private int correctSolution;
   
    private List<JCheckBox> chkbox;
    
    
/**
 * <p>Constructor</p>
 */
    public MultichoiceExercise(String title, String theme, String question, List<String> possibilities, int correctSolution)
    {
    	super(title,theme,question);
    	this.possibilities = possibilities;
    	this.correctSolution = correctSolution;
    }
    
/**
 * Returns the list of answer possibilities.
 */
    public List<String> getPossibilities() {
    	return possibilities;
    }
    
/**
 * Returns the index of the correct solution.
 */
    public int getCorrectSolution() {
    	return correctSolution;
    }

/**
 * <p>Tests if the given answer is true and calls the right tests.</p>
 */
    public List<String> validate() {
    	List<String> output = new ArrayList<String>();
    	
    	if (chkbox.get(correctSolution).isSelected())
    	    output.add("Uw antwoord is juist.");
    	else
    		output.add("Uw antwoord is verkeerd.");
    	
        return output;
    }
    
/**
 * <p>Draws the answer panel of the exercise</p>
 */
	public void drawSolvePanel(JPanel panel) {
		chkbox = new ArrayList<JCheckBox>();
		
		for (int i = 0; i < possibilities.size(); i++) {
			JCheckBox box = new JCheckBox();
			box.setText(possibilities.get(i));
			box.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			box.setMargin(new Insets(0, 0, 0, 0));
			chkbox.add(box);
			panel.add(box);
		}	
		
		panel.validate();
	}
	
	/**
	 * <p>Draws the add panel of the exercise</p>
	 */
	public void drawAddPanel(JPanel panel) {		
		final JTextField[] txtfield = new JTextField[10];
		for (int i = 0; i < txtfield.length; i++) {
			txtfield[i] = new JTextField();
		}
		for (int i = 0; i < txtfield.length; i++) {
			txtfield[i].setText("");
			panel.add(txtfield[i]);
		}
		
		JButton btnAdd = new JButton();
		btnAdd.setText("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					if (!txtfield[i].getText().equals(""))
						possibilities.add(txtfield[i].getText());
				}
			}
		});
		panel.add(btnAdd);
		
		final JTextField correctone = new JTextField();
		panel.add(correctone);
		JButton btnAddSol = new JButton();
		btnAddSol.setText("add solution");
		btnAddSol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correctSolution = Integer.valueOf(correctone.getText());
			}
		});
		panel.add(btnAddSol);
		
		panel.validate();
	}
}
