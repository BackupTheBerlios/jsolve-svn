
package Exercise;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

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
    	for (String poss : possibilities) {
    		if (poss.equals(answer))
    			correct = true;
    	}
    	output.add((correct)?"Uw antwoord is juist.":"Uw antwoord is verkeerd.");
        return null;
    }
    
/**
 * <p>Draws the answer panel of the exercise</p>
 */
	public void draw(JPanel panel) {
	// TODO
	
	} 
 }
