
package Exercise;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Subclass of exercise specificly for multiple choise exercises.
 */
public class MultichoiceExercise extends Exercise {

	/**
	 * <p>The list of possible answers.</p>
	 */
    private List<String> possibilities;

    /**
     * <p>Represents the index of the right answer in the list.</p>
     */
    private int correctSolution;    
    
    /**
     * <p>Constructor</p>
     */
    public MultichoiceExercise(){
        super("","","");
        addPanel = new MultichoiceAddPanel();
    }
    
    public MultichoiceExercise(String title, String theme, String question) {
    	super(title, theme, question);
    }
    
    public MultichoiceExercise(String title, String theme, String question, List<String> possibilities, int correctSolution) {
    	super(title,theme,question);
    	this.possibilities = possibilities;
    	this.correctSolution = correctSolution;
    }
    
    /**
     * <p>Makes sure this instant is consistant with inputted info.</p>
     */
    public void writeInput() {
    	possibilities = addPanel.getPossibilities();
    	correctSolution = addPanel.getCorrectSolution();
    }
    
    /**
     * Returns the panel used for adding a new exercise.
     * @return panel used for adding a new exercise
     */    
    public AddPanel getAddPanel(){
        return addPanel;
    }

    /**
     * <p>Tests if the given answer is true and calls the right tests.</p>
     */
    public List<String> validate() {
    	List<String> output = new ArrayList<String>();
    	
    	/*if (addPanel.getCorrectSolution().isSelected())
    	    output.add("Uw antwoord is juist.");
    	else
    		output.add("Uw antwoord is verkeerd.");*/
    	
        return output;
    }
}

