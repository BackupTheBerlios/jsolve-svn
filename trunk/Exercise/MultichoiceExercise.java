
package Exercise;
import java.awt.Insets;
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
    public List<String> validate(String answer) {
    	List<String> output = new ArrayList<String>();
    	boolean correct = false;
    	int i = 0;
    	for (String poss : possibilities) {
    		if (poss.equals(answer) && i == correctSolution)
    			correct = true;
    		i++;
    	}
    	output.add((correct)?"Uw antwoord is juist.":"Uw antwoord is verkeerd.");
        return null;
    }
    
/**
 * <p>Draws the answer panel of the exercise</p>
 */
	public void drawSolvePanel(JPanel panel) {
		JCheckBox[] box = new JCheckBox[possibilities.size()];
		for (int i = 0; i < box.length; i++) {
			box[i].setText(possibilities.get(i));
			box[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			box[i].setMargin(new Insets(0, 0, 0, 0));
			panel.add(box[i]);
		}	
		
		panel.validate();
	}
	
	/**
	 * <p>Draws the add panel of the exercise</p>
	 */
	public void drawAddPanel(JPanel panel) {
		/*JButton btnAddAnswer = new JButton();
		btnAddAnswer.setText("Add answer");
		panel.add(btnAddAnswer);*/
		
		JTextField[] field = new JTextField[4];
		for (int i = 0; i < field.length; i++) {
			field[i].setText("");
			panel.add(field[i]);
		}
		
		panel.validate();
	}
 }
